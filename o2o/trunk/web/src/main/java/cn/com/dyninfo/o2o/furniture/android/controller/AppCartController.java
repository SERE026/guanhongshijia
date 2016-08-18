
package cn.com.dyninfo.o2o.furniture.android.controller;

import cn.com.dyninfo.o2o.communication.AddCartRequest;
import cn.com.dyninfo.o2o.communication.AddCartResult;
import cn.com.dyninfo.o2o.communication.CartListRequest;
import cn.com.dyninfo.o2o.communication.CartListResult;
import cn.com.dyninfo.o2o.entity.*;
import cn.com.dyninfo.o2o.furniture.admin.service.CouponService;
import cn.com.dyninfo.o2o.furniture.common.BaseAppController;
import cn.com.dyninfo.o2o.furniture.sys.Constants;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ValidationUtil;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.model.GoodsSpecVal;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.member.model.AppLoginStatus;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.AppLoginStatusService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.order.model.CarsBox;
import cn.com.dyninfo.o2o.furniture.web.order.service.CarsService;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
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
@RequestMapping("/cart")
public class AppCartController extends BaseAppController {

    @Resource
    private HuiyuanService huiyuanService;

    @Resource
    private CouponService couponService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private OrderService orderService;

    @Resource
    private CarsService carsService;

