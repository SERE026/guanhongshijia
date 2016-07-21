package cn.com.dyninfo.o2o.furniture.web.controller;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Brand;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.model.GoodsSort;
import cn.com.dyninfo.o2o.furniture.web.goods.model.PageModule;
import cn.com.dyninfo.o2o.furniture.web.goods.service.*;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dyninfo on 2016/7/15.
 */
@Controller
@RequestMapping("/")
public class WebIndexController{
    public static final int REMAI_SKU = 27;//热卖
    public static final int QIANGGOU_SKU = 47;//抢购
    public static final int REPIN_SKU =49;//热评
    public static final int NEW_SKU =36;//新品
    public static final int XIANSHI_SKU = 37;//限时

    public static final int ONE_SKU = 1000101;//1F楼
    public static final int TWO_SKU = 1000101;//2F楼
    public static final int THREE_SKU = 1000101;//3F楼
    public static final int FOUR_SKU = 1000101;//4F楼
    @Resource
    private GoodsService goodsService;
    @Resource
    private GoodsSortService goodsSortService;

    @Resource
    private GoodsTypeService goodsTypeService;

    @Resource
    private BrandService brandService;

    @Resource
    private PageModuleService  pageModuleService;

    /**
     * 首页页面
     * @param request
     * @return
     */
    @RequestMapping(value= "index" )
    public String index(HttpServletRequest request, ModelMap mav) {
//        StringBuffer where=new StringBuffer();
//        PageInfo page = new PageInfo();
//        page.setPageSize(6);
//        page.setPageNo(1);
//        // where.append(" order by indexs");
//        HashMap<String, ?> data = goodsService.getListByPageWhere(where, page);
//        // 保存商品标签名字，便于页面加载
//        List<Goods> goodsList = (List<Goods>)data.get("DATA");
//        mav.addAttribute("goodsList", goodsList);


        StringBuffer where1=new StringBuffer();
        //所有的分类  一级。二级,三级
        List<GoodsSort> dataList =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer());
        mav.addAttribute("goodsSortList",dataList);

        //1F楼商品
        List<GoodsSort> goodsSortList1 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+ONE_SKU));
        mav.addAttribute("goodsSortList1",goodsSortList1);
        List<Goods> goodsList1 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+ONE_SKU));
        mav.addAttribute("goodsList1",goodsList1);
        //2F楼商品
        List<GoodsSort> goodsSortList2 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+TWO_SKU));
        mav.addAttribute("goodsSortList2",goodsSortList2);
        List<Goods> goodsList2 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+TWO_SKU));
        mav.addAttribute("goodsList2",goodsList2);
        //3F楼商品
        List<GoodsSort> goodsSortList3 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+THREE_SKU));
        mav.addAttribute("goodsSortList3",goodsSortList3);
        List<Goods> goodsList3 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+THREE_SKU));
        mav.addAttribute("goodsList3",goodsList3);
        //4F楼商品
        List<GoodsSort> goodsSortList4 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+FOUR_SKU));
        mav.addAttribute("goodsSortList4",goodsSortList4);
        List<Goods> goodsList4 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+FOUR_SKU));
        mav.addAttribute("goodsList4",goodsList4);


        //人气/疯狂抢购/热评/新品/限时抢购
        List<PageModule> reMaiList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+REMAI_SKU));
        List<PageModule> qiangGouList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+QIANGGOU_SKU));
        List<PageModule> rePinList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+REPIN_SKU));
        List<PageModule> newList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+NEW_SKU));
        List<PageModule> xsList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+XIANSHI_SKU));
        mav.addAttribute("reMai", reMaiList.get(0));
        mav.addAttribute("qiangGou", qiangGouList.get(0));
        mav.addAttribute("rePin", rePinList.get(0));
        mav.addAttribute("new", newList.get(0));
        mav.addAttribute("xianShi", xsList.get(0));

        return "/index";
    }
    /**
     * 首页页面
     * @param request
     * @return
     */
    @RequestMapping(value= "details" )
    public String details(HttpServletRequest request, ModelMap mav,String id) {
        //获取商品详情
        if (id == null) {
            id = "1";
        }
//        Goods goodss = (Goods)goodsService.getListByWhere(new StringBuffer(" and n.GOODS_ID='1'"));
        Goods goods = (Goods)goodsService.getObjById(id);
        mav.addAttribute("goods", goods);
        return "/details";
    }

}