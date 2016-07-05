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

package cn.com.dyninfo.o2o.furniture.fragment;

import cn.com.dyninfo.o2o.furniture.R;
import org.json.JSONArray;
import org.json.JSONObject;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.ItemizedOverlay;
import com.baidu.mapapi.map.LocationData;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationOverlay;
import com.baidu.mapapi.map.OverlayItem;
import com.baidu.mapapi.map.PopupOverlay;
import com.baidu.mapapi.search.MKAddrInfo;
import com.baidu.mapapi.search.MKBusLineResult;
import com.baidu.mapapi.search.MKDrivingRouteResult;
import com.baidu.mapapi.search.MKPoiResult;
import com.baidu.mapapi.search.MKSearch;
import com.baidu.mapapi.search.MKSearchListener;
import com.baidu.mapapi.search.MKShareUrlResult;
import com.baidu.mapapi.search.MKSuggestionResult;
import com.baidu.mapapi.search.MKTransitRouteResult;
import com.baidu.mapapi.search.MKWalkingRouteResult;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.activity.IndexActivity;
import cn.com.dyninfo.o2o.furniture.activity.home.GoodsListActivity;
import cn.com.dyninfo.o2o.furniture.dialog.ProvincesDialog;
import cn.com.dyninfo.o2o.furniture.dialog.ProvincesDialog.OnDismissListener;
import cn.com.dyninfo.o2o.furniture.map.DemoApplication;
import cn.com.dyninfo.o2o.furniture.map.MyOverLayItem;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.Constant;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;

/**
 * @Description 实体商家（地图）
 * @author ly
 * @date 2014-4
 * @updated 2014-8-28 16:01:22 不在当前界面则不取数据
 *          <hr>
 *          2014-8-25 18:06:21 解决到别的城市后，需要手动切换城市才能显示poi点 by <a
 *          href="http://t.cn/RvIApP5">ceychen</a>
 */
public class SideFragment extends BaseFragment implements OnClickListener {

	public String PAGE_TITLE = "身边店家";
	public String cityName = "";
	int deviceWidth;
	private Context context;
	private Handler handler;

	private TextView select_province, select_city, select_quxian;
	public static RelativeLayout shop_layout;
	public static TextView click_shop;// class MyOverLayItem 用到

	MapController controller = null;
	private RelativeLayout side_main_search;
	private AutoCompleteTextView edit_search_address_name;
	private ProvincesDialog dialog;

	MKSearch poiSearch;
	// 定位相关
	LocationClient locationClient;
	LocationData locData = null;
	// 定位图层
	locationOverlay myLocationOverlay = null;
	// 弹出泡泡图层
	private PopupOverlay pop = null;// 弹出泡泡图层，浏览节点时使用
	private TextView popupText = null;// 泡泡view
	private View viewCache = null;
	// 地图相关，使用继承MapView的MyLocationMapView目的是重写touch事件实现泡泡处理
	// 如果不处理touch事件，则无需继承，直接使用MapView即可
	// MyLocationMapView mapView = null; // 地图View
	MapView mapView = null; // 地图View
	private MapController mMapController = null;

	boolean isRequest = false;// 是否手动触发请求定位
	boolean isFirstLoc = true;// 是否首次定位
	private Button getpoint;
	/** 搜索 */
	MKSearch mSearch = null; // 搜索模块，也可去掉地图模块独立使用

	/************************** 省市区选择器 ****************************/
	// private PopupWindow popWindow;
	// private ListView listView;
	// private ArrayList<String> itemList;
	// private int PROVINCE_POINT;
	// private PopWindowAdapter adapter;
	/***/
	DemoApplication app;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = getActivity();
		handler = new Handler();
		poiSearch = new MKSearch();
		// initBroadcast();
		/**
		 * 初始化BMapManager. BMapManager是全局的，可为多个MapView共用，它需要地图模块创建前创建，
		 * 并在地图地图模块销毁后销毁，只要还有地图模块在使用，BMapManager就不应该销毁
		 */
		app = new DemoApplication();
		if (app.mBMapManager == null) {
			app.mBMapManager = new BMapManager(context.getApplicationContext());
			app.mBMapManager.init(new DemoApplication.MyGeneralListener());
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.side_main, container, false);
		initView(view);
		initMap();
		// initValue();
		initClick();
		// initPop();

