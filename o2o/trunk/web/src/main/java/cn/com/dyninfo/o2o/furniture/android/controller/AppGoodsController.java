
package cn.com.dyninfo.o2o.furniture.android.controller;

import cn.com.dyninfo.o2o.communication.*;
import cn.com.dyninfo.o2o.entity.GoodsDetail;
import cn.com.dyninfo.o2o.entity.GoodsSummary;
import cn.com.dyninfo.o2o.entity.Recommend;
import cn.com.dyninfo.o2o.furniture.common.BaseAppController;
import cn.com.dyninfo.o2o.furniture.sys.Constants;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ValidationUtil;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Brand;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.BrandService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsSortService;
import cn.com.dyninfo.o2o.furniture.web.member.model.AppLoginStatus;
import cn.com.dyninfo.o2o.furniture.web.member.model.Favorites;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.AppLoginStatusService;
import cn.com.dyninfo.o2o.furniture.web.member.service.FavoritesService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.page.model.Advwz;
import cn.com.dyninfo.o2o.furniture.web.page.service.AdvwzService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2016/7/29.
 */

@Controller
@RequestMapping("/goods")
public class AppGoodsController extends BaseAppController {

    @Resource
    private HuiyuanService huiyuanService;

    @Resource
    private GoodsService goodsService;

    @Resource
    FavoritesService favoritesService;

    @Resource
    private GoodsSortService goodsSortService;

    @Resource
    private BrandService brandService;


    @Resource
    private AdvwzService advwzService;

