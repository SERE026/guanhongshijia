
package cn.com.dyninfo.o2o.furniture.android.controller;

import cn.com.dyninfo.o2o.communication.*;
import cn.com.dyninfo.o2o.entity.GoodsSummary;
import cn.com.dyninfo.o2o.furniture.admin.service.SendMessageService;
import cn.com.dyninfo.o2o.furniture.common.BaseAppController;
import cn.com.dyninfo.o2o.furniture.sys.Constants;
import cn.com.dyninfo.o2o.furniture.sys.service.SmsSender;
import cn.com.dyninfo.o2o.furniture.util.MD5Encoder;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;
import cn.com.dyninfo.o2o.furniture.util.ValidationUtil;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.member.model.AppLoginStatus;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.AppLoginStatusService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.member.widget.LoginBar;
import cn.com.dyninfo.o2o.furniture.web.page.model.Advwz;
import cn.com.dyninfo.o2o.furniture.web.page.service.AdvwzService;
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
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by Administrator on 2016/7/29.
 */

@Controller
@RequestMapping("/sys")
public class AppSysController extends BaseAppController {

    @Resource
    private HuiyuanService huiyuanService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private AppLoginStatusService appLoginStatusService;
    @Resource
    private AdvwzService advwzService;

    @Resource
    private SendMessageService sendMessageService;
    @Resource
    private SMSLogService smsLogService;

    @Resource
    private SmsSender smsSender;