		return view;
	}

	private void initMap() {
		mMapController = mapView.getController();
		mMapController.setZoom(14);
		mMapController.enableClick(true);
		mapView.setBuiltInZoomControls(false);// 是否启用内置的缩放控件

		/** 定位初始化 */
		locationClient = new LocationClient(context.getApplicationContext());
		locData = new LocationData();
		locationClient.registerLocationListener(new LocationListener());
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);// 打开gps
		option.setCoorType("bd09ll"); // 设置坐标类型
		option.setScanSpan(30 * 1000);// 30 秒 定位一次
		option.setAddrType("all");// 4.1 以后是
									// setIsNeedAddress，都怪这个大哥些的旧版本啊！！！
		locationClient.setLocOption(option);
		locationClient.start();
		// 定位图层初始化
		myLocationOverlay = new locationOverlay(mapView);
		// 设置定位数据
		myLocationOverlay.setData(locData);
		// 添加定位图层
		mapView.getOverlays().add(myLocationOverlay);
		myLocationOverlay.enableCompass();
		// 修改定位数据后刷新图层生效
		mapView.refresh();
		modifyLocationOverlayIcon(null);
	}

	/**
	 * @Description 【省市区】选择器
	 */
	private void showProvincesWheel() {
		if (dialog == null) {
			dialog = new ProvincesDialog(getActivity());
		}
		dialog.setOnDismissListener(new OnDismissListener() {
			@Override
			public void OnChoiced(String province, String city, String area) {
				select_province.setText(province);
				select_city.setText(city);
				select_quxian.setText(area);
				cityName = city;
				initValue(false);
				poiSearch.init(app.mBMapManager, new MKSearchListener() {

					@Override
					public void onGetAddrResult(MKAddrInfo result, int arg1) {

						GeoPoint mPoint = result.geoPt;
						mMapController.setCenter(mPoint);

					}

					@Override
					public void onGetBusDetailResult(MKBusLineResult arg0, int arg1) {
					}

					@Override
					public void onGetDrivingRouteResult(MKDrivingRouteResult arg0, int arg1) {
					}

					@Override
					public void onGetPoiDetailSearchResult(int arg0, int arg1) {
					}

					@Override
					public void onGetPoiResult(MKPoiResult arg0, int arg1, int arg2) {
					}

					@Override
					public void onGetShareUrlResult(MKShareUrlResult arg0, int arg1, int arg2) {
					}

					@Override
					public void onGetSuggestionResult(MKSuggestionResult arg0, int arg1) {
					}

					@Override
					public void onGetTransitRouteResult(MKTransitRouteResult arg0, int arg1) {
					}

					@Override
					public void onGetWalkingRouteResult(MKWalkingRouteResult arg0, int arg1) {
					}
				});
				poiSearch.geocode(area, city);
			}
		});
		dialog.show();
	}

	/**
	 * @Description 显示附近的商家poi（选择城市、重新定位后都将执行）
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @param 设定文件
	 * @return void 返回类型
	 * @updated by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-8-25 下午4:41:05
	 */
	private void initValue(final Boolean showAll) {
		// 不在本界面时，不获取商家信息
		if (IndexActivity.nowPoint_temp != 3) {
			return;
		}
		cachedPool().execute(new Runnable() {

			@Override
			public void run() {
				handler.post(new Runnable() {

					@Override
					public void run() {
						try {
							if (cityName == null)
								cityName = "";
							// 清空标注
							mapView.getOverlays().clear();

							String content = SyncApi.getPOIList(context, showAll, cityName);
							if (content != null) {
								JSONObject object = new JSONObject(content);
								Drawable marker = getResources().getDrawable(R.drawable.icon_gcoding);
								if (object.has("status")) {
									if (object.getInt("status") == ErrorCode.SUCCESS) {
										JSONArray jsonArray = object.getJSONArray("data");
										// list = new
										// ArrayList<HotMarketBean>();
										// 生成ItemizedOverlay图层用来标注结果点
										MyOverLayItem itemOverlay = new MyOverLayItem(context, null, mapView);
										for (int i = 0; i < jsonArray.length(); i++) {
											JSONObject jsonObject = jsonArray.getJSONObject(i);

											int shangjia_id = jsonObject.getInt("shangjiaid");
											String name = jsonObject.getString("name");
											double longitude = jsonObject.getDouble("lon");
											double latitude = jsonObject.getDouble("lat");

											GeoPoint gp = new GeoPoint((int) (latitude * 1E6), (int) (longitude * 1E6));
											// 生成Item
											OverlayItem item = new OverlayItem(gp, "" + shangjia_id, name);
											// 得到需要标在地图上的资源
											// 为maker定义位置和边界
											marker.setBounds(0, 0, marker.getIntrinsicWidth(),
													marker.getIntrinsicHeight());
											// 给item设置marker
											item.setMarker(marker);
											// 在图层上添加item
											itemOverlay.addItem(item);
										}

										mapView.getOverlays().add(itemOverlay);

									} else if (object.getInt("status") == ErrorCode.ERROR) {
										try {
											Tip("请检查网络连接");
										} catch (Exception e) {
											APP.exception("连接异常", e);
										}
									}
								}
							}

							// 执行刷新使生效
							mapView.getOverlays().add(myLocationOverlay);
							mapView.refresh();
							app.mBMapManager.start();
						} catch (Exception e) {
							APP.exception("地图获取附近商家信息", e);
						}
					}
				});
			}
		});

	}

	private void initClick() {
		select_province.setOnClickListener(this);
		select_city.setOnClickListener(this);
		select_quxian.setOnClickListener(this);
		side_main_search.setOnClickListener(this);
		getpoint.setOnClickListener(this);

		shop_layout.setOnClickListener(this);
	}

	private void initView(View view) {
		mapView = (MapView) view.findViewById(R.id.bmapView);
		select_province = (TextView) view.findViewById(R.id.select_province);
		select_city = (TextView) view.findViewById(R.id.select_city);
		select_quxian = (TextView) view.findViewById(R.id.select_quxian);

		click_shop = (TextView) view.findViewById(R.id.click_shop);
		side_main_search = (RelativeLayout) view.findViewById(R.id.side_main_search);
		edit_search_address_name = (AutoCompleteTextView) view.findViewById(R.id.edit_search_address_name);
		getpoint = (Button) view.findViewById(R.id.getpoint);
		shop_layout = (RelativeLayout) view.findViewById(R.id.shop_layout);
		try {
			Animation anim = AnimationUtils.loadAnimation(context, R.anim.slide_out_to_bottom);
			shop_layout.setAnimation(anim);
		} catch (Exception e) {
			shop_layout.setVisibility(View.GONE);
			APP.exception("地图设置底部栏", e);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.select_province:
			// showAsDropDown(v);
			showProvincesWheel();
			break;

		case R.id.select_city:
			// showAsDropDown(v);
			showProvincesWheel();
			break;

		case R.id.select_quxian:
			// showAsDropDown(v);
			showProvincesWheel();
			break;

		case R.id.side_main_search:
			// 搜索
			if (!BaseActivity.getTextFromView(edit_search_address_name).isEmpty()) {
				initGeo();
				// 发起搜索，没有当前的定位地址信息则按照本地存储的城市来操作
				String CITY = "";
				if (cityName.isEmpty()) {
					CITY = context.getSharedPreferences(APPCode.CITY, Context.MODE_APPEND).getString("city_name", "成都");
				} else {
					CITY = cityName;
				}
				mSearch.geocode(BaseActivity.getTextFromView(edit_search_address_name), CITY);
			} else {
				Tip("请输入你想查找的位置");
			}
			break;

		case R.id.shop_layout: {
			if (MyOverLayItem.onId == 0) {
				return;
			}
			Bundle bundle = new Bundle();
			bundle.putString("id", String.valueOf(MyOverLayItem.onId));
			bundle.putString("page_title", MyOverLayItem.onName);
			bundle.putInt("from", APPCode.SHOP_GOODS_LIST);
			Intent intent = new Intent(context, GoodsListActivity.class);
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		}

		case R.id.getpoint:
			requestLocClick();
			break;

		}
	}

	/**
	 * 初始化搜索模块，注册事件监听
	 */
	private void initGeo() {
		mSearch = new MKSearch();
		mSearch.init(app.mBMapManager, new MKSearchListener() {
			@Override
			public void onGetPoiDetailSearchResult(int type, int error) {
			}

			public void onGetAddrResult(MKAddrInfo res, int error) {
				if (error != 0) {
					Tip("没有检索到(" + error + ")");
					return;
				}
				// 地图移动到该点
				mapView.getController().animateTo(res.geoPt);
				if (res.type == MKAddrInfo.MK_GEOCODE) {
					// 地理编码：通过地址检索坐标点
					String strInfo = String.format("纬度：%f 经度：%f", res.geoPt.getLatitudeE6() / 1e6,
							res.geoPt.getLongitudeE6() / 1e6);
				}
				if (res.type == MKAddrInfo.MK_REVERSEGEOCODE) {
					// 反地理编码：通过坐标点检索详细地址及周边poi
					String strInfo = res.strAddr;
					Tip(strInfo);
				}
				// 生成ItemizedOverlay图层用来标注结果点
				ItemizedOverlay<OverlayItem> itemOverlay = new ItemizedOverlay<OverlayItem>(null, mapView);
				// 生成Item
				OverlayItem item = new OverlayItem(res.geoPt, "", null);
				// 得到需要标在地图上的资源
				Drawable marker = getResources().getDrawable(R.drawable.icon_gcoding);
				// 为maker定义位置和边界
				marker.setBounds(0, 0, marker.getIntrinsicWidth(), marker.getIntrinsicHeight());
				// 给item设置marker
				item.setMarker(marker);
				// 在图层上添加item
				itemOverlay.addItem(item);

				// 清除地图其他图层
				// mapView.getOverlays().clear();
				// 添加一个标注ItemizedOverlay图层
				mapView.getOverlays().add(itemOverlay);
				// 执行刷新使生效
				mapView.refresh();
			}

			public void onGetPoiResult(MKPoiResult res, int type, int error) {

			}

			public void onGetDrivingRouteResult(MKDrivingRouteResult res, int error) {
			}

			public void onGetTransitRouteResult(MKTransitRouteResult res, int error) {
			}

			public void onGetWalkingRouteResult(MKWalkingRouteResult res, int error) {
			}

			public void onGetBusDetailResult(MKBusLineResult result, int iError) {
			}

			@Override
			public void onGetSuggestionResult(MKSuggestionResult res, int arg1) {
			}

			@Override
			public void onGetShareUrlResult(MKShareUrlResult result, int type, int error) {
			}
		});
	}

	/**
	 * 手动触发一次定位请求
	 */
	public void requestLocClick() {
		isRequest = true;
		if (locationClient != null && locationClient.isStarted()) {
			locationClient.requestLocation();
			Tip("定位中…");
		}
	}

	/**
	 * 修改位置图标的样式
	 * 
	 * 
	 * @param marker
	 *            marker为null时，使用默认图标绘制
	 */
	public void modifyLocationOverlayIcon(Drawable marker) {
		myLocationOverlay.setMarker(marker);
		// 修改图层，需要刷新MapView生效
		mapView.refresh();
	}

	/**
	 * 定位监听
	 */
	public class LocationListener implements BDLocationListener {

		@Override
		public void onReceiveLocation(BDLocation location) {
			if (location == null) {
				Tip("定位失败");
				return;
			}

			Log_info("地址：" + location.getAddrStr());
			locData.latitude = location.getLatitude();
			locData.longitude = location.getLongitude();
			// 更新位置信息
			Constant.lat = locData.latitude;
			Constant.lng = locData.longitude;
			// 如果不显示定位精度圈，将accuracy赋值为0即可
			locData.accuracy = location.getRadius();
			// 此处可以设置 locData的方向信息, 如果定位 SDK 未返回方向信息，可以自己实现罗盘功能添加方向信息。
			locData.direction = location.getDerect();
			// 更新定位数据
			myLocationOverlay.setData(locData);
			// 更新图层数据执行刷新后生效
			mapView.refresh();
			// 是手动触发请求或首次定位时，移动到定位点
			if (isRequest || isFirstLoc) {
				// 移动地图到定位点
				mMapController.animateTo(new GeoPoint((int) (locData.latitude * 1e6), (int) (locData.longitude * 1e6)));
				isRequest = false;
			}

			// 网络方式定位的才有地址
			if (location.getLocType() == BDLocation.TypeNetWorkLocation) {
				cityName = location.getCity();
				// 更新市区县
				select_province.setText(location.getProvince());
				select_city.setText(cityName);
				select_quxian.setText(location.getDistrict());
				// Tip("定位到地址：" + location.getAddrStr());
			}
			if (cityName == null || cityName.equals("")) {
				select_province.setText("请选择");
				select_city.setText("请选择");
				select_quxian.setText("请选择");
				initValue(true);
			} else
				initValue(false);
			// 首次定位完成
			isFirstLoc = false;
		}

		public void onReceivePoi(BDLocation poiLocation) {
			if (poiLocation == null) {
				return;
			}
		}
	}

	// 继承MyLocationOverlay重写dispatchTap实现点击处理
	public class locationOverlay extends MyLocationOverlay {

		public locationOverlay(MapView mapView) {
			super(mapView);
		}

		@Override
		protected boolean dispatchTap() {
			return true;
		}
	}

	@Override
	public void onPause() {
		mapView.onPause();
		super.onPause();
	}

	@Override
	public void onResume() {
		mapView.onResume();
		super.onResume();
	}

	@Override
	public void onDestroy() {
		// 退出时销毁定位
		if (locationClient != null)
			locationClient.stop();
		mapView.destroy();
		super.onDestroy();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mapView.onSaveInstanceState(outState);

	}

	@Override
	public void onDestroyView() {
		// context.unregisterReceiver(updateListBroadcastReceiver);
		super.onDestroyView();
	}
}

/**
 * 继承MapView重写onTouchEvent实现泡泡处理操作
 * 
 */
class MyLocationMapView extends MapView {
	static PopupOverlay pop = null;// 弹出泡泡图层，点击图标使用

	public MyLocationMapView(Context context) {
		super(context);
	}

	public MyLocationMapView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyLocationMapView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (super.onTouchEvent(event)) {
			// 消隐泡泡
			if (pop != null && event.getAction() == MotionEvent.ACTION_UP)
				pop.hidePop();
		}
		return true;
	}

	final class MyOverlayItem extends ItemizedOverlay<OverlayItem> {

		public MyOverlayItem(Drawable drawble, MapView mapview) {
			super(drawble, mapview);
		}
	}
}
