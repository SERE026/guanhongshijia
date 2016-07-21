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
import java.util.HashMap;
import java.util.List;

/**
 * Created by dyninfo on 2016/7/15.
 */
@Controller
@RequestMapping("/")
public class WebIndexController{
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
        StringBuffer where=new StringBuffer();
        PageInfo page = new PageInfo();
        page.setPageSize(6);
        page.setPageNo(1);
        // where.append(" order by indexs");
        HashMap<String, ?> data = goodsService.getListByPageWhere(where, page);
        // 保存商品标签名字，便于页面加载
        List<Goods> goodsList = (List<Goods>)data.get("DATA");
        mav.addAttribute("goodsList", goodsList);

        StringBuffer where1=new StringBuffer();

        List<GoodsSort> goodsSortList =(List<GoodsSort>)goodsSortService.getListByWhere(where1);
        mav.addAttribute("goodsSortList", goodsSortList);

        StringBuffer where2=new StringBuffer();
        where2.append(" and n.pageModule_id="+27);
        List<PageModule> pageModuleList =(List<PageModule>)pageModuleService.getListByWhere(where2);
        mav.addAttribute("pageModuleList", pageModuleList);


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