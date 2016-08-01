//package cn.com.dyninfo.o2o.furniture.android.controller;
//
//import cn.com.dyninfo.o2o.communication.LoginRequest;
//import cn.com.dyninfo.o2o.communication.LoginResult;
//import cn.com.dyninfo.o2o.communication.StartupRequest;
//import cn.com.dyninfo.o2o.communication.StartupResult;
//import cn.com.dyninfo.o2o.entity.GoodsSummary;
//import cn.com.dyninfo.o2o.furniture.common.BaseAppController;
//import cn.com.dyninfo.o2o.furniture.sys.Constants;
//import cn.com.dyninfo.o2o.furniture.util.MD5Encoder;
//import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
//import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
//import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
//import cn.com.dyninfo.o2o.furniture.web.member.model.AppLoginStatus;
//import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
//import cn.com.dyninfo.o2o.furniture.web.member.service.AppLoginStatusService;
//import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
///**
// * Created by Administrator on 2016/7/29.
// */
//@Controller
//@RequestMapping("/sys")
//public class AppSysController extends BaseAppController {
//
//    @Resource
//    private HuiyuanService huiyuanService;
//
//    @Resource
//    private GoodsService goodsService;
//
//    @Resource
//    private AppLoginStatusService appLoginStatusService;
//
//    @ResponseBody
//    @RequestMapping("/startup")
//    public StartupResult startup(@RequestBody StartupRequest startupRequest, HttpServletRequest request, HttpServletResponse response) {
//        log.debug(startupRequest);
//        StartupResult result = new StartupResult();
//
//        List<GoodsSummary>  lists=new ArrayList<GoodsSummary>();
//        List<AppLoginStatus> appLoginStatusList = (List<AppLoginStatus>) appLoginStatusService.getListByWhere(new StringBuffer(" and n.deviceId=" + startupRequest.getDeviceId() + " and n.token=" + startupRequest.getToken()));
//        if (appLoginStatusList != null && appLoginStatusList.size() > 0) {
//            AppLoginStatus appLoginStatus = appLoginStatusList.get(0);
//            result.setToken(appLoginStatus.getToken());
//            request.getSession().setAttribute(Context.SESSION_MEMBER, appLoginStatus.getHuiyuan());
//        }
//
//        List<Goods>  list=(List<Goods>)goodsService.getListByWhere(new StringBuffer(" and n.goodsSort="+ Constants.ONE_SKU));
//        if(list.size()>0) {
//            for (int i = 0; i < list.size(); i++) {
//                GoodsSummary goodsSummary = new GoodsSummary();
//                goodsSummary.setId(String.valueOf(list.get(i).getGoods_id()));
//                goodsSummary.setTitle(list.get(i).getName());
//                goodsSummary.setMainPicUrl(list.get(i).getImg());
//                goodsSummary.setPrice(list.get(i).getSalesMoney());
//                lists.add(goodsSummary);
//            }
//            result.setResultCode(SUCCESS);
//            result.setMessage("OK");
//            result.setGoodsList(lists);
//            result.setMainPic("");
//        }else{
//            result.setResultCode(NO_LOGIN);
//            result.setMessage("启动失败");
//        }
//
//        log.debug(result);
//        return result;
//    }
//}
