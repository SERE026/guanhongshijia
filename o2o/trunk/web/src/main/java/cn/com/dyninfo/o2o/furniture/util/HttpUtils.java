package cn.com.dyninfo.o2o.furniture.util;

import cn.com.dyninfo.o2o.communication.LoginRequest;
import cn.com.dyninfo.o2o.communication.LoginResult;
import cn.com.dyninfo.o2o.communication.common.BaseRequest;
import com.alibaba.fastjson.JSON;
import okhttp3.*;

import java.io.IOException;

/**
 * Created by Administrator on 2016/7/29.
 */
public class HttpUtils {

    public static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");

    public static final String SERVER_URL = "http://127.0.0.1:8080/app";

    public static final String LOGIN_URL = SERVER_URL + "/user/login";
    //添加到购物车命令
    public static final String CART_ADD_URL = SERVER_URL + "/cart/add";
    //购物车列表命令
    public static final String CART_LIST_URL = SERVER_URL + "/cart/list";
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
    //商品详情命令
    public static final String GOODS_DETAIL_URL = SERVER_URL + "/goods/detail";
    //获取轮播商品命令
    public static final String GOODS_LOOP_URL = SERVER_URL + "/goods/loop";
    //获取推荐页面命令
    public static final String GOODS_RECOMMEND_URL = SERVER_URL + "/goods/recommend";
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
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLoginName("lxfeng");
        loginRequest.setPassword("123123");
        loginRequest.setDeviceId("deviceId1");
        //模拟登录-同步请求
        try {
            LoginResult result = HttpUtils.syncPost(loginRequest, LOGIN_URL, LoginResult.class);
            System.out.println(result.getResultCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
