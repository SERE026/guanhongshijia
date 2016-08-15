package cn.com.dyninfo.o2o.furniture.web.controller;

import cn.com.dyninfo.o2o.furniture.sys.Constants;
import cn.com.dyninfo.o2o.furniture.util.CityTool;
import cn.com.dyninfo.o2o.furniture.util.CookTool;
import cn.com.dyninfo.o2o.furniture.util.FreeMarkerUtils;
import cn.com.dyninfo.o2o.furniture.util.ValidationUtil;
import cn.com.dyninfo.o2o.furniture.web.active.model.Active;
import cn.com.dyninfo.o2o.furniture.web.active.service.GameActiveService;
import cn.com.dyninfo.o2o.furniture.web.address.model.AreaBase;
import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Brand;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.model.GoodsSort;
import cn.com.dyninfo.o2o.furniture.web.goods.service.BrandService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsSortService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.PageModuleService;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.CommentService;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import cn.com.dyninfo.o2o.furniture.web.page.model.Advwz;
import cn.com.dyninfo.o2o.furniture.web.page.model.Articles;
import cn.com.dyninfo.o2o.furniture.web.page.service.AdvwzService;
import cn.com.dyninfo.o2o.furniture.web.page.service.ArticlesService;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dyninfo on 2016/7/15.
 */
@Controller
public class WebIndexController{

    private static Logger log = Logger.getLogger(WebIndexController.class);

    @Resource
    private GoodsService goodsService;
    @Resource
    private GoodsSortService goodsSortService;

    @Resource
    private OrderService orderService;

    @Resource
    private BrandService brandService;

    @Resource
    private PageModuleService  pageModuleService;

    @Resource
    private GameActiveService activeService;

    @Resource
    private AdvwzService advwzService;

    @Resource
    private AreaService areaService;
    @Resource
    private ShangJiaService shangJiaService;

    @Resource
    private CommentService commentService;

    @Resource
    private ArticlesService articlesService;

    @RequestMapping(value = "/gen")
    public void gen() {
        log.debug("Generate.....");
        FreeMarkerUtils.genIndex();
        FreeMarkerUtils.genHeader();
        FreeMarkerUtils.genFooter();
    }
    /**
     * 首页页面
     * @param request
     * @return
     */
    @RequestMapping(value= "/index" )
    public String index(HttpServletRequest request, ModelMap mav,HttpServletResponse response) {
        //所有的分类  一级。二级,三级
        List<GoodsSort> dataList =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and  n.parent is null"));
        mav.addAttribute("goodsSortList",dataList);
//        System.out.println(dataList.get(0).getChildren().get(0).getAdvpic());


        //首页广告图
        List<Advwz>  advwzList=(List<Advwz>)advwzService.getListByWhere(new StringBuffer("and n.advwz_id="+ Constants.ACTIVE_ID));
        mav.addAttribute("advwzList",advwzList.get(0));
//        System.out.println(advwzList.get(0).getAdv().get(0).getAdv_name());
//        System.out.println(advwzList.get(0).getAdv().get(0).getAdv_flie());
//        System.out.println(advwzList.get(0).getAdv().get(2).getAdv_name());
//        System.out.println(advwzList.get(0).getAdv().get(0).getAdv_link());
        //1F楼商品
        List<GoodsSort> goodsSortList1 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.ONE_SKU));
        List<Goods> goodsList1 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.shelves=0 and n.goodsSort="+Constants.ONE_SKU));
        if (goodsSortList1 != null && goodsSortList1.size() > 0) {
            mav.addAttribute("goodsSortList1",goodsSortList1.get(0));
        }

        mav.addAttribute("goodsList1",goodsList1);

        //2F楼商品
        List<GoodsSort> goodsSortList2 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.TWO_SKU));
        List<Goods> goodsList2 =(List<Goods>)goodsService.getListByWhere(new StringBuffer("  and n.shelves=0 and n.goodsSort="+Constants.TWO_SKU));

        if (goodsSortList2 != null && goodsSortList2.size() > 0) {
            mav.addAttribute("goodsSortList2",goodsSortList2.get(0));
        }
        mav.addAttribute("goodsList2",goodsList2);
        //3F楼商品
        List<GoodsSort> goodsSortList3 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.THREE_SKU));
        List<Goods> goodsList3 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and n.goodsSort="+Constants.THREE_SKU));
        if (goodsSortList3 != null && goodsSortList3.size() > 0) {
            mav.addAttribute("goodsSortList3",goodsSortList3.get(0));
        }
        mav.addAttribute("goodsList3",goodsList3);
        //4F楼商品
        List<GoodsSort> goodsSortList4 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.FOUR_SKU));
        List<Goods> goodsList4 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and n.goodsSort="+Constants.FOUR_SKU));
        if (goodsSortList4 != null && goodsSortList4.size() > 0) {
            mav.addAttribute("goodsSortList4",goodsSortList4.get(0));
        }
        mav.addAttribute("goodsList4",goodsList4);


       //
        //热卖商品/疯狂抢购/热评商品/新品上架/限时抢购
        List<Goods> reMaiList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.REMAI_SKU+"')>0"));
        List<Goods> qiangGouList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.QIANGGOU_SKU+"')>0"));
        List<Goods> rePinList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.REPIN_SKU+"')>0"));
        List<Goods> newList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.NEW_SKU+"')>0"));
        List<Goods> xsList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.XIANSHI_SKU+"')>0"));
