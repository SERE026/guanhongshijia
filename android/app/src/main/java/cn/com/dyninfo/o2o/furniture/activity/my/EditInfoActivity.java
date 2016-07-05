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
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.bean.LocalUser;
import cn.com.dyninfo.o2o.furniture.dialog.ItemDialog;
import cn.com.dyninfo.o2o.furniture.dialog.ItemDialog.OnDismissListener;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.util.Sys;
import cn.com.dyninfo.o2o.furniture.widget.ImageFilterCropActivity;
import cn.com.dyninfo.o2o.furniture.widget.RoundImageView;

/**
 * @Description 修改账户资料
 * @created 2014-8-13 13:51:02 by <a href="http://t.cn/RvIApP5">ceychen</a>
 * @updated 2014-9-1 11:06:40 取消选取本地照片是的 crop 参数，避免裁剪后再裁剪，某些设备报错
 */
public class EditInfoActivity extends BaseActivity implements OnClickListener {

	private String PAGE_TITLE = "修改资料";
	private String tag = " AccountActivity ";
	private int layoutID = R.layout.edit_user;
	private Context context;
	private Handler handler;
	private RoundImageView head;
	private LocalUser user;
	private ImageView progress;
	private TextView name, btn_head, nick, psw;
	private String CAM_CAP_FILE_PATH;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		context = this;
		handler = new Handler();
		addToActManager(this);
		initTitleAndClick(context, layoutID, PAGE_TITLE);
		user = getLastLocalUserInfoInstance(context);

		initView();
	}

	private void initView() {
		head = (RoundImageView) findViewById(R.id.head);
		name = (TextView) findViewById(R.id.name);
		progress = (ImageView) findViewById(R.id.progress);
		btn_head = (TextView) findViewById(R.id.btn_head);
		btn_head.setOnClickListener(this);
		nick = (TextView) findViewById(R.id.nick);
		nick.setOnClickListener(this);
		psw = (TextView) findViewById(R.id.psw);
		psw.setOnClickListener(this);
	}

	private void initValue() {
		handler.post(new Runnable() {

			@Override
			public void run() {
				bmpUtils_short_holder.display(head, APP.head_path(user.head));
				name.setText(user.name);
			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_head:
			// 弹出dialog 询问是拍照还是选择图片
			final String[] items = { "图库", "拍照" };
			ItemDialog dialog = new ItemDialog(context, "头像来自", items);
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
								intent_cam.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(CAM_CAP_FILE_PATH)));
								startActivityForResult(intent_cam, APPCode.GET_CAMERA_IMAGE);
							} else {
								Tip("请插入外置存储卡");
							}
						}
					}
				}
			});
			dialog.show();
			break;

		case R.id.nick:
			startActivity(new Intent(context, EditNickActivity.class));
			animLeftToRight();
			break;
		case R.id.psw:
			startActivity(new Intent(context, EditPswActivity.class));
			animLeftToRight();
			break;
		}
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
				Log_info("选择本地图片，返回的uri 指向：" + uri.getPath());
				String[] proj = { MediaStore.Images.Media.DATA };
				Cursor actualimagecursor = managedQuery(uri, proj, null, null, null);
				int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
				actualimagecursor.moveToFirst();
				String img_path = actualimagecursor.getString(actual_image_column_index);
				Log_info("--->图片路径： " + img_path);
				startPhotoZoom(img_path);
			}

			if (requestCode == APPCode.GET_CAMERA_IMAGE) {
				System.out.println("--->拍照并保存：" + CAM_CAP_FILE_PATH);
				startPhotoZoom(CAM_CAP_FILE_PATH);
			}

			if (requestCode == APPCode.PHOTO_CUT) {
				BaseActivity.Log_info("-------------> 图片裁剪页面已关闭，即将处理接收到的数据");
				String path = data.getStringExtra("path");
				Log_info("裁剪后图片为：" + path);
				if (!path.isEmpty()) {
					doPostHead(path);
				} else {
					Tip("图片裁剪失败");
				}
			}
		}
	}

	private void doPostHead(final String img_path) {
		cachedPool().execute(new Runnable() {

			@Override
			public void run() {
				showProgress(true);
				List<String> pics = new ArrayList<String>();
				pics.add(img_path);
				String json = SyncApi.uploadImg(pics);
				JSONObject object = APP.checkReturnData(json, context);
				if (object != null && object.has("status")) {
					try {
						if (object.getInt("status") == ErrorCode.SUCCESS) {
							// TODO 获取返回的头像地址
							// {"status": 0,"fileName":
							// "xiaopao_1407920199368_pic_1407858626.png"}
							String img = object.getString("fileName");
							// 服务器接口要求先返回上传成功的图片名，再请求修改头像
							String jsonString = SyncApi.updateHead(img);
							JSONObject son = APP.checkReturnData(jsonString, context);
							if (son != null && son.getInt("status") == ErrorCode.SUCCESS) {
								user.head = img;
								user.updateLocalUser();
								initValue();
							} else
								Tip("修改头像失败，请重试");
						} else if (object.getInt("status") == ErrorCode.ERROR)
							Tip("上传失败，请重试");
					} catch (JSONException e) {
						APP.exception("上传头像返回值异常", e);
					}
				}
				showProgress(false);
			}
		});
	}

	protected void showProgress(final boolean b) {
		handler.post(new Runnable() {

			@Override
			public void run() {
				try {
					Animation anim = AnimationUtils.loadAnimation(context, R.anim.loading_animation);
					progress.setAnimation(anim);
				} catch (Exception e) {
					APP.exception(tag, e);
				}
				if (b == true) {
					progress.setVisibility(View.VISIBLE);
					progress.setAlpha(1f);
				} else
					progress.setAlpha(0f);

			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		initValue();
	}

	@Override
	public void onBackPressed() {
		myfinish();
	}

	private void startPhotoZoom(String path) {
		Intent intent = new Intent(context, ImageFilterCropActivity.class);
		intent.putExtra("path", path);
		startActivityForResult(intent, APPCode.PHOTO_CUT);
	}

}