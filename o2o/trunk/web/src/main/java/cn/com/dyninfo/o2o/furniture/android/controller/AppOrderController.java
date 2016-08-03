package cn.com.dyninfo.o2o.furniture.android.controller;

import cn.com.dyninfo.o2o.communication.CreateOrderRequest;
import cn.com.dyninfo.o2o.communication.CreateOrderResult;
import cn.com.dyninfo.o2o.communication.EvalOrderRequest;
import cn.com.dyninfo.o2o.communication.EvalOrderResult;
import cn.com.dyninfo.o2o.entity.CartItem;
import cn.com.dyninfo.o2o.entity.Coupon;
import cn.com.dyninfo.o2o.entity.Order;
import cn.com.dyninfo.o2o.furniture.admin.service.CouponService;
import cn.com.dyninfo.o2o.furniture.common.BaseAppController;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
@Controller
@RequestMapping("/order")
public class AppOrderController extends BaseAppController {

    @Resource
    private HuiyuanService huiyuanService;

    @Resource
    private CouponService couponService;

    @Resource
    private OrderService orderService;

    /**
     * 创建订单请求类，在购物车点击去结算时使用
     * @param createOrderRequest
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/create")
    public  CreateOrderResult create(@RequestBody  CreateOrderRequest   createOrderRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(createOrderRequest);
        CreateOrderResult result = new  CreateOrderResult();

        List<Coupon>  lists=new ArrayList<Coupon>();
        List<cn.com.dyninfo.o2o.furniture.admin.model.Coupon> list =(List<cn.com.dyninfo.o2o.furniture.admin.model.Coupon>)couponService.getListByWhere(new StringBuffer(""));
        if(list.size()>0) {
            for (int i = 0; i < list.size(); i++) {
                cn.com.dyninfo.o2o.furniture.admin.model.Coupon c=list.get(i);
                Coupon coupon = new Coupon();
                coupon.setId(String.valueOf(c.getId()));
                coupon.setName(c.getName());
                coupon.setBeginTime(c.getBeginTime());
                coupon.setEndTime(c.getEndTime());
                coupon.setType(c.getType());
                coupon.setReduceValue(c.getReduceValue());
                coupon.setDiscountValue(c.getDiscountValue());
                coupon.setMaxAmount(c.getMaxAmouont());
                coupon.setConstraintValue(c.getConstraintValue());
                coupon.setSameUse(c.getSameUse());
                lists.add(coupon);
            }
        }


        result.setCouponList(lists); //可使用的优惠券列表
        result.setTotalPrice(0);//商品总金额
        result.setPayPrice(0);//本次支付金额
        result.setResultCode(SUCCESS);
        result.setMessage("OK");

        result.setResultCode(NO_LOGIN);
        result.setMessage("创建订单请求失败");
        log.debug(result);
        return result;
    }


    /**
     * 评价订单请求
     * @param evalOrderRequest
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/eval")
    public  EvalOrderResult eval(@RequestBody  EvalOrderRequest   evalOrderRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(evalOrderRequest);
        EvalOrderResult result = new  EvalOrderResult();

        evalOrderRequest.getOrderId(); //订单ID
        evalOrderRequest.getSameStar();//商品符合度星星数量从1-5
        evalOrderRequest.getSpeedStar(); //物流速度星星数量，从1-5
        evalOrderRequest.getAttitudeStar();//配送员服务态度星星数量，从1-5
        evalOrderRequest.getOrderStatus();//订单状态：-1——全部；0——待付款；1——待发货；2——待收货，根据当前所在tab页填入，用于返回刷新后的订单列表

        List<Order>  lists=new ArrayList<Order>();
        List<cn.com.dyninfo.o2o.furniture.web.order.model.Order> list =(List<cn.com.dyninfo.o2o.furniture.web.order.model.Order>)orderService.getListByWhere(new StringBuffer(""));
        if(list.size()>0) {
            for (int i = 0; i < list.size(); i++) {
                cn.com.dyninfo.o2o.furniture.web.order.model.Order c=list.get(i);
                Order order = new Order();
                order.setId(String.valueOf(c.getOrder_id()));
                order.setDate(String.valueOf(c.getCreatTime()));//订单日期
                order.setState(Integer.parseInt(c.getState())); //状态
                order.setReceiveName(c.getReceiveName()); //收货人姓名
                order.setOrderPrice(c.getOrderPrice()); //订单金额
                order.setPayType(Integer.parseInt(c.getPayType()));//支付方式：1-支付宝；2-银联；10-线下；11-支付宝+线下；12-银联+线下
                List<CartItem> cartItemList=new ArrayList<CartItem>();
                //TODO 评价订单请求 订单商品列表
                order.setCartItemList(cartItemList);//订单商品列表
                lists.add(order);
            }
            result.setOrderList(lists);//
            result.setResultCode(SUCCESS);
            result.setMessage("OK");
        }else{
            result.setResultCode(NO_LOGIN);
            result.setMessage("评价订单请求失败");
        }
        log.debug(result);
        return result;
    }
}
