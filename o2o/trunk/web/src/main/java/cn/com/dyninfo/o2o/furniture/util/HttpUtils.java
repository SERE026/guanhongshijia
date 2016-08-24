package cn.com.dyninfo.o2o.furniture.util;

import cn.com.dyninfo.o2o.communication.*;
import cn.com.dyninfo.o2o.communication.common.BaseRequest;
import cn.com.dyninfo.o2o.entity.AddressMember;
import com.alibaba.fastjson.JSON;
import okhttp3.*;

import java.io.IOException;


/**
 * Created by Administrator on 2016/7/29.
 */

public class HttpUtils {

    public static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");

    public static final String SERVER_URL = "http://127.0.0.1:80/app";
//    public static final String SERVER_URL = "http://www.guanhongshijia.com/app";
    public static final String LOGIN_URL = SERVER_URL + "/user/login";
    //添加到购物车命令
    public static final String CART_ADD_URL = SERVER_URL + "/cart/add";
    //删除购物车商品命令
    public static final String CART_DEL_URL = SERVER_URL + "/cart/del";
    //购物车列表命令
    public static final String CART_LIST_URL = SERVER_URL + "/cart/list";
    //取消收藏
    public static final String FAVORITES_CANCEL_URL = SERVER_URL + "/favorites/cancel";
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
    //根据商品分类查询商品列表命令
    public static final String GOODS_LIST_BY_CATEGORY_URL = SERVER_URL + "/goods/listByCategory";
    //根据商品分类查询品牌列表命令
    public static final String GOODS_LIST_BY_BRAND_URL = SERVER_URL + "/goods/listByBrand";
    //商品详情命令
    public static final String GOODS_DETAIL_URL = SERVER_URL + "/goods/detail";
    //获取轮播商品命令
    public static final String GOODS_LOOP_URL = SERVER_URL + "/goods/loop";
    //获取新品推荐列表
    public static final String GOODS_NEWRECOMMEND_URL = SERVER_URL + "/goods/newRecommend";
    //获取团购商品列表
    public static final String GOODS_GROUPRECOMMEND_URL = SERVER_URL + "/goods/groupRecommend";
    //获取促销列表
    public static final String GOODS_PROMOTIONRECOMMEND_URL = SERVER_URL + "/goods/promotionRecommend";
    //搜索命令
    public static final String GOODS_SEARCH_URL = SERVER_URL + "/goods/search";
    //确认订单命令
    public static final String ORDER_SUBMIT_URL = SERVER_URL + "/order/submit";
    //创建订单命令
    public static final String ORDER_CREATE_URL = SERVER_URL + "/order/create";
    //支付确认命令
    public static final String ORDER_CONFIRM_URL = SERVER_URL + "/order/confirm";
    //评价订单命令
    public static final String ORDER_EVAL_URL = SERVER_URL + "/order/eval";
    //订单查询命令
    public static final String ORDER_LIST_URL = SERVER_URL + "/order/list";
    //订单更改
    public static final String ORDER_UPDATE_URL = SERVER_URL + "/order/update";
    //查询市、区请求命令
    public static final String ORDER_QUERYAREA_URL  = SERVER_URL + "/order/queryArea";
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

    private static OkHttpClient client = new OkHttpClient();


/**
     * 同步POST请求
     * @param appRequest
     * @param url
     * @param clazz 返回类型，如登录使用LoginResult.class
     * @param <T>
     * @return
     * @throws IOException
     */

    public static <T> T syncPost(BaseRequest appRequest, String url, Class<T> clazz) throws IOException {
        String jsonStr = JSON.toJSONString(appRequest);
        RequestBody body = RequestBody.create(JSON_TYPE, jsonStr);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return JSON.parseObject(response.body().string(), clazz);
        } else {
            throw new IOException("Network error: " + response);
        }
    }


