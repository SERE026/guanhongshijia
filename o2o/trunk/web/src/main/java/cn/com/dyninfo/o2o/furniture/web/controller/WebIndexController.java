package cn.com.dyninfo.o2o.furniture.web.controller;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dyninfo on 2016/7/15.
 */
@Controller
@RequestMapping("/")
public class WebIndexController{
    /**
     * 首页页面
     * @param request
     * @return
     */
    @RequestMapping(value= "index" )
    public String index(HttpServletRequest request) {
//        ModelAndView mav=new ModelAndView();
//        mav.setViewName("/view/index.jsp");
        return "/index";
    }
}