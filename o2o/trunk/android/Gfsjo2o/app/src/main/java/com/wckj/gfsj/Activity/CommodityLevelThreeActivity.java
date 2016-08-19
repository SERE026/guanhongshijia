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
import com.wckj.gfsj.Bean.CategoryBrandListRequest;
import com.wckj.gfsj.Bean.CategoryBrandListResult;
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

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * 商品三级列表
 */
public class CommodityLevelThreeActivity extends BaseNewActivity implements View.OnClickListener {
    private View view;
    private CategoryBrandListResult json;
    private GridView gv_commodity_three;
    private CommonAdapter mlvAdapter;
    private TextView tv_brand_1,tv_brand_2,tv_brand_3,tv_time;
    private ImageView iv_more_left,iv_more_right;
    private TitleRelativeLayout title_rl;
    private int categoryId,mBrandFlag;
    private int mBrandPage=1,mGoodsPage=1,mCurrent=1;
    private List<Brand> mBrandList;
    private List<GoodsSummary> goodsSummaryList;
    private List<GoodsSummary> mGoodsSummaryList=new ArrayList<>()  ;
    private CategoryGoodsListResult categoryGoodsListResult;
    private boolean  isNeedGoods;//是否需要绑定gridview数据    true需要

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
         iv_more_right = (ImageView) title_rl.childView.findViewById(R.id.iv_more_right);
        iv_more_left = (ImageView) title_rl.childView.findViewById(R.id.iv_more_left);
        iv_more_left.setOnClickListener(this);
        iv_more_right .setOnClickListener(this);
        tv_brand_3 = (TextView) title_rl.childView.findViewById(R.id.tv_brand_3);
        tv_brand_2 = (TextView) title_rl.childView.findViewById(R.id.tv_brand_2);
        tv_brand_1 = (TextView) title_rl.childView.findViewById(R.id.tv_brand_1);
        tv_brand_1.setOnClickListener(this);
        tv_brand_2.setOnClickListener(this);
        tv_brand_3.setOnClickListener(this);

        return titleView;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.activity_commodity_three, null);
        gv_commodity_three = (GridView) view.findViewById(R.id.gv_commodity_three);
        setColorBackground(mBrandFlag);
        setBrandTitle();//设置标题
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
        if(mGoodsPage==1){
            mGoodsSummaryList.clear();
        }
            mGoodsSummaryList.addAll(goodsSummaryList);
        if(mlvAdapter==null){
            mlvAdapter=  new CommonAdapter<GoodsSummary>(this,mGoodsSummaryList,R.layout.item_gv_commodity_three) {
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
        setBrandTitle();//设置标题
        if(isNeedGoods){
            bindData();
        }


    }
    protected void load() {
        isNeedGoods=true;
        getBrandByList();
//
    }

    private  void setBrandTitle(){
        iv_more_left.setVisibility(mBrandPage!=1?View.VISIBLE:View.GONE);
            int j = mBrandList.size();
            switch (j){
                case 1:
                    tv_brand_1.setText(mBrandList.get(0).getTitle());
                    break;
                case 2:
                    tv_brand_1.setText(mBrandList.get(0).getTitle());
                    tv_brand_2.setText(mBrandList.get(1).getTitle());
                    break;
                case 3:
                    tv_brand_1.setText(mBrandList.get(0).getTitle());
                    tv_brand_2.setText(mBrandList.get(1).getTitle());
                    tv_brand_3.setText(mBrandList.get(2).getTitle());
                    break;
            }


    }
    /**
     * 根据商品分类查询商品列表命令
     */
    private void getBrandByList() {
        CategoryBrandListRequest request = new CategoryBrandListRequest();
        request.setPageSize(3);
        request.setPageNo(mBrandPage);
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.GOODS_LIST_BY_BRAND_URL, new ICallBack() {

            @Override
            public void onError(Call call, Exception e) {
                showPageState(FrameLoadLayout.LoadResult.error);
            }

            @Override
            public void onSuccess(String response) {
                 json =  JSON.parseObject(response, CategoryBrandListResult.class);
                mBrandList = json.getBrandList();
                if(isNeedGoods){
                    if(mBrandList!=null&&mBrandList.size()>0){
                        getCategroyByList();
                    }else {
                        showPageState(FrameLoadLayout.LoadResult.error);
                    }
                }else {//简单获取第二页展示
//                    showPageState(FrameLoadLayout.LoadResult.success);
                    setBrandTitle();
                }

            }
        });
    }
    /**
     * 根据商品分类查询商品列表命令
     */
    private void getCategroyByList() {
        mCurrent=mBrandPage;
        CategoryGoodsListRequest request = new CategoryGoodsListRequest();
        request.setCategoryId(categoryId);
        request.setBrandId(Integer.parseInt(mBrandList.get(mBrandFlag).getId()));
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.GOODS_LIST_BY_CATEGORY_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                showPageState(FrameLoadLayout.LoadResult.error);
            }

            @Override
            public void onSuccess(String response) {
                 categoryGoodsListResult =  JSON.parseObject(response, CategoryGoodsListResult.class);
                 goodsSummaryList =   categoryGoodsListResult.getGoodsSummaryList();
                showPageState(checkData(goodsSummaryList));
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_go_back:
                finish();
                break;
            case R.id.iv_more_left://上一页
                mBrandPage--;
                isNeedGoods=false;
                if(mCurrent!=mBrandPage){
                    setColorBackground(-1);
                }else {
                    setColorBackground(mBrandFlag);
                }
                getBrandByList();
                break;
            case R.id.iv_more_right://下一页
                mBrandPage++;
                isNeedGoods=false;
                if(mCurrent!=mBrandPage){
                    setColorBackground(-1);
                }else {
                    setColorBackground(mBrandFlag);
                }
                getBrandByList();
                break;
            case R.id.tv_brand_3:
                mBrandFlag=2;
                setColorBackground(mBrandFlag);
                isNeedGoods=true;
                getCategroyByList();
                break;
            case R.id.tv_brand_2:
                mBrandFlag=1;
                setColorBackground(mBrandFlag);
                isNeedGoods=true;
                getCategroyByList();
                break;
            case R.id.tv_brand_1:
                mBrandFlag=0;
                setColorBackground(mBrandFlag);
                isNeedGoods=true;
                getCategroyByList();
                break;
        }
    }

    /**
     * 设置分类的颜色
     */
    private  void setColorBackground(int id){
        tv_brand_3.setBackgroundResource(2==id?R.drawable.icon_main_bg:0);
        tv_brand_2.setBackgroundResource(1==id?R.drawable.icon_main_bg:0);
        tv_brand_1.setBackgroundResource(0==id?R.drawable.icon_main_bg:0);
        tv_brand_3.setTextColor(getResources().getColor(2==id?R.color.color_fffffe:R.color.color_767f8e));
        tv_brand_2.setTextColor(getResources().getColor(1==id?R.color.color_fffffe:R.color.color_767f8e));
        tv_brand_1.setTextColor(getResources().getColor(0==id?R.color.color_fffffe:R.color.color_767f8e));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        title_rl.clearRegister();
    }
}