/**
     * 异步POST请求，实际使用需要根据情况传入Handler用于回调
     * @param appRequest
     * @param url
     */

    public static void asyncPost(BaseRequest appRequest, String url, final AsyncHandler handler) {
        String jsonStr = JSON.toJSONString(appRequest);
        RequestBody body = RequestBody.create(JSON_TYPE, jsonStr);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handler.handle(response.body().string());
            }
       });
    }


/**
     * 测试方法
     * @param args
     */

    public static void main(String[] args) {

        // 加入购物车
        AddCartRequest loginRequest = new AddCartRequest();
        loginRequest.setDeviceId("deviceId16");
        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
        loginRequest.setCount(1);
        loginRequest.setGoodSpecVal("8aacc990568da22501568dcaa00a0035|8aacc990568da22501568dcaa0090031|8aacc990568da22501568dcaa007002d");
        loginRequest.setGoodsId("1257");
        //模拟登录-同步请求
        try {
            AddCartResult result = HttpUtils.syncPost(loginRequest, CART_ADD_URL, AddCartResult.class);
            System.out.println(result.getResultCode());

        } catch (IOException e) {
            e.printStackTrace();
        }
        // 确认支付信息
//        ConfirmOrderRequest loginRequest = new ConfirmOrderRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//        loginRequest.setTradeNo("2016082411200406");
//        loginRequest.setPayStatus("0");
//        //模拟登录-同步请求
//        try {
//            ConfirmOrderResult result = HttpUtils.syncPost(loginRequest, ORDER_CONFIRM_URL, ConfirmOrderResult.class);
//            System.out.println(result.getResultCode());
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }

//        // 创建订单
//        CreateOrderRequest loginRequest = new CreateOrderRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//
//        AddressMember addressMember=new AddressMember();//安卓APP地址实体
//        addressMember.setReceiveDate("工作日");//送货时间
//        addressMember.setProvince("110000");
//        addressMember.setCity("110100");
//        addressMember.setCounty("110101");
//
//        addressMember.setReceiveName("hepengfei");
//        addressMember.setAddress("城社区...");
//        addressMember.setReceivePhone("18973512567");
//        addressMember.setEmail("3981873@");
//        addressMember.setReceiveTel("8226610");
//        addressMember.setCode("424100");//邮编
//        loginRequest.setAddressMember(addressMember);
//
//        loginRequest.setDlytypeId("2");//快递ID  现在默认2顺丰
//        loginRequest.setCoupons("1,");  //优惠券ID  用 ,隔开
//        loginRequest.setDlyType("1");//1 物流 0上门提货
//        loginRequest.setAccountStr("1"); //是否使用账号支付  0是    1否 //现在支持支付宝
//        loginRequest.setPlayType("1");// 1支付宝
//        loginRequest.setShop("12d0338d19a949e8967f403729a39997;0f1f06a325c74f66ae346c83cadf058d");//购物车ＩＤ　用　；隔开
//        //模拟登录-同步请求
//        try {
//            CreateOrderResult result = HttpUtils.syncPost(loginRequest, ORDER_CREATE_URL, CreateOrderResult.class);
//            System.out.println(result.getResultCode());
//            System.out.println(result.getPayPrice());
//            System.out.println(result.getTotalPrice());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        // 搜索
//        SearchRequest loginRequest = new SearchRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//        loginRequest.setKeyword("CT");
//        //模拟登录-同步请求
//        try {
//            SearchResult result = HttpUtils.syncPost(loginRequest, GOODS_SEARCH_URL, SearchResult.class);
//            System.out.println(result.getResultCode());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // 删除购物车商品
//        UpdateOrderRequest loginRequest = new UpdateOrderRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//        loginRequest.setOrderId("20160818017000015");
//        loginRequest.setOrderStatus(3);
//        //模拟登录-同步请求
//        try {
//            UpdateOrderResult result = HttpUtils.syncPost(loginRequest, ORDER_UPDATE_URL, UpdateOrderResult.class);
//            System.out.println(result.getResultCode());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // 删除购物车商品
//        DelCartRequest loginRequest = new DelCartRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//        loginRequest.setGoodsId("1299");
//        //模拟登录-同步请求
//        try {
//            DelCartResult result = HttpUtils.syncPost(loginRequest, CART_DEL_URL, DelCartResult.class);
//            System.out.println(result.getResultCode());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // 取消收藏
//        CancelFavoritesRequest loginRequest = new CancelFavoritesRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//        loginRequest.setGoodsId("1340");
//        //模拟登录-同步请求
//        try {
//            CancelFavoritesResult result = HttpUtils.syncPost(loginRequest, FAVORITES_CANCEL_URL, CancelFavoritesResult.class);
//            System.out.println(result.getResultCode());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 确认订单
//        SubmitOrderRequest loginRequest = new SubmitOrderRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//        //模拟登录-同步请求
//        try {
//            SubmitOrderResult result = HttpUtils.syncPost(loginRequest, ORDER_SUBMIT_URL, SubmitOrderResult.class);
//            System.out.println(result.getResultCode());
//            System.out.println(result.getCouponList().get(0).getName());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 根据 ID查询城市列表
//        QueryAreaRequest loginRequest = new QueryAreaRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//        loginRequest.setParentId("110000");
//        //模拟登录-同步请求
//        try {
//            QueryAreaResult result = HttpUtils.syncPost(loginRequest, ORDER_QUERYAREA_URL, QueryAreaResult.class);
//            System.out.println(result.getResultCode());
//            System.out.println(result.getAreaList().get(0).getName());
//        } catch (IOException e) {
//            e.printStackTrace();
//    }

        // 订单列表
