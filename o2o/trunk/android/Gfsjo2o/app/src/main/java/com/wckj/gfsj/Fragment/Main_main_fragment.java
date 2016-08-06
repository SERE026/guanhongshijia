package com.wckj.gfsj.Fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;

import com.alibaba.fastjson.JSON;
import com.dalong.francyconverflow.FancyCoverFlow;
import com.wckj.gfsj.Activity.CommoditydetailsActivity;
import com.wckj.gfsj.Adapter.MyFancyCoverFlowAdapter;
import com.wckj.gfsj.Bean.LoopGoodsListRequest;
import com.wckj.gfsj.Bean.LoopGoodsListResult;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;

import okhttp3.Call;

/**
 * Created by 小爱爱 on 2016/7/18.
 */
public class Main_main_fragment extends BaseNewFragment{
    private FancyCoverFlow mfancyCoverFlow;
    private View view;
    private LoopGoodsListResult loopGoodsListResult;
    private MyFancyCoverFlowAdapter mMyFancyCoverFlowAdapter;


    @Override
    protected void init() {
    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        return null;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.fragment_main_main, null);
        initScroView();
        return view;
    }

    @Override
    protected void refreshOrLoadView() {

    }

    @Override
    protected void load() {
        getLoop();
//        showPageState(FrameLoadLayout.LoadResult.success);
    }

    private void  initScroView() {

        mfancyCoverFlow = (FancyCoverFlow) view.findViewById(R.id.fancyCoverFlow);
        mMyFancyCoverFlowAdapter = new MyFancyCoverFlowAdapter(view.getContext(), loopGoodsListResult.getGoodsDetailList());
        mfancyCoverFlow.setAdapter(mMyFancyCoverFlowAdapter);
         mMyFancyCoverFlowAdapter.notifyDataSetChanged();
        mfancyCoverFlow.setUnselectedAlpha(0.5f);//通明度
        mfancyCoverFlow.setUnselectedSaturation(0.5f);//设置选中的饱和度
        mfancyCoverFlow.setUnselectedScale(0.5f);//设置选中的规模
        mfancyCoverFlow.setSpacing(0);//设置间距
        mfancyCoverFlow.setMaxRotation(0);//设置最大旋转
        mfancyCoverFlow.setScaleDownGravity(0.5f);
        mfancyCoverFlow.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);
//      int num = Integer.MAX_VALUE / 2 % mList.size();
//      int selectPosition = Integer.MAX_VALUE / 2 - num;
      mfancyCoverFlow.setSelection(1);
        mfancyCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), CommoditydetailsActivity.class);
                startActivity(intent);
            }
        });

    }

    private void getLoop() {
        LoopGoodsListRequest request = new LoopGoodsListRequest();
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.GOODS_LOOP_URL, new ICallBack() {

            @Override
            public void onError(Call call, Exception e) {
                showPageState(FrameLoadLayout.LoadResult.error);
            }
            @Override
            public void onSuccess(String responsed) {
                 loopGoodsListResult =  JSON.parseObject(responsed, LoopGoodsListResult.class);

                showPageState(FrameLoadLayout.LoadResult.success);
            }

        } );
    }
}
