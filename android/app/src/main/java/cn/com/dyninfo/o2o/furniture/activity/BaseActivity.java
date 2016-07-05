/*
 * Copyright (c) 2009-2016 SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 * All rights reserved.
 *
 * This file contains valuable properties of  SHENZHEN Eternal Dynasty
 * Technology Co.,Ltd.,  embodying  substantial  creative efforts  and
 * confidential information, ideas and expressions.    No part of this
 * file may be reproduced or distributed in any form or by  any  means,
 * or stored in a data base or a retrieval system,  without  the prior
 * written permission  of  SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 *
 */

package cn.com.dyninfo.o2o.furniture.activity;

import java.io.File;
import java.util.concurrent.ExecutorService;

import cn.com.dyninfo.o2o.furniture.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.activity.cart.CartActivity;
import cn.com.dyninfo.o2o.furniture.activity.sign.SigninActivity;
import cn.com.dyninfo.o2o.furniture.bean.LocalUser;
import cn.com.dyninfo.o2o.furniture.bitmap.xutils.BitmapUtils;
import cn.com.dyninfo.o2o.furniture.bitmap.xutils.bitmap.PauseOnScrollListener;
import cn.com.dyninfo.o2o.furniture.dialog.ItemDialog;
import cn.com.dyninfo.o2o.furniture.dialog.LoadingDialog;
import cn.com.dyninfo.o2o.furniture.dialog.ItemDialog.OnDismissListener;
import cn.com.dyninfo.o2o.furniture.fragment.CartFragment;
import cn.com.dyninfo.o2o.furniture.fragment.IndexFragment;
import cn.com.dyninfo.o2o.furniture.fragment.MyFragment;
import cn.com.dyninfo.o2o.furniture.fragment.SearchFragment;
import cn.com.dyninfo.o2o.furniture.fragment.SideFragment;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.APPManager;
import cn.com.dyninfo.o2o.furniture.util.DESUtil;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.util.MyDate;
import cn.com.dyninfo.o2o.furniture.util.ThreadPool;
import cn.com.dyninfo.o2o.furniture.util.Util;
import cn.com.dyninfo.o2o.furniture.util.Var;

/**
 * @Description
 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
 * @create 2014-4-15
 * @update 2014-8-6 17:01:59 by <a href="http://t.cn/RvIApP5">ceychen</a>
 */
public class BaseActivity extends Activity {
	/** 连续双击back退出 */
	private long PRESS_TIME;
	private static final int TIME = 2000;
	/** 位图工具（占位图片较长版本） **/
	public static BitmapUtils bmpUtils;
	/** 位图工具（占位图片较短版本） **/
	public static BitmapUtils bmpUtils_short_holder;

	public static Context context;
	public static Handler handler;
	private LoadingDialog loadingDialog;

	public static String FINAL_USER_ROOT_PATH;
	public static String FINAL_USER_IMAGE_PATH;
	public static String FINAL_USER_TEMP_PATH;
	public static String FINAL_USER_FILE_PATH;
	public FragmentManager manager;
	/** 五大界面 */
	public IndexFragment indexFragment;
	public SearchFragment searchFragment;
	public SideFragment sideFragment;
	public CartFragment cartFragment;
	public MyFragment myFragment;
	// 内容区域
	public int containerViewId = R.id.content;
	/** LocalUser */
	private static LocalUser localuser;
	private static BaseActivity baseActivity;
	public static Runnable bruntip;
	// 修改购物车时用到
	private static int LocalCartNum = 0;
	private static Boolean isadded = false;
	// 添加到购物车时，记录选择的商品尺寸颜色等
	public static String[] specItemsids = null;
	public static String[] specItems = null;
	public static String specTitle = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		APPManager.getInstance().add(this);
		context = this;
		handler = new Handler();
		APPManager.getInstance().add(this);

