
package cn.com.dyninfo.o2o.furniture.android.controller;

import cn.com.dyninfo.o2o.communication.AddCartRequest;
import cn.com.dyninfo.o2o.communication.AddCartResult;
import cn.com.dyninfo.o2o.communication.CartListRequest;
import cn.com.dyninfo.o2o.communication.CartListResult;
import cn.com.dyninfo.o2o.entity.Cart;
import cn.com.dyninfo.o2o.entity.CartItem;
import cn.com.dyninfo.o2o.entity.GoodsDetail;
import cn.com.dyninfo.o2o.furniture.admin.service.CouponService;
import cn.com.dyninfo.o2o.furniture.common.BaseAppController;
import cn.com.dyninfo.o2o.furniture.util.ValidationUtil;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.order.model.CarsBox;
import cn.com.dyninfo.o2o.furniture.web.order.service.CarsService;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


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
        String id = addCartRequest.getGoodsId();
        int count = addCartRequest.getCount();
        Goods goods= (Goods) goodsService.getObjById(id);
        CarsBox carsBox=new CarsBox();
        HuiyuanInfo huiyuanInfo=(HuiyuanInfo) huiyuanService.getObjById("35");
        if(!ValidationUtil.isEmpty(huiyuanInfo)){
            carsBox.setMember(huiyuanInfo);
            carsBox.setGoods(goods);
            carsBox.setNum(count);
            carsBox.setPrice(goods.getGoodMoney());
            carsService.addObj(carsBox);
            result.setResultCode(SUCCESS);
            result.setMessage("OK");
        }else {
            result.setResultCode(NO_LOGIN);
            result.setMessage("商品添加到购物车失败");
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
        List<HuiyuanInfo>  list2=(List<HuiyuanInfo>) huiyuanService.getListByWhere(
                new StringBuffer(" and n.name='lxfeng'"));
        HuiyuanInfo info= list2.get(0);
        //获取用户信息
        // HuiyuanInfo info=(HuiyuanInfo)request.getSession().getAttribute(Context.SESSION_MEMBER);
        Cart cart=new Cart();
        List<CartItem> itemList=new ArrayList<CartItem>();
        List<CarsBox> list=(List<CarsBox>)carsService.getListByWhere(new StringBuffer(" and n.member.huiYuan_id="+info.getHuiYuan_id()));
      //  List<CarsBox> list =(List<CarsBox>)orderService.getOrderConfirm(String.valueOf(info.getHuiYuan_id()));
        if(!ValidationUtil.isEmpty(list)){
            for (int i = 0; i < list.size(); i++) {
              //  CarsBox carinfo = (CarsBox) list.get(i);
                CartItem cartItem = new CartItem();
                if(list.get(i).getCars_box_id()!=null){
                    cartItem.setId(list.get(i).getCars_box_id());
                }
                cartItem.setCount(list.get(i).getNum()); //数量
                GoodsDetail goodsDetail = new GoodsDetail();
                if(list.get(i).getGoods().getName()!=null){
                    goodsDetail.setName(list.get(i).getGoods().getName());//商品名称
                }
                //goodsDetail.setSpecList(); //参数列表
                if(list.get(i).getGoods().getShortDesc()!=null){
                    goodsDetail.setShortDesc(list.get(i).getGoods().getShortDesc());  //商品说明，显示在商品名称下方
                }
                goodsDetail.setPrice(list.get(i).getGoods().getSalesMoney()); //商品价格
              //  goodsDetail.setCategory();//商品类别
              //  goodsDetail.setBrand();  //品牌
                goodsDetail.setSaleCount(list.get(i).getGoods().getNum());//销量
                List<String> imageList=new ArrayList<String>();
                String[] arr=list.get(i).getGoods().getImages().split(";");
                if (arr.length>0 && !ValidationUtil.isEmpty(list.get(i).getGoods().getImages())){
                    for (int j = 0; j <arr.length; j++) {
                        imageList.add(arr[j]);
                    }
                }
                goodsDetail.setImageList(imageList); //图片列表
                if(list.get(i).getGoods().getDescription()!=null){
                    goodsDetail.setGoodsDesc(list.get(i).getGoods().getDescription()); //商品详情，html格式
                }
              //  cartItem.setSpecValue();//商品参数值，内部已关联了对应的商品参数
                cartItem.setGoodsDetail(goodsDetail);  //商品信息
                itemList.add(cartItem);
            }
            cart.setItemList(itemList);
            result.setCart(cart);
            result.setResultCode(SUCCESS);
            result.setMessage("OK");
        }else {
            result.setResultCode(NO_LOGIN);
            result.setMessage("获取购物车列表失败");
        }
        log.debug(result);
        return result;
    }
}

