package cn.com.dyninfo.o2o.furniture.android.controller;

import cn.com.dyninfo.o2o.communication.LoginRequest;
import cn.com.dyninfo.o2o.communication.LoginResult;
import cn.com.dyninfo.o2o.furniture.common.BaseAppController;
import cn.com.dyninfo.o2o.furniture.util.MD5Encoder;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
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


    @ResponseBody
    @RequestMapping("/login")
    public LoginResult login(@RequestBody LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(loginRequest);
        LoginResult result = new LoginResult();

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
                result.setToken(UUID.randomUUID().toString());
            }else {
                result.setResultCode(NO_LOGIN);
                result.setMessage("密码不正确");
            }
        }else{
            result.setResultCode(NO_LOGIN);
            result.setMessage("账号不存在");
        }

        log.debug(result);
        return result;
    }
}
