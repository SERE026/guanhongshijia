package cn.com.dyninfo.o2o.furniture.android.controller;

import cn.com.dyninfo.o2o.communication.AddFavoritesRequest;
import cn.com.dyninfo.o2o.communication.AddFavoritesResult;
import cn.com.dyninfo.o2o.communication.FavoritesListRequest;
import cn.com.dyninfo.o2o.communication.FavoritesListResult;
import cn.com.dyninfo.o2o.entity.GoodsSummary;
import cn.com.dyninfo.o2o.furniture.common.BaseAppController;
import cn.com.dyninfo.o2o.furniture.sys.Constants;
import cn.com.dyninfo.o2o.furniture.util.ValidationUtil;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.BrandService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.member.model.Favorites;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.FavoritesService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
@Controller
@RequestMapping("/favorites")
public class AppFavoritesController extends BaseAppController {

    @Resource
    private HuiyuanService huiyuanService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private FavoritesService favoritesService;

    @Resource
    private BrandService brandService;

    /**
     * 收藏夹商品列表请求类
     * @param favoritesListRequest
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public FavoritesListResult favoriteslist(@RequestBody FavoritesListRequest  favoritesListRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(favoritesListRequest);
        FavoritesListResult result = new FavoritesListResult();

        List<GoodsSummary>  lists=new ArrayList<GoodsSummary>();
        List<Goods>  list=(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+ Constants.ONE_SKU));
        if(list.size()>0) {
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
        log.debug(result);
        return result;
    }

    /**
     * 添加到收藏夹请求类
     * @param addFavoritesRequest
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public AddFavoritesResult add(@RequestBody AddFavoritesRequest  addFavoritesRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(addFavoritesRequest);
        AddFavoritesResult result = new AddFavoritesResult();
        //获取用户信息
        HuiyuanInfo info=(HuiyuanInfo)request.getSession().getAttribute(Context.SESSION_MEMBER);
        if(!ValidationUtil.isEmpty(info)){
            result.setResultCode(NO_LOGIN);
            result.setMessage("未登录");
            return result;
        }
        String goodId=addFavoritesRequest.getGoodsId();//商品ID
        if(info==null){
            result.setResultCode(NO_LOGIN);
            result.setMessage("添加收藏夹失败");
        }else {
            int coutn = favoritesService.getCountByWhere(new StringBuffer(" and n.type=0 and n.member.huiYuan_id=" + info.getHuiYuan_id() + " and n.good.goods_id=" + goodId));
            if (coutn == 0) {
                Favorites f = new Favorites();
                Goods good = (Goods) goodsService.getObjById(goodId);
                f.setGood(good);
                f.setType("0");
                f.setMember(info);
                f.setTime((int) (new Date().getTime() / 1000));
                favoritesService.addObj(f);
            }
            result.setResultCode(SUCCESS);
            result.setMessage("OK");
        }
        log.debug(result);
        return result;
    }
}
