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

package cn.com.dyninfo.o2o.furniture.activity.my;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.com.dyninfo.o2o.furniture.R;
import org.json.JSONObject;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.adapter.OrderCommentAdapter;
import cn.com.dyninfo.o2o.furniture.bean.OrderCommentImgBean;
import cn.com.dyninfo.o2o.furniture.bean.OrderGoodsBean;
import cn.com.dyninfo.o2o.furniture.dialog.ItemDialog;
import cn.com.dyninfo.o2o.furniture.dialog.ItemDialog.OnDismissListener;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.util.Sys;
import cn.com.dyninfo.o2o.furniture.view.CustomerListView;
import cn.com.dyninfo.o2o.furniture.widget.ImageFilterCropActivity;

/**
 * @Description 订单评价（晒单） - 完成
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @created 2014-5-19 14:43:49 by <a href="http://t.cn/RvIApP5">ceychen</a>
 * @updated 2014-9-1 11:06:40 取消选取本地照片是的 crop 参数，避免裁剪后再裁剪，某些设备报错
 */
public class OrderCommentActivity extends BaseActivity implements OnClickListener {

	private String PAGE_TITLE = "我的订单";
	private String tag = " OrderCommentActivity ";
	private int layoutID = R.layout.order_comment;
	private Context context;
	private Handler handler;
	private CustomerListView listview;
	private TextView btn;
	private OrderCommentAdapter adapter;
	private List<OrderGoodsBean> item_list = new ArrayList<OrderGoodsBean>();
	private List<OrderCommentImgBean> item_list_img = new ArrayList<OrderCommentImgBean>();
	private List<OrderCommentImgBean> item_list_img_temp = new ArrayList<OrderCommentImgBean>();
	private int POINT_CLICK;
	private String CAM_CAP_FILE_PATH;
	// 待上传图片
	private List<String> pics;
	// 服务器那边图片是按照list里面put图片的顺序的接收的
	private StringBuffer sb = null;// 记录添加图片的顺序
	private String id; // order no.
	private Boolean isPosted = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		context = this;
		addToActManager(this);
		handler = new Handler();
		initTitleAndClick(context, layoutID, PAGE_TITLE);
		initView();
		initBundle();
		initAdapter();
		initBroadcast();
	}

	private void initBundle() {
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			id = bundle.getString("orderNO");
			item_list = (List<OrderGoodsBean>) bundle.getSerializable("list");
			if (item_list == null || item_list.size() == 0) {
				Tip("获取订单信息失败");
				myfinish();
			} else
				for (int i = 0; i < item_list.size(); i++) {
					item_list_img.add(new OrderCommentImgBean(null, null, null, null));
				}
		}
	}

	private void initAdapter() {
		adapter = new OrderCommentAdapter(context, item_list, item_list_img);
		listview.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.btn:
			if (!isPosted)
				doPost();
			else if (isPosted)
				myfinish();
			break;
		}
	}

	private void doPost() {
		loadingShow();
		cachedPool().execute(new Runnable() {
			@Override
			public void run() {
				if (pics != null) {
					Log_error("----------------> 共有图片：" + pics.size() + " 张");
					for (String path : pics)
						Log_error("----------------> 路径：" + path);
				}
				if (sb == null) {
					Log_info("-----> 图片顺序：没有选择图片");
				} else {
					Log_info("-----> 图片顺序：" + sb.toString().substring(0, sb.length() - 1));
				}
				
				String pic_order = sb == null ? "" : sb.toString().substring(0, sb.length() - 1);
				String json = SyncApi.postOrderCommentary(id, adapter.getRatings(), adapter.getComTxt()
						+ "  [来自Android客户端]", pic_order, pics);
				JSONObject object = APP.checkReturnData(json, context);
				if (object != null && object.has("status")) {
					try {
						if (object.getInt("status") == ErrorCode.SUCCESS) {
							handler.post(new Runnable() {
								@Override
								public void run() {
									btn.setText("已完成");
								}
							});
							isPosted = true;
							Tip("晒单成功");
							setResult(RESULT_OK);
							findViewById(R.id.back).performClick();
						} else if (object.getInt("status") == ErrorCode.ERROR) {
							Tip("晒单失败");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					Tip("晒单失败" + APPCode.WEB_NULL);
				}
				loadingDismiss();
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Uri uri;
			if (requestCode == APPCode.CHOICE_LOCATION_PIC) {
				if (data == null || "".equals(data)) {
					Tip("选取图片失败");
					return;
				}
				uri = data.getData();
				String[] proj = { MediaStore.Images.Media.DATA };
				Cursor actualimagecursor = managedQuery(uri, proj, null, null, null);
				int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
				actualimagecursor.moveToFirst();
				String img_path = actualimagecursor.getString(actual_image_column_index);
				Log_info("--->图片路径： " + img_path);
				startPhotoZoom(img_path);
			}
			if (requestCode == APPCode.GET_CAMERA_IMAGE) {
				Log_info("--->拍照并保存：" + CAM_CAP_FILE_PATH);
				startPhotoZoom(CAM_CAP_FILE_PATH);
			}

			if (requestCode == APPCode.PHOTO_CUT) {

				String img_path = data.getStringExtra("path");
				Log_info("裁剪后图片为：" + img_path);
				if (!img_path.isEmpty()) {
					if (pics == null) {
						pics = new ArrayList<String>();
					}
					pics.add(img_path);
					if (sb == null)
						sb = new StringBuffer();
					sb.append(POINT_CLICK);
					sb.append(",");
					// 将 img_path 添加到 List
					OrderCommentImgBean imgBean = item_list_img_temp.get(POINT_CLICK);
					if (imgBean.getImg_1() == null) {
						imgBean.setImg_1(img_path);
					} else if (imgBean.getImg_2() == null) {
						imgBean.setImg_2(img_path);
					} else if (imgBean.getImg_3() == null) {
						imgBean.setImg_3(img_path);
					} else if (imgBean.getImg_4() == null) {
						imgBean.setImg_4(img_path);
					}
					item_list_img_temp.set(POINT_CLICK, imgBean);
					item_list_img.clear();
					item_list_img.addAll(item_list_img_temp);
					notifyAdapter();
				} else {
					Tip("图片裁剪失败");
				}

			}
		}
	}

	private void initView() {
		listview = (CustomerListView) findViewById(R.id.listview);
		btn = (TextView) findViewById(R.id.btn);
		btn.setOnClickListener(this);
	}

	// 跳转到详情页
	private BroadcastReceiver addPicBroadcastReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals("cn.com.dyninfo.o2o.furniture.activity.my.OrderCommentActivity#addpic")) {
				POINT_CLICK = intent.getExtras().getInt("position");
				item_list_img_temp = (List<OrderCommentImgBean>) intent.getExtras().getSerializable("img_list");

				// 弹出dialog 询问是拍照还是选择图片
				final String[] items = { "图库", "拍照" };
				// 2014-5-21 10:48:35 全新体验
				ItemDialog dialog = new ItemDialog(context, "图片来自", items);
				dialog.setOnDismissListener(new OnDismissListener() {
					@Override
					public void OnChosed(Boolean chosed, int position) {
						if (chosed) {
							if (position == 0) {
								// 选择图片
								Intent intent_addpic = new Intent(Intent.ACTION_GET_CONTENT);
								intent_addpic.setType("image/*");
								intent_addpic.putExtra("return-data", true);
								startActivityForResult(intent_addpic, APPCode.CHOICE_LOCATION_PIC);
							} else if (position == 1) {
								// 拍照
								if (Sys.isSDcardExist()) {
									Intent intent_cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
									// 保存到 temp 文件夹
									CAM_CAP_FILE_PATH = APP.getPicTempPath();
									intent_cam.putExtra(MediaStore.EXTRA_OUTPUT,
											Uri.fromFile(new File(CAM_CAP_FILE_PATH)));
									startActivityForResult(intent_cam, APPCode.GET_CAMERA_IMAGE);
								} else {
									Tip("请插入外置存储卡");
								}
							}
						}
					}
				});
				dialog.show();

			}
		}
	};

	private void startPhotoZoom(String path) {
		Intent intent = new Intent(context, ImageFilterCropActivity.class);
		intent.putExtra("path", path);
		startActivityForResult(intent, APPCode.PHOTO_CUT);
	}

	private void initBroadcast() {
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("cn.com.dyninfo.o2o.furniture.activity.my.OrderCommentActivity#addpic");
		registerReceiver(addPicBroadcastReceiver, intentFilter);
	}

	private void notifyAdapter() {
		handler.post(new Runnable() {
			@Override
			public void run() {
				adapter.notifyDataSetChanged();
				item_list_img_temp = null;
			}
		});
	}

	@Override
	public void onBackPressed() {
		myfinish();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(addPicBroadcastReceiver);
	}
}