package cn.com.dyninfo.o2o.furniture.admin.controller;

import cn.com.dyninfo.o2o.furniture.admin.model.Coupon;
import cn.com.dyninfo.o2o.furniture.admin.model.KefuInfo;
import cn.com.dyninfo.o2o.furniture.admin.service.KefuInfoService;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zengrc on 2016/7/26.
 */

@Controller
@RequestMapping("/manage/kefu")
public class KefuContronller {


    @Resource
    private KefuInfoService kefuInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request){
        ModelAndView mav=new ModelAndView();
        StringBuffer where=new StringBuffer();
        List<KefuInfo> kefuList = new ArrayList<KefuInfo>();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageSize(15);
        int pageNo = 1;
        if (request.getParameter("pageNo") != null) {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
        }
        pageInfo.setPageNo(pageNo);
        HashMap map=kefuInfoService.getListByPageWhere(where,pageInfo);
        if (map != null) {
            kefuList = (List<KefuInfo>) map.get("DATA");
        }
        pageInfo = (PageInfo) map.get("PAGE_INFO");
        mav.addObject("PAGE_INFO",pageInfo);
        mav.addObject("kefuList",kefuList);
        mav.setViewName("/kefu/list");
        return mav;
    }

    /**
     * 进入编辑页面
     */
    @RequestMapping(value = "/{id}/disUpdate")
    public ModelAndView disUpdate(@PathVariable String id,String goodsId, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("roomName", id);
        mav.addObject("goodsId", goodsId);
        mav.setViewName("/kefu/disUpdate");
        return mav;
    }
//
//    /**
//     * 进入添加页面
//     */
//    @RequestMapping("/disAdd")
//    public ModelAndView disAdd(HttpServletRequest request) {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("/coupon/add");
//        return mav;
//    }
//
    /**
     *  上线下线
     * 删除单个
     */
    @RequestMapping(value = "/update/{id}")
    public ModelAndView update(@PathVariable String id,String status,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        KefuInfo kefuInfo = (KefuInfo) kefuInfoService.getObjById(id);
            kefuInfo.setStatus(status);
        kefuInfoService.updateObj(kefuInfo);
        mav.setViewName("redirect:/html/manage/kefu/list");
        return  mav;
    }
//
//    /**
//     *
//     * 删除多个
//     */
//    @RequestMapping("/delall")
//    public ModelAndView delAll(HttpServletRequest request) {
//        ModelAndView mav = new ModelAndView();
//        if(request.getParameterValues("list")!=null){
//            String []list=request.getParameterValues("list");
//            for(String couponId:list){
//                couponService.delObjById(couponId);
//            }
//        }
//        mav.setViewName("redirect:/html/manage/coupon/list");
//        return  mav;
//    }
//
//    /**
//     * 添加保存
//     */
//    @RequestMapping(method = RequestMethod.POST)
//    public ModelAndView add(HttpServletRequest request,Coupon coupon) {
//        ModelAndView mav = new ModelAndView();
//        try{
//            couponService.addObj(coupon);
//            mav.setViewName("redirect:/html/manage/coupon/list");
//            return mav;
//        }catch(Exception e){
//            e.printStackTrace();
//            mav.setViewName("/coupon/add");
//            return  mav;
//        }
//    }
//
//    /**
//     * 进入编辑页面
//     */
//    @RequestMapping(value = "/{id}/disUpdate")
//    public ModelAndView disUpdate(@PathVariable String id, HttpServletRequest request) {
//        ModelAndView mav = new ModelAndView();
//        Coupon coupon = (Coupon) couponService.getObjById(id);
//        mav.addObject("info", coupon);
//        mav.setViewName("/coupon/disUpdate");
//        return mav;
//    }
//
//    /**
//     * 编辑保存操作
//     */
//    @RequestMapping(method=RequestMethod.PUT)
//    public ModelAndView update(Coupon coupon,HttpServletRequest request) {
//        ModelAndView mav = new ModelAndView();
//        couponService.updateObj(coupon);
//        mav.setViewName("redirect:/html/manage/coupon/list");
//        return  mav;
//    }


}
