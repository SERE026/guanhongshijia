package cn.com.dyninfo.o2o.furniture.util;

import cn.com.dyninfo.o2o.furniture.sys.Constants;
import cn.com.dyninfo.o2o.furniture.web.active.model.Active;
import cn.com.dyninfo.o2o.furniture.web.active.service.GameActiveService;
import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Brand;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.model.GoodsSort;
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
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
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
            List<GoodsSort> dataList =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and  n.parent is null"));
            paramsMap.put("goodsSortList",dataList);
            List<Advwz>  advwzList=(List<Advwz>)advwzService.getListByWhere(new StringBuffer("and n.advwz_id="+ Constants.ACTIVE_ID));
            if (advwzList != null && advwzList.size() > 0) {
                paramsMap.put("advwzList",advwzList.get(0));
            }
            //1F楼商品
            List<GoodsSort> goodsSortList1 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.ONE_SKU));
            List<Goods> goodsList1 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.shelves=0 and n.goodsSort like '%"+Constants.ONE_SKU +"%' order by n.indexs desc"));
            if (goodsSortList1 != null && goodsSortList1.size() > 0) {
                paramsMap.put("goodsSortList1",goodsSortList1.get(0));
            }
            paramsMap.put("goodsList1",goodsList1);
            //2F楼商品
            List<GoodsSort> goodsSortList2 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.TWO_SKU));
            List<Goods> goodsList2 =(List<Goods>)goodsService.getListByWhere(new StringBuffer("  and n.shelves=0 and n.goodsSort like '%"+Constants.TWO_SKU +"%' order by n.indexs desc"));
            if (goodsSortList2 != null && goodsSortList2.size() > 0) {
                paramsMap.put("goodsSortList2",goodsSortList2.get(0));
            }
            paramsMap.put("goodsList2",goodsList2);
            //3F楼商品
            List<GoodsSort> goodsSortList3 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.THREE_SKU));
            List<Goods> goodsList3 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and n.goodsSort like '%"+Constants.THREE_SKU +"%'order by n.indexs desc"));
            if (goodsSortList3 != null && goodsSortList3.size() > 0) {
                paramsMap.put("goodsSortList3",goodsSortList3.get(0));
            }
            paramsMap.put("goodsList3",goodsList3);
            //4F楼商品
            List<GoodsSort> goodsSortList4 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.FOUR_SKU));
            List<Goods> goodsList4 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and n.goodsSort like '%"+Constants.FOUR_SKU +"%' order by n.indexs desc"));
            if (goodsSortList4 != null && goodsSortList4.size() > 0) {
                paramsMap.put("goodsSortList4",goodsSortList4.get(0));
            }
            paramsMap.put("goodsList4",goodsList4);



            //热卖商品/疯狂抢购/热评商品/新品上架/限时抢购
            List<Goods> reMaiList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.REMAI_SKU+"')>0"));
            List<Goods> qiangGouList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.QIANGGOU_SKU+"')>0"));
            List<Goods> rePinList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.REPIN_SKU+"')>0"));
            List<Goods> newList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.NEW_SKU+"')>0"));
            List<Goods> xsList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.XIANSHI_SKU+"')>0"));
            if (reMaiList != null && reMaiList.size() > 0) {
                paramsMap.put("reMai", reMaiList);
            }
            if (qiangGouList != null && qiangGouList.size() > 0) {
                paramsMap.put("qiangGou", qiangGouList);
            }
            if (rePinList != null && rePinList.size() > 0) {
                paramsMap.put("rePin",  rePinList);
            }
            if (newList != null && newList.size() > 0) {
                paramsMap.put("new", newList);
            }
            if (xsList != null && xsList.size() > 0) {
                paramsMap.put("xianShi",  xsList);
            }
            //显示抢购商品
            List<Active> activeList =(List<Active>) gameActiveService.getListByWhere(new StringBuffer("and n.active_id="+Constants.ACTIVE_SKU));

            if (xsList != null && xsList.size() > 0) {
                paramsMap.put("activeList",xsList);
            }
            //5L综合系列
            //获取品牌表数据
            List<Brand> brandList=( List<Brand>)brandService.getListByWhere(new StringBuffer());
            if (brandList != null && brandList.size() > 0) {
                paramsMap.put("brandList", brandList);
                if (brandList.size()>5){
                    paramsMap.put("logo1", brandList.get(1).getLogo());
                    paramsMap.put("logo2", brandList.get(2).getLogo());
                    paramsMap.put("logo3", brandList.get(3).getLogo());
                    paramsMap.put("logo4", brandList.get(4).getLogo());
                }
            }
            //获取一级分类
            List<GoodsSort> goodsSortList5 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.extendshow=0 and n.parent is null"));
            paramsMap.put("goodsSortList5",goodsSortList5);
            //根据一级分类ID 获取商品list
            List<List<Goods>> lists=new ArrayList<List<Goods>>();
            for (int i = 0; i <8; i++) {
                int goodsSortId=goodsSortList5.get(i).getGoodsSort_id();
                List<Goods> goodsList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and n.goodsSort like '%"+goodsSortId+"%' order by n.indexs desc"));
//                List<GoodsSort> goodsSortList6 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.parent=" + goodsSortId));
//                List<Goods> goodsList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and n.goodsSort=" + goodsSortList6.get(0).getGoodsSort_id()));
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
            List<GoodsSort> dataList =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and  n.parent is null"));
            paramsMap.put("goodsSortList",dataList);
            List<Advwz>  advwzList=(List<Advwz>)advwzService.getListByWhere(new StringBuffer("and n.advwz_id="+ Constants.ACTIVE_ID));
            paramsMap.put("advwzList",advwzList.get(0));
            //1F楼商品
            List<GoodsSort> goodsSortList1 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.ONE_SKU));
            List<Goods> goodsList1 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.shelves=0 and n.goodsSort like '%"+Constants.ONE_SKU +"%' order by n.indexs desc"));
            paramsMap.put("goodsSortList1",goodsSortList1.get(0));
            paramsMap.put("goodsList1",goodsList1);
            //2F楼商品
            List<GoodsSort> goodsSortList2 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.TWO_SKU));
            List<Goods> goodsList2 =(List<Goods>)goodsService.getListByWhere(new StringBuffer("  and n.shelves=0 and n.goodsSort like '%"+Constants.TWO_SKU +"%' order by n.indexs desc"));
            paramsMap.put("goodsSortList2",goodsSortList2.get(0));
            paramsMap.put("goodsList2",goodsList2);
            //3F楼商品
            List<GoodsSort> goodsSortList3 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.THREE_SKU));
            List<Goods> goodsList3 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and n.goodsSort like '%"+Constants.THREE_SKU +"%'order by n.indexs desc"));
            paramsMap.put("goodsSortList3",goodsSortList3.get(0));
            paramsMap.put("goodsList3",goodsList3);
            //4F楼商品
            List<GoodsSort> goodsSortList4 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.FOUR_SKU));
            List<Goods> goodsList4 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and n.goodsSort like '%"+Constants.FOUR_SKU +"%' order by n.indexs desc"));
            paramsMap.put("goodsSortList4",goodsSortList4.get(0));
            paramsMap.put("goodsList4",goodsList4);



            //热卖商品/疯狂抢购/热评商品/新品上架/限时抢购
            List<Goods> reMaiList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.REMAI_SKU+"')>0"));
            List<Goods> qiangGouList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.QIANGGOU_SKU+"')>0"));
            List<Goods> rePinList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.REPIN_SKU+"')>0"));
            List<Goods> newList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.NEW_SKU+"')>0"));
            List<Goods> xsList = (List<Goods>) goodsService.getListByWhere(new StringBuffer("  and n.shelves=0 and instr(n.biaoqian,'"+Constants.XIANSHI_SKU+"')>0"));
            paramsMap.put("reMai", reMaiList);
            paramsMap.put("qiangGou", qiangGouList);
            paramsMap.put("rePin", rePinList);
            paramsMap.put("new", newList);
            paramsMap.put("xianShi", xsList);
            //显示抢购商品
            List<Active> activeList =(List<Active>) gameActiveService.getListByWhere(new StringBuffer("and n.active_id="+Constants.ACTIVE_SKU));
            paramsMap.put("activeList",xsList);
            // mav.addAttribute("activeList",activeList);
            //5L综合系列
            //获取品牌表数据
            List<Brand> brandList=( List<Brand>)brandService.getListByWhere(new StringBuffer());
            paramsMap.put("brandList", brandList);
            if (brandList.size()>5){
                paramsMap.put("logo1", brandList.get(1).getLogo());
                paramsMap.put("logo2", brandList.get(2).getLogo());
                paramsMap.put("logo3", brandList.get(3).getLogo());
                paramsMap.put("logo4", brandList.get(4).getLogo());
            }
            //获取一级分类
            List<GoodsSort> goodsSortList5 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.extendshow=0 and n.parent is null"));
            paramsMap.put("goodsSortList5",goodsSortList5);
            //根据一级分类ID 获取商品list
            List<List<Goods>> lists=new ArrayList<List<Goods>>();
            for (int i = 0; i <8; i++) {
                int goodsSortId=goodsSortList5.get(i).getGoodsSort_id();
                List<Goods> goodsList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and n.goodsSort like '%"+goodsSortId+"%' order by n.indexs desc"));
//                List<GoodsSort> goodsSortList6 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.parent=" + goodsSortId));
//                List<Goods> goodsList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.goodsSort=" + goodsSortList6.get(0).getGoodsSort_id()));
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
            List<GoodsSort> dataList =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and  n.parent is null"));
            paramsMap.put("goodsSortList",dataList);
            List<Advwz>  advwzList=(List<Advwz>)advwzService.getListByWhere(new StringBuffer("and n.advwz_id="+ Constants.ACTIVE_ID));
            paramsMap.put("advwzList",advwzList.get(0));
            //1F楼商品
            List<GoodsSort> goodsSortList1 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.ONE_SKU));
            List<Goods> goodsList1 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.shelves=0 and n.goodsSort like '%"+Constants.ONE_SKU +"%' order by n.indexs desc"));
            paramsMap.put("goodsSortList1",goodsSortList1.get(0));
            paramsMap.put("goodsList1",goodsList1);
            //2F楼商品
            List<GoodsSort> goodsSortList2 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.TWO_SKU));
            List<Goods> goodsList2 =(List<Goods>)goodsService.getListByWhere(new StringBuffer("  and n.shelves=0 and n.goodsSort like '%"+Constants.TWO_SKU +"%' order by n.indexs desc"));
            paramsMap.put("goodsSortList2",goodsSortList2.get(0));
            paramsMap.put("goodsList2",goodsList2);
            //3F楼商品
            List<GoodsSort> goodsSortList3 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.THREE_SKU));
            List<Goods> goodsList3 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and n.goodsSort like '%"+Constants.THREE_SKU +"%'order by n.indexs desc"));
            paramsMap.put("goodsSortList3",goodsSortList3.get(0));
            paramsMap.put("goodsList3",goodsList3);
            //4F楼商品
            List<GoodsSort> goodsSortList4 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+Constants.FOUR_SKU));
            List<Goods> goodsList4 =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and n.goodsSort like '%"+Constants.FOUR_SKU +"%' order by n.indexs desc"));
            paramsMap.put("goodsSortList4",goodsSortList4.get(0));
            paramsMap.put("goodsList4",goodsList4);

            //
            //热卖商品/疯狂抢购/热评商品/新品上架/限时抢购
            List<Goods> reMaiList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.REMAI_SKU+"')>0"));
            List<Goods> qiangGouList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.QIANGGOU_SKU+"')>0"));
            List<Goods> rePinList = (List<Goods>) goodsService.getListByWhere(new StringBuffer("  and n.shelves=0 and instr(n.biaoqian,'"+Constants.REPIN_SKU+"')>0"));
            List<Goods> newList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.NEW_SKU+"')>0"));
            List<Goods> xsList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.XIANSHI_SKU+"')>0"));

            paramsMap.put("reMai", reMaiList);
            paramsMap.put("qiangGou", qiangGouList);
            paramsMap.put("rePin", rePinList);
            paramsMap.put("new", newList);
            paramsMap.put("xianShi", xsList);
            //显示抢购商品
            List<Active> activeList =(List<Active>)gameActiveService.getListByWhere(new StringBuffer("and n.active_id="+Constants.ACTIVE_SKU));
            paramsMap.put("activeList",xsList);
            // mav.addAttribute("activeList",activeList);

            //5L综合系列
            //获取品牌表数据
            List<Brand> brandList=( List<Brand>)brandService.getListByWhere(new StringBuffer());
            paramsMap.put("brandList", brandList);
            if (brandList.size()>5){
                paramsMap.put("logo1", brandList.get(1).getLogo());
                paramsMap.put("logo2", brandList.get(2).getLogo());
                paramsMap.put("logo3", brandList.get(3).getLogo());
                paramsMap.put("logo4", brandList.get(4).getLogo());
            }
            //获取一级分类
            List<GoodsSort> goodsSortList5 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.extendshow=0 and n.parent is null"));
            paramsMap.put("goodsSortList5",goodsSortList5);
            //根据一级分类ID 获取商品list
            List<List<Goods>> lists=new ArrayList<List<Goods>>();
            for (int i = 0; i <8; i++) {
                int goodsSortId=goodsSortList5.get(i).getGoodsSort_id();
                List<Goods> goodsList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and n.goodsSort like '%"+goodsSortId+"%' order by n.indexs desc"));
//                List<GoodsSort> goodsSortList6 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.parent=" + goodsSortId));
//                List<Goods> goodsList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and n.goodsSort=" + goodsSortList6.get(0).getGoodsSort_id()));
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