//        QueryOrderRequest loginRequest = new QueryOrderRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//        loginRequest.setOrderStatus(0);
////        loginRequest.setToken("d59797e6-64c8-4add-895e-bda798ae021d");
//        //模拟登录-同步请求
//        try {
//            QueryOrderResult result = HttpUtils.syncPost(loginRequest, ORDER_LIST_URL, QueryOrderResult.class);
//            System.out.println(result.getResultCode());
//            System.out.println(result.getOrderList().get(0).getReceiveName());
//        } catch (IOException e) {
//            e.printStackTrace();
//    }

        // 购物车列表
//        CartListRequest loginRequest = new CartListRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
////        loginRequest.setToken("d59797e6-64c8-4add-895e-bda798ae021d");
//        //模拟登录-同步请求
//        try {
//            CartListResult result = HttpUtils.syncPost(loginRequest, CART_LIST_URL, CartListResult.class);
//            System.out.println(result.getResultCode());
//            System.out.println(result.getCart().getItemList().get(0).getGoodsDetail().getSpecVal());
//            System.out.println(result.getCart().getItemList().get(1).getGoodsDetail().getSpecVal());
//            System.out.println(result.getCart().getItemList().get(2).getGoodsDetail().getSpecVal());
//        } catch (IOException e) {
//            e.printStackTrace();
//    }
//
//        // 商品详情
//        GoodsDetailRequest loginRequest = new GoodsDetailRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//        loginRequest.setId("1263");
//        //模拟登录-同步请求
//        try {
//            GoodsDetailResult result = HttpUtils.syncPost(loginRequest, GOODS_DETAIL_URL, GoodsDetailResult.class);
//            System.out.println(result.getDetail().getName());
//            System.out.println(result.getDetail().getPrice());
//            System.out.println(result.getDetail().getCollection());
//            System.out.println(result.getDetail().getSpecList().get(0).getName());
//            System.out.println(result.getDetail().getSpecList().get(0).getSpecValueList().get(0).getValue());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        // 根据商品分类查询品牌列表
//        CategoryBrandListRequest loginRequest = new CategoryBrandListRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setPageNo(1);
//        loginRequest.setPageSize(3);
////        loginRequest.setCategoryId(100010101);
////        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//        loginRequest.setToken("d59797e6-64c8-4add-895e-bda798ae021d");
//        //模拟登录-同步请求
//        try {
//            CategoryBrandListResult result = HttpUtils.syncPost(loginRequest, GOODS_LIST_BY_BRAND_URL, CategoryBrandListResult.class);
//            System.out.println(result.getResultCode());
//            System.out.println(result.getBrandList().get(0).getTitle()+";;;"+result.getTotalPage());
//        } catch (IOException e) {
//            e.printStackTrace();
//    }

        // 发送
