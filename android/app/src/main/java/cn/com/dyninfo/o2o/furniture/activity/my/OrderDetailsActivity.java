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

import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import cn.com.dyninfo.o2o.furniture.R;
import org.json.JSONArray;
import org.json.JSONObject;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alipay.android.app.sdk.AliPay;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.adapter.OrderDetailsGoodsAdapter;
import cn.com.dyninfo.o2o.furniture.alipay.Keys;
import cn.com.dyninfo.o2o.furniture.alipay.Result;
import cn.com.dyninfo.o2o.furniture.alipay.Rsa;
import cn.com.dyninfo.o2o.furniture.bean.OrderGoodsBean;
import cn.com.dyninfo.o2o.furniture.dialog.LoadingDialog;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.util.MyDate;
import cn.com.dyninfo.o2o.furniture.view.CustomerListView;

/**
 * @Description 订单详情
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @created 2014-5-16 14:06:02 by <a href="http://t.cn/RvIApP5">ceychen</a>
 * @updated 2014-7-31 11:36:05 by <a href="http://t.cn/RvIApP5">ceychen</a>
 */
public class OrderDetailsActivity extends BaseActivity implements OnClickListener {

	private String PAGE_TITLE = "我的订单";
	private String tag = " AddressActivity ";
	private int layoutID = R.layout.order_details;
	private Context context;
	private Handler handler;
	private CustomerListView listview;
	private TextView time, name, tel, addr, freight, score, balance, total;
	private TextView btn;
	/** 0：确认收货 ， 1：去晒单， 2：关闭页面 ，3：立即付款 */
	private int btnCode = 0;
	private String id;
	private List<OrderGoodsBean> item_list;
	private OrderDetailsGoodsAdapter adapter;
	private JSONObject object;
	// 自取件没有收货人地址
	private TextView self_tip;
	private RelativeLayout rece_layout;
	// 取消支付、支付成功时，对页面的操作
	private Boolean tryToPay = false;
	private static final int ALIPAY_PEY = 1;
	private static final int ALIPAY_SIGN = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		context = this;
		addToActManager(this);
		handler = new Handler();
		initTitleAndClick(context, layoutID, PAGE_TITLE);

