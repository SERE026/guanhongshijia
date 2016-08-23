package com.wckj.gfsj;

/**
 * Created by jinlei on 2016/8/3.
 */
public class GlobalUtils {
    public  static String DB_Name="ghsj";
    public  static int DB_CODE=1;



    public static final String SERVER_URL = "http://www.guanhongshijia.com/app";

    //登录命令
    public static final String LOGIN_URL = SERVER_URL + "/user/login";
    //添加到购物车命令
    public static final String CART_ADD_URL = SERVER_URL + "/cart/add";
    //购物车列表命令
    public static final String CART_LIST_URL = SERVER_URL + "/cart/list";
    //取消收藏
    public static final String FAVORITES_CANCEL_URL = SERVER_URL + "/favorites/cancel";
    //删除购物车商品命令
    public static final String CART_DEL_URL = SERVER_URL + "/cart/del";
    //添加到收藏夹命令
    public static final String FAVORITES_ADD_URL = SERVER_URL + "/favorites/add";
    //收藏夹商品列表命令
    public static final String FAVORITES_LIST_URL = SERVER_URL + "/favorites/list";
    //获取主分类列表命令
    public static final String CATEGORY_MAIN_URL = SERVER_URL + "/category/main";
    //获取更多分类列表命令
    public static final String CATEGORY_MORE_URL = SERVER_URL + "/category/more";
    //获取二级类别列表命令
    public static final String CATEGORY_SUB_URL = SERVER_URL + "/category/sub";
    //根据商品品牌列表
    public static final String GOODS_LIST_BY_BRAND_URL = SERVER_URL + "/goods/listByBrand";
    //根据品牌下的商品列表
    public static final String GOODS_LIST_BY_CATEGORY_URL = SERVER_URL + "/goods/listByCategory";
    //商品详情命令
    public static final String GOODS_DETAIL_URL = SERVER_URL + "/goods/detail";
    //获取轮播商品命令
    public static final String GOODS_LOOP_URL = SERVER_URL + "/goods/loop";
    //获取推荐页面命令
    public static final String GROUP_RECOMMEND_URL = SERVER_URL + "/goods/groupRecommend";
    //获取推荐页面命令
    public static final String PROMOTION_RECOMMEND_URL = SERVER_URL + "/goods/promotionRecommend";
    //获取推荐页面命令
    public static final String NEW_RECOMMEND_URL = SERVER_URL + "/goods/newRecommend";
    //搜索命令
    public static final String GOODS_SEARCH_URL = SERVER_URL + "/goods/search";
    //创建订单命令
    public static final String ORDER_CREATE_URL = SERVER_URL + "/order/create";
    //评价订单命令
    public static final String ORDER_EVAL_URL = SERVER_URL + "/order/eval";
    //订单查询命令
    public static final String ORDER_LIST_URL = SERVER_URL + "/order/list";
    //找回锁定密码命令
    public static final String FIND_PWD_LOCK_URL = SERVER_URL + "/user/findLockPassword";
    //找回登录密码命令
    public static final String FIND_PWD_LOGIN_URL = SERVER_URL + "/user/findLoginPassword";
    //设置锁定密码命令
    public static final String SET_PWD_LOCK_URL = SERVER_URL + "/user/lockPassword";
    //佣金查询命令
    public static final String AGENCY_FEE_QUERY_URL = SERVER_URL + "/user/queryAgencyFee";
    //银行卡查询命令
    public static final String BANK_CARD_QUERY_URL = SERVER_URL + "/user/bankCard";
    //优惠券查询命令
    public static final String COUPON_QUERY_URL = SERVER_URL + "/user/coupon";
    //查询个人信息命令
    public static final String PERSONAL_QUERY_URL = SERVER_URL + "/user/personal";
    //发送短信命令
    public static final String SMS_URL = SERVER_URL + "/sys/sms";
    //启动请求命令
    public static final String STARTUP_URL = SERVER_URL + "/sys/startup";
    //订单更改 (确认订单和取消订单)
    public static final String ORDER_UPDATE_URL = SERVER_URL + "/order/update";
    //查询市、区请求命令
    public static final String ORDER_QUERYAREA_URL  = SERVER_URL + "/order/queryArea";

}