//        SmsRequest loginRequest = new SmsRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//        loginRequest.setMobileNo("18973512867");
//        loginRequest.setType(1);
//        //模拟登录-同步请求
//        try {
//            SmsResult result = HttpUtils.syncPost(loginRequest, SMS_URL, SmsResult.class);
//            System.out.println(result.getResultCode());//FIND_PWD_LOGIN_URL
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        // 设置锁定密码
//        FindPasswordRequest loginRequest = new FindPasswordRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//        loginRequest.setMobileNo("18973512867");
//        loginRequest.setValidateCode("411528");
//        loginRequest.setNewPassword("123123");
//        //模拟登录-同步请求
//        try {
//            FindPasswordResult result = HttpUtils.syncPost(loginRequest, FIND_PWD_LOCK_URL, FindPasswordResult.class);
//            System.out.println(result.getResultCode());//FIND_PWD_LOGIN_URL
//            System.out.println(result.getMessage());//FIND_PWD_LOGIN_URL
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 设置锁定密码
//        SetLockPasswordRequest loginRequest = new SetLockPasswordRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//        loginRequest.setPassword("123456");
//        //模拟登录-同步请求
//        try {
//            SetLockPasswordResult result = HttpUtils.syncPost(loginRequest, SET_PWD_LOCK_URL, SetLockPasswordResult.class);
//            System.out.println(result.getResultCode());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



//         根据商品分类查询商品表
//        CategoryGoodsListRequest loginRequest = new CategoryGoodsListRequest();
//        loginRequest.setDeviceId("deviceId16");
////        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//        loginRequest.setCategoryId(100010101);
//        loginRequest.setBrandId(182);
//        //模拟登录-同步请求
//        try {
//            CategoryGoodsListResult result = HttpUtils.syncPost(loginRequest, GOODS_LIST_BY_CATEGORY_URL, CategoryGoodsListResult.class);
//            System.out.println(result.getResultCode());
//            System.out.println(result.getGoodsSummaryList().get(0).getTitle());
//        } catch (IOException e) {
//            e.printStackTrace();
//    }





        // 加入收藏
//        AddFavoritesRequest loginRequest = new AddFavoritesRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
////        loginRequest.setDeviceId("deviceId1");
////        loginRequest.setToken("d59797e6-64c8-4add-895e-bda798ae021d");
//        loginRequest.setGoodsId("1274");
//        //模拟登录-同步请求
//        try {
//            AddFavoritesResult result = HttpUtils.syncPost(loginRequest, FAVORITES_ADD_URL, AddFavoritesResult.class);
//            System.out.println(result.getResultCode());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // 收藏列表
//        FavoritesListRequest loginRequest = new FavoritesListRequest();
//        loginRequest.setDeviceId("deviceId16");
////        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//        loginRequest.setToken("d59797e6-64c8-4add-895e-bda798ae021d");
//        //模拟登录-同步请求
//        try {
//            FavoritesListResult result = HttpUtils.syncPost(loginRequest, FAVORITES_LIST_URL, FavoritesListResult.class);
//            System.out.println(result.getResultCode());
//            System.out.println(result.getGoodsSummaryList().get(0).getId());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }




        //  获取二级类别
