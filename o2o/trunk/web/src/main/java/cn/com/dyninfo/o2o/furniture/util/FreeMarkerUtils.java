package cn.com.dyninfo.o2o.furniture.util;

import cn.com.dyninfo.o2o.furniture.sys.Constants;
import cn.com.dyninfo.o2o.furniture.web.active.model.Active;
import cn.com.dyninfo.o2o.furniture.web.active.service.GameActiveService;
import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Brand;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.model.GoodsSort;
import cn.com.dyninfo.o2o.furniture.web.goods.model.PageModule;
import cn.com.dyninfo.o2o.furniture.web.goods.service.BrandService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsSortService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.PageModuleService;
import cn.com.dyninfo.o2o.furniture.web.page.model.Advwz;
import cn.com.dyninfo.o2o.furniture.web.page.model.Articles;
import cn.com.dyninfo.o2o.furniture.web.page.service.AdvwzService;
import cn.com.dyninfo.o2o.furniture.web.page.service.ArticlesService;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/26.
 */
public class FreeMarkerUtils {

    private static Logger log = Logger.getLogger(FreeMarkerUtils.class);

    private static GoodsService goodsService;
    private static GoodsSortService goodsSortService;
    private static BrandService brandService;
    private static PageModuleService pageModuleService;
    private static GameActiveService gameActiveService;
    private static AdvwzService advwzService;
    private static AreaService areaService;
    private static ShangJiaService shangJiaService;
    private static ArticlesService articlesService;


    private static FreeMarkerConfigurer freemarkerConfig;

    public GoodsSortService getGoodsSortService() {
        return goodsSortService;
    }

    public void setGoodsSortService(GoodsSortService goodsSortService) {
        FreeMarkerUtils.goodsSortService = goodsSortService;
    }

    public BrandService getBrandService() {
        return brandService;
    }

    public void setBrandService(BrandService brandService) {
        FreeMarkerUtils.brandService = brandService;
    }

    public PageModuleService getPageModuleService() {
        return pageModuleService;
    }

    public void setPageModuleService(PageModuleService pageModuleService) {
        FreeMarkerUtils.pageModuleService = pageModuleService;
    }

    public GameActiveService getGameActiveService() {
        return gameActiveService;
    }

    public void setGameActiveService(GameActiveService gameActiveService) {
        FreeMarkerUtils.gameActiveService = gameActiveService;
    }

    public AdvwzService getAdvwzService() {
        return advwzService;
    }

    public void setAdvwzService(AdvwzService advwzService) {
        FreeMarkerUtils.advwzService = advwzService;
    }

    public AreaService getAreaService() {
        return areaService;
    }

    public void setAreaService(AreaService areaService) {
        FreeMarkerUtils.areaService = areaService;
    }

    public ShangJiaService getShangJiaService() {
        return shangJiaService;
    }

    public void setShangJiaService(ShangJiaService shangJiaService) {
        FreeMarkerUtils.shangJiaService = shangJiaService;
    }

    public GoodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(GoodsService goodsService) {
        FreeMarkerUtils.goodsService = goodsService;
    }