		if (loadingDialog == null) {
			synchronized (this) {
				if (loadingDialog == null) {
					loadingDialog = new LoadingDialog(context);
				}
			}
		}
		bmpUtils = new BitmapUtils(context, Util.IMG_CACHE_XUTILS_SDCARD_PATH);
		bmpUtils.configDefaultLoadingImage(APP.IMG_LOAD_HOLDER);
		bmpUtils.configDefaultLoadFailedImage(APP.IMG_LOAD_FAILD);
		bmpUtils.configDefaultBitmapConfig(Bitmap.Config.RGB_565);
		bmpUtils.configDefaultAutoRotation(false);
		bmpUtils.configMemoryCacheEnabled(true);
		bmpUtils.configDiskCacheEnabled(true);
		// Animation animation = AnimationUtils.loadAnimation(context,
		// R.anim.gradient_adv);
		// try {
		// bmpUtils.configDefaultImageLoadAnimation(animation);
		// } catch (Exception e) {
		// }
		//
		bmpUtils_short_holder = new BitmapUtils(context, Util.IMG_CACHE_XUTILS_SDCARD_PATH);
		bmpUtils_short_holder.configDefaultLoadingImage(APP.IMG_LOAD_HOLDER_SHORT);
		bmpUtils_short_holder.configDefaultLoadFailedImage(APP.IMG_LOAD_FAILD_SHORT);
		bmpUtils_short_holder.configDefaultBitmapConfig(Bitmap.Config.RGB_565);
		bmpUtils_short_holder.configDefaultAutoRotation(false);
		bmpUtils_short_holder.configMemoryCacheEnabled(true);
		bmpUtils_short_holder.configDiskCacheEnabled(true);
		// try {
		// bmpUtils_short_holder.configDefaultImageLoadAnimation(animation);
		// } catch (Exception e) {
		// }

