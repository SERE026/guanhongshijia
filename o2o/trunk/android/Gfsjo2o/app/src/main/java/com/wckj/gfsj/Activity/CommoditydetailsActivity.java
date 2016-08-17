package com.wckj.gfsj.Activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Adapter.CommoditydetailsAdapter;
import com.wckj.gfsj.Application.AppApplication;
import com.wckj.gfsj.Bean.AddCartRequest;
import com.wckj.gfsj.Bean.AddFavoritesRequest;
import com.wckj.gfsj.Bean.GoodsDetailRequest;
import com.wckj.gfsj.Bean.GoodsDetailResult;
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
    private TextView tv_add_cart,tv_title_name,tv_title_desc,tv_prices,tv_type,tv_color,tv_specification,tv_sale_count;
    private ImageView iv_collect;
    private GoodsDetailResult result;

    private String goodsId;

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
        tv_type = (TextView) view.findViewById(R.id.tv_type);
        tv_color = (TextView) view.findViewById(R.id.tv_color);
        tv_specification = (TextView) view.findViewById(R.id.tv_specification);
        tv_sale_count = (TextView) view.findViewById(R.id.tv_sale_count);


        initSuccessView();

        bt_buy.setOnClickListener(this);
        tv_add_cart.setOnClickListener(this);
        iv_collect.setOnClickListener(this);

        vp_commodity_pic = (ViewPager) view.findViewById(R.id.vp_commodity_pic);
        bindViewPage();//绑定viewpage
        return view;
    }


    private void bindViewPage() {

        vp_commodity_pic.setAdapter(new CommoditydetailsAdapter(imageList,this));
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
        tv_type.setText(result.getDetail().getType());
        tv_sale_count.setText("成交价格"+result.getDetail().getSaleCount()+"件");
        iv_collect.setImageResource(result.getDetail().getCollection().equals("收藏")?R.drawable.icon_collect_normal:R.drawable.icon_collect_press);
//        tv_color.setText();
//        tv_specification
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
            case R.id.bt_buy:
                startActivity(new Intent(this,ShoppingCartActivity.class));
                break;
            case R.id.tv_add_cart://加入购物车
                addCart();
                break;
            case R.id.iv_collect://收藏夹
                if(AppApplication.loginResult.getToken()==null){
                    OwerToastShow.show("暂无权限,需要先登录哦！！！");
                    return;
                }
                addCollect();
                 result.getDetail().setCollection( result.getDetail().getCollection().equals("收藏")?"已收藏":"收藏");
                iv_collect.setImageResource(result.getDetail().getCollection().equals("收藏")?R.drawable.icon_collect_normal:R.drawable.icon_collect_press);
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
//                AddCartResult json = JSON.parseObject(response, AddCartResult.class);
//                OwerToastShow.show("收藏夹加入成功");
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
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.CART_ADD_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                OwerToastShow.show("购物车加入失败");
            }

            @Override
            public void onSuccess(String response) {
//                AddCartResult json = JSON.parseObject(response, AddCartResult.class);
                OwerToastShow.show("购物车加入成功");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        title_rl. clearRegister();
    }
}