    public static void genIndex() {
        try {
            Configuration configuration = freemarkerConfig.getConfiguration();
            Template template = configuration.getTemplate(Constants.TEMPLATE_INDEX);
            String fileName = SystemConfig.getInfo("static.index.file");
            File file = new File(fileName);
            Writer out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            Map<String, Object> paramsMap = new HashMap<String, Object>();
            List<GoodsSort> dataList =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer());
            paramsMap.put("goodsSortList",dataList);
            List<Advwz>  advwzList=(List<Advwz>)advwzService.getListByWhere(new StringBuffer("and n.advwz_id="+ Constants.ACTIVE_ID));
            paramsMap.put("advwzList",advwzList.get(0));
            //1F楼商品
            List<GoodsSort> goodsSortList1 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.ONE_SKU));
            List<Goods> goodsList1 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+Constants.ONE_SKU));
            paramsMap.put("goodsSortList1",goodsSortList1.get(0));
            paramsMap.put("goodsList1",goodsList1);
            //2F楼商品
            List<GoodsSort> goodsSortList2 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.TWO_SKU));
            List<Goods> goodsList2 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+Constants.TWO_SKU));
            paramsMap.put("goodsSortList2",goodsSortList2.get(0));
            paramsMap.put("goodsList2",goodsList2);
            //3F楼商品
            List<GoodsSort> goodsSortList3 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.THREE_SKU));
            List<Goods> goodsList3 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+Constants.THREE_SKU));
            paramsMap.put("goodsSortList3",goodsSortList3.get(0));
            paramsMap.put("goodsList3",goodsList3);
            //4F楼商品
            List<GoodsSort> goodsSortList4 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.FOUR_SKU));
            List<Goods> goodsList4 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+Constants.FOUR_SKU));
            paramsMap.put("goodsSortList4",goodsSortList4.get(0));
            paramsMap.put("goodsList4",goodsList4);

            //显示抢购商品
            List<Active> activeList =(List<Active>) gameActiveService.getListByWhere(new StringBuffer("and n.active_id="+Constants.ACTIVE_SKU));
            paramsMap.put("activeList",goodsList4);
            // mav.addAttribute("activeList",activeList);

            //热卖商品/疯狂抢购/热评商品/新品上架/限时抢购
            List<PageModule> reMaiList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.REMAI_SKU));
            List<PageModule> qiangGouList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.QIANGGOU_SKU));
            List<PageModule> rePinList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.REPIN_SKU));
            List<PageModule> newList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.NEW_SKU));
            List<PageModule> xsList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.XIANSHI_SKU));
            paramsMap.put("reMai", reMaiList.get(0));
            paramsMap.put("qiangGou", qiangGouList.get(0));
            paramsMap.put("rePin", rePinList.get(0));
            paramsMap.put("new", newList.get(0));
            paramsMap.put("xianShi", xsList.get(0));

            //5L综合系列
            //获取品牌表数据
            List<Brand> brandList=( List<Brand>)brandService.getListByWhere(new StringBuffer());
            paramsMap.put("brandList", brandList);
            //获取一级分类
            List<GoodsSort> goodsSortList5 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.extendshow=0 and n.parent is null"));
            paramsMap.put("goodsSortList5",goodsSortList5);
            //根据一级分类ID 获取商品list
            List<List<Goods>> lists=new ArrayList<List<Goods>>();
            for (int i = 0; i <8; i++) {
                int goodsSortId=1000101;
                //goodsSortList5.get(i).getGoodsSort_id();
                List<Goods> goodsList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.goodsSort=" + goodsSortId));
                lists.add(goodsList);

            }
            paramsMap.put("lists",lists);
            Articles articles = (Articles) articlesService.getObjById("28");
            paramsMap.put("article28", articles);
            Map<String, String> rcMap = new HashMap<String, String>();
            rcMap.put("contextPath", Constants.DOMAIN_NAME);
            paramsMap.put("rc", rcMap);
            template.process(paramsMap, out);
            IOUtils.closeQuietly(out);
            FileUtil.setPermission(fileName);
        } catch (Exception e) {
            log.error("Generate Index Error", e);
        }
    }

    public static void genHeader() {
        try {
            Configuration configuration = freemarkerConfig.getConfiguration();
            Template template = configuration.getTemplate(Constants.TEMPLATE_HEADER);
            String fileName = Context.webPath + Context.tempPath + "/static/header.html";
            File file = new File(fileName);
            Writer out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            Map<String, Object> paramsMap = new HashMap<String, Object>();
            List<GoodsSort> dataList =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer());
            paramsMap.put("goodsSortList",dataList);
            List<Advwz>  advwzList=(List<Advwz>)advwzService.getListByWhere(new StringBuffer("and n.advwz_id="+ Constants.ACTIVE_ID));
            paramsMap.put("advwzList",advwzList.get(0));
            //1F楼商品
            List<GoodsSort> goodsSortList1 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.ONE_SKU));
            List<Goods> goodsList1 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+Constants.ONE_SKU));
            paramsMap.put("goodsSortList1",goodsSortList1.get(0));
            paramsMap.put("goodsList1",goodsList1);
            //2F楼商品
            List<GoodsSort> goodsSortList2 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.TWO_SKU));
            List<Goods> goodsList2 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+Constants.TWO_SKU));
            paramsMap.put("goodsSortList2",goodsSortList2.get(0));
            paramsMap.put("goodsList2",goodsList2);
            //3F楼商品
            List<GoodsSort> goodsSortList3 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.THREE_SKU));
            List<Goods> goodsList3 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+Constants.THREE_SKU));
            paramsMap.put("goodsSortList3",goodsSortList3.get(0));
            paramsMap.put("goodsList3",goodsList3);
            //4F楼商品
            List<GoodsSort> goodsSortList4 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.FOUR_SKU));
            List<Goods> goodsList4 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+Constants.FOUR_SKU));
            paramsMap.put("goodsSortList4",goodsSortList4.get(0));
            paramsMap.put("goodsList4",goodsList4);

            //显示抢购商品
            List<Active> activeList =(List<Active>) gameActiveService.getListByWhere(new StringBuffer("and n.active_id="+Constants.ACTIVE_SKU));
            paramsMap.put("activeList",goodsList4);
            // mav.addAttribute("activeList",activeList);

            //热卖商品/疯狂抢购/热评商品/新品上架/限时抢购
            List<PageModule> reMaiList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.REMAI_SKU));
            List<PageModule> qiangGouList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.QIANGGOU_SKU));
            List<PageModule> rePinList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.REPIN_SKU));
            List<PageModule> newList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.NEW_SKU));
            List<PageModule> xsList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.XIANSHI_SKU));
            paramsMap.put("reMai", reMaiList.get(0));
            paramsMap.put("qiangGou", qiangGouList.get(0));
            paramsMap.put("rePin", rePinList.get(0));
            paramsMap.put("new", newList.get(0));
            paramsMap.put("xianShi", xsList.get(0));

            //5L综合系列
            //获取品牌表数据
            List<Brand> brandList=( List<Brand>)brandService.getListByWhere(new StringBuffer());
            paramsMap.put("brandList", brandList);
            //获取一级分类
            List<GoodsSort> goodsSortList5 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.extendshow=0 and n.parent is null"));
            paramsMap.put("goodsSortList5",goodsSortList5);
            //根据一级分类ID 获取商品list
            List<List<Goods>> lists=new ArrayList<List<Goods>>();
            for (int i = 0; i <8; i++) {
                int goodsSortId=1000101;
                //goodsSortList5.get(i).getGoodsSort_id();
                List<Goods> goodsList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.goodsSort=" + goodsSortId));
                lists.add(goodsList);

            }
            paramsMap.put("lists",lists);
            paramsMap.put("contextPath", Constants.DOMAIN_NAME);
            template.process(paramsMap, out);
            IOUtils.closeQuietly(out);