    @Resource
    private AppLoginStatusService appLoginStatusService;

/**
     * 将商品添加到购物车
     * @param addCartRequest
     * @param request
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping("/add")
    public AddCartResult add(@RequestBody AddCartRequest  addCartRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(addCartRequest);
        AddCartResult result = new AddCartResult();
        if (StringUtils.isBlank(addCartRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
        if (StringUtils.isBlank(addCartRequest.getToken())) {
            result.setResultCode(NO_LOGIN);
            result.setMessage("用户未登录");
            return result;
        }
        //获取用户信息
        AppLoginStatus appLoginStatus=null;
        HuiyuanInfo info=(HuiyuanInfo)request.getSession().getAttribute(Context.SESSION_MEMBER);
        if (ValidationUtil.isEmpty(info)){
            List<AppLoginStatus> appLoginStatusList =(List<AppLoginStatus>)appLoginStatusService.getListByWhere(new StringBuffer(" and  n.token='"+ addCartRequest.getToken()+"'"));
            if(!ValidationUtil.isEmpty(appLoginStatusList)){
                appLoginStatus=appLoginStatusList.get(0);
            }
        }
        if (!ValidationUtil.isEmpty(appLoginStatus)) {
            info = appLoginStatus.getHuiyuan();
        }
        if (!ValidationUtil.isEmpty(info)) {
            String id = addCartRequest.getGoodsId();
            int count = addCartRequest.getCount();
            Goods goods= (Goods) goodsService.getObjById(id);
            CarsBox carsBox=new CarsBox();
            carsBox.setMember(info);
            carsBox.setGoods(goods);
            carsBox.setSpecVal("");
            carsBox.setActInfo("|");
            carsBox.setNum(count);
            carsBox.setPrice(goods.getGoodMoney());
            carsService.addObj(carsBox);
            result.setResultCode(SUCCESS);
            result.setMessage("OK");
        }
        else {
            result.setResultCode(NO_LOGIN);
            result.setMessage("商品添加到购物车失败，请重新登录");
        }
        log.debug(result);
        return result;
    }


/**
     * 获取购物车列表
     * @param cartListRequest
     * @param request
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping("/list")
    public CartListResult list(@RequestBody CartListRequest  cartListRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(cartListRequest);
        CartListResult result = new CartListResult();
        if (StringUtils.isBlank(cartListRequest.getDeviceId())) {
            result.setResultCode(NEED_DEVICE_ID);
            result.setMessage("设备识别码不能为空");
            return result;
        }
        if (StringUtils.isBlank(cartListRequest.getToken())) {
            result.setResultCode(NO_LOGIN);
            result.setMessage("用户未登录");
            return result;
        }
        PageInfo pageInfo=new PageInfo();
        pageInfo.setPageSize(cartListRequest.getPageSize());
        pageInfo.setPageNo(cartListRequest.getPageNo());
        //获取用户信息
        AppLoginStatus appLoginStatus=null;
        HuiyuanInfo info=(HuiyuanInfo)request.getSession().getAttribute(Context.SESSION_MEMBER);
        if (ValidationUtil.isEmpty(info)){
            List<AppLoginStatus> appLoginStatusList =(List<AppLoginStatus>)appLoginStatusService.getListByWhere(new StringBuffer(" and  n.token='"+ cartListRequest.getToken()+"'"));
            if(!ValidationUtil.isEmpty(appLoginStatusList)){
                appLoginStatus=appLoginStatusList.get(0);
            }
        }
        if (!ValidationUtil.isEmpty(appLoginStatus)) {
            info = appLoginStatus.getHuiyuan();
        }
        Cart cart=new Cart();
        List<CartItem> itemList=new ArrayList<CartItem>();

        List<GoodsSpec> specList=new ArrayList<GoodsSpec>();

        if (!ValidationUtil.isEmpty(info)) {
            Map map=carsService.getListByPageWhere(new StringBuffer(" and n.member.huiYuan_id=" + info.getHuiYuan_id()),pageInfo);
            List<CarsBox> list=(List) map.get("DATA");
            if (!ValidationUtil.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    //  CarsBox carinfo = (CarsBox) list.get(i);
                    CartItem cartItem = new CartItem();
                    if (list.get(i).getCars_box_id() != null) {
                        cartItem.setId(list.get(i).getCars_box_id());
                    }
                    cartItem.setCount(list.get(i).getNum()); //数量
                    GoodsDetail goodsDetail = new GoodsDetail();
                    Goods goods=list.get(i).getGoods();

                    //获取商品参数属性
                    List<cn.com.dyninfo.o2o.furniture.web.goods.model.GoodsSpec> goodsSpecs=goods.getSpecList();
                    if(!ValidationUtil.isEmpty(goodsSpecs)) {
                        for (int f = 0; f < goodsSpecs.size(); f++) {
                            GoodsSpec goodsSpec = new GoodsSpec();
                            if (goodsSpecs.get(f).getStatus() == 0) {
                                goodsSpec.setId(goodsSpecs.get(f).getGoods_spec_id());//参数类型ID
                                goodsSpec.setName(goodsSpecs.get(f).getName());//参数类型名称
                                List<GoodsSpecVal> goodsSpecValList = goodsSpecs.get(f).getValList(); //后台数据
                                List<GoodsSpecValue> specValueList = new ArrayList<GoodsSpecValue>();//安卓实体
                                if(!ValidationUtil.isEmpty(goodsSpecValList)) {
                                    for (int j = 0; j < goodsSpecValList.size(); j++) {
                                        if (goodsSpecs.get(f).getGoods_spec_id().equals(goodsSpecValList.get(j).getSpec().getGoods_spec_id())) {
                                            GoodsSpecValue goodsSpecValuej = new GoodsSpecValue();
                                            goodsSpecValuej.setId(goodsSpecValList.get(j).getSpec_val_id()); //参数ID
                                            goodsSpecValuej.setValue(goodsSpecValList.get(j).getVal());//参数值
                                            specValueList.add(goodsSpecValuej);

                                        }
                                    }
                                }
                                goodsSpec.setSpecValueList(specValueList);
                                specList.add(goodsSpec);
                            }
                        }
                        goodsDetail.setSpecList(specList);
                    }



                    if(String.valueOf(goods.getGoods_id())!=null){
                        goodsDetail.setId(String.valueOf(goods.getGoods_id()));
                    }
                    if (goods.getName() != null) {
                        goodsDetail.setName(goods.getName());//商品名称
                    }
                    //goodsDetail.setSpecList(); //参数列表
                    if (goods.getShortDesc() != null) {
                        goodsDetail.setShortDesc(goods.getShortDesc());  //商品说明，显示在商品名称下方
                    }
                    goodsDetail.setPrice(goods.getSalesMoney()); //商品价格
                    //  goodsDetail.setCategory();//商品类别
                    //  goodsDetail.setBrand();  //品牌
                    goodsDetail.setSaleCount(goods.getNum());//销量
                    //图片
                    if(goods.getDefaultImage()!=null){
                        goodsDetail.setDefaultImage(Constants.DOMAIN_NAME+Constants.GOODS_IMG+goods.getDefaultImage());
                    }
                    if (goods.getDescription() != null) {
                        goodsDetail.setGoodsDesc(goods.getDescription()); //商品详情，html格式
                    }
                    //  cartItem.setSpecValue();//商品参数值，内部已关联了对应的商品参数
                    cartItem.setGoodsDetail(goodsDetail);  //商品信息
                    itemList.add(cartItem);
                }
                cart.setItemList(itemList);
            }
            int totalpage=(pageInfo.getTotalCount()+pageInfo.getPageSize()-1)/pageInfo.getPageSize();
            result.setPageNo(pageInfo.getPageNo());
            result.setTotalPage(totalpage);
            result.setCart(cart);
            result.setResultCode(SUCCESS);
            result.setMessage("OK");
        }
        else {
            result.setResultCode(NO_LOGIN);
            result.setMessage("获取购物车列表失败，请重新登录");
        }
        log.debug(result);
        return result;
    }
}