		initBundle();
		initView();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				initView4Data();
				getDetail();
			}
		}, 100);

	}

	protected void getDetail() {
		new Thread() {
			public void run() {

				String json = SyncApi.getOrderDetails(id);
				object = APP.checkReturnData(json, context);
				handler.post(new Runnable() {
					@Override
					public void run() {
						try {
							if (object != null) {
								if (object.has("status"))
									if (object.getInt("status") == ErrorCode.ERROR) {
										Tip("获取详情失败");
									} else if (object.getInt("status") == ErrorCode.SUCCESS) {
										object = object.getJSONObject("data");
										JSONArray array = object.getJSONArray("orderProductList");
										item_list = new ArrayList<OrderGoodsBean>();
										for (int i = 0; i < array.length(); i++) {
											JSONObject item_object = array.getJSONObject(i);
											item_list.add(new OrderGoodsBean(item_object.getString("name"), item_object
													.getDouble("goodMoney"), Integer.valueOf(item_object
													.getString("num")), item_object.getDouble("xiaoji")));
										}

										// 自提无地址，需要设置隐藏 dly：1 物流 0上门提货
										if (Integer.valueOf(object.getString("dly")) == 1) {
											self_tip.setVisibility(View.INVISIBLE);
											rece_layout.setVisibility(View.VISIBLE);
										} else if (Integer.valueOf(object.getString("dly")) == 0) {
											self_tip.setVisibility(View.VISIBLE);
											rece_layout.setVisibility(View.INVISIBLE);
										}
										// 状态码：0.等待付款 1.已付款
										// 2.已发货3.确认完成4.申请退款5.申请退货6.交易失败
										// 订单状态
										((TextView) findViewById(R.id.order_status)).setText(APPCode
												.getOrderPay(Integer.valueOf(object.getString("state"))));
										// 状态码判断
										switch (Integer.valueOf(object.getString("state"))) {
										case 0:
											btn.setText("立即付款");
											btnCode = 3;
											break;
										case 1:
											btn.setText("返回");
											btnCode = 2;
											break;
										case 2:
											btn.setText("确认收货");
											btnCode = 0;
											break;
										// 属于客户端不操作的类型
										case 3:
											btn.setText("返回");
											btnCode = 2;
											break;
										case 4:
											btn.setText("返回");
											btnCode = 2;
											break;
										case 5:
											btn.setText("返回");
											btnCode = 2;
											break;
										case 6:
											btn.setText("返回");
											btnCode = 2;
											break;

										default:
											btn.setText("返回");
											btnCode = 2;
											break;
										}
										// 0需要晒单，1晒过单了
										if (Integer.valueOf(object.getString("isShaiDan")) == 0) {
											// 不是确认收货、立即付款状态，而且可以晒单的情况
											if (btnCode != 0 && btnCode != 3) {
												btn.setText("我要晒单");
												btnCode = 1;
											}
										}

										time.setText(MyDate.timestamp2date(object.getString("creatTime")));
										name.setText(object.getString("receiveName"));
										tel.setText(object.getString("receiveTel").replace("-", "").replace(" ", ""));
										addr.setText(object.getString("province") + " " + object.getString("city")
												+ " " + object.getString("county") + " " + object.getString("address"));
										freight.setText(object.getString("shippingPrice"));
										score.setText(object.getString("pointPrice"));
										balance.setText(object.getString("zfmoney"));
										total.setText(object.getString("orderPrice"));

										btn.setVisibility(View.VISIBLE);
										initAdapter();
									}
							}else {
								Tip("获取订单详情失败" + APPCode.WEB_NULL);
							}
						} catch (Exception e) {
							APP.exception("OrderDetailsActivity JSON :", e);
							Tip("获取失败");
						}
					}
				});

			};
		}.start();
	}

	protected void initView4Data() {
		// 交易时间
		time = (TextView) findViewById(R.id.order_trading_time);
		// 收件人
		name = (TextView) findViewById(R.id.recipients_name);
		// 收件人电话
		tel = (TextView) findViewById(R.id.recipients_tel);
		// 地址
		addr = (TextView) findViewById(R.id.recipients_addre);
		// 运费
		freight = (TextView) findViewById(R.id.total_freight);
		// 积分
		score = (TextView) findViewById(R.id.score);
		// 余额支付
		balance = (TextView) findViewById(R.id.balance);
		// 总计
		total = (TextView) findViewById(R.id.order_total);
	}

	private void initBundle() {
		Bundle bundle = getIntent().getExtras();
		if (bundle == null) {
			return;
		}
		id = bundle.getString("orderNo");
		((TextView) findViewById(R.id.order_no)).setText(id);// 订单号
	}

	private void initAdapter() {
		if (adapter == null) {
			adapter = new OrderDetailsGoodsAdapter(context, item_list);
			listview.setAdapter(adapter);
		}
		notifyAdapter();
	}

	@Override
	public void onClick(View v) {

		// 测试用：这里直接跳转去晒单界面，不判断
		// Intent intent_comment = new Intent(this, OrderCommentActivity.class);
		// Bundle bundle = new Bundle();
		// bundle.putString("orderNO", id);
		// bundle.putSerializable("list", (Serializable) item_list);
		// intent_comment.putExtras(bundle);
		// startActivityForResult(intent_comment, APPCode.ORDER_COMMENT);
		// animLeftToRight();

		switch (v.getId()) {
		case R.id.btn:
			switch (btnCode) {
			case 0:
				final LoadingDialog dialog = new LoadingDialog(context);
				dialog.show();
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						cachedPool().execute(new Runnable() {
							@Override
							public void run() {
								String json = SyncApi.confirmOrderReceipt(id);
								final JSONObject object = APP.checkReturnData(json, context);
								handler.post(new Runnable() {

									@Override
									public void run() {
										try {
											if (object.has("status")) {
												if (object.getInt("status") == ErrorCode.SUCCESS) {
													Tip("确认收货成功");
													btn.setText("立即晒单");
													btnCode = 1;
												} else
													Tip("确认收货失败");
											} else
												Tip("确认收货失败，请刷新再试");

										} catch (Exception e) {
											Tip("确认收货失败，请刷新再试");
										}
										dialog.dismiss();
									}
								});
							}
						});
					}
				}, 350);
				break;
			case 1:
				Intent intent_comment = new Intent(this, OrderCommentActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("orderNO", id);
				bundle.putSerializable("list", (Serializable) item_list);
				intent_comment.putExtras(bundle);
				startActivityForResult(intent_comment, APPCode.ORDER_COMMENT);
				animLeftToRight();
				break;
			case 2:
				myfinish();
				break;
			case 3:
				final LoadingDialog hold = new LoadingDialog(context);
				hold.show();
				hold.setCancelable(false);
				// 开始获取数据
				new Thread() {
					public void run() {
						String json = SyncApi.getOrderMoney(id);
						JSONObject object = APP.checkReturnData(json, context);
						if (object != null && object.has("status")) {
							try {
								if (object.getInt("status") == ErrorCode.SUCCESS) {
									JSONArray array = object.getJSONArray("data");
									if (array.length() > 0) {
										JSONObject son = array.getJSONObject(0);
										doPay(son.getString("tradeNo"), son.getDouble("orderMoney"));
									} else {
										Tip("获取订单信息失败，请重试");
									}
								} else if (object.getInt("status") == ErrorCode.ERROR) {
									Tip("获取订单信息失败");
								}
							} catch (Exception e) {
								APP.exception(json, e);
							}
						}

						hold.dismiss();
					};
				}.start();
				break;
			}
			break;
		}
	}

	/**
	 * @Description 调用支付宝去支付
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-8-8 下午5:58:56
	 */
	protected void doPay(String order, double money) {
		StringBuilder sb = new StringBuilder();
		sb.append("partner=\"");
		sb.append(Keys.DEFAULT_PARTNER);
		sb.append("\"&out_trade_no=\"");
		sb.append(order);
		sb.append("\"&subject=\"");
		sb.append("炫品妆成客户端下单");
		sb.append("\"&body=\"");
		sb.append("订单金额：" + money + "元");
		sb.append("\"&total_fee=\"" + money);
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

		String orderInfo = sb.toString();
		String sign = Rsa.sign(orderInfo, Keys.PRIVATE);
		sign = URLEncoder.encode(sign);
		orderInfo += "&sign=\"" + sign + "\"&" + "sign_type=\"RSA\"";
		Log_info("start pay");
		// 开始调用支付宝
		AliPay alipay = new AliPay(OrderDetailsActivity.this, alipayHandler);
		tryToPay = true;
		// 设置为沙箱模式，不设置默认为线上环境
		// alipay.setSandBox(true);
		String result = alipay.pay(orderInfo);
		System.out.println("result = " + result);
		Message msg = new Message();
		msg.what = ALIPAY_PEY;
		msg.obj = result;
		alipayHandler.sendMessage(msg);
	}

	Handler alipayHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			Result result = new Result((String) msg.obj);
			switch (msg.what) {
			case ALIPAY_PEY:

			case ALIPAY_SIGN:
				Tip(result.getResult());
				break;

			default:
				break;
			}
		};
	};

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			if (requestCode == APPCode.ORDER_COMMENT) {
				btn.setText("已完成");
				btnCode = 2;
			}
		}

		// 尝试付款后，重新获取数据（没用）
		if (tryToPay) {
			getDetail();
		}
	}

	private void initView() {
		listview = (CustomerListView) findViewById(R.id.listview);
		btn = (TextView) findViewById(R.id.btn);
		btn.setOnClickListener(this);

		self_tip = (TextView) findViewById(R.id.self_tip);
		rece_layout = (RelativeLayout) findViewById(R.id.rece_layout);
	}

	private void notifyAdapter() {
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

}