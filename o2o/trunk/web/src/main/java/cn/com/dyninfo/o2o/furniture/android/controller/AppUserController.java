
package cn.com.dyninfo.o2o.furniture.android.controller;

import cn.com.dyninfo.o2o.communication.*;
import cn.com.dyninfo.o2o.entity.AgencyFeeItem;
import cn.com.dyninfo.o2o.entity.Card;
import cn.com.dyninfo.o2o.entity.Coupon;
import cn.com.dyninfo.o2o.entity.Personal;
import cn.com.dyninfo.o2o.furniture.admin.model.CouponMemberRel;
import cn.com.dyninfo.o2o.furniture.admin.service.CouponMemberRelService;
import cn.com.dyninfo.o2o.furniture.admin.service.CouponService;
import cn.com.dyninfo.o2o.furniture.common.BaseAppController;
import cn.com.dyninfo.o2o.furniture.util.MD5Encoder;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ValidationUtil;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.member.model.AppLoginStatus;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.AppLoginStatusService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import cn.com.dyninfo.o2o.furniture.web.setting.model.SMSLog;
import cn.com.dyninfo.o2o.furniture.web.setting.service.SMSLogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by Administrator on 2016/7/29.
 */

@Controller
@RequestMapping("/user")
public class AppUserController extends BaseAppController {

    @Resource
    private HuiyuanService huiyuanService;

    @Resource
    private AppLoginStatusService appLoginStatusService;

    @Resource
    private CouponMemberRelService couponMemberRelService;

    @Resource
    private OrderService orderService;

    @Resource
    private CouponService couponService;

