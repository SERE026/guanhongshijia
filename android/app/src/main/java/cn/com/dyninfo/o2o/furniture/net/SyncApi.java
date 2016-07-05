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

package cn.com.dyninfo.o2o.furniture.net;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.util.Log;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.bean.LocalUser;
import cn.com.dyninfo.o2o.furniture.sign.tencent.weixin.WeixinConstants;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.Constant;

/**
 * @Description
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-5-27 10:53:58
 * @update 2014-9-15 16:17:01 新增微信接口
 *         <hr>
 *         2014-8-25 18:06:21 更新地图
 *         <hr>
 *         2014-8-14 16:16:21 新增修改个人账户信息接口
 *         <hr>
 *         2014-8-8 17:20:33 新增未付款订单界面可以重新付款
 *         <hr>
 *         2014-7-17 11:18:02 更新首页广告城市读取为本地
 *         <hr>
 *         <Strong>Nobody likes to work on Sundays.
 */
public class SyncApi {

	private static void wrapAuth(List<NetParam> parameters) {
		LocalUser localUser = BaseActivity.getLastLocalUserInfoInstance(BaseActivity.context);
		parameters.add(new NetParam("huiyuanid", localUser.uid));
		parameters.add(new NetParam("key", APPCode.VERSION));
	}

	/**
	 * @Description 检测新版本
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @date 2014-7-11 09:27:34
	 */
	public static String getVer() {
		String url = "http://www.xpzc.com/css/app.css";// 写绝对地址，避免局域网测试时误发布后无法更新
		List<NetParam> parameters = new ArrayList<NetParam>();
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("检测新版本 = " + result);
		return result;
	}