    @ResponseBody
    @RequestMapping("/startup")
    public StartupResult startup(@RequestBody StartupRequest startupRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(startupRequest);
        StartupResult result = new StartupResult();
        if (StringUtils.isBlank(startupRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
//        if (StringUtils.isBlank(startupRequest.getToken())) {
//            result.setResultCode(NO_LOGIN);
//            result.setMessage("用户未登录");
//            return result;
//        }
        List<GoodsSummary>  lists=new ArrayList<GoodsSummary>();
//        List<AppLoginStatus> appLoginStatusList = (List<AppLoginStatus>) appLoginStatusService.getListByWhere(new StringBuffer(" and n.deviceId=" + startupRequest.getDeviceId() + " and n.token=" + startupRequest.getToken()));
//        if (appLoginStatusList != null && appLoginStatusList.size() > 0) {
//            AppLoginStatus appLoginStatus = appLoginStatusList.get(0);
//            result.setToken(appLoginStatus.getToken());
//            request.getSession().setAttribute(Context.SESSION_MEMBER, appLoginStatus.getHuiyuan());
//        }
        List<Goods>  list=(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+ Constants.ONE_SKU));
        if(list!=null&&list.size()>0) {
            for (int i = 0; i < list.size(); i++) {
                GoodsSummary goodsSummary = new GoodsSummary();
                if(String.valueOf(list.get(i).getGoods_id())!=null){
                    goodsSummary.setId(String.valueOf(list.get(i).getGoods_id()));
                }
                if(list.get(i).getName()!=null) {
                    goodsSummary.setTitle(list.get(i).getName());
                }
                if(list.get(i).getDefaultImage()!=null) {
                    goodsSummary.setMainPicUrl(Constants.DOMAIN_NAME + Constants.GOODS_IMG + list.get(i).getDefaultImage());
                }
                goodsSummary.setPrice(list.get(i).getSalesMoney());
                lists.add(goodsSummary);
            }

        }
        List<Advwz>  advwzList=(List<Advwz>)advwzService.getListByWhere(new StringBuffer("and n.advwz_id="+ Constants.STARTUP_IMG ));
        if(!ValidationUtil.isEmpty(advwzList)) {
            Advwz advwz = (Advwz) advwzList.get(0);
            if(!ValidationUtil.isEmpty(advwz.getAdv())) {
                result.setMainPic(Constants.DOMAIN_NAME + Constants.ADV_IMG + advwz.getAdv().get(0).getAdv_flie());
            }
        }
        result.setResultCode(SUCCESS);
        result.setMessage("OK");
        result.setGoodsList(lists);
        log.debug(result);
        return result;
    }

/**
     * 发送短信请求
     * @param smsRequest
     * @param request
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping("/sms")
    public SmsResult sms(@RequestBody SmsRequest smsRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(smsRequest);
        SmsResult result = new SmsResult();
        if (StringUtils.isBlank(smsRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
//        if (StringUtils.isBlank(smsRequest.getToken())) {
//            result.setResultCode(NO_LOGIN);
//            result.setMessage("用户未登录");
//            return result;
//        }
        String mobileNo = smsRequest.getMobileNo();//接收短信的手机号码
        int type = smsRequest.getType();//请求类型，1-找回登录密码；2-找回锁定密码
        //验证手机号是否存在，是否已验证
        StringBuffer where = new StringBuffer();
        where.append(" and n.phone='" + mobileNo + "' and n.phonestate='1' ");
        List<HuiyuanInfo> huiyuan = (List<HuiyuanInfo>) huiyuanService.getListByWhere(where);
        // 大于0，表示手机号已存在
        if (huiyuan.size() > 0) {
            if (AppsendCode(mobileNo,type)) {
                result.setResultCode(SUCCESS);
                result.setMessage("OK");
            }else {
                result.setResultCode(FAIL);
                result.setMessage("短信发送失败");
            }
        } else {
            result.setResultCode(NO_LOGIN);
            result.setMessage("手机号无效或未验证");
        }
        log.debug(result);
        return result;
    }

    /**
     * 安卓发送手机、找回密码、找回锁定密码、验证码
     */
    public boolean AppsendCode(String phone, int type) {
        // 首先检查该号码在3分钟内是否发送过
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuffer where = new StringBuffer();
        long l = new Date().getTime() - 3*60*1000;//当前时间-3分钟
        String time3Ago = sdf.format(new Date(l));
        String timeNow = sdf.format(new Date());
        log.warn("3分钟前的时间是：" + time3Ago);
        where.append(" and n.phone='" + phone + "'");
        where.append(" and n.time>='" + time3Ago + "' and n.time<='" + timeNow + "'");
        log.warn("查询语句：" + where);
        List logList = smsLogService.getListByWhere(where);
        if (logList.size() > 0) {
            log.warn(phone + "该号码3分钟内已经发送过验证码！");
            return false;
        } else {
            log.warn(phone + "可以发送验证码！");
        }

        // 生成验证码并发送短信
        String regCode = String.valueOf(new Random().nextInt(999999));
        log.warn("验证码是："+regCode);
        int success = -1;
        try {
            String[] par = {phone, regCode};
            boolean flag=smsSender.sendSmsWithTemplate(phone, "VCODE",par);
            if (flag){
                success=0;
            }
            log.warn("flag是："+flag);
            //request.getSession().setAttribute("VCODE", "123456");

            //success = SendDx.sendSMS(phone,"您正在进行【观红世家】手机验证，验证码是" + regCode + "，若非本人操作，请忽略【观红世家】","");
        } catch (Exception e) {
            log.error("短信发送失败！", e);
        }
        log.warn("success is: " + success);
        // 判断是否发送成功，并写入日志记录
        if (success == 0 || success == 1) {
//            session.setAttribute("regCode", regCode);
            where = new StringBuffer();
            where.append(" and n.phone='" + phone + "' order by n.time");
            List list = smsLogService.getListByWhere(where);
            if (list.size() > 0) {
                SMSLog sms = (SMSLog)list.get(0);
                sms.setPhone(phone);
                sms.setType(type);
                sms.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                sms.setPs(phone + "请求手机验证，验证码是" + regCode);
                smsLogService.updateObj(sms);
            } else {
                //System.out.println("写入新纪录==================");
                SMSLog sms = new SMSLog();
                sms.setPhone(phone);
                sms.setType(type);
                sms.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                sms.setPs(phone + "请求手机验证，验证码是" + regCode);
                smsLogService.addObj(sms);
            }
            return true;
        }
//        session.removeAttribute("regCode");
        return false;
    }
}