    @Resource
    private SMSLogService smsLogService;


/**
     * d登录请求
     * @param loginRequest
     * @param request
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping("/login")
    public LoginResult login(@RequestBody LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(loginRequest);
        LoginResult result = new LoginResult();
        if (StringUtils.isBlank(loginRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }

       String password= MD5Encoder.encodePassword(loginRequest.getPassword(), Context.PASSWORDY);

        List<HuiyuanInfo>  list=(List<HuiyuanInfo>) huiyuanService.getListByWhere(
                new StringBuffer(" and n.name='"+loginRequest.getLoginName() + "'"));
        if(!ValidationUtil.isEmpty(list)){
            HuiyuanInfo info= list.get(0);
            if(password.equals(info.getPassword())){
                result.setResultCode(SUCCESS);
                result.setMessage("OK");
                result.setDeviceId(loginRequest.getDeviceId());
                result.setLoginName(info.getName());
                result.setRealName(info.getNickname());
                result.setUserId(String.valueOf(info.getHuiYuan_id())); //会员实体是 int
                String token = UUID.randomUUID().toString();
                result.setToken(token);
                AppLoginStatus appLoginStatus = new AppLoginStatus();
                appLoginStatus.setToken(token);
                appLoginStatus.setDeviceId(loginRequest.getDeviceId());
                appLoginStatus.setHuiyuan(info);
                appLoginStatusService.addObj(appLoginStatus);
                request.getSession().setAttribute(Context.SESSION_MEMBER, info);
            }else {
                result.setResultCode(NO_LOGIN);
                result.setMessage("用户名或密码错误");
            }
        }else{
            result.setResultCode(NO_LOGIN);
            result.setMessage("用户名或密码错误");
        }
        HuiyuanInfo info=(HuiyuanInfo)request.getSession().getAttribute(Context.SESSION_MEMBER);
        log.debug(result);
        return result;
    }
    /**
     * 验证码是否正确判断
     * @param phone
     * @param code
     * @return
     */
    public boolean validphoneCode(String phone, String code){
        // 判断验证码是否超时
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuffer where = new StringBuffer();
        long l = new Date().getTime() - 3*60*1000;//当前时间-3分钟
        String time3Ago = sdf.format(new Date(l));
        String timeNow = sdf.format(new Date());
        //System.out.println("3分钟前的时间是：" + time3Ago);
        where.append(" and n.phone='" + phone + "'");
        where.append(" and n.time>='" + time3Ago + "' and n.time<='" + timeNow + "'");
//        where.append(" order n.time desc ");
        //System.out.println("查询语句：" + where);
        List logList = smsLogService.getListByWhere(where);
        // 如果未超时，允许验证
        if (logList.size() == 0) {
            return false;
        }else{// 判断验证码是否正确
            SMSLog log = (SMSLog)logList.get(0);
            if(code.length() == 6 && log.getPs().contains(code)){
                return true;
            }else{
                return false;
            }
        }
    }

/**
     * 找回锁定密码
     * @param findPasswordRequest
     * @param request
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping("/findLockPassword")
    public FindPasswordResult findLockPassword(@RequestBody FindPasswordRequest findPasswordRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(findPasswordRequest);
        FindPasswordResult result = new  FindPasswordResult();
        if (StringUtils.isBlank(findPasswordRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
//        if (StringUtils.isBlank(findPasswordRequest.getToken())) {
//            result.setResultCode(NO_LOGIN);
//            result.setMessage("用户未登录");
//            return result;
//        }
        String newPassword= MD5Encoder.encodePassword(findPasswordRequest.getNewPassword(), Context.PASSWORDY);
        String validateCode=findPasswordRequest.getValidateCode();//校验码
        String mobileNo=findPasswordRequest.getMobileNo();//手机号码
        List<HuiyuanInfo>  list=(List<HuiyuanInfo>) huiyuanService.getListByWhere(
                new StringBuffer(" and n.phone="+ mobileNo));
        if(!ValidationUtil.isEmpty(list)){
            HuiyuanInfo info= list.get(0);
            if(validphoneCode(mobileNo,validateCode)){  //判断校验码 是否正确
                info.setLockPassword(newPassword);
                huiyuanService.updateObj(info);
                result.setResultCode(SUCCESS);
                result.setMessage("OK");
            }else {
                result.setResultCode(NO_LOGIN);
                result.setMessage("校验码不正确");
            }
        }else{
            result.setResultCode(NO_LOGIN);
            result.setMessage("账号不存,无效的手机号码");
        }
        log.debug(result);
        return result;
    }

/**
     * 找回登陆密码
     * @param findPasswordRequest
     * @param request
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping("/findLoginPassword")
    public  FindPasswordResult findLoginPassword(@RequestBody  FindPasswordRequest   findPasswordRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(findPasswordRequest);
        FindPasswordResult result = new  FindPasswordResult();
        if (StringUtils.isBlank(findPasswordRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
//        if (StringUtils.isBlank(findPasswordRequest.getToken())) {
//            result.setResultCode(NO_LOGIN);
//            result.setMessage("用户未登录");
//            return result;
//        }
        String validateCode=findPasswordRequest.getValidateCode();//校验码
        String mobileNo=findPasswordRequest.getMobileNo();//校验码
        String newPassword= MD5Encoder.encodePassword(findPasswordRequest.getNewPassword(), Context.PASSWORDY);
        List<HuiyuanInfo>  list=(List<HuiyuanInfo>) huiyuanService.getListByWhere(
                new StringBuffer(" and n.phone="+mobileNo));
        if(!ValidationUtil.isEmpty(list)){
            HuiyuanInfo info= list.get(0);
            if(validphoneCode(mobileNo,validateCode)){  //判断校验码 是否正确
                info.setPassword(newPassword);
                huiyuanService.updateObj(info);
                result.setResultCode(SUCCESS);
                result.setMessage("OK");
            }else {
                result.setResultCode(NO_LOGIN);
                result.setMessage("校验码不正确");
            }
        }else{
            result.setResultCode(NO_LOGIN);
            result.setMessage("账号不存,无效的手机号码");
        }
        log.debug(result);
        return result;
    }


/**
     * 佣金查询
     * @param queryAgencyFeeRequest
     * @param request
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping("/queryAgencyFee")
    public QueryAgencyFeeResult queryAgencyFee(@RequestBody  QueryAgencyFeeRequest   queryAgencyFeeRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(queryAgencyFeeRequest);
        QueryAgencyFeeResult result = new  QueryAgencyFeeResult();
        if (StringUtils.isBlank(queryAgencyFeeRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
        if (StringUtils.isBlank(queryAgencyFeeRequest.getToken())) {
            result.setResultCode(NO_LOGIN);
            result.setMessage("用户未登录");
            return result;
        }
        AppLoginStatus appLoginStatus=null;
        HuiyuanInfo info=(HuiyuanInfo)request.getSession().getAttribute(Context.SESSION_MEMBER);
        if (ValidationUtil.isEmpty(info)){
            List<AppLoginStatus> appLoginStatusList =(List<AppLoginStatus>)appLoginStatusService.getListByWhere(new StringBuffer(" and  n.token='"+ queryAgencyFeeRequest.getToken()+"'"));
            if(!ValidationUtil.isEmpty(appLoginStatusList)){
                appLoginStatus=appLoginStatusList.get(0);
            }
        }
        if (!ValidationUtil.isEmpty(appLoginStatus)) {
            info = appLoginStatus.getHuiyuan();
        }
       PageInfo pageInfo=new PageInfo();
        pageInfo.setPageNo(queryAgencyFeeRequest.getPageNo());
        pageInfo.setPageSize(queryAgencyFeeRequest.getPageSize());
        List<AgencyFeeItem> lists=new ArrayList<AgencyFeeItem>();
        Double totalMoney=0.00;//+"and n.agencyPay='1' order by n.time asc"
      // List<Order> list =(List<Order>)orderService.getListByWhere(new StringBuffer(" and n.agencyPay='1' and  n.huiyuan.huiYuan_id="+info.getHuiYuan_id()+"order by n.time asc"));
        if(!ValidationUtil.isEmpty(info)) {
            Map map = orderService.getListByPageWhere(new StringBuffer(" and n.agencyPay='1' and  n.huiyuan.huiYuan_id=" + info.getHuiYuan_id() + "order by n.time desc"), pageInfo);
            List<Order> list = (List<Order>) map.get("DATA");
            if (!ValidationUtil.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    AgencyFeeItem agency = new AgencyFeeItem();
                    agency.setId(String.valueOf(list.get(i).getOrder_id()));
                    agency.setDate(String.valueOf(list.get(i).getTime()));//订单完成日期
                    agency.setOrderNo(list.get(i).getOrder_id());//订单号
                    agency.setPrice(list.get(i).getOrderPrice()); //商品总价（去除优惠券抵扣价格）
                    agency.setPercent(String.valueOf(list.get(i).getAgencyPercent()));//佣金比率
                    agency.setAmount(list.get(i).getAgencyFee()); //佣金金额
                    totalMoney += list.get(i).getAgencyFee();
                    lists.add(agency);
                }
                result.setRecentMoney(list.get(0).getAgencyFee()); //最近佣金
            }
            int totalpage=(pageInfo.getTotalCount()+pageInfo.getPageSize()-1)/pageInfo.getPageSize();
            result.setPageNo(pageInfo.getPageNo());
            result.setTotalPage(totalpage);
            result.setTotalMoney(totalMoney); //累计佣金
            result.setDataDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));//数据截至时间
            result.setCurrentMoney(info.getMoney()); //总资产
            result.setAgencyFeeItemList(lists);//佣金明细
            result.setResultCode(SUCCESS);
            result.setMessage("OK");
        }
        else {
            result.setResultCode(NO_LOGIN);
            result.setMessage("佣金查询失败,请重新登录");
        }
        log.debug(result);
        return result;
    }


/**
     * 银行卡查询
     * @param queryCardRequest
     * @param request
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping("/bankCard")
    public  QueryCardResult bankCard(@RequestBody  QueryCardRequest   queryCardRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(queryCardRequest);
        QueryCardResult result = new  QueryCardResult();
        if (StringUtils.isBlank(queryCardRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
        if (StringUtils.isBlank(queryCardRequest.getToken())) {
            result.setResultCode(NO_LOGIN);
            result.setMessage("用户未登录");
            return result;
        }
        //获取用户信息
        AppLoginStatus appLoginStatus=null;
        HuiyuanInfo info=(HuiyuanInfo)request.getSession().getAttribute(Context.SESSION_MEMBER);
        if (ValidationUtil.isEmpty(info)){
            List<AppLoginStatus> appLoginStatusList =(List<AppLoginStatus>)appLoginStatusService.getListByWhere(new StringBuffer(" and  n.token='"+ queryCardRequest.getToken()+"'"));
            if(!ValidationUtil.isEmpty(appLoginStatusList)){
                appLoginStatus=appLoginStatusList.get(0);
            }
        }
        if (!ValidationUtil.isEmpty(appLoginStatus)) {
            info = appLoginStatus.getHuiyuan();
        }
        List<Card>  lists=new ArrayList<Card>();
        if(!ValidationUtil.isEmpty(info)){
                Card card = new Card();
                card.setId(String.valueOf(info.getShangJiaInfo().getShangjia_id()));
                card.setCardNo(info.getShangJiaInfo().getBankCardAccount());
                card.setBankName(info.getShangJiaInfo().getBankName());
//                card.setStatus(c.getEndTime());
//                card.setType(c.getType());
                lists.add(card);
            result.setCardList(lists);
            result.setResultCode(SUCCESS);
            result.setMessage("OK");
        }
        else{
            result.setResultCode(NO_LOGIN);
            result.setMessage("银行卡查询失败");
        }
        log.debug(result);
        return result;
    }


/**
     * 优惠券查询
     * @param queryCouponRequest
     * @param request
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping("/coupon")
    public  QueryCouponResult coupon(@RequestBody  QueryCouponRequest   queryCouponRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(queryCouponRequest);
        QueryCouponResult result = new  QueryCouponResult();
        if (StringUtils.isBlank(queryCouponRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
        if (StringUtils.isBlank(queryCouponRequest.getToken())) {
            result.setResultCode(NO_LOGIN);
            result.setMessage("用户未登录");
            return result;
        }
        //获取用户信息
        AppLoginStatus appLoginStatus=null;
        HuiyuanInfo info=(HuiyuanInfo)request.getSession().getAttribute(Context.SESSION_MEMBER);
        if (ValidationUtil.isEmpty(info)){
            List<AppLoginStatus> appLoginStatusList =(List<AppLoginStatus>)appLoginStatusService.getListByWhere(new StringBuffer(" and  n.token='"+ queryCouponRequest.getToken()+"'"));
            if(!ValidationUtil.isEmpty(appLoginStatusList)){
                appLoginStatus=appLoginStatusList.get(0);
            }
        }
        if (!ValidationUtil.isEmpty(appLoginStatus)) {
            info = appLoginStatus.getHuiyuan();
        }
        List<Coupon>  lists=new ArrayList<Coupon>();
        // List<cn.com.dyninfo.o2o.furniture.admin.model.Coupon> list =(List<cn.com.dyninfo.o2o.furniture.admin.model.Coupon>)couponService.getListByWhere(new StringBuffer(" and n."));
        if(!ValidationUtil.isEmpty(info)) {
            List list = couponMemberRelService.getListByWhere(new StringBuffer(" and  n.huiyuan=" + info.getHuiYuan_id() + " order by n.coupon.endTime asc"));

            if (!ValidationUtil.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    CouponMemberRel c = (CouponMemberRel) list.get(i);
                    Coupon coupon = new Coupon();
                    coupon.setId(String.valueOf(c.getCoupon().getId()));
                    coupon.setName(c.getCoupon().getName());
                    coupon.setBeginTime(c.getCoupon().getBeginTime());
                    coupon.setEndTime(c.getCoupon().getEndTime());
                    coupon.setType(c.getCoupon().getType());
                    coupon.setReduceValue(c.getCoupon().getReduceValue());
                    coupon.setDiscountValue(c.getCoupon().getDiscountValue());
                    coupon.setMaxAmount(c.getCoupon().getMaxAmouont());
                    coupon.setConstraintValue(c.getCoupon().getConstraintValue());
                    coupon.setSameUse(c.getCoupon().getSameUse());
                    lists.add(coupon);
                }
            }
            result.setResultCode(SUCCESS);
            result.setMessage("OK");
            result.setCouponList(lists);
        }
        else{
            result.setResultCode(NO_LOGIN);
            result.setMessage("优惠券查询失败");
        }
        log.debug(result);
        return result;
    }


/**
     * 个人信息查询
     * @param queryPersonalRequest
     * @param request
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping("/personal")
    public  QueryPersonalResult personal(@RequestBody  QueryPersonalRequest   queryPersonalRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(queryPersonalRequest);
        QueryPersonalResult result = new  QueryPersonalResult();
        if (StringUtils.isBlank(queryPersonalRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
        if (StringUtils.isBlank(queryPersonalRequest.getToken())) {
            result.setResultCode(NO_LOGIN);
            result.setMessage("用户未登录");
            return result;
        }
        //获取用户信息
        AppLoginStatus appLoginStatus=null;
        HuiyuanInfo info=(HuiyuanInfo)request.getSession().getAttribute(Context.SESSION_MEMBER);
        if (ValidationUtil.isEmpty(info)){
            List<AppLoginStatus> appLoginStatusList =(List<AppLoginStatus>)appLoginStatusService.getListByWhere(new StringBuffer(" and  n.token='"+ queryPersonalRequest.getToken()+"'"));
            if(!ValidationUtil.isEmpty(appLoginStatusList)){
                appLoginStatus=appLoginStatusList.get(0);
            }
        }
        if (!ValidationUtil.isEmpty(appLoginStatus)) {
            info = appLoginStatus.getHuiyuan();
        }
        Personal personal=new Personal();
        if(!ValidationUtil.isEmpty(info)){
            personal.setNickName(info.getUserName());//昵称
            personal.setRealName(info.getNickname());//真实姓名
            personal.setId(String.valueOf(info.getHuiYuan_id())); //会员实体是 int
            personal.setMobileNo(info.getPhone());
            personal.setEmail(info.getEmail());
            personal.setBirthday(info.getBirthday());
            personal.setPhoneNo(info.getTel());
            personal.setAddress(info.getAddress());

            result.setPersonal(personal);
            result.setResultCode(SUCCESS);
            result.setMessage("OK");
        }
        else{
            result.setResultCode(NO_LOGIN);
            result.setMessage("个人信息查询失败");
        }
        log.debug(result);
        return result;
    }


/**
     * 设置锁定密码请求
     * @param setLockPasswordRequest
     * @param request
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping("/lockPassword")
    public SetLockPasswordResult lockPassword(@RequestBody SetLockPasswordRequest setLockPasswordRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(setLockPasswordRequest);
        SetLockPasswordResult result = new  SetLockPasswordResult();
        if (StringUtils.isBlank(setLockPasswordRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
        if (StringUtils.isBlank(setLockPasswordRequest.getToken())) {
            result.setResultCode(NO_LOGIN);
            result.setMessage("用户未登录");
            return result;
        }
        String password= MD5Encoder.encodePassword(setLockPasswordRequest.getPassword(), Context.PASSWORDY);
        //获取用户信息
        AppLoginStatus appLoginStatus=null;
        HuiyuanInfo info=(HuiyuanInfo)request.getSession().getAttribute(Context.SESSION_MEMBER);
        if (ValidationUtil.isEmpty(info)){
            List<AppLoginStatus> appLoginStatusList =(List<AppLoginStatus>)appLoginStatusService.getListByWhere(new StringBuffer(" and  n.token='"+ setLockPasswordRequest.getToken()+"'"));
            if(!ValidationUtil.isEmpty(appLoginStatusList)){
                appLoginStatus=appLoginStatusList.get(0);
            }
        }
        if (!ValidationUtil.isEmpty(appLoginStatus)) {
            info = appLoginStatus.getHuiyuan();
        }
        if(!ValidationUtil.isEmpty(info)){
            info.setLockPassword(password);
            huiyuanService.updateObj(info);
            result.setResultCode(SUCCESS);
            result.setMessage("OK");
        }
        else{
            result.setResultCode(NO_LOGIN);
            result.setMessage("设置锁定密码失败");
        }
        log.debug(result);
        return result;
    }
}

