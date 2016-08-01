package cn.com.dyninfo.o2o.furniture.android.controller;

import cn.com.dyninfo.o2o.communication.LoginRequest;
import cn.com.dyninfo.o2o.communication.LoginResult;
import cn.com.dyninfo.o2o.furniture.common.BaseAppController;
import cn.com.dyninfo.o2o.furniture.util.MD5Encoder;
import cn.com.dyninfo.o2o.furniture.util.StringUtil;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.member.model.AppLoginStatus;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.AppLoginStatusService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

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
                new StringBuffer("n.name="+loginRequest.getLoginName()));
        if(list.size()>0){
            HuiyuanInfo info= list.get(0);
            if(password.equals(info.getPassword())){
                result.setResultCode(SUCCESS);
                result.setMessage("OK");
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

        log.debug(result);
        return result;
    }
}
