package com.wckj.gfsj.Alipay;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.wckj.gfsj.Alipay.util.PayOrderInfoUtil2_0;
import com.wckj.gfsj.R;

import java.util.Map;

public class PayDemoActivity extends FragmentActivity {
	//创建的APPID
	public static final String APPID = "2088421503901771";
	// 商户收款账号
	public static final String SELLER = "guanhongshijia@126.com";
	// 商户私钥，pkcs8格式
	public static final String RSA_PRIVATE = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALyJoRqZKg6vAQ3y\n" +
			"fSCvoKSjwB57bNWAUvHwcpJ0mxNlV4U5S62Tzcf1YjvGBa7fdV9BzKR7oUetrLQP\n" +
			"S79zZTMSXN+HhhJUnYE4twONfZnXgEDtOPkwFWxwY761gbYYJVcIvRBQ0FtLm8gC\n" +
			"NU//5ZpSwp/uDnjsaBheRuoXZ9FvAgMBAAECgYEAnGRh8elZXMLIUiRyrRliXQ/E\n" +
			"PsTNO7DtnOmCcIAvXwByf/1ODFcNnK+s475YWn3cI782HL68wvOKzfXeNJppN2zI\n" +
			"xE5Br4DzSteiOu/+bB3KsawqoWFKZNqwT1T/74pmMXLk9peXs3XXadxtfYPa0n7G\n" +
			"uVuPwbluPM8+D4E6ACECQQDzLegVWVcZcqKYXaUCOiIi+Qs8rrommejshFxfYDYU\n" +
			"fphtxDuquI2E31pLrgspZpvFa+4ylXN+utnqbo0tiuo/AkEAxno+34/msDLX1N1O\n" +
			"Rxt1bMup29MTClmaWV4cN3po5VJGEQWpHr9u0KdrA/QZ0GVuiToBgfD5cWM+h8Kw\n" +
			"LtRs0QJAYmpSwckdWdwt95H2hNc4F4VIye9AwPyK6qWKqMLMQDEXyVygdTApffvS\n" +
			"lExEkiXHpvdOOESJsGE4bgr9sc/FiwJBAK8lZ2BPk2o/o7jjhlU3hPr6Cq3C6RWE\n" +
			"FrHwW4QVkIV1ggE5dpF8qyST6Nr3SORe7hlIx9XMOcN2qdKR2nmo2VECQCSncb4d\n" +
			"RYm3UOFB5Mjq02bSemTiP3la3cvW5ryxI7KDR58Ft1/hTaFP8Efv96jkrXq1p2oG\n" +
			"CtnVAmbb/P/MU5Q=";
	// 支付宝公钥
	public static final String RSA_PUBLIC = "";
	private static final int SDK_PAY_FLAG = 1;

	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {
		@SuppressWarnings("unused")
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SDK_PAY_FLAG: {
				PayResult payResult = new PayResult((String) msg.obj);
				/**
				 * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
				 * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
				 * docType=1) 建议商户依赖异步通知
				 */
				String resultInfo = payResult.getResult();// 同步返回需要验证的信息

				String resultStatus = payResult.getResultStatus();
				// 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
				if (TextUtils.equals(resultStatus, "9000")) {
					Toast.makeText(PayDemoActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
				} else {
					// 判断resultStatus 为非"9000"则代表可能支付失败
					// "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
					if (TextUtils.equals(resultStatus, "8000")) {
						Toast.makeText(PayDemoActivity.this, "支付结果确认中", Toast.LENGTH_SHORT).show();

					} else {
						// 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
						Toast.makeText(PayDemoActivity.this, "支付失败", Toast.LENGTH_SHORT).show();

					}
				}
				break;
			}
			default:
				break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pay_main);
	}
	
	public void pay(View v) {
		if (TextUtils.isEmpty(APPID) || TextUtils.isEmpty(RSA_PRIVATE) || TextUtils.isEmpty(SELLER)) {
			new AlertDialog.Builder(this).setTitle("警告").setMessage("需要配置APPID | RSA_PRIVATE| SELLER")
					.setPositiveButton("确定", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialoginterface, int i) {
							//
							finish();
						}
					}).show();
			return;
		}
		
		// 请配置好如下3个参数
		String seller_id = SELLER;
		String app_id = APPID;
		String rsaKey = RSA_PRIVATE;
		
		Map<String, String> params = PayOrderInfoUtil2_0.buildOrderParamMap(seller_id, app_id);
		String orderParam = PayOrderInfoUtil2_0.buildOrderParam(params);
		String sign = PayOrderInfoUtil2_0.getSign(params, rsaKey);
		
		final String orderInfo = orderParam + "&" + sign;
		
		Runnable payRunnable = new Runnable() {

			@Override
			public void run() {
				PayTask alipay = new PayTask(PayDemoActivity.this);
				String result = alipay.pay(orderInfo, true);
				
				Message msg = new Message();
				msg.what = SDK_PAY_FLAG;
				msg.obj = result;
				mHandler.sendMessage(msg);
			}
		};

		Thread payThread = new Thread(payRunnable);
		payThread.start();
	}

	/**
	 * get the sdk version. 获取SDK版本号
	 * 
	 */
	public void getSDKVersion() {
		PayTask payTask = new PayTask(this);
		String version = payTask.getVersion();
		Toast.makeText(this, version, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 原生的H5（手机网页版支付切natvie支付） 【对应页面网页支付按钮】
	 * 
	 * @param v
	 */
	public void h5Pay(View v) {
		Intent intent = new Intent(this, H5PayDemoActivity.class);
		Bundle extras = new Bundle();
		/**
		 * url是测试的网站，在app内部打开页面是基于webview打开的，demo中的webview是H5PayDemoActivity，
		 * demo中拦截url进行支付的逻辑是在H5PayDemoActivity中shouldOverrideUrlLoading方法实现，
		 * 商户可以根据自己的需求来实现
		 */
		String url = "http://m.taobao.com";
		// url可以是一号店或者淘宝等第三方的购物wap站点，在该网站的支付过程中，支付宝sdk完成拦截支付
		extras.putString("url", url);
		intent.putExtras(extras);
		startActivity(intent);
	}

}