		baseActivity = new BaseActivity();
	}

	public static LocalUser getLocalUserInfoInstance(Context context) {
		if (localuser == null) {
			synchronized (BaseActivity.class) {
				if (localuser == null) {
					localuser = new LocalUser(context);
				}
			}
		}
		return localuser;
	}

	public static LocalUser getLastLocalUserInfoInstance(Context context) {
		return getLocalUserInfoInstance(context).getLastUser();
	}

	public static BaseActivity getBaseActivityInstance(Context context) {
		if (baseActivity == null) {
			synchronized (BaseActivity.class) {
				if (baseActivity == null) {
					baseActivity = new BaseActivity();
				}
			}
		}
		return baseActivity;
	}

	/**
	 * @Description 不固定线程池
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @date 2014-8-19 15:42:06
	 */
	public static ExecutorService cachedPool() {
		return ThreadPool.getCachedThreadPool();
	}

	/**
	 * @Description 单线程池
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @date 2014-8-19 15:47:27
	 */
	public static ExecutorService singlePool() {
		return ThreadPool.getSingleThreadPool();
	}

	public static void init_user_path() {
		String uid = getLastLocalUserInfoInstance(context).uid;
		FINAL_USER_ROOT_PATH = Util.APP_DATA_ROOT_PATH + (uid.length() == 0 ? "0" : uid) + "/";
		FINAL_USER_IMAGE_PATH = FINAL_USER_ROOT_PATH + "images/";
		FINAL_USER_TEMP_PATH = FINAL_USER_ROOT_PATH + "temp/";
		FINAL_USER_FILE_PATH = FINAL_USER_ROOT_PATH + "file/";

		File isPath = new File(FINAL_USER_ROOT_PATH);
		if (!isPath.exists()) {
			isPath.mkdirs();
		}

		isPath = new File(FINAL_USER_IMAGE_PATH);
		if (!isPath.exists()) {
			isPath.mkdirs();
		}

		isPath = new File(FINAL_USER_TEMP_PATH);
		if (!isPath.exists()) {
			isPath.mkdirs();
		}

		isPath = new File(FINAL_USER_FILE_PATH);
		if (!isPath.exists()) {
			isPath.mkdirs();
		}
	}

	public void myfinish() {
		try {
			unregisterReceiver(setCartCountBR);
		} catch (Exception e) {
		}
		System.gc();
		finish();
		overridePendingTransition(R.anim.push_right_in2, R.anim.push_right_to2);
	}

	protected void exit() {
		if (IndexActivity.nowPoint_temp != 1)
			openNowPoint(1);
		else {
			if (System.currentTimeMillis() - PRESS_TIME > TIME) {
				APP.tip(this, "再按一次 退出" + getResources().getString(R.string.app_name));
				PRESS_TIME = System.currentTimeMillis();
			} else {
				try {
					unregisterReceiver(setCartCountBR);
				} catch (Exception e) {
				}
				APPManager.getInstance().exit();
			}
		}
	}

	/**
	 * @Description 弹出软键盘
	 */
	public void showKeyboard() {
		handler.post(new Runnable() {

			@Override
			public void run() {
				try {
					getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
				} catch (Exception e) {
					APP.exception("弹出软键盘", e);
				}
			}
		});
	}

	/**
	 * @Description 关闭当前，并切换选项卡
	 * @param pos
	 *            需要切换的 tab 下标（1~5）
	 */
	public void openNowPoint(int pos) {
		IndexActivity.nowPoint_temp = pos;
		APPManager.getInstance().finish();
		context.startActivity(new Intent(context, IndexActivity.class));
		animRightToLeft();
	}

	public static int getNowPoint() {
		return IndexActivity.nowPoint_temp;
	}

	protected void animRightToLeft() {
		try {
			overridePendingTransition(R.anim.push_right_in2, R.anim.push_right_to2);
		} catch (Exception e) {
		}
	}

	protected void animLeftToRight() {
		try {
			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
		} catch (Exception e) {
		}
	}

	protected void animBottomToTop() {
		try {
			overridePendingTransition(R.anim.roll_up, R.anim.roll);
		} catch (Exception e) {
		}
	}

	public static Animation shakeAnim(int counts) {
		Animation translateAnimation = new TranslateAnimation(0, 15, 0, 0);
		translateAnimation.setInterpolator(new CycleInterpolator(counts));
		translateAnimation.setDuration(1000);
		return translateAnimation;
	}

	public void backHome() {
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.addCategory(Intent.CATEGORY_HOME);
		startActivity(intent);
	}

	/**
	 * @Description 添加到购物车(普通商品)
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @created 2014-7-8 14:58:49 by <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @updated 2014-7-31 11:59:06 by <a href="http://t.cn/RvIApP5">ceychen</a>
	 */
	public static void addToCartList(final Context context, final int goodId, final int count) {
		if (getLastLocalUserInfoInstance(context).signed != 0) {
			getBaseActivityInstance(context).checkUser(context);
		}
		Log_info("------添加到购物车(普通商品)");
		// 弹出属性选择框
		singlePool().execute(new Runnable() {
			@Override
			public void run() {
				handler.post(new Runnable() {
					@Override
					public void run() {
						if (hadSpec(goodId) && specItems != null) {
							ItemDialog dialog = new ItemDialog(context, "请选择" + specTitle, specItems);
							dialog.setOnDismissListener(new OnDismissListener() {
								@Override
								public void OnChosed(Boolean chosed, int position) {
									if (chosed) {
										Log_info(" itemsids[position] " + specItemsids[position]);
										doAddtoCart(goodId, count, specItemsids[position]);
									}
								}
							});
							dialog.show();

						} else {
							doAddtoCart(goodId, count, "");
						}
					}
				});
			}
		});
	}

	/**
	 * @Description 该商品添加到购物车前，是否有参数可以选择
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-9-3 10:15:47
	 */
	public static Boolean hadSpec(final int goodId) {
		String sizeJson = SyncApi.getGoodsSize(String.valueOf(goodId));
		JSONObject sizeObject = APP.checkReturnData(sizeJson, context);
		if (sizeObject != null) {
			if (sizeObject.has("status"))
				try {
					if (sizeObject.getInt("status") == ErrorCode.SUCCESS) {
						specItems = null;
						JSONArray array = sizeObject.getJSONArray("data");
						if (array != null && array.length() > 0) {
							JSONObject son = array.getJSONObject(0);
							specTitle = son.getString("name");
							JSONArray sonArray = son.getJSONArray("specval");
							if (sonArray != null && sonArray.length() > 0) {
								specItems = new String[sonArray.length()];
								specItemsids = new String[sonArray.length()];
								for (int i = 0; i < sonArray.length(); i++) {
									JSONObject item = sonArray.getJSONObject(i);
									specItems[i] = "";
									// specItems[i] = item.getString("val") +
									// "(" + item.getString("sales") + "元，重："
									// + item.getString("weight") + ")";
									specItems[i] = item.getString("val") + "(" + item.getString("sales") + "元)";
									specItemsids[i] = "";
									specItemsids[i] = item.getString("spec_val_id");
								}
							}
						}
						Log_info("hadSpec true");
						return true;
					} else if (sizeObject.getInt("status") == ErrorCode.ERROR) {
						// 没有属性
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
		}
		Log_info("hadSpec false");
		return false;
	}

	/**
	 * @Description 选择好尺寸，然后添加到购物车
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-8-1 下午6:28:08
	 */
	protected static void doAddtoCart(int goodId, int count, String sizeCode) {
		// 直接把商品属性加在这里
		String json = SyncApi.addToCartList(String.valueOf(goodId), count, sizeCode,
				BaseActivity.getLastLocalUserInfoInstance(context).uid);
		JSONObject object = APP.checkReturnData(json, context);
		if (object != null) {
			if (object.has("status"))
				try {
					if (object.getInt("status") == ErrorCode.SUCCESS) {
						BaseActivity.Tip("添加成功");
						notifyCartListByLocal(context);
						notifyCartCountAtIndex(context);
						notifyCartList(context);
					} else if (object.getInt("status") == ErrorCode.ERROR) {
						if (object.has("msg") && !object.getString("msg").isEmpty())
							BaseActivity.Tip(object.getString("msg"));
						else
							BaseActivity.Tip("对不起，您购买的商品售罄或已下架");
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
		} else {
			Tip("添加失败" + APPCode.WEB_NULL);
		}
	}

	/**
	 * @Description 选择好尺寸，然后添加到购物车（活动商品）
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-8-1 18:40:41
	 */
	protected static void doAddtoCart4Action(final Context context, final int goodId, final int actID, final int agmId,
			final String sizeCode) {
		new Thread() {
			@Override
			public void run() {
				String json = SyncApi.addToCartList(String.valueOf(goodId), sizeCode, String.valueOf(actID),
						BaseActivity.getLastLocalUserInfoInstance(context).uid, String.valueOf(agmId));
				JSONObject object = APP.checkReturnData(json, context);
				if (object != null) {
					if (object.has("status"))
						try {
							if (object.getInt("status") == ErrorCode.SUCCESS) {
								BaseActivity.Tip("添加成功");
								// 添加成功后刷新购物车 ( CartFragment 启动的情况下有效 )
								notifyCartListByLocal(context);
								notifyCartCountAtIndex(context);
								notifyCartList(context);
							} else if (object.getInt("status") == ErrorCode.ERROR) {
								BaseActivity.Tip("添加失败");
							}
						} catch (JSONException e) {
							e.printStackTrace();
						}
				} else {
					Tip("添加失败" + APPCode.WEB_NULL);
				}
			}
		}.start();
	}

	/**
	 * @Description 添加到购物车(活动商品，限购1件)
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-7-11 18:41:47
	 */
	public static void addToCartList(final Context context, final int goodId, final int actID, final int agmId) {
		if (getLastLocalUserInfoInstance(context).signed != 0) {
			baseActivity.checkUser(context);
		}
		singlePool().execute(new Runnable() {

			@Override
			public void run() {
				handler.post(new Runnable() {

					@Override
					public void run() {
						if (hadSpec(goodId) && specItems != null) {
							ItemDialog dialog = new ItemDialog(context, "请选择" + specTitle, specItems);
							dialog.setOnDismissListener(new OnDismissListener() {
								@Override
								public void OnChosed(Boolean chosed, int position) {
									if (chosed) {
										Log_info(" itemsids[position] " + specItemsids[position]);
										doAddtoCart4Action(context, goodId, actID, agmId, specItemsids[position]);
									}
								}
							});
							dialog.show();
						} else {
							doAddtoCart4Action(context, goodId, actID, agmId, "");
						}
					}
				});
			}
		});

	}

	/**
	 * @Description 选择好尺寸，然后添加到购物车（活动商品）
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-8-1 18:40:41
	 */
	public static void doAddtoCart4ActionAndBuy(final Context context, final int goodId, final int actID,
			final int agmId) {
		if (getLastLocalUserInfoInstance(context).signed != 0) {
			baseActivity.checkUser(context);
			// return;
		}
		new Thread() {
			@Override
			public void run() {
				String json = SyncApi.addToCartList(String.valueOf(goodId), "", String.valueOf(actID),
						BaseActivity.getLastLocalUserInfoInstance(context).uid, String.valueOf(agmId));
				JSONObject object = APP.checkReturnData(json, context);
				if (object != null) {
					if (object.has("status"))
						try {
							if (object.getInt("status") == ErrorCode.SUCCESS) {
								BaseActivity.Tip("添加成功");
								// 添加成功后刷新购物车 (CartFragment启动的情况下有效 )
								notifyCartListByLocal(context);
								notifyCartCountAtIndex(context);
								notifyCartList(context);
								// 跳转到支付页面
								JSONArray array = object.getJSONArray("data");
								if (array.length() > 0) {
									JSONObject objectSon = array.getJSONObject(0);
									Intent intent = new Intent(context, CartActivity.class);
									Bundle bundle = new Bundle();
									bundle.putDouble("money", objectSon.getDouble("money"));
									bundle.putStringArray("goodsInfo",
											new String[] { objectSon.getString("cars_box_id") });
									intent.putExtras(bundle);
									context.startActivity(intent);
								} else {
									BaseActivity.Tip("购买失败，请重试");
								}
							} else if (object.getInt("status") == ErrorCode.ERROR) {
								BaseActivity.Tip("添加失败");
							}
						} catch (JSONException e) {
							e.printStackTrace();
						}
				} else {
					Tip("添加失败" + APPCode.WEB_NULL);
				}

			}
		}.start();
	}

	/**
	 * @Description 修改购物车数量
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-7-8 15:05:45
	 */
	public static boolean editCartList(Context context, String cartGoodsId, int count, Boolean Tips) {
		String json = SyncApi.editCartList(cartGoodsId, count);
		JSONObject object = APP.checkReturnData(json, context);
		if (object != null) {
			if (object.has("status"))
				try {
					if (object.getInt("status") == ErrorCode.SUCCESS) {
						if (Tips)
							BaseActivity.Tip("修改成功");
						return true;
					} else if (object.getInt("status") == ErrorCode.ERROR) {
						if (Tips)
							BaseActivity.Tip("修改失败，请重试");
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
		} else {
			Tip("修改失败" + APPCode.WEB_NULL);
		}
		return false;
	}

	/**
	 * @Description 添加到购物车成功后，通知更新数量，IndexActivity 用
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-7-8 15:01:36
	 */
	public static void notifyCartCountAtIndex(Context context) {
		Intent intent = new Intent();
		intent.setAction("cn.com.dyninfo.o2o.furniture.IndexActivity#cartcount");
		context.sendBroadcast(intent);
	}

	/**
	 * @Description 更新账户信息
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-8-13 18:13:42
	 * @updated 2014-8-21 11:08:25
	 */
	public static void getAccinfo(final Context context) {
		cachedPool().execute(new Runnable() {

			@Override
			public void run() {

				String json = SyncApi.getAccInfo();
				JSONObject object = APP.checkReturnData(json, context);
				if (object != null && object.has("status")) {
					try {
						if (object.getInt("status") == ErrorCode.SUCCESS) {
							JSONObject son = object.getJSONArray("data").getJSONObject(0);
							LocalUser user = getLastLocalUserInfoInstance(context);
							user.name = son.getString("username");
							user.score = son.getInt("jf");
							user.head = son.getString("imgtx");
							user.updateLocalUser();
							Log_info("已更新本地账户信息");
						}
					} catch (JSONException e) {
						APP.exception("更新账户信息返回值异常", e);
					}
				}
			}
		});
	}

	/**
	 * @Description 通知刷新购物车(购物车页面联网获取列表)
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-7-8 18:08:05
	 */
	public static void notifyCartList(Context context) {
		System.out.println("-------> 即将发送刷新购物车通知（购物车页面）");
		Intent intent = new Intent();
		intent.setAction("cn.com.dyninfo.o2o.furniture.fragment.CartFragment#update");
		context.sendBroadcast(intent);
	}

	/**
	 * @Description 通知刷新购物车(其他页面用，直接获取本地缓存，读取赋值，修改成功后保存)
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-7-16 10:38:34
	 * @update 2014-7-16 15:26:19
	 */
	public static void notifyCartListByLocal(Context context) {
		isadded = false;
		baseActivity.initBroadcast(context);
		LocalCartNum = context.getSharedPreferences(APPCode.CART, 0).getInt("cartCount", 0);
		LocalCartNum += 1;
		Intent intent = new Intent();
		intent.setAction("cn.com.dyninfo.o2o.furniture.BaseActivity#setLocalCart");
		context.sendBroadcast(intent);
		context.getSharedPreferences(APPCode.CART, 0).edit().putInt("cartCount", LocalCartNum).commit();
	}

	public static void Log_info(String log) {
		Log.i(Var.info, "-----> " + MyDate.getDateEN() + " : " + log);
	}

	public static void Log_error(String log) {
		Log.e(Var.error, "-----> " + MyDate.getDateEN() + " : " + log);
	}

	public static void Log_warn(String log) {
		Log.w(Var.warn, "-----> " + MyDate.getDateEN() + " : " + log);
	}

	public static void Tip(final String msg) {
		bruntip = new Runnable() {
			@Override
			public void run() {
				APP.tip(context, msg);
			}
		};
		handler.post(bruntip);
	}

	public static void setTitle(Handler handler, final TextView title, final String page_title) {
		APP.setTitle(handler, title, page_title);
	}

	public static void setTitle(final String page_title) {
		IndexActivity.setPageTitle(page_title);
	}

	public static BitmapUtils getBmpUtils() {
		return bmpUtils;
	}

	public static BitmapUtils getBmpUtilsShort() {
		return bmpUtils_short_holder;
	}

	/** 返回 EditText 或者 TextView 的文本值 */
	public static String getTextFromView(View view) {
		return getTextFromView(view, false, false);
	}

	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description ListView 滚动时暂停加载
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-8-26 上午11:51:42
	 */
	public static void pauseDisplay(ListView lstview) {
		try {
			lstview.setOnScrollListener(new PauseOnScrollListener(bmpUtils_short_holder, false, true));
			lstview.setOnScrollListener(new PauseOnScrollListener(bmpUtils, false, true));
		} catch (Exception e) {
			APP.exception("pauseDisplay", e);
		}
	}

	/**
	 * @Description 返回 EditText 或者 TextView 的文本值
	 * @param replaceSpace
	 *            为true 时，返回【删除所有空格】后的字符串
	 * @param replaceConsecutiveSpace
	 *            为true 时，返回【替换所有连续的空格为一个空格】后的字符串
	 */
	public static String getTextFromView(View view, Boolean replaceSpace, Boolean replaceConsecutiveSpace) {
		if (view instanceof EditText) {
			if (replaceSpace) {
				return ((EditText) view).getText().toString().replace(" ", "");
			}
			if (replaceConsecutiveSpace) {
				return ((EditText) view).getText().toString().replaceAll(" +", " ");
			}
			return ((EditText) view).getText().toString();
		} else if (view instanceof TextView) {
			if (replaceSpace) {
				return ((TextView) view).getText().toString().replace(" ", "");
			}
			if (replaceConsecutiveSpace) {
				return ((TextView) view).getText().toString().replaceAll(" +", " ");
			}
			return ((TextView) view).getText().toString();
		}
		return null;
	}

	/** 添加当前Activity，方便管理 */
	public static void addToActManager(Activity activity) {
		APPManager.getInstance().add(activity);
	}

	/**
	 * @Description 用户登录状态判断 (没登录则登录，否则无操作)
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-9-12 下午3:32:19
	 */
	public void checkUserSignStatus(Context context) {
		if (getLastLocalUserInfoInstance(context).signed != 0) {
			getBaseActivityInstance(context).checkUser(context);
		}
	}

	/**
	 * @Description 用户登录状态判断 (没登录则登录，否则检验登录状态是否过期)
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-4 14:29:32
	 * @update 2014-8-13 11:53:13
	 */
	public void checkUser(final Context context) {
		new Thread() {
			public void run() {
				LocalUser user = new LocalUser(context);
				user.getLastUser();
				Log_info(" 正在检查上次登录并保存的账户信息：acct = " + user.acct);
				if (user.uid.isEmpty() || (user.auto != 0 && user.auto != 1)) {
					// 账户为空、QQ登录 或者 上一次点击了 退出登录 的
					context.startActivity(new Intent(context, SigninActivity.class)
							.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
					animLeftToRight();
				} else {
					// 如果是炫品账户登录的，而且不在登录状态，则开始检验，QQ登录的则不校验
					if (user.from == 0 && user.signed != 0) {
						Log_info("正在验证本地账户是否可以通过");
						String json;
						try {
							json = SyncApi.signin(user.acct, DESUtil.decode(user.psw));
						} catch (Exception e) {
							APP.exception(" baseactivity checkUser", e);
							return;
						}
						JSONObject object = APP.checkReturnData(json, context);
						if (object != null && object.has("status")) {
							try {
								if (object.getInt("status") == ErrorCode.SUCCESS) {
									user.json2db(json, context);
									user.auto = 0;
									user.from = 0;
									user.updateLocalUser();
								} else {
									Tip("本地账户信息已过期，请重新登录");
									Log_info("本地账户信息已过期，需要重新登录");
									getLastLocalUserInfoInstance(context).delete();
									context.startActivity(new Intent(context, SigninActivity.class)
											.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
									animLeftToRight();
								}
							} catch (JSONException e) {
							}
						}
						// else
						// Tip("服务器临时维护，请稍后再试");
					}
				}
			};
		}.start();

	}

	/**
	 * @Description 展示统一的加载中等待框
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-9-15 下午3:39:54
	 */
	public void loadingShow() {
		if (loadingDialog != null && !loadingDialog.isShowing()) {
			handler.post(new Runnable() {
				@Override
				public void run() {
					try {
						loadingDialog.show();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	/**
	 * @Description 取消
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-9-15 下午3:39:54
	 */
	public void loadingDismiss() {
		if (loadingDialog != null && loadingDialog.isShowing()) {
			try {
				handler.post(new Runnable() {

					@Override
					public void run() {
						loadingDialog.dismiss();
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @Description 传入layout，为其设置顶部和底部的点击事件，以及页面标题
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-4-25 11:44:25
	 */
	public void initTitleAndClick(Context context, int layoutID, String page_title) {
		try {
			Log_info("--------------------> initTitleAndClick");
			// 页面标题
			page_title = page_title.equals("") || page_title.equals("null") ? getResources().getString(
					R.string.app_name) : page_title == null ? getResources().getString(R.string.app_name) : page_title;
			((TextView) findViewById(R.id.title)).setText(page_title);
			// 底部导航
			findViewById(R.id.index_layout).setOnClickListener(new BottomClick(context, layoutID));
			findViewById(R.id.search_layout).setOnClickListener(new BottomClick(context, layoutID));
			findViewById(R.id.side_layout).setOnClickListener(new BottomClick(context, layoutID));
			findViewById(R.id.cart_layout).setOnClickListener(new BottomClick(context, layoutID));
			findViewById(R.id.my_layout).setOnClickListener(new BottomClick(context, layoutID));
			// 返回按钮
			findViewById(R.id.back).setOnClickListener(new TopClick(context, layoutID));

		} catch (Exception e) {
			APP.exception("initTitleAndClick", e);
		}
	}

	/**
	 * 顶部返回按钮点击事件
	 */
	public class TopClick implements OnClickListener {

		private ImageView back;
		private Context context;
		private int layoutID;

		/**
		 * @Description 顶部title点击事件 <br>
		 *              layoutID：R.layout.xxx
		 */
		public TopClick(Context context, int layoutID) {
			this.context = context;
			this.layoutID = layoutID;
			initView();
		}

		private void initView() {
			if (layoutID < 0) {
				return;
			}
			LayoutInflater inflater = LayoutInflater.from(context);
			View view = inflater.inflate(layoutID, null);
			back = (ImageView) view.findViewById(R.id.back);
			back.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.back:
				myfinish();
				break;

			default:
				break;
			}
		}

	}

	/**
	 * 底部返回按钮点击事件
	 */
	public class BottomClick implements OnClickListener {

		private Context context;
		/** 炫品首页 */
		public View index_layout;
		public ImageView index_image;
		/** 搜索 */
		public View search_layout;
		public ImageView search_image;
		/** 身边店家 */
		public View side_layout;
		public ImageView side_image;
		/** 购物车 */
		public View cart_layout;
		public ImageView cart_image;
		/** 我的炫品 */
		public View my_layout;
		public ImageView my_image;
		/** 首次进入默认选中位置 */
		int position;
		// ******/
		private TextView cartCount;

		int layoutID;

		/**
		 * @Description 底部导航点击事件（当前默认不选中任何选项卡） <br>
		 *              layoutID：R.layout.xxx
		 */
		public BottomClick(Context context, int layoutID) {
			this.context = context;
			this.layoutID = layoutID;
			initView();
		}

		/**
		 * @Description 底部导航点击事件（默认选中选项卡 position）<br>
		 *              position：1~5 <br>
		 *              layoutID：R.layout.xxx
		 */
		public BottomClick(Context context, int position, int layoutID) {
			this.context = context;
			this.position = position;
			this.layoutID = layoutID;
			initView();
			setCheck(position);
		}

		private void setCheck(int position) {
			final View layout[] = new View[] { index_layout, search_layout, side_layout, cart_layout, my_layout };
			final ImageView img[] = new ImageView[] { index_image, search_image, side_image, cart_image, my_image };
			final int icoNormalID[] = new int[] { R.drawable.home_tab_ico_1_normal, R.drawable.home_tab_ico_2_normal,
					R.drawable.home_tab_ico_4_normal, R.drawable.home_tab_ico_4_normal,
					R.drawable.home_tab_ico_5_normal };
			final int icoPressID[] = new int[] { R.drawable.home_tab_ico_1_press, R.drawable.home_tab_ico_2_press,
					R.drawable.home_tab_ico_4_press, R.drawable.home_tab_ico_4_press, R.drawable.home_tab_ico_5_press };
			for (int i = 0; i < layout.length; i++) {
				if (i == position - 1) {
					layout[i].setBackgroundColor(Color.parseColor("#ffffff"));
					img[i].setImageResource(icoPressID[i]);
				} else {
					layout[i].setBackgroundColor(Color.parseColor("#000000"));
					img[i].setImageResource(icoNormalID[i]);
				}
			}
		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			// 底部导航按钮
			case R.id.index_layout:
				setTabSelection(1);
				break;
			case R.id.search_layout:
				setTabSelection(2);
				break;
			case R.id.side_layout:
				setTabSelection(3);
				break;
			case R.id.cart_layout:
				setTabSelection(4);
				break;
			case R.id.my_layout:
				setTabSelection(5);
				break;
			}
		}

		protected void setTabSelection(int pos) {
			Log_info("click tab " + pos);
			openNowPoint(pos);
		}

		/** 底部导航 **/
		private void initView() {
			if (layoutID < 0) {
				return;
			}
			LayoutInflater inflater = LayoutInflater.from(context);
			View view = inflater.inflate(layoutID, null);
			index_layout = view.findViewById(R.id.index_layout);
			search_layout = view.findViewById(R.id.search_layout);
			side_layout = view.findViewById(R.id.side_layout);
			cart_layout = view.findViewById(R.id.cart_layout);
			my_layout = view.findViewById(R.id.my_layout);
			index_image = (ImageView) view.findViewById(R.id.index_image);
			search_image = (ImageView) view.findViewById(R.id.search_image);
			side_image = (ImageView) view.findViewById(R.id.side_image);
			cart_image = (ImageView) view.findViewById(R.id.cart_image);
			my_image = (ImageView) view.findViewById(R.id.my_image);
			cartCount = (TextView) findViewById(R.id.cart_ico_num);
			index_layout.setOnClickListener(this);
			search_layout.setOnClickListener(this);
			side_layout.setOnClickListener(this);
			cart_layout.setOnClickListener(this);
			my_layout.setOnClickListener(this);

			// 设置购物车数量
			int count = getSharedPreferences(APPCode.CART, 0).getInt("cartCount", 0);
			cartCount.setText(String.valueOf(count));

			initBroadcast(context);
		}

	}

	// 测试全局广播 修改购物车数量
	private void initBroadcast(Context context) {
		isadded = false;
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("cn.com.dyninfo.o2o.furniture.BaseActivity#setLocalCart");
		try {
			context.registerReceiver(setCartCountBR, intentFilter);
		} catch (Exception e) {
			APP.exception("initBroadcast", e);
		}
	}

	private void unBroadcast(Context context) {
		try {
			context.unregisterReceiver(setCartCountBR);
		} catch (Exception e) {
			APP.exception("unBroadcast", e);
		}
	}

	private BroadcastReceiver setCartCountBR = new BroadcastReceiver() {
		@Override
		public void onReceive(final Context context, Intent intent) {
			if (intent.getAction().equals("cn.com.dyninfo.o2o.furniture.BaseActivity#setLocalCart")) {
				// 2014-7-16 14:56:03 测试2
				handler.post(new Runnable() {
					@Override
					public void run() {
						try {
							TextView cart_num = (TextView) findViewById(R.id.cart_ico_num);
							System.out.println("----------> 本地购物车数量为 BaseActivity#setLocalCart ：" + LocalCartNum);
							cart_num.setText(String.valueOf(LocalCartNum));
						} catch (Exception e) {
							APP.exception("setCartCountBR", e);
						}
					}
				});
				if (isadded) {
					baseActivity.unBroadcast(context);
				} else {
					isadded = true;
				}
			}
		}
	};

}