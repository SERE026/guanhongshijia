package com.wckj.gfsj.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.wckj.gfsj.Activity.CommodityLevelThreeActivity;
import com.wckj.gfsj.Adapter.CommonAdapter;
import com.wckj.gfsj.Adapter.ViewHolder;
import com.wckj.gfsj.Bean.Commodity_level_three;
import com.wckj.gfsj.R;

import java.util.ArrayList;

/**
 * 二级商品gridview列表
 */
public class Commodity_level_two_fragment extends Fragment{

    private GridView gv_two_commodity;
    private View view;
    private ArrayList<Commodity_level_three> mList;
    private CommonAdapter mAapter;
    private String ceshi;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view =  inflater.inflate(R.layout.fragment_gv_commodity_two, null);
        Bundle bundle = getArguments();
         ceshi =  bundle.getString("ceshi");
        gv_two_commodity = (GridView) view.findViewById(R.id.gv_two_commodity);
        if(mList==null){
            mList=new ArrayList<>();
        }

        for (int i = 0; i <9 ; i++) {
            mList.add(new Commodity_level_three());
        }
        bindData();
        setListener();
        return view;
    }

    //gridview点击
    private void setListener() {
        gv_two_commodity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent= new Intent(view.getContext(), CommodityLevelThreeActivity.class);
               startActivity(intent);
            }
        });

    }




    private void bindData() {
        if(mAapter==null){
            mAapter=  new CommonAdapter<Commodity_level_three>(view.getContext(),mList,R.layout.item_gv_commodity_two) {
                @Override
                public void convert(ViewHolder helper, Commodity_level_three item, int position) {
                        helper.setText(R.id.tv_name,ceshi);

                }
            };
            gv_two_commodity.setAdapter(mAapter);
        }else {
            mAapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAapter=null;
    }
}
