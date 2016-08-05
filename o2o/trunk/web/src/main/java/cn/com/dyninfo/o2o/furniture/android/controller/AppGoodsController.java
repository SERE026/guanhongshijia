
package cn.com.dyninfo.o2o.furniture.android.controller;

import cn.com.dyninfo.o2o.communication.*;
import cn.com.dyninfo.o2o.entity.GoodsDetail;
import cn.com.dyninfo.o2o.entity.GoodsSummary;
import cn.com.dyninfo.o2o.entity.Recommend;
import cn.com.dyninfo.o2o.furniture.common.BaseAppController;
import cn.com.dyninfo.o2o.furniture.sys.Constants;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ValidationUtil;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Brand;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.BrandService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsSortService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
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
    private GoodsSortService goodsSortService;

    @Resource
    private BrandService brandService;


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
        List<GoodsSummary>  goodsLists=new ArrayList<GoodsSummary>();
        List<cn.com.dyninfo.o2o.entity.Brand> brandLists=new ArrayList<cn.com.dyninfo.o2o.entity.Brand>();

        //获取商品
        List<Goods> goodsList =(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+categoryGoodsListRequest.getCategoryId()));
        //获取品牌
        List<Brand> brandList=( List<Brand>)brandService.getListByWhere(new StringBuffer());

        if(goodsList.size()>0&&brandList.size()>0) {
            for (int i = 0; i < goodsList.size(); i++) {
                GoodsSummary goodsSummary = new GoodsSummary();
                goodsSummary.setId(String.valueOf(goodsList.get(i).getGoods_id()));
                goodsSummary.setTitle(goodsList.get(i).getName());
                goodsSummary.setMainPicUrl(goodsList.get(i).getImg());
                goodsSummary.setPrice(goodsList.get(i).getSalesMoney());
                goodsLists.add(goodsSummary);
            }
            for (int i = 0; i < brandList.size(); i++) {
                cn.com.dyninfo.o2o.entity.Brand brand = new cn.com.dyninfo.o2o.entity.Brand();
                brand.setId(String.valueOf(brandList.get(i).getBrand_id()));
                brand.setTitle(brandList.get(i).getName());
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
       // List<GoodsSpec> specList=new ArrayList<GoodsSpec>();
       // Category category=new Category();
       // cn.com.dyninfo.o2o.entity.Brand brand=new cn.com.dyninfo.o2o.entity.Brand();
        List<String> imageList=new ArrayList<String>();
        GoodsDetail detail=new GoodsDetail();
        List list=goodsService.getListByWhere(new StringBuffer(" and n.goods_id="+goodsDetailRequest.getId()));
        if(!ValidationUtil.isEmpty(list)){
               Goods goods=(Goods)list.get(0);
                detail.setName(goods.getName());
                detail.setId(String.valueOf(goods.getGoods_id()));
                detail.setShortDesc(goods.getShortDesc());
                detail.setSaleCount(goods.getNum());
                detail.setPrice(goods.getSalesMoney());
                detail.setGoodsDesc(goods.getGoodsDescription());
                String[] arr=goods.getImages().split(";");
                if (arr.length>0 && !ValidationUtil.isEmpty(goods.getImages())){
                    for (int i = 0; i <arr.length; i++) {
                        imageList.add(arr[i]);
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
                    detail.setName(goods.getName());
                    detail.setId(String.valueOf(goods.getGoods_id()));
                    detail.setShortDesc(goods.getShortDesc());
                    detail.setSaleCount(goods.getNum());
                    detail.setPrice(goods.getSalesMoney());
                    detail.setGoodsDesc(goods.getGoodsDescription());
//                    String[] arr=goods.getImages().split(";");
//                    if (arr.length>0 && !ValidationUtil.isEmpty(goods.getImages())){
                    imageList.add(goods.getDefaultImage());
//                    }
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
     * 获取推荐页面 商品列表
     * @param recommendGoodsRequest
     * @param request
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping("/recommend")
    public RecommendGoodsResult recommend(@RequestBody RecommendGoodsRequest  recommendGoodsRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(recommendGoodsRequest);
        RecommendGoodsResult result = new RecommendGoodsResult();
        //新品推荐列表
        List<Recommend> newList=new ArrayList<Recommend>();

        //团购列表
        List<Recommend> groupList=new ArrayList<Recommend>();

        //促销列表
        List<Recommend> promotionList=new ArrayList<Recommend>();


        Recommend recommend=new Recommend();
        List<GoodsSummary>  lists=new ArrayList<GoodsSummary>();
        List<Goods>  list=(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+ Constants.ONE_SKU));
        if(!ValidationUtil.isEmpty(list)){
            for (int i = 0; i < list.size(); i++) {
                GoodsSummary goodsSummary = new GoodsSummary();
                goodsSummary.setId(String.valueOf(list.get(i).getGoods_id()));
                goodsSummary.setTitle(list.get(i).getName());
                goodsSummary.setMainPicUrl(list.get(i).getImg());
                goodsSummary.setPrice(list.get(i).getSalesMoney());
                lists.add(goodsSummary);
            }
            recommend.setGoodsSummaryList(lists);
            recommend.setImageUrl("");
            newList.add(recommend);
            groupList.add(recommend);
            promotionList.add(recommend);
        }
        result.setNewList(newList);
        result.setGroupList(groupList);
        result.setPromotionList(promotionList);
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

        List<GoodsSummary>  lists=new ArrayList<GoodsSummary>();
        List<Goods>  list=(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+ Constants.ONE_SKU));
        if(!ValidationUtil.isEmpty(list)){
            for (int i = 0; i < list.size(); i++) {
                GoodsSummary goodsSummary = new GoodsSummary();
                goodsSummary.setId(String.valueOf(list.get(i).getGoods_id()));
                goodsSummary.setTitle(list.get(i).getName());
                goodsSummary.setMainPicUrl(list.get(i).getImg());
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

