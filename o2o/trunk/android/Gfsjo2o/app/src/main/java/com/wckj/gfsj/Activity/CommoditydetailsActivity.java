package com.wckj.gfsj.Activity;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Adapter.CommoditydetailsAdapter;
import com.wckj.gfsj.Alipay.PayUtils;
import com.wckj.gfsj.Application.AppApplication;
import com.wckj.gfsj.Bean.AddCartRequest;
import com.wckj.gfsj.Bean.AddCartResult;
import com.wckj.gfsj.Bean.AddFavoritesRequest;
import com.wckj.gfsj.Bean.CancelFavoritesRequest;
import com.wckj.gfsj.Bean.GoodsDetailRequest;
import com.wckj.gfsj.Bean.GoodsDetailResult;
import com.wckj.gfsj.Bean.entity.GoodsSpec;
import com.wckj.gfsj.Bean.entity.GoodsSpecValue;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.OwerToastShow;

import java.util.List;

import okhttp3.Call;

/**
 * 商品详情信息展示付款
 */
public class CommoditydetailsActivity extends BaseNewActivity implements View.OnClickListener{
    private Button bt_buy;
    private ViewPager vp_commodity_pic;
    private List<String> imageList;
    private TitleRelativeLayout title_rl;
    private TextView tv_add_cart,tv_title_name,tv_title_desc,tv_prices,tv_type_1,tv_type_2,tv_type_3,tv_type_4,tv_type_5,tv_specification_1,tv_specification_2,tv_specification_3,tv_specification_4,tv_specification_5,tv_color_1,tv_sale_count,tv_color_2,tv_color_3,tv_color_4,tv_color_5;
    private ImageView iv_collect;
    private GoodsDetailResult result;

    private String goodsId,colorId,typeId,specificationId;
    private List<GoodsSpec> specList;

    @Override
    protected void init() {
        goodsId =  getIntent().getStringExtra("goodsId");
        if( goodsId==null){
            OwerToastShow.show("该商品不存在");
//            finish();
        }
    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView = inflater.inflate(R.layout.layout_public_title_main, null);
        title_rl = (TitleRelativeLayout) titleView.findViewById(R.id.title_rl);
        title_rl.childView. findViewById(R.id.tv_go_back).setOnClickListener(this);
        title_rl.childView . findViewById(R.id.tv_content_desc).setVisibility(View.GONE);

        return titleView;
    }

    @Override
    protected View onCreateSuccessView() {
        View view = inflater.inflate(R.layout.activity_commodity_details, null);
        bt_buy = (Button) view.findViewById(R.id.bt_buy);
        tv_add_cart = (TextView) view.findViewById(R.id.tv_add_cart);
        iv_collect = (ImageView) view.findViewById(R.id.iv_collect);
        tv_title_name = (TextView) view.findViewById(R.id.tv_title_name);
        tv_title_desc = (TextView) view.findViewById(R.id.tv_title_desc);
        tv_prices = (TextView) view.findViewById(R.id.tv_prices);

        tv_color_1 = (TextView) view.findViewById(R.id.tv_color_1);
        tv_color_2 = (TextView) view.findViewById(R.id.tv_color_2);
        tv_color_3 = (TextView) view.findViewById(R.id.tv_color_3);
        tv_color_4 = (TextView) view.findViewById(R.id.tv_color_4);
        tv_color_5 = (TextView) view.findViewById(R.id.tv_color_5);

        tv_type_1 = (TextView) view.findViewById(R.id.tv_type_1);
        tv_type_2 = (TextView) view.findViewById(R.id.tv_type_2);
        tv_type_3 = (TextView) view.findViewById(R.id.tv_type_3);
        tv_type_4 = (TextView) view.findViewById(R.id.tv_type_4);
        tv_type_5 = (TextView) view.findViewById(R.id.tv_type_5);

        tv_specification_1 = (TextView) view.findViewById(R.id.tv_specification_1);
        tv_specification_2 = (TextView) view.findViewById(R.id.tv_specification_2);
        tv_specification_3 = (TextView) view.findViewById(R.id.tv_specification_3);
        tv_specification_4 = (TextView) view.findViewById(R.id.tv_specification_4);
        tv_specification_5 = (TextView) view.findViewById(R.id.tv_specification_5);


        tv_sale_count = (TextView) view.findViewById(R.id.tv_sale_count);


        initSuccessView();

        bt_buy.setOnClickListener(this);
        tv_add_cart.setOnClickListener(this);
        iv_collect.setOnClickListener(this);

        tv_type_1.setOnClickListener(this);
        tv_type_2.setOnClickListener(this);
        tv_type_4.setOnClickListener(this);

        tv_color_1.setOnClickListener(this);
        tv_color_2.setOnClickListener(this);
        tv_color_3.setOnClickListener(this);

        tv_specification_1.setOnClickListener(this);
        tv_specification_2.setOnClickListener(this);
        tv_specification_3.setOnClickListener(this);

        vp_commodity_pic = (ViewPager) view.findViewById(R.id.vp_commodity_pic);
        bindViewPage();//绑定viewpage
        return view;
    }


