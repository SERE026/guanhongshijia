package cn.com.dyninfo.o2o.furniture.admin.controller;

import cn.com.dyninfo.o2o.furniture.admin.model.Coupon;
import cn.com.dyninfo.o2o.furniture.admin.model.CouponMemberRel;
import cn.com.dyninfo.o2o.furniture.admin.model.UserInfo;
import cn.com.dyninfo.o2o.furniture.admin.service.CouponMemberRelService;
import cn.com.dyninfo.o2o.furniture.admin.service.CouponService;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zengrc on 2016/7/26.
 */

@Controller
@RequestMapping("/manage/coupon")
public class CouponContronller {


    @Resource
    private CouponService couponService;
    @Resource
    CouponMemberRelService couponMemberRelService;

    @Resource
    private HuiyuanService huiyuanService;

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
     *
     * 删除单个
     */
    @RequestMapping(value = "/{id}/del")
    public ModelAndView del(@PathVariable String id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        couponService.delObjById(id);
        mav.setViewName("redirect:/html/manage/coupon/list");
        return  mav;
    }

    /**
     *
     * 删除多个
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
     *
     * 条件发放优惠卷
     */
    @RequestMapping("/grantCouponByWhere")
    public ModelAndView grantCouponByWhere(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        String id=request.getParameter("aaa");
        StringBuffer where=new StringBuffer();
        String couponId=request.getParameter("couponId");
        int couponId1=Integer.parseInt(request.getParameter("couponId"));
        if("0".equals(id)){
            List<HuiyuanInfo> huiyuanInfos=(List<HuiyuanInfo>) huiyuanService.getListByWhere(where);
            for (int i=0;i<huiyuanInfos.size();i++){
                List<CouponMemberRel> couponMemberRelList=(List<CouponMemberRel>)couponMemberRelService.getListByWhere(new StringBuffer(" and  n.huiyuan="+ huiyuanInfos.get(i).getHuiYuan_id()+" and  n.coupon.id="+ couponId));
               if(couponMemberRelList.size()==0){
                   Coupon coupon=(Coupon) couponService.getObjById(couponId);
                  // HuiyuanInfo huiyuanInfo=(HuiyuanInfo) huiyuanService.getObjById(Integer.toString(huiyuanInfos.get(i).getHuiYuan_id()));
                   CouponMemberRel couponMemberRel=new CouponMemberRel();
                   couponMemberRel.setUsedCount(0);
                   couponMemberRel.setCount(1);
                   couponMemberRel.setHuiyuan(huiyuanInfos.get(i));
                   couponMemberRel.setCoupon(coupon);
                   couponMemberRelService.addObj(couponMemberRel);
               }else {
                   CouponMemberRel couponMemberRel=couponMemberRelList.get(0);
                   couponMemberRel.setCount(couponMemberRelList.get(0).getCount()+1);
                   couponMemberRelService.updateObj(couponMemberRel);
               }
            }
        }else if("1".equals(id)){
            int days=Integer.parseInt(request.getParameter("days"));
            String money=request.getParameter("money");
            Date date=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String myDate=df.format(date);
            String date1=df.format(new Date(date.getTime() - days * 24 * 60 * 60 * 1000));
            List<HuiyuanInfo> huiyuanInfo=(List<HuiyuanInfo>) huiyuanService.getListByWhere(new StringBuffer(" and n.logindata betwwen"+date1+" and"+myDate+"group by n.logindata"));
            for (int i=0;i<huiyuanInfo.size();i++){
                List<CouponMemberRel> couponMemberRelList=(List<CouponMemberRel>)couponMemberRelService.getListByWhere(new StringBuffer(" and  n.huiyuan="+ id+" and  n.coupon.id="+ couponId));
                if (couponMemberRelList.size()==0){
                    Coupon coupon=(Coupon) couponService.getObjById(couponId);
                   // HuiyuanInfo huiyuanInfo=(HuiyuanInfo) huiyuanService.getObjById(Integer.toString(huiyuanInfos.get(i).getHuiYuan_id()));
                    CouponMemberRel couponMemberRel=new CouponMemberRel();
                    couponMemberRel.setUsedCount(0);
                    couponMemberRel.setCount(1);
                    couponMemberRel.setHuiyuan(huiyuanInfo.get(i));
                    couponMemberRel.setCoupon(coupon);
                    couponMemberRelService.addObj(couponMemberRel);
                }else {
                    CouponMemberRel couponMemberRel=couponMemberRelList.get(0);
                    couponMemberRel.setCount(couponMemberRelList.get(0).getCount()+1);
                    couponMemberRelService.updateObj(couponMemberRel);
                }
            }
        }else if("2".equals(id)){
            int day=Integer.parseInt(request.getParameter("day"));
            Date date=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String myDate=df.format(date);
            String date1=df.format(new Date(date.getTime() - day * 24 * 60 * 60 * 1000));
            List<HuiyuanInfo> huiyuanInfos=(List<HuiyuanInfo>) huiyuanService.getListByWhere(new StringBuffer(" and n.loginData between "+date1+" and "+myDate));
            for(int i=0;i<huiyuanInfos.size();i++){
                List<CouponMemberRel> couponMemberRelList=(List<CouponMemberRel>)couponMemberRelService.getListByWhere(new StringBuffer(" and  n.huiyuan="+ huiyuanInfos.get(i).getHuiYuan_id()+" and  n.coupon.id="+ couponId));
                if (couponMemberRelList.size()==0){
                    Coupon coupon=(Coupon) couponService.getObjById(couponId);
                    // HuiyuanInfo huiyuanInfo=(HuiyuanInfo) huiyuanService.getObjById(Integer.toString(huiyuanInfos.get(i).getHuiYuan_id()));
                    CouponMemberRel couponMemberRel=new CouponMemberRel();
                    couponMemberRel.setUsedCount(0);
                    couponMemberRel.setCount(1);
                    couponMemberRel.setHuiyuan(huiyuanInfos.get(i));
                    couponMemberRel.setCoupon(coupon);
                    couponMemberRelService.addObj(couponMemberRel);
                }else {
                    CouponMemberRel couponMemberRel=couponMemberRelList.get(0);
                    couponMemberRel.setCount(couponMemberRelList.get(0).getCount()+1);
                    couponMemberRelService.updateObj(couponMemberRel);
                }
            }

        }
        mav.setViewName("redirect:/html/manage/coupon/list");
        return  mav;
    }



