package com.wckj.gfsj.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.dalong.francyconverflow.FancyCoverFlow;
import com.wckj.gfsj.R;

/**
 * Created by 小爱爱 on 2016/7/15.
 * 分类
 */
public class Main_classification_fragment extends Fragment{
    private View view;
    private FancyCoverFlow mfancyCoverFlow;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_main_main, null);
        TextView tv_msg = (TextView) view.findViewById(R.id.tv_msg);
        tv_msg.setText("cccc");
        initScroView();
        return view;
    }
  private void  initScroView(){
       mfancyCoverFlow =  (FancyCoverFlow) view.findViewById(R.id.fancyCoverFlow);
//      mMyFancyCoverFlowAdapter = new fa(this, mFancyCoverFlows);
//      mfancyCoverFlow.setAdapter(mMyFancyCoverFlowAdapter);
//      mMyFancyCoverFlowAdapter.notifyDataSetChanged();
      mfancyCoverFlow.setUnselectedAlpha(0.5f);//通明度
      mfancyCoverFlow.setUnselectedSaturation(0.5f);//设置选中的饱和度
      mfancyCoverFlow.setUnselectedScale(0.5f);//设置选中的规模
      mfancyCoverFlow.setSpacing(0);//设置间距
      mfancyCoverFlow.setMaxRotation(0);//设置最大旋转
      mfancyCoverFlow.setScaleDownGravity(0.5f);
      mfancyCoverFlow.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);
//      int num = Integer.MAX_VALUE / 2 % mFancyCoverFlows.size();
//      int selectPosition = Integer.MAX_VALUE / 2 - num;
//      mfancyCoverFlow.setSelection(selectPosition);
      mfancyCoverFlow.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//              Item homeFancyCoverFlow = (Item) mfancyCoverFlow.getSelectedItem();
//              if (homeFancyCoverFlow != null) {
//                  Toast.makeText(MainActivity.this,homeFancyCoverFlow.getName(),Toast.LENGTH_SHORT).show();
//              }

          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {
          }
      });
    }
}