    private void bindViewPage() {
        if(imageList!=null){
            vp_commodity_pic.setAdapter(new CommoditydetailsAdapter(imageList,this));
        }
    }

    @Override
    protected void refreshOrLoadView() {

    }

    @Override
    protected void load() {
        getGoodsDetail();

    }

    //成功之后初始化界面数据
    private void initSuccessView() {
        tv_title_name.setText(result.getDetail().getName());
        tv_title_desc.setText(result.getDetail().getShortDesc());
        tv_prices.setText("￥ "+result.getDetail().getPrice());
        tv_sale_count.setText("成交价格"+result.getDetail().getSaleCount()+"件");
        iv_collect.setImageResource(result.getDetail().getCollection().equals("收藏")?R.drawable.icon_collect_normal:R.drawable.icon_collect_press);

        specList =  result.getDetail().getSpecList();
        if(specList!=null){
            for (int i = 0; i <specList.size() ; i++) {
                if(specList.get(i).getSpecValueList()!=null){
                    List<GoodsSpecValue> specValueList = specList.get(i).getSpecValueList();
                    switch (i){
                            case 0://类型
                                switch (specValueList.size()){
                                    case 1:
                                        tv_type_1.setVisibility(View.VISIBLE);
                                        tv_type_1.setText(specValueList.get(0).getValue());
                                        break;
                                    case 2:
                                        tv_type_1.setVisibility(View.VISIBLE);
                                        tv_type_2.setVisibility(View.VISIBLE);
                                        tv_type_1.setText(specValueList.get(0).getValue());
                                        tv_type_2.setText(specValueList.get(1).getValue());
                                        break;
                                    case 3:
                                        tv_type_1.setVisibility(View.VISIBLE);
                                        tv_type_2.setVisibility(View.VISIBLE);
                                        tv_type_4.setVisibility(View.VISIBLE);
                                        tv_type_1.setText(specValueList.get(0).getValue());
                                        tv_type_2.setText(specValueList.get(1).getValue());
                                        tv_type_4.setText(specValueList.get(2).getValue());
                                        break;
                                }
                                typeId=specValueList.get(0).getId();
                                break;
                            case 1://颜色
                                switch (specValueList.size()){//三种颜色
                                    case 1:
                                        tv_color_1.setVisibility(View.VISIBLE);
                                        tv_color_1.setText(specValueList.get(0).getValue());
                                        break;
                                    case 2:
                                        tv_color_1.setVisibility(View.VISIBLE);
                                        tv_color_2.setVisibility(View.VISIBLE);
                                        tv_color_1.setText(specValueList.get(0).getValue());
                                        tv_color_2.setText(specValueList.get(1).getValue());
                                        break;
                                    case 3:
                                        tv_color_1.setVisibility(View.VISIBLE);
                                        tv_color_2.setVisibility(View.VISIBLE);
                                        tv_color_3.setVisibility(View.VISIBLE);
                                        tv_color_1.setText(specValueList.get(0).getValue());
                                        tv_color_2.setText(specValueList.get(1).getValue());
                                        tv_color_3.setText(specValueList.get(2).getValue());
                                        break;
                                }
                                colorId=specValueList.get(0).getId();
                                break;
                            case 2://规格
                                switch (specValueList.size()){//三种颜色
                                    case 1:
                                        tv_specification_1.setVisibility(View.VISIBLE);
                                        tv_specification_1.setText(specValueList.get(0).getValue());
                                        break;
                                    case 2:
                                        tv_specification_1.setVisibility(View.VISIBLE);
                                        tv_specification_2.setVisibility(View.VISIBLE);
                                        tv_specification_1.setText(specValueList.get(0).getValue());
                                        tv_specification_2.setText(specValueList.get(1).getValue());
                                        break;
                                    case 3:
                                        tv_specification_1.setVisibility(View.VISIBLE);
                                        tv_specification_2.setVisibility(View.VISIBLE);
                                        tv_specification_3.setVisibility(View.VISIBLE);
                                        tv_specification_1.setText(specValueList.get(0).getValue());
                                        tv_specification_2.setText(specValueList.get(1).getValue());
                                        tv_specification_3.setText(specValueList.get(2).getValue());
                                        break;
                                }
                                specificationId=specValueList.get(0).getId();
                                break;
                }
                }
            }
        }
    }