//            FileUtil.setPermission(fileName);
        } catch (Exception e) {
            log.error("Generate Header Error", e);
        }
    }

    public static void genFooter() {
        try {
            Configuration configuration = freemarkerConfig.getConfiguration();
            Template template = configuration.getTemplate(Constants.TEMPLATE_FOOTER);
            File file = new File(Context.webPath + Context.tempPath + "/static/footer.html");
            Writer out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            Map<String, Object> paramsMap = new HashMap<String, Object>();
            List<GoodsSort> dataList =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer());
            paramsMap.put("goodsSortList",dataList);
            List<Advwz>  advwzList=(List<Advwz>)advwzService.getListByWhere(new StringBuffer("and n.advwz_id="+ Constants.ACTIVE_ID));
            paramsMap.put("advwzList",advwzList.get(0));
            //1F楼商品
            List<GoodsSort> goodsSortList1 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.ONE_SKU));
            List<Goods> goodsList1 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+Constants.ONE_SKU));
            paramsMap.put("goodsSortList1",goodsSortList1.get(0));
            paramsMap.put("goodsList1",goodsList1);
            //2F楼商品
            List<GoodsSort> goodsSortList2 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.TWO_SKU));
            List<Goods> goodsList2 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+Constants.TWO_SKU));
            paramsMap.put("goodsSortList2",goodsSortList2.get(0));
            paramsMap.put("goodsList2",goodsList2);
            //3F楼商品
            List<GoodsSort> goodsSortList3 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.THREE_SKU));
            List<Goods> goodsList3 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+Constants.THREE_SKU));
            paramsMap.put("goodsSortList3",goodsSortList3.get(0));
            paramsMap.put("goodsList3",goodsList3);
            //4F楼商品
            List<GoodsSort> goodsSortList4 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.FOUR_SKU));
            List<Goods> goodsList4 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+Constants.FOUR_SKU));
            paramsMap.put("goodsSortList4",goodsSortList4.get(0));
            paramsMap.put("goodsList4",goodsList4);

            //显示抢购商品
            List<Active> activeList =(List<Active>) gameActiveService.getListByWhere(new StringBuffer("and n.active_id="+Constants.ACTIVE_SKU));
            paramsMap.put("activeList",goodsList4);
            // mav.addAttribute("activeList",activeList);

            //热卖商品/疯狂抢购/热评商品/新品上架/限时抢购
            List<PageModule> reMaiList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.REMAI_SKU));
            List<PageModule> qiangGouList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.QIANGGOU_SKU));
            List<PageModule> rePinList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.REPIN_SKU));
            List<PageModule> newList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.NEW_SKU));
            List<PageModule> xsList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id="+Constants.XIANSHI_SKU));
            paramsMap.put("reMai", reMaiList.get(0));
            paramsMap.put("qiangGou", qiangGouList.get(0));
            paramsMap.put("rePin", rePinList.get(0));
            paramsMap.put("new", newList.get(0));
            paramsMap.put("xianShi", xsList.get(0));

            //5L综合系列
            //获取品牌表数据
            List<Brand> brandList=( List<Brand>)brandService.getListByWhere(new StringBuffer());
            paramsMap.put("brandList", brandList);
            //获取一级分类
            List<GoodsSort> goodsSortList5 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.extendshow=0 and n.parent is null"));
            paramsMap.put("goodsSortList5",goodsSortList5);
            //根据一级分类ID 获取商品list
            List<List<Goods>> lists=new ArrayList<List<Goods>>();
            for (int i = 0; i <8; i++) {
                int goodsSortId=1000101;
                //goodsSortList5.get(i).getGoodsSort_id();
                List<Goods> goodsList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.goodsSort=" + goodsSortId));
                lists.add(goodsList);

            }
            paramsMap.put("lists",lists);
            paramsMap.put("contextPath", Constants.DOMAIN_NAME);
            template.process(paramsMap, out);
            IOUtils.closeQuietly(out);
        } catch (Exception e) {
            log.error("Generate Footer Error", e);
        }
    }

    public void setFreemarkerConfig(FreeMarkerConfigurer freemarkerConfig) {
        this.freemarkerConfig = freemarkerConfig;
    }

    public FreeMarkerConfigurer getFreemarkerConfig() {
        return freemarkerConfig;
    }

    public ArticlesService getArticlesService() {
        return articlesService;
    }

    public void setArticlesService(ArticlesService articlesService) {
        FreeMarkerUtils.articlesService = articlesService;
    }
}