    @Resource
    private AppLoginStatusService appLoginStatusService;


/**
     * 根据商品分类查询商品列表
     * @param categoryGoodsListRequest
     * @param request
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping("/listByCategory")
    public CategoryGoodsListResult listByCategory(@RequestBody CategoryGoodsListRequest categoryGoodsListRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(categoryGoodsListRequest);
        CategoryGoodsListResult result = new CategoryGoodsListResult();
        if (StringUtils.isBlank(categoryGoodsListRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
        List<GoodsSummary>  goodsLists=new ArrayList<GoodsSummary>();
        List<cn.com.dyninfo.o2o.entity.Brand> brandLists=new ArrayList<cn.com.dyninfo.o2o.entity.Brand>();

        //获取商品
        List<Goods> goodsList =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+categoryGoodsListRequest.getCategoryId()));
        //获取品牌
        List<Brand> brandList=( List<Brand>)brandService.getListByWhere(new StringBuffer());

        if(goodsList.size()>0&&brandList.size()>0) {
            for (int i = 0; i < goodsList.size(); i++) {
                GoodsSummary goodsSummary = new GoodsSummary();
                if(String.valueOf(goodsList.get(i).getGoods_id())!=null){
                    goodsSummary.setId(String.valueOf(goodsList.get(i).getGoods_id()));
                }
                if(goodsList.get(i).getName()!=null){
                    goodsSummary.setTitle(goodsList.get(i).getName());
                }
                if(goodsList.get(i).getImg()!=null){
                    goodsSummary.setMainPicUrl(goodsList.get(i).getImg());
                }
                goodsSummary.setPrice(goodsList.get(i).getSalesMoney());
                goodsLists.add(goodsSummary);
            }
            for (int i = 0; i < brandList.size(); i++) {
                cn.com.dyninfo.o2o.entity.Brand brand = new cn.com.dyninfo.o2o.entity.Brand();
                if(String.valueOf(brandList.get(i).getBrand_id())!=null){
                    brand.setId(String.valueOf(brandList.get(i).getBrand_id()));
                }
                if(brandList.get(i).getName()!=null){
                    brand.setTitle(brandList.get(i).getName());
                }
                brandLists.add(brand);
            }
        }
        result.setBrandList(brandLists);
        result.setGoodsSummaryList(goodsLists);
        result.setResultCode(SUCCESS);
        result.setMessage("OK");
        result.setPageNo(1);
        result.setTotalPage(2);
        log.debug(result);
        return result;
    }


/**
     * 获取商品详情
     * @param goodsDetailRequest
     * @param request
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping("/detail")
    public GoodsDetailResult detail(@RequestBody GoodsDetailRequest goodsDetailRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(goodsDetailRequest);
        GoodsDetailResult result = new GoodsDetailResult();
//        if (StringUtils.isBlank(goodsDetailRequest.getDeviceId())) {
//            result.setResultCode(NEED_DEVICE_ID);
//            result.setMessage("设备识别码不能为空");
//            return result;
//        }
       // List<GoodsSpec> specList=new ArrayList<GoodsSpec>();
        //获取用户信息
        AppLoginStatus appLoginStatus=null;
        HuiyuanInfo info=(HuiyuanInfo)request.getSession().getAttribute(Context.SESSION_MEMBER);
        if (ValidationUtil.isEmpty(info)&&!ValidationUtil.isEmpty(goodsDetailRequest.getToken())){
            List<AppLoginStatus> appLoginStatusList =(List<AppLoginStatus>)appLoginStatusService.getListByWhere(new StringBuffer(" and  n.token='"+ goodsDetailRequest.getToken()+"'"));
            if(!ValidationUtil.isEmpty(appLoginStatusList)){
                appLoginStatus=appLoginStatusList.get(0);
            }
        }
        if (!ValidationUtil.isEmpty(appLoginStatus)) {
            info = appLoginStatus.getHuiyuan();
        }

        List<String> imageList=new ArrayList<String>();
        GoodsDetail detail=new GoodsDetail();
        List list=goodsService.getListByWhere(new StringBuffer(" and n.goods_id="+goodsDetailRequest.getId()));
        if(!ValidationUtil.isEmpty(list)){
               Goods goods=(Goods)list.get(0);
            if (!ValidationUtil.isEmpty(info)){
               List<Favorites> favorites=(List<Favorites>) favoritesService.getListByWhere(new StringBuffer( " and n.member="+info.getHuiYuan_id()+" and n.good="+goods.getGoods_id()));
                if(ValidationUtil.isEmpty(favorites)){
                    detail.setCollection("收藏");
                }else {
                    detail.setCollection("已收藏");
                }
            }else {
                detail.setCollection("收藏");
            }
            if(goods.getName()!=null){
                detail.setName(goods.getName());
            }
            if(String.valueOf(goods.getGoods_id())!=null){
                detail.setId(String.valueOf(goods.getGoods_id()));
            }
            if(goods.getShortDesc()!=null){
                detail.setShortDesc(goods.getShortDesc());
            }
                detail.setSaleCount(goods.getNum());
                detail.setPrice(goods.getSalesMoney());
            if(goods.getGoodsDescription()!=null){
                detail.setGoodsDesc(goods.getGoodsDescription());
            }
            //类型 颜色 规格
//            if(goods.getGoodsType().getName()!=null){
//                detail.setType(goods.getGoodsType().getName());
//            }
            //商品多张图片
            if(!ValidationUtil.isEmpty(goods.getImages())) {
                String[] arr = goods.getImages().split(";");
                if (arr.length > 0 && !ValidationUtil.isEmpty(goods.getImages())) {
                    for (int i = 0; i < arr.length; i++) {
                        imageList.add(Constants.DOMAIN_NAME + Constants.GOODS_IMG + arr[i]);
                    }
                }
            }
                detail.setImageList(imageList);
            }
            result.setDetail(detail);
        log.debug(result);
        return result;
    }




/**
     * 获取轮播商品
     * @param loopGoodsListRequest
     * @param request
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping("/loop")
    public LoopGoodsListResult loop(@RequestBody LoopGoodsListRequest loopGoodsListRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(loopGoodsListRequest);
        LoopGoodsListResult result = new LoopGoodsListResult();
        if (StringUtils.isBlank(loopGoodsListRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
        PageInfo page=new PageInfo();
        page.setPageNo(1);
        page.setPageSize(10);
        List<String> imageList=new ArrayList<String>();
        List<GoodsDetail> detailList=new ArrayList<GoodsDetail> ();
//        List<Goods> list =(List<Goods>)goodsService.getListByPageWhere(new StringBuffer(" and n.goodsSort="+Constants.FOUR_SKU),page);
        Map map=goodsService.getListByPageWhere(new StringBuffer(""),page);
        if(!ValidationUtil.isEmpty(map)) {
            List<Goods> list = (List<Goods>) map.get("DATA");
            if (!ValidationUtil.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    Goods goods = list.get(i);
                    GoodsDetail detail = new GoodsDetail();
                    if(goods.getName()!=null){
                        detail.setName(goods.getName());
                    }
                    if(String.valueOf(goods.getGoods_id())!=null){
                        detail.setId(String.valueOf(goods.getGoods_id()));
                    }
                    if(goods.getShortDesc()!=null){
                        detail.setShortDesc(goods.getShortDesc());
                    }
                    detail.setSaleCount(goods.getNum());
                    detail.setPrice(goods.getSalesMoney());
                    if(goods.getGoodsDescription()!=null){
                        detail.setGoodsDesc(goods.getGoodsDescription());
                    }
//                    String[] arr=goods.getImages().split(";");
//                    if (arr.length>0 && !ValidationUtil.isEmpty(goods.getImages())){
//                    }
                    if(goods.getDefaultImage()!=null){
                        imageList.add(Constants.DOMAIN_NAME+Constants.GOODS_IMG+goods.getDefaultImage());
                    }
                    detail.setImageList(imageList);
                    detailList.add(detail);
                }
            }
        }
        result.setGoodsDetailList(detailList);
        result.setResultCode(SUCCESS);
        result.setMessage("OK");
        log.debug(result);
        return result;
    }



/**
     * 获取新品推荐列表
     * @param recommendGoodsRequest
     * @param request
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping("/newRecommend")
    public RecommendNewGoodsResult newRecommend(@RequestBody RecommendGoodsRequest  recommendGoodsRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(recommendGoodsRequest);
        RecommendNewGoodsResult result = new RecommendNewGoodsResult();
        if (StringUtils.isBlank(recommendGoodsRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
        //新品推荐列表
        List<Recommend> newList=new ArrayList<Recommend>();
        PageInfo pageInfo=new PageInfo();
        pageInfo.setPageSize(recommendGoodsRequest.getPageSize());
        pageInfo.setPageNo(recommendGoodsRequest.getPageNo());
        Map map=goodsService.getListByPageWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.NEW_SKU+"')>0"),pageInfo);
//        List<Goods> list = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.NEW_SKU+"')>0"));
        List<Goods> list=(List) map.get("DATA");

        if(!ValidationUtil.isEmpty(list)){
            for (int i = 0; i < list.size(); i++) {
                Recommend recommend=new Recommend();
                if(list.get(i).getShortDesc()!=null){
                    recommend.setShortDesc(list.get(i).getShortDesc());
                }
                if(list.get(i).getGoodsStory()!=null){
                    recommend.setGoodsStory(list.get(i).getGoodsStory());
                }
                if(list.get(i).getDefaultImage()!=null){
                    recommend.setImageUrl(Constants.DOMAIN_NAME+Constants.GOODS_IMG+list.get(i).getDefaultImage());
                }
                if(String.valueOf(list.get(i).getGoods_id())!=null){
                    recommend.setId(String.valueOf(list.get(i).getGoods_id()));
                }
                newList.add(recommend);
            }
        }
        int totalpage=(pageInfo.getTotalCount()+pageInfo.getPageSize()-1)/pageInfo.getPageSize();
        result.setPageNo(pageInfo.getPageNo());
        result.setTotalPage(totalpage);
        result.setNewList(newList);
        List<Advwz>  advwzList=(List<Advwz>)advwzService.getListByWhere(new StringBuffer("and n.advwz_id="+ Constants.ANEW_IMG ));
        if(!ValidationUtil.isEmpty(advwzList)) {
            Advwz advwz = (Advwz) advwzList.get(0);
            if(!ValidationUtil.isEmpty(advwz.getAdv())) {
                result.setImage(Constants.DOMAIN_NAME + Constants.ADV_IMG + advwz.getAdv().get(0).getAdv_flie());
            }
        }
        result.setResultCode(SUCCESS);
        result.setMessage("OK");
        log.debug(result);
        return result;
    }


    /**
     * 获取团购列表
     * @param recommendGoodsRequest
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/groupRecommend")
    public RecommendGroupGoodsResult groupRecommend(@RequestBody RecommendGoodsRequest  recommendGoodsRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(recommendGoodsRequest);
        RecommendGroupGoodsResult result = new RecommendGroupGoodsResult();
        if (StringUtils.isBlank(recommendGoodsRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }

        //团购列表
        List<Recommend> groupList=new ArrayList<Recommend>();
        PageInfo pageInfo=new PageInfo();
        pageInfo.setPageSize(recommendGoodsRequest.getPageSize());
        pageInfo.setPageNo(recommendGoodsRequest.getPageNo());
        Map map=goodsService.getListByPageWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.GROUP_SKU+"')>0"),pageInfo);
        List<Goods> list=(List) map.get("DATA");
        if(!ValidationUtil.isEmpty(list)){
            for (int i = 0; i < list.size(); i++) {
                Recommend recommend=new Recommend();
                if(list.get(i).getShortDesc()!=null){
                    recommend.setShortDesc(list.get(i).getShortDesc());
                }
                if(list.get(i).getGoodsStory()!=null){
                    recommend.setGoodsStory(list.get(i).getGoodsStory());
                }
                if(list.get(i).getDefaultImage()!=null){
                    recommend.setImageUrl(Constants.DOMAIN_NAME+Constants.GOODS_IMG+list.get(i).getDefaultImage());
                }
                if(String.valueOf(list.get(i).getGoods_id())!=null){
                    recommend.setId(String.valueOf(list.get(i).getGoods_id()));
                }
                groupList.add(recommend);
                /*GoodsSummary goodsSummary = new GoodsSummary();
                goodsSummary.setId(String.valueOf(list.get(i).getGoods_id()));
                goodsSummary.setTitle(list.get(i).getName());
                goodsSummary.setMainPicUrl(list.get(i).getImg());
                goodsSummary.setPrice(list.get(i).getSalesMoney());
                lists.add(goodsSummary);*/
            }
           /* recommend.setGoodsSummaryList(lists);
            recommend.setImageUrl("");
            groupList.add(recommend);*/
        }
        int totalpage=(pageInfo.getTotalCount()+pageInfo.getPageSize()-1)/pageInfo.getPageSize();
        result.setPageNo(pageInfo.getPageNo());
        result.setTotalPage(totalpage);
        result.setGroupList(groupList);
        List<Advwz>  advwzList=(List<Advwz>)advwzService.getListByWhere(new StringBuffer("and n.advwz_id="+ Constants.AGROUP_IMG ));
        if(!ValidationUtil.isEmpty(advwzList)) {
            Advwz advwz = (Advwz) advwzList.get(0);
            if(!ValidationUtil.isEmpty(advwz.getAdv())) {
                result.setImage(Constants.DOMAIN_NAME + Constants.ADV_IMG + advwz.getAdv().get(0).getAdv_flie());
            }
        }
        result.setResultCode(SUCCESS);
        result.setMessage("OK");
        log.debug(result);
        return result;
    }


    /**
     * 获取促销列表
     * @param recommendGoodsRequest
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/promotionRecommend")
    public RecommendPromotionGoodsResult promotionRecommend(@RequestBody RecommendGoodsRequest  recommendGoodsRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(recommendGoodsRequest);
        RecommendPromotionGoodsResult result = new RecommendPromotionGoodsResult();
        if (StringUtils.isBlank(recommendGoodsRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
        //促销列表
        List<Recommend> promotionList=new ArrayList<Recommend>();

        PageInfo pageInfo=new PageInfo();
        pageInfo.setPageSize(recommendGoodsRequest.getPageSize());
        pageInfo.setPageNo(recommendGoodsRequest.getPageNo());

        Map map=goodsService.getListByPageWhere(new StringBuffer(" and n.shelves=0  and instr(n.biaoqian,'"+Constants.QIANGGOU_SKU+"')>0"),pageInfo);
        List<Goods> list=(List) map.get("DATA");
        if(!ValidationUtil.isEmpty(list)){
            for (int i = 0; i < list.size(); i++) {
                Recommend recommend=new Recommend();
                if(list.get(i).getShortDesc()!=null){
                    recommend.setShortDesc(list.get(i).getShortDesc());
                }
                if(list.get(i).getGoodsStory()!=null){
                    recommend.setGoodsStory(list.get(i).getGoodsStory());
                }
                if(list.get(i).getDefaultImage()!=null){
                    recommend.setImageUrl(Constants.DOMAIN_NAME+Constants.GOODS_IMG+list.get(i).getDefaultImage());
                }
                if(String.valueOf(list.get(i).getGoods_id())!=null){
                    recommend.setId(String.valueOf(list.get(i).getGoods_id()));
                }
                promotionList.add(recommend);
            }
        }
        int totalpage=(pageInfo.getTotalCount()+pageInfo.getPageSize()-1)/pageInfo.getPageSize();
        result.setPageNo(pageInfo.getPageNo());
        result.setTotalPage(totalpage);
        result.setPromotionList(promotionList);
        List<Advwz>  advwzList=(List<Advwz>)advwzService.getListByWhere(new StringBuffer("and n.advwz_id="+ Constants.APROMOTION_IMG ));
        if(!ValidationUtil.isEmpty(advwzList)) {
            Advwz advwz = (Advwz) advwzList.get(0);
            if(!ValidationUtil.isEmpty(advwz.getAdv())) {
                result.setImage(Constants.DOMAIN_NAME + Constants.ADV_IMG + advwz.getAdv().get(0).getAdv_flie());
            }
        }
        result.setResultCode(SUCCESS);
        result.setMessage("OK");
        log.debug(result);
        return result;
    }

/**
     * 搜索请求类
     * @param searchRequest
     * @param request
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping("/search")
    public SearchResult search(@RequestBody SearchRequest  searchRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(searchRequest);
        SearchResult result = new SearchResult();
        if (StringUtils.isBlank(searchRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
        List<GoodsSummary>  lists=new ArrayList<GoodsSummary>();
        List<Goods>  list=(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+ Constants.ONE_SKU));
        if(!ValidationUtil.isEmpty(list)){
            for (int i = 0; i < list.size(); i++) {
                GoodsSummary goodsSummary = new GoodsSummary();
                if(String.valueOf(list.get(i).getGoods_id())!=null){
                    goodsSummary.setId(String.valueOf(list.get(i).getGoods_id()));
                }
                if(list.get(i).getName()!=null){
                    goodsSummary.setTitle(list.get(i).getName());
                }
                if(list.get(i).getDefaultImage()!=null){
                    goodsSummary.setMainPicUrl(Constants.DOMAIN_NAME+Constants.GOODS_IMG+list.get(i).getDefaultImage());
                }
                goodsSummary.setPrice(list.get(i).getSalesMoney());
                lists.add(goodsSummary);
            }
        }
        result.setGoodsSummaryList(lists);
        result.setResultCode(SUCCESS);
        result.setMessage("OK");
        log.debug(result);
        return result;
    }
}

