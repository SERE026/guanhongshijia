package com.wckj.gfsj.Fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Activity.CommoditydetailsActivity;
import com.wckj.gfsj.Adapter.CommonAdapter;
import com.wckj.gfsj.Adapter.ViewHolder;
import com.wckj.gfsj.Bean.AddFavoritesRequest;
import com.wckj.gfsj.Bean.AddFavoritesResult;
import com.wckj.gfsj.Bean.FavoritesListRequest;
import com.wckj.gfsj.Bean.FavoritesListResult;
import com.wckj.gfsj.Bean.entity.GoodsSummary;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.LogUtil;

import java.util.List;

import okhttp3.Call;

/**
 * Created by 小爱爱 on 2016/7/18.
 */
public class Collect_fragment extends BaseNewFragment implements View.OnClickListener {
    private View view;
    private GridView gv_commodity_three;
    private CommonAdapter mlvAdapter;
    private List<GoodsSummary> mGoodsList;

    @Override
    protected void init() {
        loadPage.iv_networktext.setImageResource(R.drawable.icon_collect_empty);
        loadPage.textView1.setText("你还没有相关收藏");
        loadPage.textView2.setText("快去商品购物页收藏其他商品吧！！！");
    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView = inflater.inflate(R.layout.layout_two_title, null);
        TextView tv_content_desc = (TextView) titleView.findViewById(R.id.tv_content_desc);
        tv_content_desc.setText("我的收藏系列");
        return titleView;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.activity_commodity_three, null);
        gv_commodity_three = (GridView) view.findViewById(R.id.gv_commodity_three);
        bindData();
        setListener();
        return view;
    }

    private void setListener() {
        gv_commodity_three.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(view.getContext(), CommoditydetailsActivity.class);
                GoodsSummary goods = (GoodsSummary) parent.getItemAtPosition(position);
                intent .putExtra("goodsId",goods.getId());
                startActivity(intent);
            }
        });
    }

    private void bindData() {
        if(mlvAdapter==null){
            mlvAdapter=  new CommonAdapter<GoodsSummary>(view.getContext(),mGoodsList,R.layout.item_gv_commodity_three) {
                @Override
                public void convert(ViewHolder helper, GoodsSummary item, int position) {
                    helper.setText(R.id.tv_title_desc,item.getTitle());
                    helper.setImageByUrl(R.id.iv_shopping_pic,item.getMainPicUrl());
                    helper.setText(R.id.tv_name,"￥"+item.getPrice());


                }
            };
            gv_commodity_three.setAdapter(mlvAdapter);
        }else {
            mlvAdapter.notifyDataSetChanged();
        }

    }


    @Override
    protected void refreshOrLoadView() {

    }

    protected void load() {
        getFavoritesList();
    }

    /**
     * 收藏列表
     */
    private void getFavoritesList(){
        FavoritesListRequest request = new FavoritesListRequest();
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.FAVORITES_LIST_URL, new ICallBack() {

            @Override
            public void onError(Call call, Exception e) {
                showPageState(checkData(mGoodsList));
            }
            @Override
            public void onSuccess(String response) {
                FavoritesListResult result = JSON.parseObject(response, FavoritesListResult.class);
                 mGoodsList =  result.getGoodsSummaryList();
                showPageState(checkData(mGoodsList));
            }

        } );
    }

    /**
     * 添加到收藏夹
     * @param goodsId 商品ID
     */
    private void addFavorites(String goodsId) {
        AddFavoritesRequest request = new AddFavoritesRequest();
        request.setGoodsId(goodsId);
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.FAVORITES_ADD_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                LogUtil.e("{" + e.toString() + "}");
            }

            @Override
            public void onSuccess(String response) {
                AddFavoritesResult json = JSON.parseObject(response, AddFavoritesResult.class);
                LogUtil.i(response);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.iv_more_left://下一页

                break;
            case R.id.iv_more_right://上一页

                break;

        }
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
