
package cn.com.dyninfo.o2o.furniture.android.controller;

import cn.com.dyninfo.o2o.communication.AddFavoritesRequest;
import cn.com.dyninfo.o2o.communication.AddFavoritesResult;
import cn.com.dyninfo.o2o.communication.FavoritesListRequest;
import cn.com.dyninfo.o2o.communication.FavoritesListResult;
import cn.com.dyninfo.o2o.entity.GoodsSummary;
import cn.com.dyninfo.o2o.furniture.common.BaseAppController;
import cn.com.dyninfo.o2o.furniture.util.ValidationUtil;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
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

//        List<HuiyuanInfo>  list2=(List<HuiyuanInfo>) huiyuanService.getListByWhere(
//                new StringBuffer(" and n.name='lxfeng'"));
//        HuiyuanInfo info= list2.get(0);
        //获取用户信息
         HuiyuanInfo info = (HuiyuanInfo) request.getSession().getAttribute(Context.SESSION_MEMBER);

        List<GoodsSummary>  lists=new ArrayList<GoodsSummary>();

        List<Favorites>  list=(List<Favorites>)favoritesService.getListByWhere(new StringBuffer(" and n.member.huiYuan_id="+info.getHuiYuan_id()));

        if(!ValidationUtil.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                Goods good=list.get(i).getGood();
                GoodsSummary goodsSummary = new GoodsSummary();
                if(String.valueOf(good.getGoods_id())!=null){
                    goodsSummary.setId(String.valueOf(good.getGoods_id()));
                }
                if(good.getName()!=null){
                    goodsSummary.setTitle(good.getName());
                }
                if(good.getDefaultImage()!=null){
                    goodsSummary.setMainPicUrl(good.getDefaultImage());
                }
                goodsSummary.setPrice(good.getSalesMoney());
                lists.add(goodsSummary);
            }
            result.setGoodsSummaryList(lists);
            result.setResultCode(SUCCESS);
            result.setMessage("OK");
        }else {
            result.setResultCode(NO_LOGIN);
            result.setMessage("收藏夹商品列表请求失败");
        }
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
//        List<HuiyuanInfo>  list=(List<HuiyuanInfo>) huiyuanService.getListByWhere(
//                new StringBuffer(" and n.name='lxfeng'"));
//        HuiyuanInfo info= list.get(0);
        //获取用户信息
        HuiyuanInfo info = (HuiyuanInfo) request.getSession().getAttribute(Context.SESSION_MEMBER);
        if (ValidationUtil.isEmpty(info)) {
            result.setResultCode(NO_LOGIN);
            result.setMessage("未登录");
            return result;
        } else {
            String goodId = addFavoritesRequest.getGoodsId();//商品ID
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
            log.debug(result);
            return result;
        }
    }
}

