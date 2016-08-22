
package cn.com.dyninfo.o2o.furniture.android.controller;

import cn.com.dyninfo.o2o.communication.*;
import cn.com.dyninfo.o2o.entity.Area;
import cn.com.dyninfo.o2o.entity.CartItem;
import cn.com.dyninfo.o2o.entity.Coupon;
import cn.com.dyninfo.o2o.entity.Order;
import cn.com.dyninfo.o2o.furniture.admin.model.CouponMemberRel;
import cn.com.dyninfo.o2o.furniture.admin.service.CouponMemberRelService;
import cn.com.dyninfo.o2o.furniture.admin.service.CouponService;
import cn.com.dyninfo.o2o.furniture.common.BaseAppController;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;
import cn.com.dyninfo.o2o.furniture.util.ValidationUtil;
import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.member.model.AppLoginStatus;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.AppLoginStatusService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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

    @Resource
    private AppLoginStatusService appLoginStatusService;

    @Resource
    private AreaService areaService;
    @Resource
    private CouponMemberRelService couponMemberRelService;
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
                if(String.valueOf(c.getId())!=null){
                    coupon.setId(String.valueOf(c.getId()));
                }
                if(c.getName()!=null){
                    coupon.setName(c.getName());
                }
                if(c.getBeginTime()!=null){
                    coupon.setBeginTime(c.getBeginTime());
                }
                if(c.getEndTime()!=null){
                    coupon.setEndTime(c.getEndTime());
                }
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
     * 订单确认请求，在购物车点击去结算时跳到确认页面
     * @param submitOrderRequest
     * @param request
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping("/submit")
    public  SubmitOrderResult submit(@RequestBody  SubmitOrderRequest   submitOrderRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(submitOrderRequest);
        SubmitOrderResult result = new  SubmitOrderResult();
        if (StringUtils.isBlank(submitOrderRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
        if (StringUtils.isBlank(submitOrderRequest.getToken())) {
            result.setResultCode(NO_LOGIN);
            result.setMessage("用户未登录");
            return result;
        }
//        String status=String.valueOf(createOrderRequest.getOrderStatus());//订单状态
        AppLoginStatus appLoginStatus=null;
        HuiyuanInfo info=(HuiyuanInfo)request.getSession().getAttribute(Context.SESSION_MEMBER);
        if (ValidationUtil.isEmpty(info)){
            List<AppLoginStatus> appLoginStatusList =(List<AppLoginStatus>)appLoginStatusService.getListByWhere(new StringBuffer(" and  n.token='"+ submitOrderRequest.getToken()+"'"));
            if(!ValidationUtil.isEmpty(appLoginStatusList)){
                appLoginStatus=appLoginStatusList.get(0);
            }
        }
        if (!ValidationUtil.isEmpty(appLoginStatus)) {
            info = appLoginStatus.getHuiyuan();
        }
        List<Coupon>  lists=new ArrayList<Coupon>();
        if (!ValidationUtil.isEmpty(info)) {
            List<CouponMemberRel> couponMemberRelList = (List<CouponMemberRel>) couponMemberRelService.getListByWhere(new StringBuffer(" and n.coupon.endTime > now() and  n.huiyuan=" + info.getHuiYuan_id() + " order by n.coupon.endTime asc"));
            if (!ValidationUtil.isEmpty(couponMemberRelList)) {
                for (int i = 0; i < couponMemberRelList.size(); i++) {
                    int count = couponMemberRelList.get(i).getCount();
                    for (int j = 0; j < count; j++) {
                        cn.com.dyninfo.o2o.furniture.admin.model.Coupon c = couponMemberRelList.get(i).getCoupon();
                        Coupon coupon = new Coupon();
                        if (String.valueOf(c.getId()) != null) {
                            coupon.setId(String.valueOf(c.getId()));
                        }
                        if (c.getName() != null) {
                            coupon.setName(c.getName());
                        }
                        if (c.getBeginTime() != null) {
                            coupon.setBeginTime(c.getBeginTime());
                        }
                        if (c.getEndTime() != null) {
                            coupon.setEndTime(c.getEndTime());
                        }
                        coupon.setType(c.getType());
                        coupon.setReduceValue(c.getReduceValue());
                        coupon.setDiscountValue(c.getDiscountValue());
                        coupon.setMaxAmount(c.getMaxAmouont());
                        coupon.setConstraintValue(c.getConstraintValue());
                        coupon.setSameUse(c.getSameUse());
                        lists.add(coupon);
                    }
                }
            }

            result.setCouponList(lists); //可使用的优惠券列表
            result.setResultCode(SUCCESS);
            result.setMessage("OK");
        }else{
            result.setResultCode(NO_LOGIN);
            result.setMessage("订单确认请求失败");
        }

        log.debug(result);
        return result;
    }


    /**
     * 查询省市
     * @param queryAreaRequest
     * @param request
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping("/queryArea")
    public  QueryAreaResult queryArea(@RequestBody QueryAreaRequest   queryAreaRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(queryAreaRequest);
        QueryAreaResult result = new  QueryAreaResult();
        if (StringUtils.isBlank(queryAreaRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
        List list=null;
        String parentId=queryAreaRequest.getParentId();//(父类ID
        if(parentId!=null&&parentId.length()>0){
            list=areaService.getListByWhere(new StringBuffer(" and n.parent.id='"+parentId+"' "));
        }else{
            list=areaService.getListByWhere(new StringBuffer(" and n.parent.id is null "));
        }
        List<Area> areaList=new ArrayList<Area>();
        if (!ValidationUtil.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                AreaInfo a = (AreaInfo) list.get(i);
                Area area = new Area();
                area.setId(a.getId());
                area.setName(a.getName());
                areaList.add(area);
            }
        }
        result.setAreaList(areaList);
        result.setResultCode(SUCCESS);
        result.setMessage("OK");
//        result.setResultCode(NO_LOGIN);
//        result.setMessage("创建订单请求失败");
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
                if(String.valueOf(c.getOrder_id())!=null){
                    order.setId(String.valueOf(c.getOrder_id()));
                }
                if(String.valueOf(c.getCreatTime())!=null){
                    order.setDate(String.valueOf(c.getCreatTime()));//订单日期
                }
                order.setState(Integer.parseInt(c.getState())); //状态
                if(c.getReceiveName()!=null){
                    order.setReceiveName(c.getReceiveName()); //收货人姓名
                }
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


/**
     * 订单查询请求
     * @param queryOrderRequest
     * @param request
     * @param response
     * @return
     * 0.有效 1.未付款 2.已付款3.交易成功4.无效
     */

    @ResponseBody
    @RequestMapping("/list")
    public QueryOrderResult list(@RequestBody  QueryOrderRequest   queryOrderRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(queryOrderRequest);
        QueryOrderResult result = new  QueryOrderResult();
        if (StringUtils.isBlank(queryOrderRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
        if (StringUtils.isBlank(queryOrderRequest.getToken())) {
            result.setResultCode(NO_LOGIN);
            result.setMessage("用户未登录");
            return result;
        }
        String status=String.valueOf(queryOrderRequest.getOrderStatus());//订单状态
        AppLoginStatus appLoginStatus=null;
        HuiyuanInfo info=(HuiyuanInfo)request.getSession().getAttribute(Context.SESSION_MEMBER);
        if (ValidationUtil.isEmpty(info)){
            List<AppLoginStatus> appLoginStatusList =(List<AppLoginStatus>)appLoginStatusService.getListByWhere(new StringBuffer(" and  n.token='"+ queryOrderRequest.getToken()+"'"));
            if(!ValidationUtil.isEmpty(appLoginStatusList)){
                appLoginStatus=appLoginStatusList.get(0);
            }
        }
        if (!ValidationUtil.isEmpty(appLoginStatus)) {
            info = appLoginStatus.getHuiyuan();
        }
        PageInfo pageInfo=new PageInfo();
        pageInfo.setPageNo(queryOrderRequest.getPageNo());
        pageInfo.setPageSize(queryOrderRequest.getPageSize());
        StringBuffer where =new StringBuffer();//0.有效 1.未付款 2.已付款3.交易成功4.无效
        if(!ValidationUtil.isEmpty(info)) {
            where.append(" and n.huiyuan.huiYuan_id = '" + info.getHuiYuan_id() + "' ");
            if (status.equals("0")) {
                where.append(" and n.state != '6' ");
            } else if (status.equals("1")) {
                where.append(" and n.state = '0' and n.isPay='0' ");
            } else if (status.equals("2")) {
                where.append(" and n.state = '1' ");
            } else if (status.equals("3")) {
                where.append(" and n.state = '3' ");
            } else if (status.equals("4")) {
                where.append(" and n.state = '6' ");
            }
            where.append(" and n.status='0'");
            where.append(" order by n.time desc");
            List<Order> lists = new ArrayList<Order>();
            Map map =  (Map) orderService.getListByPageWhere(where, pageInfo);//查询订单
            List<cn.com.dyninfo.o2o.furniture.web.order.model.Order> list=(List<cn.com.dyninfo.o2o.furniture.web.order.model.Order>) map.get("DATA");

            if(!ValidationUtil.isEmpty(list)){
                for (int i = 0; i < list.size(); i++) {
                    Order order=new  Order();
                    order.setId(list.get(i).getOrder_id());//ID
                    order.setDate(String.valueOf(list.get(i).getCreatTime()));//创建时间
                    order.setOrderPrice(list.get(i).getOrderPrice());//总价
                    order.setState(Integer.parseInt(list.get(i).getState()));//状态
                    order.setReceiveName(list.get(i).getReceiveName());//收货人
                    order.setPayType(Integer.parseInt(list.get(i).getIsPay()));//是否支付
                    lists.add(order);
                }
                int totalpage=(pageInfo.getTotalCount()+pageInfo.getPageSize()-1)/pageInfo.getPageSize();
                result.setPageNo(pageInfo.getPageNo());
                result.setTotalPage(totalpage);
                result.setOrderList(lists);
                result.setResultCode(SUCCESS);
                result.setMessage("OK");
            }
        } else{
            result.setResultCode(NO_LOGIN);
            result.setMessage("订单查询请求失败");
        }
        log.debug(result);
        return result;
    }
}

