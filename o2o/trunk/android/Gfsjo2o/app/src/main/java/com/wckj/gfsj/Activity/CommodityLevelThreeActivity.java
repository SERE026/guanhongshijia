package com.wckj.gfsj.Activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Adapter.CommonAdapter;
import com.wckj.gfsj.Adapter.ViewHolder;
import com.wckj.gfsj.Bean.CategoryGoodsListRequest;
import com.wckj.gfsj.Bean.CategoryGoodsListResult;
import com.wckj.gfsj.Bean.entity.Brand;
import com.wckj.gfsj.Bean.entity.GoodsSummary;
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
 * 商品三级列表
 */
public class CommodityLevelThreeActivity extends BaseNewActivity implements View.OnClickListener {
    private View view;
    private CategoryGoodsListResult json;
    private GridView gv_commodity_three;
    private CommonAdapter mlvAdapter;
    private TextView tv_brand_1,tv_brand_2,tv_brand_3,tv_time;
    private ImageView iv_more_left;
    private TitleRelativeLayout title_rl;
    private int categoryId,mBrandFlag;
    private List<Brand> mBrandList;

    @Override
    protected void init() {
         categoryId = getIntent().getIntExtra("categoryId", -1);
        if(categoryId==-1){
            OwerToastShow.show("商品系列不存在");
            finish();
        }
    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView = inflater.inflate(R.layout.layout_public_title_main, null);
        title_rl = (TitleRelativeLayout) titleView.findViewById(R.id.title_rl);
        title_rl.childView. findViewById(R.id.rl_brand).setVisibility(View.VISIBLE);
        title_rl.childView. findViewById(R.id.tv_go_back).setOnClickListener(this);
        title_rl.childView.findViewById(R.id.iv_more_right).setOnClickListener(this);
        iv_more_left = (ImageView) title_rl.childView.findViewById(R.id.iv_more_left);
        iv_more_left.setOnClickListener(this);
        tv_brand_3 = (TextView) title_rl.childView.findViewById(R.id.tv_brand_3);
        tv_brand_2 = (TextView) title_rl.childView.findViewById(R.id.tv_brand_2);
        tv_brand_1 = (TextView) title_rl.childView.findViewById(R.id.tv_brand_1);

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
            mlvAdapter=  new CommonAdapter<GoodsSummary>(this,json.getGoodsSummaryList(),R.layout.item_gv_commodity_three) {
                @Override
                public void convert(ViewHolder helper, GoodsSummary item, int position) {
                    helper.setImageByUrl(R.id.iv_shopping_pic,item.getMainPicUrl());
                    helper.setText(R.id.tv_name,"￥ "+item.getPrice());
                    helper.setText(R.id.tv_title_desc,item.getTitle());
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
        getCategroyByList();
//
    }

    private  void setBrandTitle(){
        int i = mBrandList.size() / 3+1;
        if(mBrandFlag<i){
            tv_brand_1.setText(mBrandList.get(mBrandFlag).getTitle());
            tv_brand_2.setText(mBrandList.get(mBrandFlag+1).getTitle());
            tv_brand_3.setText(mBrandList.get(mBrandFlag+2).getTitle());
        }else if(mBrandFlag==i){
            int j = mBrandList.size()%3;
            switch (j){
                case 0:
                    tv_brand_1.setText(mBrandList.get(mBrandFlag).getTitle());
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }

            tv_brand_2.setText(mBrandList.get(mBrandFlag+1).getTitle());
            tv_brand_3.setText(mBrandList.get(mBrandFlag+2).getTitle());
        }

    }
    /**
     * 根据商品分类查询商品列表命令
     */
    private void getCategroyByList() {
        CategoryGoodsListRequest request = new CategoryGoodsListRequest();
        request.setCategoryId(categoryId);
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.GOODS_LIST_BY_CATEGORY_URL, new ICallBack() {

            @Override
            public void onError(Call call, Exception e) {
                showPageState(FrameLoadLayout.LoadResult.error);
            }

            @Override
            public void onSuccess(String response) {
                 json =  JSON.parseObject(response, CategoryGoodsListResult.class);
                mBrandList = json.getBrandList();
                showPageState(checkData(json.getGoodsSummaryList()));
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_go_back:
                finish();
                break;
            case R.id.iv_more_left://下一页

                break;
            case R.id.iv_more_right://上一页

                break;
            case R.id.tv_brand_3:
                setColorBackground(R.id.tv_brand_3);
                break;
            case R.id.tv_brand_2:
                setColorBackground(R.id.tv_brand_2);
                break;
            case R.id.tv_brand_1:
                setColorBackground(R.id.tv_brand_1);
                break;
        }
    }

    /**
     * 设置分类的颜色
     */
    private  void setColorBackground(int id){
        tv_brand_3.setBackgroundResource(R.id.tv_main==id?R.drawable.icon_main_bg:0);
        tv_brand_2.setBackgroundResource(R.id.tv_main_classification==id?R.drawable.icon_main_bg:0);
        tv_brand_1.setBackgroundResource(R.id.tv_main_recommend==id?R.drawable.icon_main_bg:0);
        tv_brand_3.setTextColor(getResources().getColor(R.id.tv_main==id?R.color.color_fffffe:R.color.color_767f8e));
        tv_brand_2.setTextColor(getResources().getColor(R.id.tv_main_classification==id?R.color.color_fffffe:R.color.color_767f8e));
        tv_brand_1.setTextColor(getResources().getColor(R.id.tv_main_recommend==id?R.color.color_fffffe:R.color.color_767f8e));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        title_rl.clearRegister();
    }
}
