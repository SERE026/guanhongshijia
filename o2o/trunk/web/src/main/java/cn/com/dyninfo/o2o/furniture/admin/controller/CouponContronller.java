package cn.com.dyninfo.o2o.furniture.admin.controller;

import cn.com.dyninfo.o2o.furniture.admin.model.Coupon;
import cn.com.dyninfo.o2o.furniture.admin.service.CouponService;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wuweiye on 2016/7/26.
 */

@Controller
@RequestMapping("/manage/coupon")
public class CouponContronller {


    @Resource
    private CouponService couponService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request){
        ModelAndView mav=new ModelAndView();
        StringBuffer where=new StringBuffer();
        List<Coupon> couponList = new ArrayList<Coupon>();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageSize(15);
        int pageNo = 1;
        if (request.getParameter("pageNo") != null) {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
        }
        pageInfo.setPageNo(pageNo);
        HashMap map=couponService.getListByPageWhere(where,pageInfo);
        if (map != null) {
            couponList = (List<Coupon>) map.get("DATA");
        }
        pageInfo = (PageInfo) map.get("PAGE_INFO");
        mav.addObject("PAGE_INFO",pageInfo);
        mav.addObject("coupomList",couponList);
        mav.setViewName("/coupon/list");
        return mav;
    }

    /**
     * 进入添加页面
     */
    @RequestMapping("/disAdd")
    public ModelAndView disAdd(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/coupon/add");
        return mav;
    }

    /**
     * 添加保存
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView add(HttpServletRequest request,Coupon coupon) {
        ModelAndView mav = new ModelAndView();
        try{
            couponService.addObj(coupon);
            mav.setViewName("redirect:/html/manage/coupon/list");
            return mav;
        }catch(Exception e){
            e.printStackTrace();
            mav.setViewName("/coupon/add");
            return  mav;
        }
    }

    /**
     * 进入编辑页面
     */
    @RequestMapping(value = "/{id}/disUpdate")
    public ModelAndView disUpdate(@PathVariable String id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        Coupon coupon = (Coupon) couponService.getObjById(id);
        mav.addObject("info", coupon);
        mav.setViewName("/coupon/disUpdate");
        return mav;
    }

    /**
     * 编辑保存操作
     */
    @RequestMapping(method=RequestMethod.PUT)
    public ModelAndView update(Coupon coupon,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        couponService.updateObj(coupon);
        mav.setViewName("redirect:/html/manage/coupon/list");
        return  mav;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/{id}/del")
    public ModelAndView del(@PathVariable String id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        couponService.delObjById(id);
        mav.setViewName("redirect:/html/manage/coupon/list");
        return  mav;
    }

    /**
     * 删除全部
     */
    @RequestMapping("/delall")
    public ModelAndView delAll(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        if(request.getParameterValues("list")!=null){
            String []list=request.getParameterValues("list");
            for(String couponId:list){
                couponService.delObjById(couponId);
            }
        }
        mav.setViewName("redirect:/html/manage/coupon/list");
        return  mav;
    }
}
