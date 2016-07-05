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

package cn.com.dyninfo.o2o.furniture.activity.cart;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.com.dyninfo.o2o.furniture.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alipay.android.app.sdk.AliPay;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.activity.my.AddressActivity;
import cn.com.dyninfo.o2o.furniture.adapter.CheckstandAdapter;
import cn.com.dyninfo.o2o.furniture.alipay.Keys;
import cn.com.dyninfo.o2o.furniture.alipay.Result;
import cn.com.dyninfo.o2o.furniture.alipay.Rsa;
import cn.com.dyninfo.o2o.furniture.bean.CheckstandBean;
import cn.com.dyninfo.o2o.furniture.dialog.InputDialog;
import cn.com.dyninfo.o2o.furniture.dialog.ItemDialog;
import cn.com.dyninfo.o2o.furniture.dialog.ItemDialog.OnDismissListener;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.MyDate;
import cn.com.dyninfo.o2o.furniture.util.NumArithmetic;
import cn.com.dyninfo.o2o.furniture.util.SaveLog;
import cn.com.dyninfo.o2o.furniture.util.Utils;
import cn.com.dyninfo.o2o.furniture.view.CustomerListView;

/**
 * @Description 结算中心
 * @author ly
 * @editor wangmin & <a href="http://t.cn/RvIApP5">ceychen</a>
 * @updated 2014-8-19 11:29:35 更新运费与积分支付抵消规则<br>
 *          2014-8-11 17:44:29 新增解析服务器返回数据发生异常时，保存log到内存卡<br>
 *          2014-7-31 17:31:13 新增使用积分抵用 by <a
 *          href="http://t.cn/RvIApP5">ceychen</a>
 */
public class CartActivity extends BaseActivity implements OnClickListener {

	private int layoutID = R.layout.cart_activity;
	private String PAGE_TITLE = "结算中心";
	private Context context;
	private Handler handler;
	private CustomerListView refreshListView;
	private CheckstandAdapter adapter;
	private List<CheckstandBean> list = new ArrayList<CheckstandBean>();
	private TextView submit_order;
	private RadioButton select_true;
	/** 支付宝 */
	private EditText mUserId;
	private Button mLogon;

	private static final int RQF_PAY = 1;
	private static final int RQF_LOGIN = 2;

	private double freight_ = 0;// 初始化运费
	private String uid;
	private Bundle bundle;
	private double money = 0;// 需要支付的费用
	private TextView show_money, maxJfView;
	private TextView goods_all_money;
	private TextView freight;
	private TextView end_money;

