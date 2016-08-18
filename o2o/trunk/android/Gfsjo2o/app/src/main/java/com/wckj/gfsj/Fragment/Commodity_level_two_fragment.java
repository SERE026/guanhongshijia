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
import com.wckj.gfsj.Bean.entity.CategoryThree;
import com.wckj.gfsj.R;

import java.util.ArrayList;

/**
 * 二级商品gridview列表
 */
public class Commodity_level_two_fragment extends Fragment{

    private GridView gv_two_commodity;
    private View view;
    private CommonAdapter mAapter;
    private String ceshi;
    private ArrayList<CategoryThree> mCategotyList;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view =  inflater.inflate(R.layout.fragment_gv_commodity_two, null);
        Bundle bundle = getArguments();
         ceshi =  bundle.getString("title");
         mCategotyList =  (ArrayList) bundle.getSerializable("categoryThree");
        if(mCategotyList==null){
            mCategotyList=new ArrayList<>();
        }

        gv_two_commodity = (GridView) view.findViewById(R.id.gv_two_commodity);
        bindData();
        setListener();
        return view;
    }

    //gridview点击
    private void setListener() {
        gv_two_commodity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CategoryThree item = (CategoryThree) parent.getItemAtPosition(position);
                Intent intent= new Intent(view.getContext(), CommodityLevelThreeActivity.class);
                intent.putExtra("categoryId",Integer.parseInt(item.getId()));
               startActivity(intent);
            }
        });

    }




    private void bindData() {
        if(mAapter==null){
            mAapter=  new CommonAdapter<CategoryThree>(view.getContext(),mCategotyList,R.layout.item_gv_commodity_two) {
                @Override
                public void convert(ViewHolder helper, CategoryThree item, int position) {
                        helper.setText(R.id.tv_name,item.getTitle());
                    helper.setImageByUrl(R.id.iv_commodity_two,item.getImageUrl(),R.drawable.icon_public_classification);

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