	/**
	 * @Description 登录
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-3 11:05:11
	 */
	public static String signin(String acct, String psw) {
		String url = APP.domains("huiyuanlog/login");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("name", acct));
		parameters.add(new NetParam("psw", psw));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "POST", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("signin result = " + result);
		return result;
	}

	/**
	 * @Description 注册
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-9-11 上午11:08:44
	 * @param checkCode
	 *            短信验证码
	 * @param code
	 *            邀请码，选填
	 */
	public static String signup(String acct, String psw, String tel, String checkCode, String code) {
		String url = APP.domains("huiyuanlog/reg");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("name", acct));
		parameters.add(new NetParam("psw", psw));
		parameters.add(new NetParam("phone", tel));
		parameters.add(new NetParam("code", checkCode));
		parameters.add(new NetParam("gsm", code));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "POST", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("signup result = " + result);
		return result;
	}

	/**
	 * @Description 注册时，获取验证码
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-9-18 上午11:14:28
	 */
	public static String getSMSCode(String tel) {
		String url = APP.domains("huiyuanlog/validPhone");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("phone", tel));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("获取验证码 = " + result);
		return result;
	}

	/**
	 * @Description 城市列表
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-6 16:08:36
	 * @update 2014-6-17 15:25:37
	 */
	public static String getCities() {
		String url = APP.domains("aarea/list");
		List<NetParam> parameters = new ArrayList<NetParam>();
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// BaseActivity.Log_info("城市列表 json = " + result);
		return result;
	}

	/**
	 * @Description 首页广告，顶部和底部的产品广告
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-13 11:48:13
	 * @update 2014-6-25 13:39:40
	 * @update 2014-7-29 添加参数城市ID
	 */
	public static String getIndexAdv(int position, String cityId) {
		String url = APP.domains("aindex/adv");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("wzid", String.valueOf(position)));
		parameters.add(new NetParam("quyu", cityId));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// BaseActivity.Log_info("首页广告 json = " + result);
		return result;
	}

	/**
	 * @Description 首页广告，中间部分长期不变的菜单
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-28 11:13:37
	 */
	public static String getIndexMenu(int position) {
		String url = APP.domains("aindex/menu");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("wzid", String.valueOf(position)));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// BaseActivity.Log_info("首页广告 json = " + result);
		return result;
	}

	/**
	 * @Description 首页广告点击后列表
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-28 15:09:25
	 * @update 2014-7-17 11:16:34
	 */
	public static String getAdvGoodsList(Context context, String adv_id, int page) {
		String url = APP.domains("aindex/goodslist");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("id", adv_id));
		parameters.add(new NetParam("p", String.valueOf(page)));
		parameters.add(new NetParam("city", context.getSharedPreferences(APPCode.CITY, Context.MODE_APPEND).getString(
				APPCode.CHOICE_CITY_ID, "")));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("广告指向的商品列表 json = " + result);
		return result;
	}

	/**
	 * @Description 女人街
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-13 13:54:06
	 * @update 2014-7-8 14:15:54 取不到城市时默认全国
	 */
	public static String getWomenStreet(Context context, int page) {
		String url = APP.domains("anrj/list");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("id", context.getSharedPreferences(APPCode.CITY, Context.MODE_APPEND).getString(
				APPCode.CHOICE_CITY_ID, "")));
		parameters.add(new NetParam("pageno", page + ""));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// BaseActivity.Log_info("女人街 json = " + result);
		return result;
	}

	/**
	 * @Description 地图 poi 结果(没有选择或者定位到城市时，使用本地存储的城市 id )
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-8-25 下午4:19:34
	 */
	public static String getPOIList(Context context, Boolean showAll, String city) {
		String url = APP.domains("ashop/mapshop");
		List<NetParam> parameters = new ArrayList<NetParam>();
		String id = "";
		if (!showAll) {
			id = city.isEmpty() ? context.getSharedPreferences(APPCode.CITY, Context.MODE_APPEND).getString(
					APPCode.CHOICE_CITY_ID, "") : "";
		}
		parameters.add(new NetParam("id", id));
		parameters.add(new NetParam("name", city));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("地图获取附近商家信息 json = " + result);
		return result;
	}

	/**
	 * 
	 * @Description 搜索商品
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-8-27 下午4:06:18
	 */
	public static String getQuery(Context context, String key, int page, int type) {
		String url = APP.domains("agoods/search");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("id", context.getSharedPreferences(APPCode.CITY, Context.MODE_APPEND).getString(
				APPCode.CHOICE_CITY_ID, "")));
		parameters.add(new NetParam("key", key));
		parameters.add(new NetParam("pageno", String.valueOf(page)));
		parameters.add(new NetParam("serchType", String.valueOf(type)));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("搜索商品 = " + result);
		return result;
	}

	/**
	 * @Description 测试地址，各种临时测试
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-8-29 下午3:27:16
	 */
	public static String TEST() {
		String url = "http://192.168.1.127:8080/xpzc/test.txt";
		List<NetParam> parameters = new ArrayList<NetParam>();
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("TEST = " + result);
		return result;
	}

	/**
	 * @Description 女人街点击后列表
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-29 14:26:10
	 */
	public static String getStoreGoodsList(String storeID, int page) {
		String url = APP.domains("ashop/nrjgoods");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("id", storeID));
		parameters.add(new NetParam("pageno", String.valueOf(page)));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// BaseActivity.Log_info("女人街指向的商品列表 json = " + result);
		return result;
	}

	/**
	 * @Description 美丽宣言列表
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-17 16:20:05
	 */
	public static String getBeautyProclaim(int page) {
		String url = APP.domains("abbs/list");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("pageno", page + ""));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// BaseActivity.Log_info("美丽宣言列表 json = " + result);
		return result;
	}

	/**
	 * @Description 美丽宣言详情
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-18 11:17:42
	 */
	public static String getBeautyProclaimDetails(long id) {
		String url = APP.domains("abbs/detail");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("bbsid", id + ""));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// BaseActivity.Log_info("美丽宣言详情 json = " + result);
		return result;
	}

	/**
	 * @Description 获取美丽宣言评论列表
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-18 11:17:42
	 */
	public static String getBeautyProclaimDiscusses(long id, int page) {
		String url = APP.domains("abbs/pinglun");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("bbsid", id + ""));
		parameters.add(new NetParam("pageno", page + ""));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// BaseActivity.Log_info("美丽宣言评论列表 json = " + result);
		return result;
	}

	/**
	 * @Description 发布美丽宣言评论
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-18 16:06:31
	 */
	public static String postBeautyProclaimDiscusses(long id, String msg) {
		String url = APP.domains("abbs/submit");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("bbsid", id + ""));
		parameters.add(new NetParam("content", msg));
		wrapAuth(parameters);
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("发布美丽宣言评论 json = " + result);
		return result;
	}

	/**
	 * @Description 晒单
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-15 10:57:50
	 * @update 2014-6-20 17:00:02
	 * @param orderNO
	 * @param pics
	 */
	public static String postOrderCommentary(String orderNO, String stars, String comTxt, String picOrderby,
			List<String> pics) {
		String url = APP.domains("aorder/commentBaskSingle");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("orderId", orderNO));
		parameters.add(new NetParam("leve", stars));
		parameters.add(new NetParam("saycontent", comTxt));
		parameters.add(new NetParam("imgOrder", picOrderby));
		wrapAuth(parameters);
		List<NetParam> files = null;
		if (pics != null && pics.size() != 0) {
			files = new ArrayList<NetParam>();
			int num = 1;
			for (String pic : pics) {
				files.add(new NetParam("pic_" + num, pic));
				File file = new File(pic);
				Log.e("晒单", "-------> 晒单图片：pic_" + num + "，路径" + pic + "，大小：" + file.length() + "");
				num++;
			}
		}
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "POST", parameters, files);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("晒单 json = " + result);
		return result;
	}

	/**
	 * @Description 订单列表
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @update 2014-6-19 15:24:50
	 */
	public static String getOrderList(int statusCode, int page) {
		String url = APP.domains("aorder/orderlist");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("status", String.valueOf(statusCode)));
		parameters.add(new NetParam("pageNo", String.valueOf(page)));
		wrapAuth(parameters);
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("订单列表 json = " + result);
		return result;
	}

	/**
	 * @Description 订单详情
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-20 13:40:23
	 * @update 2014-6-21 10:15:42
	 */
	public static String getOrderDetails(String orderNO) {
		String url = APP.domains("aorder/order");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("orderId", orderNO));
		wrapAuth(parameters);
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("订单详情 json = " + result);
		return result;
	}

	/**
	 * @Description 确认收货
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-20 16:49:18
	 */
	public static String confirmOrderReceipt(String orderNO) {
		String url = APP.domains("aorder/cinfirmReceipt");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("orderId", orderNO));
		wrapAuth(parameters);
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("确认收货 json = " + result);
		return result;
	}

	/**
	 * @Description 收货地址
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-21 14:48:18
	 */
	public static String getAddressList(String uid) {
		String url = APP.domains("aadress/list");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("huiYuan_id", uid));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("收货地址 json = " + result);
		return result;
	}

	/**
	 * @Description 新增收货地址
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-21 15:57:56
	 */
	public static String addAddress(String uid, String province, String city, String area, String address, String name,
			String tel) {
		String url = APP.domains("aadress/add");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("huiYuan_id", uid));
		parameters.add(new NetParam("province", province));
		parameters.add(new NetParam("city", city));
		parameters.add(new NetParam("county", area));
		parameters.add(new NetParam("address", address));
		parameters.add(new NetParam("receiveName", name));
		parameters.add(new NetParam("receivePhone", tel));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("新增收货地址 json = " + result);
		return result;
	}

	/**
	 * @Description 更新收货地址
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-21 16:11:22
	 */
	public static String updateAddress(String uid, String address_id, String province, String city, String area,
			String address, String name, String tel) {
		String url = APP.domains("aadress/save");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("huiYuan_id", uid));
		parameters.add(new NetParam("address_id", address_id));
		parameters.add(new NetParam("province", province));
		parameters.add(new NetParam("city", city));
		parameters.add(new NetParam("county", area));
		parameters.add(new NetParam("address", address));
		parameters.add(new NetParam("receiveName", name));
		parameters.add(new NetParam("receivePhone", tel));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("更新收货地址 json = " + result);
		return result;
	}

	/**
	 * @Description 删除收货地址
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-22 12:52:29
	 */
	public static String delAddress(String address_id) {
		String url = APP.domains("aadress/del");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("address_id", address_id));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("删除收货地址 json = " + result);
		return result;
	}

	/**
	 * @Description 社会化登录
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 */
	public static String SocialSignin(String openid, String head, String nickName) {
		String url = APP.domains("aqqlogin/login");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("openid", openid));
		parameters.add(new NetParam("img", head));
		parameters.add(new NetParam("name", nickName));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("社会化登录 json = " + result);
		return result;
	}

	/**
	 * @Description 获取微信Token
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-9-15 下午1:47:07
	 * @param code
	 *            授权后会返回，用这个code来获取token
	 */
	public static String getWeixinToken(String code) {
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token";
		// appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("appid", WeixinConstants.APP_ID));
		parameters.add(new NetParam("secret", WeixinConstants.APP_KEY));
		parameters.add(new NetParam("grant_type", "authorization_code"));
		parameters.add(new NetParam("code", code));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("获取微信Token json = " + result);
		return result;
	}

	/**
	 * @Description 获取微信账户资料
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-9-15 下午1:47:07
	 * @param access_token
	 *            token
	 * @param openid
	 *            获取 token 时一起返回的
	 */
	public static String getWeixinAcInfo(String token, String openid) {
		String url = "https://api.weixin.qq.com/sns/userinfo";
		// access_token=ACCESS_TOKEN&openid=OPENID
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("access_token", token));
		parameters.add(new NetParam("openid", openid));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("获取微信账户资料 json = " + result);
		return result;
	}

	/**
	 * @Description 拉取推送消息
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @param lastDate
	 *            likes 2014-05-18
	 */
	public static String pullNotices(String lastID, String lastDate) {
		String url = APP.domains("amessage/send");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("id", lastID));
		parameters.add(new NetParam("data", lastDate));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("拉取推送消息 json = " + result);
		return result;
	}

	/**
	 * @Description 炫品公告
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-22 13:52:40
	 */
	public static String getNotices(String uid, int page) {
		String url = APP.domains("amessage/getxpgg");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("pageno", String.valueOf(page)));
		parameters.add(new NetParam("uid", uid));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("炫品公告 json = " + result);
		return result;
	}

	/**
	 * @Description 打折促销
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-22 13:52:40
	 */
	public static String getDiscount(String uid, int page) {
		String url = APP.domains("amessage/getdzcx");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("pageno", String.valueOf(page)));
		parameters.add(new NetParam("uid", uid));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("打折促销 json = " + result);
		return result;
	}

	/**
	 * @Description 删除打折促销、炫品公告
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-22 16:22:21
	 */
	public static String delNotices(String msgID, String uid) {
		String url = APP.domains("amessage/del");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("messagesend_id", msgID));
		parameters.add(new NetParam("uid", uid));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("拉取推送消息 json = " + result);
		return result;
	}

	/**
	 * @Description 根据活动商品 id 获取游戏类型（是点还是转）
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-7-11 16:05:10
	 * @param actid
	 *            活动id
	 */
	public static String getGameType(String actid) {
		String url = APP.domains("aactive/game");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("actid", actid));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// result = "{\"status\":0,\"data\":[{\"gamename\":\"diandian\"}]}";
		BaseActivity.Log_info("获取游戏类型 json = " + result);
		return result;
	}

	/**
	 * @Description 获取短信验证码
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-7-10 18:51:32
	 */
	public static String getSmsCode(String phone) {
		String url = APP.cart;
		// ../widget.html?widget=loginBar&changePassSendCode=1&phone=18288989898
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("widget", "loginBar"));
		parameters.add(new NetParam("changePassSendCode", "1"));
		parameters.add(new NetParam("phone", phone));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("获取短信验证码 json = " + result);
		return result;
	}

	/**
	 * @Description 重置密码
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-7-10 19:03:43
	 */
	public static String resetPsw(String phone, String checkCode, String psw) {
		String url = APP.cart;
		// ../widget.html?widget=loginBar&changePass=1&phone=18288989898&valide=ys12&newpwd=123123123
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("widget", "loginBar"));
		parameters.add(new NetParam("changePass", "1"));
		parameters.add(new NetParam("phone", phone));
		parameters.add(new NetParam("newpwd", psw));
		parameters.add(new NetParam("valide", checkCode));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("重置密码 json = " + result);
		return result;
	}

	/**
	 * 活动商品列表
	 * 
	 * @param context
	 * @param page
	 * @return
	 */
	public static String getPromotionSales(Context context, int page) {

		String url = APP.domains("aactive/list");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("id", context.getSharedPreferences(APPCode.CITY, Context.MODE_APPEND).getString(
				APPCode.CHOICE_CITY_ID, "")));
		parameters.add(new NetParam("pageno", page + ""));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("游戏优惠(活动商品)列表 json = " + result);
		return result;
	}

	/**
	 * @Description 活动商品详情
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-7-9 10:14:27
	 * @return String
	 * @param goodId
	 *            :商品id
	 * @param actid
	 *            :商品游戏类型
	 */
	public static String getPromotionDetails(int goodID, int actionID, String memberId) {

		String url = APP.domains("aactive/detail");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("goodId", String.valueOf(goodID)));
		parameters.add(new NetParam("actid", String.valueOf(actionID)));
		parameters.add(new NetParam("memberId", String.valueOf(memberId)));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("活动商品详情 json = " + result);
		return result;
	}

	/**
	 * @Description 搜索时推荐的商品列表
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-7-3 14:29:24
	 * @update 2014-7-8 14:15:54 取不到城市时默认全国
	 */
	public static String getRecomList(Context context) {
		String url = APP.domains("agoods/recommend");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("id", context.getSharedPreferences(APPCode.CITY, Context.MODE_APPEND).getString(
				APPCode.CHOICE_CITY_ID, "")));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("搜索时推荐的商品列表 json = " + result);
		return result;
	}

	/**
	 * @Description 摇一摇
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-7-3 11:05:21
	 * @update 2014-7-8 14:15:54 取不到城市时默认全国
	 */
	public static String getShakeList(Context context) {

		String url = APP.domains("aactive/yaoyiyao");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("id", context.getSharedPreferences(APPCode.CITY, Context.MODE_APPEND).getString(
				APPCode.CHOICE_CITY_ID, "")));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("摇一摇 json = " + result);
		return result;
	}

	/**
	 * 爆品
	 * 
	 * @update 2014-7-8 14:15:54 取不到城市时默认全国
	 */
	public static String getBoomData(Context context, int page) {

		String url = APP.domains("aactive/baoping");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("id", context.getSharedPreferences(APPCode.CITY, Context.MODE_APPEND).getString(
				APPCode.CHOICE_CITY_ID, "")));
		parameters.add(new NetParam("pageno", page + ""));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("爆品 json = " + result);
		return result;
	}

	/**
	 * 附近宝贝
	 * 
	 * @param context
	 * @param page
	 * @return
	 */
	public static String getNearData(int page) {

		String url = APP.domains("ashop/neargoods");
		List<NetParam> parameters = new ArrayList<NetParam>();

		parameters.add(new NetParam("lon", Constant.lng + ""));
		parameters.add(new NetParam("lat", Constant.lat + ""));

		parameters.add(new NetParam("pageno", page + ""));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("附近宝贝 json = " + result);
		return result;
	}

	/**
	 * 炫品热销（会员专区）
	 * 
	 * @update 2014-7-8 14:15:54 取不到城市时默认全国
	 */
	public static String getHotData(Context context, int page) {

		String url = APP.domains("agoods/hotlist");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("id", context.getSharedPreferences(APPCode.CITY, Context.MODE_APPEND).getString(
				APPCode.CHOICE_CITY_ID, "")));
		parameters.add(new NetParam("pageno", page + ""));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info(" 炫品热销（会员专区） json = " + result);
		return result;
	}

	/**
	 * 
	 * @Description 美容项目
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @updated by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-8-28 10:09:22
	 */
	public static String getBeautifulProjectData(Context context, int page) {

		String url = APP.domains("ashop/nearmrxm");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("cityid", context.getSharedPreferences(APPCode.CITY, Context.MODE_APPEND)
				.getString(APPCode.CHOICE_CITY_ID, "")));
		parameters.add(new NetParam("pageno", page + ""));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info(" 美容项目  json = " + result);
		return result;
	}

	/**
	 * @Description 其他人还买了
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-7-4 15:33:32
	 * @update 2014-7-8 14:15:54 取不到城市时默认全国
	 */
	public static String getOtherPeopleBuy(Context context) {
		String url = APP.domains("agoods/otherbuy");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("id", context.getSharedPreferences(APPCode.CITY, Context.MODE_APPEND).getString(
				APPCode.CHOICE_CITY_ID, "")));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("其他人还买了  json = " + result);
		return result;
	}

	/**
	 * 身边美容院
	 * 
	 * @param context
	 * @param page
	 * @return
	 */
	public static String getBeautifulData(int page) {

		String url = APP.domains("ashop/nearshop");
		List<NetParam> parameters = new ArrayList<NetParam>();

		parameters.add(new NetParam("lon", Constant.lng + ""));
		parameters.add(new NetParam("lat", Constant.lat + ""));
		parameters.add(new NetParam("pageno", page + ""));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("身边美容院  json = " + result);
		return result;
	}

	/**
	 * @Description 确认订单（查询订单内商品金额）
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-9-17 下午4:44:41
	 */
	public static String checkCartOrderGoods(String buffer) {
		String url = APP.cart;
		// action=phone&widget=confirmOrder&dataType=json&event=getShopGoods&memberId=
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("event", "getShopGoods"));// 动作是获取要结算的商品信息
		parameters.add(new NetParam("action", "phone"));
		parameters.add(new NetParam("widget", "confirmOrder"));
		parameters.add(new NetParam("dataType", "json"));
		parameters.add(new NetParam("memberId", BaseActivity.getLastLocalUserInfoInstance(BaseActivity.context).uid));
		// 其他的设计导致，只能这样奇葩的写法
		url += "?" + buffer;
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("确认订单（查询订单内商品金额）  json = " + result);
		return result;
	}

	/**
	 * @Description 查询购物车内所要结算的商品的配送方式
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-9-17 17:35:02
	 */
	public static String getShippingForOrder(String buffer) {
		String url = APP.cart;
		// action=phone&widget=confirmOrder&dataType=json&event=queryYF&memberId=
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("event", "queryYF"));// 动作是查询运费
		parameters.add(new NetParam("action", "phone"));
		parameters.add(new NetParam("widget", "confirmOrder"));
		parameters.add(new NetParam("dataType", "json"));
		parameters.add(new NetParam("memberId", BaseActivity.getLastLocalUserInfoInstance(BaseActivity.context).uid));
		// 其他的设计导致，只能这样奇葩的写法
		url += "?" + buffer;
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("查询订单配送方式  json = " + result);
		return result;
	}

	/**
	 * @Description 提交订单（服务器计算价格，然后使用支付宝支付）
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-9-17 17:35:02
	 */
	public static String checkOrder(String buffer) {
		String url = APP.cart;
		// action=phone&widget=confirmOrder&dataType=json&event=create&memberId=
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("event", "create"));// 动作是创建
		parameters.add(new NetParam("action", "phone"));
		parameters.add(new NetParam("widget", "confirmOrder"));
		parameters.add(new NetParam("dataType", "json"));
		parameters.add(new NetParam("memberId", BaseActivity.getLastLocalUserInfoInstance(BaseActivity.context).uid));
		// 其他的设计导致，只能这样奇葩的写法
		url += "?" + buffer;
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("提交订单  json = " + result);
		return result;
	}

	/**
	 * @Description 获取购物车列表
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-7-7 18:16:33
	 */
	public static String getCartList(String uid) {

		String url = APP.domains("acar/goodlist");
		List<NetParam> parameters = new ArrayList<NetParam>();

		parameters.add(new NetParam("huiYuan_id", uid));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("获取购物车列表  json = " + result);
		return result;
	}

	/**
	 * @Description 添加到购物车（普通商品）
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-7-8 14:15:00
	 */
	public static String addToCartList(String goodsID, int count, String sizeCode, String uid) {
		String url = APP.cart;
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("widget", "carsWidget"));
		parameters.add(new NetParam("dataType", "json"));
		parameters.add(new NetParam("n", String.valueOf(count)));
		parameters.add(new NetParam("action", "add"));
		parameters.add(new NetParam("1", "1"));
		parameters.add(new NetParam("i", "0.9020185777330575"));
		parameters.add(new NetParam("spec_val_id", sizeCode));
		parameters.add(new NetParam("g_id", goodsID));
		parameters.add(new NetParam("huiYuan_id", uid));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("添加到购物车（普通商品）  json = " + result);
		return result;
	}

	/**
	 * @Description 添加到购物车（活动商品，限购一件）
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-7-11 18:40:10
	 * @updated 2014-8-1 18:32:46 by <a
	 *          href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 */
	public static String addToCartList(String goodsID, String sizeCode, String actID, String uid, String agmId) {
		String url = APP.domains("acar/actadd");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("action", "Actadd"));
		parameters.add(new NetParam("num", "1"));// 活动商品限购1件
		parameters.add(new NetParam("g_id", goodsID));
		parameters.add(new NetParam("a_id", actID));
		parameters.add(new NetParam("huiYuan_id", uid));
		parameters.add(new NetParam("spec_val_id", sizeCode));
		parameters.add(new NetParam("agmId", agmId));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("添加到购物车（活动商品，限购一件）  json = " + result);
		return result;
	}

	/**
	 * @Description 修改购物车数量
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-7-8 14:48:13
	 * @param cartGoodsId
	 *            类似：d4934d8e1e96465682370d7d5ffbd50d
	 */
	public static String editCartList(String cartGoodsId, int count) {
		String url = APP.domains("acar/modify");

		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("cars_box_id", cartGoodsId));
		parameters.add(new NetParam("num", String.valueOf(count)));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("修改购物车数量 json " + result);
		return result;
	}

	/**
	 * @Description 删除购物车中某件商品
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-7-7 18:21:29
	 * @param cartGoodsId
	 *            类似：d4934d8e1e96465682370d7d5ffbd50d
	 */
	public static String delCartGood(String cartGoodsId) {
		String url = APP.cart;
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("widget", "carsWidget"));
		parameters.add(new NetParam("dataType", "json"));
		parameters.add(new NetParam("action", "del"));
		parameters.add(new NetParam("carInfo", cartGoodsId + ":::|"));
		parameters.add(new NetParam("huiYuan_id", BaseActivity.getLastLocalUserInfoInstance(BaseActivity.context).uid));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("删除购物车中某件商品 json " + result);
		return result;
	}

	/**
	 * 身边美容院 详情
	 * 
	 * @param context
	 * @param page
	 * @return
	 */
	public static String getAbsaData(int id, int page) {

		String url = APP.domains("ashop/shoplist");
		List<NetParam> parameters = new ArrayList<NetParam>();

		parameters.add(new NetParam("id", id + ""));
		parameters.add(new NetParam("pageno", page + ""));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("身边美容院详情  json = " + result);
		return result;
	}

	/**
	 * @Description 根据商品 id 获取归属店铺 名和店铺id
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-7-31 下午3:46:58
	 */
	public static String getStoreByGoods(String id) {

		String url = APP.domains("ashop/getshop");
		List<NetParam> parameters = new ArrayList<NetParam>();

		parameters.add(new NetParam("id", id));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("商品归属店铺  json = " + result);
		return result;
	}

	/**
	 * @Description 根据商品 id 获取该商品 尺寸、颜色等属性
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-8-1 17:49:53
	 */
	public static String getGoodsSize(String id) {
		String url = APP.domains("agoods/spec");
		List<NetParam> parameters = new ArrayList<NetParam>();

		parameters.add(new NetParam("id", id));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// BaseActivity.Log_info(id + " 商品属性  json = " + result);
		BaseActivity.Log_info(id + " 商品属性  json = " + result);
		return result;
	}

	/**
	 * @Description 获取转盘游戏参数
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @date 2014-7-11 09:27:34
	 */
	public static String getGameParam(String goodsID, String actid) {
		String url = APP.domains("aactive/gameParam");
		List<NetParam> parameters = new ArrayList<NetParam>();
		LocalUser localUser = BaseActivity.getLastLocalUserInfoInstance(BaseActivity.context);

		parameters.add(new NetParam("memberId", localUser.uid));
		parameters.add(new NetParam("goodId", goodsID));
		parameters.add(new NetParam("actid", actid));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("获取转盘游戏参数 = " + result);
		return result;
	}

	/**
	 * @Description 未付款订单，点击付款时获取订单总价
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @created 2014-8-8 17:19:09
	 */
	public static String getOrderMoney(String orderID) {
		String url = APP.domains("aorder/topay");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("huiyuanid", BaseActivity.getLastLocalUserInfoInstance(BaseActivity.context).uid));
		parameters.add(new NetParam("orderid", orderID));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("未付款订单，点击付款时获取订单总价 = " + result);
		return result;
	}

	/**
	 * @Description 上传图片
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @created 2014-8-13 16:53:26
	 */
	public static String uploadImg(List<String> pics) {
		String url = APP.domains("ahuiyuan/uploadimg");
		List<NetParam> parameters = new ArrayList<NetParam>();
		wrapAuth(parameters);
		List<NetParam> files = null;
		if (pics != null && pics.size() != 0) {
			files = new ArrayList<NetParam>();
			int num = 1;
			for (String pic : pics) {
				files.add(new NetParam("pic_" + num, pic));
				File file = new File(pic);
				Log.e("上传图片", "-------> 图片：pic_" + num + "，路径" + pic + "，大小：" + file.length() + "");
				num++;
			}
		}
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "POST", parameters, files);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("上传图片 json = " + result);
		return result;
	}

	/**
	 * @Description 修改头像
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @created 2014-8-13 17:37:07
	 */
	public static String updateHead(String imgName) {
		String url = APP.domains("ahuiyuan/edittx");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("uid", BaseActivity.getLastLocalUserInfoInstance(BaseActivity.context).uid));
		parameters.add(new NetParam("imgname", imgName));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("修改头像 = " + result);
		return result;
	}

	/**
	 * @Description 修改昵称
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @created 2014-8-13 15:46:31
	 */
	public static String updateNick(String txt) {
		String url = APP.domains("ahuiyuan/editname");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("uid", BaseActivity.getLastLocalUserInfoInstance(BaseActivity.context).uid));
		parameters.add(new NetParam("userName", txt));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "POST", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("修改昵称 = " + result);
		return result;
	}

	/**
	 * @Description 修改密码
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @created 2014-8-13 16:33:52
	 */
	public static String updatePsw(String old, String now) {
		String url = APP.domains("ahuiyuan/editpsw");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("uid", BaseActivity.getLastLocalUserInfoInstance(BaseActivity.context).uid));
		parameters.add(new NetParam("oldpsw", old));
		parameters.add(new NetParam("newpsw", now));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "POST", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("修改密码 = " + result);
		return result;
	}

	/**
	 * @Description 获取账户昵称头像和积分
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @created 2014-8-13 18:00:21
	 */
	public static String getAccInfo() {
		String url = APP.domains("ahuiyuan/gethData");
		List<NetParam> parameters = new ArrayList<NetParam>();
		parameters.add(new NetParam("uid", BaseActivity.getLastLocalUserInfoInstance(BaseActivity.context).uid));
		NetRequest request = new NetRequest();
		String result = null;
		try {
			result = request.syncRequest(url, "GET", parameters, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseActivity.Log_info("获取账户信息 = " + result);
		return result;
	}

}