	private String goodName = "";
	private TextView revcName;
	private TextView revcPhone;
	private TextView revcAddress;
	private RadioGroup kdfs;
	// 选择收货地址
	private Boolean hadAddress = false;
	private RelativeLayout addr_layout;
	// 选择派送时间
	private TextView delivery_date;
	// 取消支付、支付成功时，关闭页面
	private Boolean tryToPay = false;
	// 使用积分
	private NumArithmetic numArithmetic;
	private TextView used_score;
	private int score_acc = 0;
	private int score2use = 0;
	private RelativeLayout use_score;
	private double scoreValue;
	private String tipStr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		addToActManager(this);
		context = this;
		handler = new Handler();
		initBundle();
		initView();
		initValue();
		initClick();
	}

	private void initBundle() {
		bundle = getIntent().getExtras();
		money = bundle.getDouble("money");
		shopgid = bundle.getStringArray("goodsInfo");
	}

	private void initView() {
		uid = BaseActivity.getLastLocalUserInfoInstance(context).uid;

		refreshListView = (CustomerListView) findViewById(R.id.car_activity_list);
		submit_order = (TextView) findViewById(R.id.submit_order);
		select_true = (RadioButton) findViewById(R.id.select_true);
		show_money = (TextView) findViewById(R.id.show_money);
		goods_all_money = (TextView) findViewById(R.id.goods_all_money);
		freight = (TextView) findViewById(R.id.freight);

		end_money = (TextView) findViewById(R.id.end_money);
		// 应付金额
		show_money.setText(money + "");
		goods_all_money.setText(money + "");
		freight.setText(freight_ + "");
		end_money.setText((money + freight_) + "");
		revcName = (TextView) findViewById(R.id.buy_car_name);
		revcPhone = (TextView) findViewById(R.id.buy_car_phone);
		revcAddress = (TextView) findViewById(R.id.buy_car_address);
		kdfs = (RadioGroup) findViewById(R.id.kdfs);
		maxJfView = (TextView) findViewById(R.id.maxJf);

		addr_layout = (RelativeLayout) findViewById(R.id.addr_layout);
		delivery_date = (TextView) findViewById(R.id.delivery_date);
		use_score = (RelativeLayout) findViewById(R.id.use_score);
		used_score = (TextView) findViewById(R.id.used_score);
	}

	private void initClick() {
		initTitleAndClick(context, layoutID, PAGE_TITLE);
		addr_layout.setOnClickListener(this);
		delivery_date.setOnClickListener(this);
		submit_order.setOnClickListener(this);
		use_score.setOnClickListener(this);
		select_true.setOnClickListener(this);

		kdfs.check(R.id.kdfs_kd);
		kdfs.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				if (arg1 == R.id.kdfs_sm) {
					// TODO 选择自提
					dly = true;
					dlyType = "0";
					freight.setText("0");
					pointExpressMoney = 0d;
					end_money.setText(money + pointExpressMoney - scoreValue + "");
				} else {
					dlyType = "1";
					queryDistribution();
					pointExpressMoney = dlyMoney;
				}
			}

		});
	}

	private String receiveId = "";// 收货地址ID
	private String dlyType = "1";// 配送方式1快递方式 0我要自己提货
	private String account = "0";// 余额支付金额
	private String playType = "1";// 支付方式1支付宝 2银联
	private String receiveDate = "0";// 收货时间0[工作日、双休日、节假日均可收货] 1[双休日、节假日不收货]
										// 2[工作日不收货]
	private String p = "0";// 积分
	private String shop[];// 店铺信息【店铺ID=运输方式Id=商品Id=商品Id=商品Id=商品Id】
	private String shopDly[];
	private String s_d = "";// gid
	private boolean dly = false;// 当前地址是否所有店铺都能送达
	private Double dlyMoney = 0d;// 当前地址获取的运费合计
	private Double pointExpressMoney = 0d;// 当前地址获取的运费合计

	// 选择性购买宝贝
	private String shopgid[];// 购买的购物车宝贝店铺 拼接的 id

	private int maxJf = 0;// 账户可用最大积分数
	private Double maxAccountMoney = 0d;// 账户可用最大金额
	private Double jfToMoney = 0d;// 每一点积分兑换多少元RMB

	// g_id="${good.good_id}:${good.shop_id}:${good.actId}_${good.actMoney}:${good.num}:${good.id}"
	// d_g="${good.deliverFlag}"
	// area_id&shop=dlyId=g_id&shop=dlyId=g_id 算费用接口
	// area_id&s_d 查询快递方式
	private void createOrder() {
		loadingShow();
		String buffer = "&receiveDate=" + receiveDate + "&dlyType=" + dlyType + "&account=" + account;
		buffer += "&playType=" + playType + "&p=" + score2use + "&receiveId=" + receiveId;
		for (int i = 0; i < shop.length; i++) {
			try {
				// shopDly[i] 是 店铺配送方式，自提的话，不需要传店铺运输方式，也少一个 =
				Log_info("===========> shop [ " + i + " ] = " + shop[i].split("=")[0] + "， shopDly[i] =" + shopDly[i]);
				buffer += "&shop=" + shop[i].split("=")[0]
						+ (dlyType.equals("1") ? shopDly[i].equals("null") ? "" : "=" + shopDly[i] : "") + shopgid[i];
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		final String bufferStr = buffer;
		cachedPool().execute(new Runnable() {

			@Override
			public void run() {
				String result = SyncApi.checkOrder(bufferStr);
				if (!result.isEmpty()) {
					Double needPayDouble = 0.0;
					String buf = "";
					buf = "\n服务器没有返回该订单的信息";
					JSONObject object = APP.checkReturnData(result, context);
					tipStr = "";
					if (object != null) {
						// {"create":true,"tradeNo":"2014091706055882","totale":4.0,"orderMoney":4.0,"dlyMoney":0.0}
						try {
							// TODO 这里没有执行
							if (object.getBoolean("create")) {
								StringBuilder sb = new StringBuilder();
								sb.append("partner=\"");
								sb.append(Keys.DEFAULT_PARTNER);
								sb.append("\"&out_trade_no=\"");
								sb.append(object.getString("tradeNo"));
								sb.append("\"&subject=\"");
								sb.append("炫品妆成客户端下单");
								sb.append("\"&body=\"");
								// 需要支付的总价
								needPayDouble = object.getDouble("totale");
								sb.append("订单金额：" + object.getString("orderMoney") + "（元）运费："
										+ object.getString("dlyMoney") + "（元）");
								sb.append("\"&total_fee=\"" + needPayDouble);// 订单支付总金额
								sb.append("\"&notify_url=\"");
								// 网址需要做URL编码
								sb.append(URLEncoder.encode("http://www.xpzc.com/notify_url.html"));
								sb.append("\"&service=\"mobile.securitypay.pay");
								sb.append("\"&_input_charset=\"UTF-8");
								sb.append("\"&return_url=\"");
								sb.append(URLEncoder.encode("http://www.xpzc.com/return_url.html"));
								sb.append("\"&payment_type=\"1");
								sb.append("\"&seller_id=\"");
								sb.append(Keys.DEFAULT_SELLER);

								// 如果show_url值为空，可不传
								// sb.append("\"&show_url=\"");
								sb.append("\"&it_b_pay=\"1m");
								sb.append("\"");

								String info = sb.toString();
								String sign = Rsa.sign(info, Keys.PRIVATE);
								sign = URLEncoder.encode(sign);
								info += "&sign=\"" + sign + "\"&" + getSignType();
								Log_info("开始支付宝支付，付款信息：" + info);

								if (needPayDouble <= 0) {
									Tip("该订单无需额外支付，已付款成功");
									loadingDismiss();
									myfinish();
									return;
								}
								// 调用支付宝
								AliPay alipay = new AliPay(CartActivity.this, alipayHandler);
								tryToPay = true;
								// 设置为沙箱模式，不设置默认为线上环境
								// alipay.setSandBox(true);
								Log_info("支付宝支付结果：" + result);
								Message msg = new Message();
								msg.what = RQF_PAY;
								msg.obj = alipay.pay(info);
								alipayHandler.sendMessage(msg);

							} else {
								tipStr = "，无法创建订单";
								alipayHandler.sendEmptyMessage(2);
								loadingDismiss();
							}
						} catch (Exception ex) {
							SaveLog.save("请求创建订单时，服务器返回： " + result + " ，异常为： " + ex.toString(), MyDate.getDateEN()
									+ " - befpayExcp");
							Tip("调用支付宝支付失败" + buf);
							APP.exception("尝试使用支付宝支付", ex);
							myfinish();
						}
					}
				} else {

					Tip("创建订单失败，" + APPCode.WEB_NULL);
				}
				loadingDismiss();

			}
		});
	}

	private void queryDistribution() {
		if (dlyType.equals("0")) {
			dly = true;
			freight.setText(0);
			return;
		}
		// 收货地址 id
		if (receiveId.length() == 0) {
			Tip("记得设置收货地址哦");
			return;
		}
		cachedPool().execute(new Runnable() {

			@Override
			public void run() {
				String result = SyncApi.getShippingForOrder("&receiveId=" + receiveId + "&p=" + s_d);
				JSONArray array = null;
				try {
					array = new JSONArray(result);
				} catch (JSONException e) {
					e.printStackTrace();
				}

				final JSONArray data = array;
				if (data != null) {
					handler.post(new Runnable() {

						@Override
						public void run() {
							try {
								dlyMoney = 0d;
								dly = true;
								for (int i = 0; i < data.length(); i++) {
									JSONObject jsonObject = data.getJSONObject(i);
									String shopId = jsonObject.getString("shopId");
									int item = getShopItem(shopId);
									if (item == -1)
										continue;
									shopDly[item] = "";
									// 配送方式
									String status = jsonObject.getString("status");
									String statusMean = "";
									if (status.equals("1")) {
										// 不支持配送
										dly = false;
										statusMean = "不支持配送";
									} else if (status.equals("0")) {
										// 支持配送并且有快递
										String dlyId = jsonObject.getString("dlyId");
										shopDly[item] = dlyId;
										String mondy = jsonObject.getString("money");
										if (!mondy.equals("null")) {
											dlyMoney += Double.parseDouble(jsonObject.getString("money"));
										}
										statusMean = "支持配送并且有快递";
									} else if (status.equals("2")) {
										// 包邮
										statusMean = "包邮";
									} else if (status.equals("3")) {
										// 支持配送但是没有快递方式
										dlyMoney += Double.parseDouble(jsonObject.getString("money"));
										statusMean = "支持配送但是没有快递方式";
									}
									Log_info("查询配送方式：" + statusMean);
								}
								// 不支持配送
								if (!dly)
									dlyMoney = 0d;
								loadingDismiss();
								pointExpressMoney = dlyMoney;
								freight.setText(dlyMoney + "");
								end_money.setText(money + pointExpressMoney - scoreValue + "");
							} catch (Exception e) {
								Tip("获取商品配送方式失败");
								e.printStackTrace();
							}
						}
					});
				} else {
					Tip("查询商品配送方式失败");
				}
			}
		});

	}

	private int getShopItem(String shopId) {
		for (int i = 0; i < shop.length; i++) {
			if (shop[i].split("=")[0].equals(shopId)) {
				return i;
			}
		}
		return -1;
	}

	private void initValue() {
		String add = "";
		for (int i = 0; i < shopgid.length; i++) {
			add += "&carId=" + shopgid[i];
		}
		final String buffer = add;

		// 获取要结算的订单价格
		cachedPool().execute(new Runnable() {

			@Override
			public void run() {
				String result = SyncApi.checkCartOrderGoods(buffer);
				final JSONObject json = APP.checkReturnData(result, context);
				handler.post(new Runnable() {

					@Override
					public void run() {
						try {
							if (json != null) {
								String jf = json.getString("jf");
								String account = json.getString("account");
								String jf_money = json.getString("jf_money");
								maxJf = Integer.parseInt(jf);
								maxAccountMoney = Double.parseDouble(account);
								jfToMoney = Double.parseDouble(jf_money);
								Log_info("1积分抵现 = " + jfToMoney);
								maxJfView.setText(jf + "分");
								score_acc = Integer.valueOf(jf);

								// 收货地址列表
								JSONArray dzList = json.getJSONArray("address");
								if (dzList.length() > 0) {
									hadAddress = true;
									JSONObject jsonObject = dzList.getJSONObject(0);
									revcName.setText(jsonObject.getString("name"));
									revcPhone.setText(jsonObject.getString("phone"));
									revcAddress.setText(jsonObject.getString("address"));
									receiveId = jsonObject.getString("id");
								} else {
									hadAddress = false;
								}
								JSONArray data = json.getJSONArray("shopGoods");
								shopDly = new String[data.length()];
								shop = new String[data.length()];
								shopgid = new String[data.length()];
								for (int i = 0; i < data.length(); i++) {
									JSONObject jsonObject = data.getJSONObject(i);
									JSONArray goodsList = jsonObject.getJSONArray("goods");

									shop[i] = jsonObject.getString("shopId");
									// TODO 订单内店铺id
									Log_info("===========> shop [ " + i + " ] = " + shop[i]);
									shopgid[i] = "";
									for (int j = 0; j < goodsList.length(); j++) {
										JSONObject goods = goodsList.getJSONObject(j);
										String name = goods.getString("goodsName");
										goodName += name + ",";
										double money = Double.parseDouble(goods.getString("price"));
										int num = Integer.parseInt(goods.getString("num"));
										shop[i] += "=" + goods.getString("goodsId");
										s_d += goods.getString("goodsId");
										s_d += ":" + jsonObject.getString("shopId");
										s_d += ":" + goods.getString("actId");
										s_d += ":" + goods.getString("num");
										s_d += ":" + goods.getString("id");
										s_d += "@";
										shopgid[i] += "=" + goods.getString("goodsId") + ":"
												+ jsonObject.getString("shopId");
										shopgid[i] += ":" + goods.getString("actId") + ":" + goods.getString("num");
										shopgid[i] += ":" + goods.getString("id");
										list.add(new CheckstandBean(name, num, Utils.decimal(money * num, 2)));
									}

									Log_info("===========> shop [ " + 0 + " ] = " + shop[0]);
									s_d += "=";
								}
								if (goodName.length() > 0) {
									goodName = goodName.substring(0, goodName.length() - 1);
								}
							} else {
								Tip("没有获取到要结算的商品信息，请重试");
							}
						} catch (Exception e) {
							APP.exception("服务器异常", e);
							Tip("网络连接错误，请重试");
						}
					}
				});
			}
		});

		queryDistribution();
		notifyAdapter();
	}

	private void notifyAdapter() {
		if (adapter == null) {
			adapter = new CheckstandAdapter(context, list);
			refreshListView.setAdapter(adapter);
		}

		handler.post(new Runnable() {
			@Override
			public void run() {
				adapter.notifyDataSetChanged();
			}
		});
	}

	@Override
	public void onBackPressed() {
		myfinish();
	}

	/**
	 * 
	 * @return
	 */
	@SuppressLint("SimpleDateFormat")
	private String getOutTradeNo() {
		SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss");
		Date date = new Date();
		String key = format.format(date);

		java.util.Random r = new java.util.Random();
		key += r.nextInt();
		key = key.substring(0, 15);

		System.out.println("outTradeNo: " + key);

		return key;
	}

	@Override
	/**
	 * 创建快速登录菜单
	 */
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE, Menu.FIRST, 1, "快速登录");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case Menu.FIRST:
			setContentView(R.layout.trustlogin);
			mUserId = (EditText) findViewById(R.id.user_id);
			mLogon = (Button) findViewById(R.id.get_token);
			mLogon.setOnClickListener(this);
			break;
		}
		return false;
	}

	/**
	 * 
	 * @return
	 */
	private String getUserInfo() {
		String userId = mUserId.getText().toString();
		return trustLogin(Keys.DEFAULT_PARTNER, userId);
	}

	/**
	 * 
	 * @param partnerId
	 * @param appUserId
	 * @return
	 */
	private String trustLogin(String partnerId, String appUserId) {
		StringBuilder sb = new StringBuilder();
		sb.append("app_name=\"mc\"&biz_type=\"trust_login\"&partner=\"");
		sb.append(partnerId);
		Log.d("TAG", "UserID = " + appUserId);
		if (!TextUtils.isEmpty(appUserId)) {
			appUserId = appUserId.replace("\"", "");
			sb.append("\"&app_id=\"");
			sb.append(appUserId);
		}
		sb.append("\"");

		String info = sb.toString();

		// 请求信息签名
		String sign = Rsa.sign(info, Keys.PRIVATE);
		try {
			sign = URLEncoder.encode(sign, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		info += "&sign=\"" + sign + "\"&" + getSignType();

		return info;
	}

	/**
	 * 
	 * @return
	 */
	private String getSignType() {
		return "sign_type=\"RSA\"";
	}

	Handler alipayHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			Result result = new Result((String) msg.obj);
			switch (msg.what) {
			case RQF_PAY:

			case RQF_LOGIN:
				Tip("购买失败  " + tipStr + result.getResult());
				break;
			}
		};
	};

	/**
	 * 
	 */
	private void doLogin() {
		final String orderInfo = getUserInfo();
		new Thread() {
			public void run() {
				String result = new AliPay(CartActivity.this, alipayHandler).pay(orderInfo);

				System.out.println("result = " + result);

				Message msg = new Message();
				msg.what = RQF_LOGIN;
				msg.obj = result;
				alipayHandler.sendMessage(msg);
			}
		}.start();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.get_token:
			doLogin();
			break;

		case R.id.submit_order:
			if (!hadAddress) {
				Tip("请添加收货人信息");
				break;
			}
			if (!dly) {
				Tip("订单内部分商品无法送达，请选择自提");
				break;
			}
			if (select_true.isChecked()) {
				createOrder();
			} else {
				Tip("请先选择支付方式");
			}
			break;
		/**
		 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
		 * @date 2014-7-5 16:34:01
		 */
		// 选择收货地址 和 收货人信息
		case R.id.addr_layout:
			Intent intent = new Intent(context, AddressActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("from", "order");
			intent.putExtras(bundle);
			startActivityForResult(intent, APPCode.CHOICE_ADDR);
			break;
		/**
		 * @created <a href="http://t.cn/RvIApP5">ceychen</a>
		 * @date 2014-7-5 16:34:01
		 */
		// 选择派送时间
		case R.id.delivery_date:
			final String items[] = new String[] { "不限", "仅工作日派送", "仅节假日派送" };
			ItemDialog dialog = new ItemDialog(context, "选择派送时间", items);
			dialog.setOnDismissListener(new OnDismissListener() {
				@Override
				public void OnChosed(Boolean chosed, int position) {
					if (chosed) {
						// 收货时间
						// 0[工作日、双休日、节假日均可收货]
						// 1[双休日、节假日不收货]
						// 2[工作日不收货]
						delivery_date.setText(items[position]);
						receiveDate = String.valueOf(position);
					}
				}
			});
			dialog.show();
			break;

		/**
		 * @created <a href="http://t.cn/RvIApP5">ceychen</a>
		 * @date 2014-7-31 17:08:26
		 */
		case R.id.use_score:
			if (score_acc != 0) {
				InputDialog inputDialog = new InputDialog(context, "使用积分", "请输入要使用的积分数量", "确认");
				inputDialog.setOnDismissListener(new InputDialog.OnDismissListener() {
					@Override
					public void OnConfirmed(Boolean confirmed, String input) {
						if (confirmed)
							if (input != null)
								try {
									// TODO 使用积分抵扣
									if (Integer.valueOf(input) <= score_acc) {
										score2use = Integer.valueOf(input);
										if (numArithmetic == null) {
											numArithmetic = new NumArithmetic();
										}
										// 积分抵扣的价值
										scoreValue = numArithmetic.mul(score2use, jfToMoney);

										if (scoreValue > money + pointExpressMoney) {
											Tip("输入的积分价值已超过订单总价，请重新输入");
										} else {
											used_score.setText("使用 " + score2use + " 分(抵现" + scoreValue + "元)");
											// 还需支付的金额
											end_money.setText(money + pointExpressMoney - scoreValue + "");
										}
									} else {
										score2use = 0;
										Tip("积分不够，请重新输入");
									}
								} catch (Exception e) {
									APP.exception("使用积分输入的值有误", e);
									Tip("输入有误");
								}
					}
				});
				inputDialog.show();
			} else
				Tip("无可用积分");
			break;
		}
	}

	@Override
	protected void onResume() {

		loadingDismiss();
		if (tryToPay) {
			myfinish();
		}
		super.onResume();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == RESULT_OK) {
			/**
			 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
			 * @date 2014-7-5 16:34:01
			 */
			if (requestCode == APPCode.CHOICE_ADDR) {
				Bundle bundle = data.getExtras();
				revcName.setText(bundle.getString("name"));
				revcPhone.setText(bundle.getString("tel"));
				revcAddress.setText(bundle.getString("addr"));
				receiveId = bundle.getString("id");
				hadAddress = true;
				// 选择地址后，查询一次运费
				queryDistribution();
			}
		}
	}
}