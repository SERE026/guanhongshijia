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

package cn.com.dyninfo.o2o.furniture.dialog;

import java.util.ArrayList;
import java.util.List;

import cn.com.dyninfo.o2o.furniture.R;
import org.json.JSONArray;
import org.json.JSONObject;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.adapter.CityChoiceDialogAdapter;
import cn.com.dyninfo.o2o.furniture.bean.CitiesBean;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.util.Sys;

public class CityChoiceDialog extends Dialog {

	private Context context;
	private int marginTop;
	private List<CitiesBean> citys_list;
	private OnDismissListener dismissListener;
	private GridView gridview;
	private CityChoiceDialogAdapter adapter;
	private ImageView back; // 返回按钮
	private TextView city; // 城市名
	private Handler handler;
	private TextView loading;

	/**
	 * @Description 首页城市选择 dialog
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-6 下午5:48:52
	 * @update 2014-6-25 10:39:41
	 */
	public CityChoiceDialog(Context context, int marginTop) {
		super(context, R.style.FullScreenDialog);
		this.context = context;
		this.marginTop = marginTop;
		handler = new Handler();
		initView();
		setCancelable(true);
		setCanceledOnTouchOutside(true);
		initPosition();
		initAdapter();
		getCityList();
	}

	private void initAdapter() {
		citys_list = new ArrayList<CitiesBean>();
		if (adapter == null) {
			adapter = new CityChoiceDialogAdapter(context, citys_list);
			gridview.setAdapter(adapter);
			gridview.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					dismissListener.OnChosed(true, position, citys_list.get(position));
					dismiss();
				}
			});
		}

	}

	private void getCityList() {
		citys_list.clear();
		BaseActivity.singlePool().execute(new Runnable() {

			@Override
			public void run() {
				handler.post(new Runnable() {

					@Override
					public void run() {
						try {
							String json = SyncApi.getCities();
							JSONObject object = APP.checkReturnData(json, context);
							if (object != null && object.has("status") && object.getInt("status") == ErrorCode.SUCCESS) {
								JSONArray array = object.getJSONArray("data");
								for (int i = 0; i < array.length(); i++) {
									object = array.getJSONObject(i);
									citys_list.add(new CitiesBean(object.getString("id"), object.getString("name"),
											object.getString("ps")));
								}
							}
							System.out.println("城市共有 " + citys_list.size() + " 个");
							
							loading.setAlpha(0);
							adapter.notifyDataSetChanged();
						} catch (Exception e) {
							loading.setAlpha(0);
							APP.tip(context, "城市刷新失败，请重试");
							dismiss();
						}

					}
				});

			}
		});
	}

	private void initPosition() {
		Window window = getWindow();
		WindowManager.LayoutParams lp = window.getAttributes();
		// lp.dimAmount = 0.0f; // 不变暗
		lp.x = 0;
		lp.y = marginTop;
		lp.width = LayoutParams.MATCH_PARENT;
		lp.height = Sys.getScreenHeight(context) * 2 / 5;
		window.setAttributes(lp);
		window.setGravity(Gravity.TOP);
		window.setWindowAnimations(R.style.top_in_top_out);
		onWindowAttributesChanged(lp);
	}

	private void initView() {
		setContentView(R.layout.city_dialog);
		back = (ImageView) findViewById(R.id.back);
		city = (TextView) findViewById(R.id.city);
		gridview = (GridView) findViewById(R.id.gridview);
		loading = (TextView) findViewById(R.id.prog);
		loading.setAnimation(AnimationUtils.loadAnimation(context, R.anim.loading_animation));
		back.setVisibility(View.GONE);
		city.setVisibility(View.VISIBLE);
		city.setText(context.getSharedPreferences(APPCode.CITY, context.MODE_APPEND).getString("city_name", "全国"));
	}

	/**
	 * <p>
	 * Title: setOnDismissListener
	 * </p>
	 * <p>
	 * Description: 自定义dismiss监听
	 * </p>
	 * 
	 * @param l
	 * @see android.app.Dialog#setOnDismissListener(android.content.DialogInterface.OnDismissListener)
	 */
	public void setOnDismissListener(OnDismissListener l) {
		dismissListener = l;

	}

	/**
	 * @param chosed
	 *            点击了某一条选项
	 * @param position
	 *            点击的位置
	 * @param bean
	 *            CitiesBean
	 */
	public interface OnDismissListener {
		public void OnChosed(Boolean chosed, int position, CitiesBean bean);
	}

	@Override
	public void dismiss() {
		super.dismiss();
	}

	@Override
	public void onBackPressed() {
		dismissListener.OnChosed(false, -1, null);
		dismiss();
	}

}