    /**
     * 商品详情命令
     */
    private void getGoodsDetail() {
        GoodsDetailRequest request = new GoodsDetailRequest();
        request.setId(goodsId+"");
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.GOODS_DETAIL_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                showPageState(FrameLoadLayout.LoadResult.error);
            }

            @Override
            public void onSuccess(String response) {
                 result =  JSON.parseObject(response, GoodsDetailResult.class);
               imageList = result.getDetail().getImageList();
                showPageState(FrameLoadLayout.LoadResult.success);
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_go_back:
                finish();
                break;
            case R.id.bt_buy://支付宝付款
//                startActivity(new Intent(this,ShoppingCartActivity.class));
                if(AppApplication.loginResult.getToken()==null){
                    OwerToastShow.show("请先登录在购买哦！！！");
                    return;
                }
                PayUtils.getInstance().pay(this,0.01+"","heheh","hahahhahahahahha");
                break;
            case R.id.tv_add_cart://加入购物车
                addCart();
                break;
            case R.id.iv_collect://收藏夹
                if(AppApplication.loginResult.getToken()==null){
                    OwerToastShow.show("暂无权限,需要先登录哦！！！");
                    return;
                }
                if( result.getDetail().getCollection().equals("收藏"))
                    addCollect();
                else
                    cancelCollect();
                addCollect();
                 result.getDetail().setCollection( result.getDetail().getCollection().equals("收藏")?"已收藏":"收藏");
                iv_collect.setImageResource(result.getDetail().getCollection().equals("收藏")?R.drawable.icon_collect_normal:R.drawable.icon_collect_press);
                break;
            case R.id.tv_color_1:
                setMainColor(R.id.tv_color_1);
                colorId=specList.get(1).getSpecValueList().get(0).getId();
                break;
            case R.id.tv_color_2:
                setMainColor(R.id.tv_color_2);
                colorId=specList.get(1).getSpecValueList().get(1).getId();
                break;
            case R.id.tv_color_3:
                setMainColor(R.id.tv_color_3);
                colorId=specList.get(1).getSpecValueList().get(2).getId();
                break;
            case R.id.tv_type_1:
                setType(R.id.tv_type_1);
                typeId=specList.get(0).getSpecValueList().get(0).getId();
                break;
            case R.id.tv_type_2:
                setType(R.id.tv_type_2);
                typeId=specList.get(0).getSpecValueList().get(1).getId();
                break;
            case R.id.tv_type_4:
                setType(R.id.tv_type_4);
                typeId=specList.get(0).getSpecValueList().get(2).getId();
                break;
            case R.id.tv_specification_1:
                setSpecification(R.id.tv_specification_1);
                specificationId=specList.get(2).getSpecValueList().get(0).getId();
                break;
            case R.id.tv_specification_2:
                setSpecification(R.id.tv_specification_2);
                specificationId=specList.get(2).getSpecValueList().get(1).getId();
                break;
            case R.id.tv_specification_3:
                setSpecification(R.id.tv_specification_3);
                specificationId=specList.get(2).getSpecValueList().get(2).getId();
                break;



        }
    }
    /**
     * 加入收藏夹
     */
    private void addCollect() {
        AddFavoritesRequest request = new AddFavoritesRequest();

        request.setGoodsId(goodsId+"");
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.FAVORITES_ADD_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
            }

            @Override
            public void onSuccess(String response) {

            }
        });
    }

    /**
     * 取消收藏
     */
    private void cancelCollect() {
        CancelFavoritesRequest request = new CancelFavoritesRequest();

        request.setGoodsId(goodsId+"");
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.FAVORITES_CANCEL_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
            }

            @Override
            public void onSuccess(String response) {
            }
        });
    }

    /**
     * 加入购物车
     */
    private void addCart() {
        AddCartRequest request = new AddCartRequest();
        request.setCount(1);
        request.setGoodsId(goodsId+"");
        request.setGoodSpecVal(typeId+"|"+colorId+"|"+specificationId);
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.CART_ADD_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                OwerToastShow.show("购物车加入失败");
            }

            @Override
            public void onSuccess(String response) {
                AddCartResult json = JSON.parseObject(response, AddCartResult.class);
                if(json.getResultCode()==0){
                    OwerToastShow.show("购物车加入成功");
                }else {
                    OwerToastShow.show("购物车加入失败");
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        title_rl. clearRegister();
    }

    /**
     * 设置颜色的背景选择
     * @param id
     */
    private void setMainColor(int id){
        tv_color_1.setBackgroundResource(R.id.tv_color_1==id?R.drawable.icon_details_color_select:0);
        tv_color_2.setBackgroundResource(R.id.tv_color_2==id?R.drawable.icon_details_color_select:0);
        tv_color_3.setBackgroundResource(R.id.tv_color_3==id?R.drawable.icon_details_color_select:0);
        tv_color_4.setBackgroundResource(R.id.tv_color_4==id?R.drawable.icon_details_color_select:0);
        tv_color_5.setBackgroundResource(R.id.tv_color_5==id?R.drawable.icon_details_color_select:0);
    }

    private void  setType(int id){
        tv_type_1.setBackgroundResource(R.id.tv_type_1==id?R.drawable.icon_details_color_select:0);
        tv_type_2.setBackgroundResource(R.id.tv_type_2==id?R.drawable.icon_details_color_select:0);
        tv_type_4.setBackgroundResource(R.id.tv_type_4==id?R.drawable.icon_details_color_select:0);
        tv_type_4.setBackgroundResource(R.id.tv_type_4==id?R.drawable.icon_details_color_select:0);
        tv_type_5.setBackgroundResource(R.id.tv_type_5==id?R.drawable.icon_details_color_select:0);
    }

    private void  setSpecification(int id){
        tv_specification_1.setBackgroundResource(R.id.tv_specification_1==id?R.drawable.icon_details_color_select:0);
        tv_specification_2.setBackgroundResource(R.id.tv_specification_2==id?R.drawable.icon_details_color_select:0);
        tv_specification_3.setBackgroundResource(R.id.tv_specification_3==id?R.drawable.icon_details_color_select:0);
        tv_specification_4.setBackgroundResource(R.id.tv_specification_4==id?R.drawable.icon_details_color_select:0);
        tv_specification_5.setBackgroundResource(R.id.tv_specification_5==id?R.drawable.icon_details_color_select:0);
    }


}
