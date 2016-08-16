
package cn.com.dyninfo.o2o.furniture.android.controller;

import cn.com.dyninfo.o2o.communication.*;
import cn.com.dyninfo.o2o.entity.GoodsSummary;
import cn.com.dyninfo.o2o.furniture.common.BaseAppController;
import cn.com.dyninfo.o2o.furniture.sys.Constants;
import cn.com.dyninfo.o2o.furniture.util.MD5Encoder;
import cn.com.dyninfo.o2o.furniture.util.ValidationUtil;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.member.model.AppLoginStatus;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.AppLoginStatusService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.page.model.Advwz;
import cn.com.dyninfo.o2o.furniture.web.page.service.AdvwzService;
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
import java.util.UUID;


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
        SmsResult result = new  SmsResult();
        String mobileNo=smsRequest.getMobileNo();//接收短信的手机号码
        int type=smsRequest.getType();//请求类型，1-找回登录密码；2-找回锁定密码

        result.setResultCode(SUCCESS);
        result.setMessage("OK");

        result.setResultCode(NO_LOGIN);
        result.setMessage("短信发送失败");
        log.debug(result);
        return result;
    }
}