//        List<PageModule> reMaiList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.REMAI_SKU));
//        List<PageModule> qiangGouList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.QIANGGOU_SKU));
//        List<PageModule> rePinList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.REPIN_SKU));
//        List<PageModule> newList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.NEW_SKU));
//        List<PageModule> xsList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.XIANSHI_SKU));
        mav.addAttribute("reMai", reMaiList);
        mav.addAttribute("qiangGou", qiangGouList);
        mav.addAttribute("rePin", rePinList);
        mav.addAttribute("new", newList);
        mav.addAttribute("xianShi", xsList);
        //显示抢购商品
        List<Active> activeList =(List<Active>)activeService.getListByWhere(new StringBuffer("and n.active_id="+Constants.ACTIVE_SKU));
        mav.addAttribute("activeList",xsList);
        // mav.addAttribute("activeList",activeList);

        //5L综合系列
        //获取品牌表数据
        List<Brand> brandList=( List<Brand>)brandService.getListByWhere(new StringBuffer());
        mav.addAttribute("brandList", brandList);
        if (brandList!=null&&brandList.size()>5){
        mav.addAttribute("logo1", brandList.get(1).getLogo());
        mav.addAttribute("logo2", brandList.get(2).getLogo());
        mav.addAttribute("logo3", brandList.get(3).getLogo());
        mav.addAttribute("logo4", brandList.get(4).getLogo());
        }
        //获取一级分类
        List<GoodsSort> goodsSortList5 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.extendshow=0 and n.parent is null"));
        mav.addAttribute("goodsSortList5",goodsSortList5);
        //根据一级分类ID 获取商品list
        List<List<Goods>> lists=new ArrayList<List<Goods>>();
        for (int i = 0; i <8; i++) {
            int goodsSortId=goodsSortList5.get(i).getGoodsSort_id();
//            List<GoodsSort> goodsSortList6 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.parent=" + goodsSortId));

            List<Goods> goodsList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and n.goodsSort like '%"+goodsSortId+"%'"));
            lists.add(goodsList);
        }
        mav.addAttribute("lists",lists);
        Articles articles = (Articles) articlesService.getObjById("28");
        mav.addAttribute("article28", articles);
        return "/index";
    }
    //切换城市，获取城市ID与相关数据
    @RequestMapping(value= "/getCity" )
    @ResponseBody
    public AreaBase getCity(HttpServletRequest request, ModelMap mav, String id, HttpServletResponse response) {

        if(id.equals("ALL")){
            request.getSession().removeAttribute(Context.SESSION_AEAR);
            CookTool.addCookValue("city", "ALL", response);
            return null;
        }else{
            AreaInfo area=(AreaInfo) areaService.getObjById(id);
            CookTool.addCookValue("city", area.getId(), response);
            if(area!=null) {//&&area.getIsDefault().equals("1")
                Cookie ck = new Cookie(Context.COOKIE_AEAR_ID, area.getId());
                ck.setPath("/");
                ck.setMaxAge(365 * 24 * 60 * 60 * 1000);
                response.addCookie(ck);
                request.getSession().setAttribute(Context.SESSION_AEAR, area);
            }
            int num =shangJiaService.getCountByWhere(new StringBuffer(" and n.id="+area.getId()+"'"));
            AreaBase areaBase=new AreaBase();
            areaBase.setId(area.getId());
            areaBase.setName(area.getName());
            areaBase.setNum(num);
            return areaBase;
            }
    }

    //index 页，获取城市ID与相关数据,登录后用户昵称
    @RequestMapping(value= "/getCity2" )
    @ResponseBody
    public AreaBase getCity2(HttpServletRequest request, ModelMap mav,  HttpServletResponse response) {
        AreaInfo area=(AreaInfo) request.getSession().getAttribute(Context.SESSION_AEAR);
        AreaBase areaBase=new AreaBase();
        if(area==null){
            String city=CookTool.getCookIEValue("city", request);
            if(city==null||!city.equals("ALL")){
                if(city==null||city.equals("")){
                    String cityName=CityTool.getClientCityId(request);
//                    log.warn("IP is:cityName " + cityName);
                    if (!ValidationUtil.isEmpty(cityName)) {
                        List list = areaService.getListByWhere(new StringBuffer(" and n.name='" + cityName+"'"));//+"' and n.isDefault=1 "
                        if (list.size() > 0) {
//                        log.warn("IP is:list.size()>0 " + list.size());
                            area = (AreaInfo) list.get(0);
                            request.getSession().setAttribute(Context.SESSION_AEAR, list.get(0));
                        } else {
//                        log.warn("IP is:list.size()>0 else " + list.size());
                        }
                    }
                }
                else{
//                    log.warn("IP is:city==null else " + city);
                    area=(AreaInfo) areaService.getObjById(city);
                    request.getSession().setAttribute(Context.SESSION_AEAR, area);
                }
            }
        }
        if(area!=null) {
//            log.warn("IP is:area!=null" + area.getId());
            CookTool.addCookValue("city", area.getId(), response);
         //&&area.getIsDefault().equals("1")
                Cookie ck = new Cookie(Context.COOKIE_AEAR_ID, area.getId());
                ck.setPath("/");
                ck.setMaxAge(365 * 24 * 60 * 60 * 1000);
                response.addCookie(ck);
                request.getSession().setAttribute(Context.SESSION_AEAR, area);

            int num =shangJiaService.getCountByWhere(new StringBuffer(" and n.id="+area.getId()+"'"));

            areaBase.setId(area.getId());
            areaBase.setName(area.getName());
            areaBase.setNum(num);
        }
        if (request.getSession().getAttribute(Context.SESSION_MEMBER) != null) {
             HuiyuanInfo info=(HuiyuanInfo)request.getSession().getAttribute(Context.SESSION_MEMBER);
            areaBase.setUsername(info.getUserName());
        }
            return areaBase;
        }
}