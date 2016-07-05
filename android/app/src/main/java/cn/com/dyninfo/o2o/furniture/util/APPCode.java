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

package cn.com.dyninfo.o2o.furniture.util;

/**
 * @Description activity 跳转时的请求码
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-4-29 下午2:57:11
 * @update 2014-9-11 11:21:12
 */
public class APPCode {
	/** -------------------------- 测试用 -------------------------- */
	public static String VERSION = "jx_xpzc_roid_140922"; // 版本号，测试用

	public static int TIMEOUT = 10 * 60 * 1000;// 连接超时时间

	/** ----------------------- SharedPreferences 代码 --------------------- */
	/** 引导页 */
	public static String USED = "used";
	/** 购物车 */
	public static String CART = "cart";
	/** 社会化登录 */
	public static String SIGN = "Social";
	/** 用户存储的城市 */
	public static String CITY = "City";
	/** 存储上次拉取通知日期 */
	public static String DATE = "PullDate";

	/** 定位到的城市 */
	public static String POINT_CITY_NAME = "point_city_name";
	/** 选择的城市 */
	public static String CHOICE_CITY_ID = "city_id";

	/** -------------------------- Dialog 提示用代码 -------------------------- */
	/** 服务器返回为空 */
	public static String WEB_NULL = "(错误：1500)";

	/** -------------------------- Intent 跳转用代码 -------------------------- */
	/** 去注册 */
	public static int TO_SIGNUP = 1001;
	/** 选择所在地区 */
	public static int CHOICE_LOCATION = 1002;
	/** 新增收货地址 */
	public static int ADD_ADDRESS = 1003;
	/** 修改收货地址 */
	public static int EDIT_ADDRESS = 1004;
	/** 订单商品评价 */
	public static int ORDER_COMMENT = 1005;
	/** 选择本地图片 */
	public static int CHOICE_LOCATION_PIC = 1006;
	/** 拍照并选择图片 */
	public static int GET_CAMERA_IMAGE = 1007;
	/** 裁剪图片 */
	public static int PHOTO_CUT = 1008;
	/** 来自会员专区 */
	public static int VIP_ZONE = 1009;
	/** 来自广告列表 */
	public static int ADV_LIST = 1010;
	/** 来自女人街列表 */
	public static int WOMEN_STREEET_LIST = 1011;
	/** 来自商店商品列表 */
	public static int SHOP_GOODS_LIST = 1012;
	/** 订单页切换收货地址 */
	public static int CHOICE_ADDR = 1013;

	/** 支付宝 - 支付 - 暂时没用 */
	public static int ALIPAY_PEY = 1014;
	/** 支付宝 - 登录 - 暂时没用 */
	public static int ALIPAY_SIGN = 1015;
	/** -------------------------- 数据库表名代码 -------------------------- */

	/** 本地用户表 */
	public static String DB_USER = "local_users";
	public static String DATABASE = "dress.db";

	/**
	 * -------------------------- SlideViewPager 页面代码 --------------------------
	 */

	/** 订单界面 */
	public static int ORDER = 2001;
	/** 消息界面 */
	public static int MSG = 2002;
	/** 退换货 */
	public static int RETURN = 2003;

	/** -------------------------- 订单有效代码 -------------------------- */
	// 0.有效 1.未付款 2.已付款3.交易成功4.无效
	static int orderStatusCode[] = { 0, 1, 2, 3, 4 };
	public static String[] orderStatusTxt = { "有效 ", "未付款", "已付款", "交易成功", "无效" };

	/** -------------------------- 订单状态代码 -------------------------- */
	static int orderPayCode[] = { 0, 1, 2, 3, 4, 5, 6 };
	// 0.等待付款 1.已付款 2.已发货3.确认完成4.申请退款5.申请退货6.交易失败
	public static String[] orderPayTxt = { "等待付款 ", "已付款", "已发货", "确认完成", "申请退款", "申请退货", "交易失败" };

	/**
	 * @Description 根据订单状态代码 获取 该状态对应的字符串
	 */
	public static String getOrderStatus(int statusCode) {
		for (int i = 0; i < orderStatusCode.length; i++) {
			if (statusCode == orderStatusCode[i]) {
				return orderStatusTxt[i];
			}
		}
		return null;
	}

	/**
	 * @Description 根据订单支付代码 获取 该状态对应的支付状态
	 */
	public static String getOrderPay(int payCode) {
		for (int i = 0; i < orderPayCode.length; i++) {
			if (payCode == orderPayCode[i]) {
				return orderPayTxt[i];
			}
		}
		return null;
	}

}