    /**
     * 进入发放优惠卷页面
     */
    @RequestMapping(value = "/{id}/grantCoupon")
    public ModelAndView grantCoupon(@PathVariable String id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        StringBuffer where=new StringBuffer();
        UserInfo info=(UserInfo) request.getSession().getAttribute("UserInfo");
        PageInfo page = new PageInfo();
        page.setPageSize(25);
        int no = 0;
        if ((request.getParameter("pageNo") != null)) {
            no = Integer.parseInt(request.getParameter("pageNo"));
        }
        if (no > 0) {
            page.setPageNo(no);
        } else
            page.setPageNo(1);
        if(info.getIs_user().equals("1")){
            where.append(" and n.shangJiaInfo.name like '%").append(info.getShanfJiaInfo().getName()).append("%'");
        }
        where.append(" and n.status ='0'");
        mav.addAllObjects(huiyuanService.getListByPageWhere(where, page));
        mav.addObject("PAGE_INFO", page);
        mav.addObject("info",info);
        mav.addObject("couponId",id);
        mav.setViewName("/coupon/grantCoupon");
        return mav;
    }



    /**
     * 单个发放优惠卷
     */
    @RequestMapping(value = "/{id}/grantCouponByID")
    public ModelAndView grantCouponByID(@PathVariable String id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        String couponId=request.getParameter("couponId");
        List<CouponMemberRel> couponMemberRelList=(List<CouponMemberRel>)couponMemberRelService.getListByWhere(new StringBuffer(" and  n.huiyuan="+ id+" and  n.coupon.id="+ couponId));
        if (couponMemberRelList.size()==0){
            Coupon coupon=(Coupon) couponService.getObjById(couponId);
            HuiyuanInfo huiyuanInfo=(HuiyuanInfo) huiyuanService.getObjById(id);
            CouponMemberRel couponMemberRel=new CouponMemberRel();
            couponMemberRel.setUsedCount(0);
            couponMemberRel.setCount(1);
            couponMemberRel.setHuiyuan(huiyuanInfo);
            couponMemberRel.setCoupon(coupon);
            couponMemberRelService.addObj(couponMemberRel);
        }else {
            CouponMemberRel couponMemberRel=couponMemberRelList.get(0);
            couponMemberRel.setCount(couponMemberRelList.get(0).getCount()+1);
            couponMemberRelService.updateObj(couponMemberRel);
        }
        mav.setViewName("redirect:/html/manage/coupon/list");
        return  mav;
    }

    /**
     * 多个发放优惠卷
     */
    @RequestMapping("/grantCouponAll")
    public ModelAndView grantCouponAll(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        String couponId=request.getParameter("couponId");
        Coupon coupon=(Coupon) couponService.getObjById(couponId);
        if(request.getParameterValues("list")!=null){
            String []list=request.getParameterValues("list");
            for(String id:list){
                List<CouponMemberRel> couponMemberRelList=(List<CouponMemberRel>)couponMemberRelService.getListByWhere(new StringBuffer(" and  n.huiyuan="+ id+" and  n.coupon.id="+ couponId));
                if (couponMemberRelList.size()==0){
                    HuiyuanInfo huiyuanInfo=(HuiyuanInfo) huiyuanService.getObjById(id);
                    CouponMemberRel couponMemberRel=new CouponMemberRel();
                    couponMemberRel.setUsedCount(0);
                    couponMemberRel.setCount(1);
                    couponMemberRel.setHuiyuan(huiyuanInfo);
                    couponMemberRel.setCoupon(coupon);
                    couponMemberRelService.addObj(couponMemberRel);
                }else {

                    CouponMemberRel couponMemberRel=couponMemberRelList.get(0);
                    couponMemberRel.setHuiyuan(couponMemberRelList.get(0).getHuiyuan());
                    couponMemberRel.setId(couponMemberRelList.get(0).getId());
                    couponMemberRel.setUsedCount(couponMemberRelList.get(0).getUsedCount());
                    couponMemberRel.setCount(couponMemberRelList.get(0).getCount()+1);
                    couponMemberRel.setCoupon(couponMemberRelList.get(0).getCoupon());
                    couponMemberRelService.updateObj(couponMemberRel);
                }
            }
        }
        mav.setViewName("redirect:/html/manage/coupon/list");
        return  mav;
    }
}
