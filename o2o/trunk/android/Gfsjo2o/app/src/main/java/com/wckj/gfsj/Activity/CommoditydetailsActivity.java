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
import com.wckj.gfsj.Bean.AddCartRequest;
import com.wckj.gfsj.Bean.AddCartResult;
import com.wckj.gfsj.Bean.Commodity_level_details;
import com.wckj.gfsj.Bean.GoodsDetailRequest;
import com.wckj.gfsj.Bean.GoodsDetailResult;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;

import java.util.ArrayList;

import okhttp3.Call;

/**
 * 商品详情信息展示付款
 */
public class CommoditydetailsActivity extends BaseNewActivity implements View.OnClickListener{
    private Button bt_buy;
    private ViewPager vp_commodity_pic;
    private ArrayList<Commodity_level_details> mList=new ArrayList<>();
    private TitleRelativeLayout title_rl;
    private TextView tv_add_cart;
    private ImageView iv_collect;

    private int goodsId;

    @Override
    protected void init() {
         goodsId =  getIntent().getIntExtra("goodsId", -1);
        if( goodsId==-1){
            finish();
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

        bt_buy.setOnClickListener(this);
        tv_add_cart.setOnClickListener(this);

        vp_commodity_pic = (ViewPager) view.findViewById(R.id.vp_commodity_pic);
        bindViewPage();//绑定viewpage
        return view;
    }

    private void bindViewPage() {
        for (int i = 0; i <5 ; i++) {
            mList.add(new Commodity_level_details());
        }
        vp_commodity_pic.setAdapter(new CommoditydetailsAdapter(mList,this));
    }

    @Override
    protected void refreshOrLoadView() {

    }

    @Override
    protected void load() {
//        getGoodsDetail();
        showPageState(FrameLoadLayout.LoadResult.success);
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
            }

            @Override
            public void onSuccess(String responsed) {
                GoodsDetailResult json = JSON.parseObject(responsed, GoodsDetailResult.class);
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
//                addCollect()
                break;
        }
    }
    /**
     * 加入收藏夹
     */
    private void addCollect() {
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
            }

            @Override
            public void onSuccess(String responsed) {
                AddCartResult json = JSON.parseObject(responsed, AddCartResult.class);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        title_rl. clearRegister();
    }
}
