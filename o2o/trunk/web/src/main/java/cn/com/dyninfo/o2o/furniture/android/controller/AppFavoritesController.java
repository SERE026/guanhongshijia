
package cn.com.dyninfo.o2o.furniture.android.controller;

import cn.com.dyninfo.o2o.communication.AddFavoritesRequest;
import cn.com.dyninfo.o2o.communication.AddFavoritesResult;
import cn.com.dyninfo.o2o.communication.FavoritesListRequest;
import cn.com.dyninfo.o2o.communication.FavoritesListResult;
import cn.com.dyninfo.o2o.entity.GoodsSummary;
import cn.com.dyninfo.o2o.furniture.common.BaseAppController;
import cn.com.dyninfo.o2o.furniture.sys.Constants;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ValidationUtil;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.member.model.AppLoginStatus;
import cn.com.dyninfo.o2o.furniture.web.member.model.Favorites;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.AppLoginStatusService;
import cn.com.dyninfo.o2o.furniture.web.member.service.FavoritesService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import org.apache.commons.lang.StringUtils;
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
import java.util.Map;


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
    private AppLoginStatusService appLoginStatusService;

/**
     * 收藏夹商品列表请求
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
        if (StringUtils.isBlank(favoritesListRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
        if (StringUtils.isBlank(favoritesListRequest.getToken())) {
            result.setResultCode(NO_LOGIN);
            result.setMessage("用户未登录");
            return result;
        }
        PageInfo pageInfo=new PageInfo();
        pageInfo.setPageSize(favoritesListRequest.getPageSize());
        pageInfo.setPageNo(favoritesListRequest.getPageNo());
        //获取用户信息
        AppLoginStatus appLoginStatus=null;
        HuiyuanInfo info=(HuiyuanInfo)request.getSession().getAttribute(Context.SESSION_MEMBER);
        if (ValidationUtil.isEmpty(info)){
            List<AppLoginStatus> appLoginStatusList =(List<AppLoginStatus>)appLoginStatusService.getListByWhere(new StringBuffer(" and  n.token='"+ favoritesListRequest.getToken()+"'"));
            if(!ValidationUtil.isEmpty(appLoginStatusList)){
                appLoginStatus=appLoginStatusList.get(0);
            }
        }
        if (!ValidationUtil.isEmpty(appLoginStatus)) {
            info = appLoginStatus.getHuiyuan();
        }
        List<GoodsSummary>  lists=new ArrayList<GoodsSummary>();
        if(!ValidationUtil.isEmpty(info)) {
            Map map = favoritesService.getListByPageWhere(new StringBuffer(" and n.member.huiYuan_id=" + info.getHuiYuan_id()), pageInfo);
            List<Favorites> list = (List<Favorites>) map.get("DATA");
            if (!ValidationUtil.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    Goods good = list.get(i).getGood();
                    GoodsSummary goodsSummary = new GoodsSummary();
                    if (String.valueOf(good.getGoods_id()) != null) {
                        goodsSummary.setId(String.valueOf(list.get(i).getFavorites_id()));
                    }
                    if (good.getName() != null) {
                        goodsSummary.setTitle(good.getName());
                    }
                    if (good.getDefaultImage() != null) {
                        goodsSummary.setMainPicUrl(Constants.DOMAIN_NAME + Constants.GOODS_IMG + good.getDefaultImage());
                    }
                    goodsSummary.setPrice(good.getSalesMoney());
                    lists.add(goodsSummary);
                }
            }
        }
            result.setGoodsSummaryList(lists);
            result.setResultCode(SUCCESS);
            result.setMessage("OK");
//        }else {
//            result.setResultCode(NO_LOGIN);
//            result.setMessage("收藏夹商品列表请求失败");
//        }
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
        if (StringUtils.isBlank(addFavoritesRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
        if (StringUtils.isBlank(addFavoritesRequest.getToken())) {
            result.setResultCode(NO_LOGIN);
            result.setMessage("用户未登录");
            return result;
        }
        //获取用户信息
        AppLoginStatus appLoginStatus=null;
        HuiyuanInfo info=(HuiyuanInfo)request.getSession().getAttribute(Context.SESSION_MEMBER);
        if (ValidationUtil.isEmpty(info)){
            List<AppLoginStatus> appLoginStatusList =(List<AppLoginStatus>)appLoginStatusService.getListByWhere(new StringBuffer(" and  n.token='"+ addFavoritesRequest.getToken()+"'"));
            if(!ValidationUtil.isEmpty(appLoginStatusList)){
                appLoginStatus=appLoginStatusList.get(0);
            }
        }
        if (!ValidationUtil.isEmpty(appLoginStatus)) {
            info = appLoginStatus.getHuiyuan();
        }
        if(!ValidationUtil.isEmpty(info)) {
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
        }
        result.setResultCode(SUCCESS);
        result.setMessage("OK");
        log.debug(result);
        return result;
    }
}

