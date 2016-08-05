package com.wckj.gfsj.Fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Activity.CommoditydetailsActivity;
import com.wckj.gfsj.Adapter.CommonAdapter;
import com.wckj.gfsj.Adapter.ViewHolder;
import com.wckj.gfsj.Bean.Commodity_level_three;
import com.wckj.gfsj.Bean.FavoritesListRequest;
import com.wckj.gfsj.Bean.FavoritesListResult;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;

import java.util.ArrayList;

import okhttp3.Call;

/**
 * Created by 小爱爱 on 2016/7/18.
 */
public class Collect_fragment extends BaseNewFragment implements View.OnClickListener {
    private View view;
    private ArrayList<Commodity_level_three> mList;
    private GridView gv_commodity_three;
    private CommonAdapter mlvAdapter;

    @Override
    protected void init() {
    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView = inflater.inflate(R.layout.layout_two_title, null);

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
                startActivity(intent);
            }
        });
    }

    private void bindData() {
        if(mlvAdapter==null){
            mlvAdapter=  new CommonAdapter<Commodity_level_three>(view.getContext(),mList,R.layout.item_gv_commodity_three) {
                @Override
                public void convert(ViewHolder helper, Commodity_level_three item, int position) {
                    helper.setText(R.id.tv_title_desc,"凳子");


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
        mList = new ArrayList<>();
        for (int i = 0; i <8 ; i++) {
            mList.add(new Commodity_level_three());
        }
//        getFavoritesList();
        showPageState(FrameLoadLayout.LoadResult.success);
    }

    /**
     * 收藏列表
     */
    private void getFavoritesList(){
        FavoritesListRequest request = new FavoritesListRequest();
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.FAVORITES_LIST_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
            }
            @Override
            public void onSuccess(String responsed) {
                JSON.parseObject(responsed, FavoritesListResult.class);

            }

        } );
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
