package cn.com.dyninfo.o2o.furniture.android.controller;

import cn.com.dyninfo.o2o.communication.LoginRequest;
import cn.com.dyninfo.o2o.communication.LoginResult;
import cn.com.dyninfo.o2o.furniture.common.BaseAppController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by Administrator on 2016/7/29.
 */
@Controller
@RequestMapping("/user")
public class AppUserController extends BaseAppController {

    @ResponseBody
    @RequestMapping("/login")
    public LoginResult login(@RequestBody LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(loginRequest);
        LoginResult result = new LoginResult();
        result.setResultCode(SUCCESS);
        result.setMessage("OK");
        result.setLoginName("userName2");
        result.setRealName("realName2");

        result.setToken(UUID.randomUUID().toString());
        result.setUserId("userID2");
        log.debug(result);
        return result;
    }
}