//        SubCategoryRequest loginRequest = new SubCategoryRequest();
//        loginRequest.setId(10001);
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("d59797e6-64c8-4add-895e-bda798ae021d");
//        //模拟登录-同步请求
//        try {
//            SubCategoryResult result = HttpUtils.syncPost(loginRequest, CATEGORY_SUB_URL, SubCategoryResult.class);
//            System.out.println(result.getResultCode());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        // 获取新品列表
//        RecommendGoodsRequest loginRequest = new RecommendGoodsRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("d59797e6-64c8-4add-895e-bda798ae021d");
//        //模拟登录-同步请求
//        try {
//            RecommendNewGoodsResult result = HttpUtils.syncPost(loginRequest, GOODS_NEWRECOMMEND_URL, RecommendNewGoodsResult.class);
//            System.out.println(result.getResultCode());
//            System.out.println(result.getNewList().get(0).getImageUrl());
//            System.out.println(result.getImage());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        // 获取团购列表
//        RecommendGoodsRequest loginRequest = new RecommendGoodsRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("d59797e6-64c8-4add-895e-bda798ae021d");
//        //模拟登录-同步请求
//        try {
//            RecommendGroupGoodsResult result = HttpUtils.syncPost(loginRequest, GOODS_GROUPRECOMMEND_URL, RecommendGroupGoodsResult.class);
//            System.out.println(result.getResultCode());
//            System.out.println(result.getGroupList().get(0).getImageUrl());
//            System.out.println(result.getImage());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//银行卡查询
//        QueryCardRequest loginRequest = new QueryCardRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//        //模拟登录-同步请求
//        try {
//            QueryCardResult result = HttpUtils.syncPost(loginRequest, BANK_CARD_QUERY_URL, QueryCardResult.class);
//            System.out.println(result.getResultCode());
//            System.out.println(result.getCardList().get(0).getBankName());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//佣金查询
//        QueryAgencyFeeRequest loginRequest = new QueryAgencyFeeRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//        //模拟登录-同步请求
//        try {
//            QueryAgencyFeeResult result = HttpUtils.syncPost(loginRequest, AGENCY_FEE_QUERY_URL, QueryAgencyFeeResult.class);
//            System.out.println(result.getResultCode()+"当前金额"+result.getCurrentMoney()+"佣金总额"+result.getTotalMoney());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//个人信息查询
//        QueryPersonalRequest loginRequest = new QueryPersonalRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//        //模拟登录-同步请求
//        try {
//            QueryPersonalResult result = HttpUtils.syncPost(loginRequest, PERSONAL_QUERY_URL, QueryPersonalResult.class);
//            System.out.println(result.getResultCode()+result.getPersonal().getMobileNo());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////优惠券查询
//        QueryCouponRequest loginRequest = new QueryCouponRequest();
//        loginRequest.setDeviceId("deviceId16");
//        loginRequest.setToken("2ca4ea91-1218-4320-8b9d-789d641af0fa");
//        //模拟登录-同步请求
//        try {
//            QueryCouponResult result = HttpUtils.syncPost(loginRequest, COUPON_QUERY_URL, QueryCouponResult.class);
//            System.out.println(result.getResultCode());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        //登陆测试
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setLoginName("18973512867");
//         loginRequest.setPassword("123123");
//        loginRequest.setDeviceId("deviceId16");
//        //模拟登录-同步请求
//        try {
//            LoginResult result = HttpUtils.syncPost(loginRequest, LOGIN_URL, LoginResult.class);
//            System.out.println(result.getResultCode());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        //模拟登录-异步请求
//        HttpUtils.asyncPost(loginRequest, LOGIN_URL, new AsyncHandler() {
//            @Override
//            public void handle(String responseBody) {
//                LoginResult loginResult = JSON.parseObject(responseBody, LoginResult.class);
//                System.out.println(loginResult.getResultCode());
//            }
//        });
    }


/**
     * 实际使用需要定义为一个公共接口
     */

    interface AsyncHandler {
        void handle(String responseBody);
    }
}
