package com.wckj.gfsj.Activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Bean.QueryAreaRequest;
import com.wckj.gfsj.Bean.QueryAreaResult;
import com.wckj.gfsj.Bean.entity.Area;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.LogUtil;
import com.wckj.gfsj.Utils.OwerToastShow;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class OrderConfirmOneActivity extends BaseNewActivity implements View.OnClickListener {

    private TitleRelativeLayout mRlTitle;
    private View view;
    private TextView tvOrderConfirm;
    private TextView tvSelectShipMethod;
    private RadioGroup rgShipMethod;
    private TextView tvSelectAddress;
    private RadioGroup rgAddress;
    private Button btnNext;

    private TextView tvAddNewAddress;
    private TextView tvUserName;
    private TextView tvProvince;
    private TextView tvStreet;
    private TextView tvZipCode;
    private TextView tvCellPhoneNum;
    private TextView tvPhoneNum;
    private TextView tvEmail;
    private TextView tvEmailToast;

    private ListView lvProvince, lvCity, lvDistrict;
    private ArrayAdapter provinceAdapter, cityAdapter, districtAdapter;

    List<String> provinceList = new ArrayList<String>();
    List<String> cityList = new ArrayList<String>();
    List<String> districtList = new ArrayList<String>();

    @Override
    protected void init() {
        provinceAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, provinceList);
        cityAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cityList);
        districtAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, districtList);
    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView =  inflater.inflate(R.layout.layout_public_title_main, null);
        mRlTitle = (TitleRelativeLayout) titleView.findViewById(R.id.title_rl);
        mRlTitle.childView.findViewById(R.id.tv_go_back).setOnClickListener(this);

        TextView tv_content_desc = (TextView) mRlTitle.childView.findViewById(R.id.tv_content_desc);
        tv_content_desc.setVisibility(View.GONE);
        return titleView;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.activity_order_confirm_one, null);
        initView();
        queryArea("");
        return view;
    }

    @Override
    protected void refreshOrLoadView() {
    }

    @Override
    protected void load() {
        showPageState(FrameLoadLayout.LoadResult.success);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRlTitle.clearRegister();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_go_back:
                finish();
                break;
            case R.id.btn_next:
                Intent intent = new Intent(view.getContext(), OrderConfirmTwoActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void initView() {
        tvOrderConfirm = (TextView) view.findViewById(R.id.tv_order_confirm);
        tvSelectShipMethod = (TextView) view.findViewById(R.id.tv_select_ship_method);
        rgShipMethod = (RadioGroup) view.findViewById(R.id.rg_ship_method);
        tvSelectAddress = (TextView) view.findViewById(R.id.tv_select_address);
        rgAddress = (RadioGroup) view.findViewById(R.id.rg_address);
        btnNext = (Button) view.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
        tvAddNewAddress = (TextView) view.findViewById(R.id.tv_add_new_address);
        tvUserName = (TextView) view.findViewById(R.id.tv_user_name);
        tvProvince = (TextView) view.findViewById(R.id.tv_province);
        tvStreet = (TextView) view.findViewById(R.id.tv_street);
        tvZipCode = (TextView) view.findViewById(R.id.tv_zip_code);
        tvCellPhoneNum = (TextView) view.findViewById(R.id.tv_cell_phone_num);
        tvPhoneNum = (TextView) view.findViewById(R.id.tv_phone_num);
        tvEmail = (TextView) view.findViewById(R.id.tv_email);
        tvEmailToast = (TextView) view.findViewById(R.id.tv_email_toast);

        lvProvince = (ListView) view.findViewById(R.id.lv_province);
        lvCity = (ListView) view.findViewById(R.id.lv_city);
        lvDistrict = (ListView) view.findViewById(R.id.lv_district);

        lvProvince.setAdapter(provinceAdapter);
        lvCity.setAdapter(cityAdapter);
        lvDistrict.setAdapter(districtAdapter);
    }

    /**
     * 查询市、区
     */
    private void queryArea(String parentId) {
        QueryAreaRequest request = new QueryAreaRequest();
        request.setParentId(parentId);
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.ORDER_QUERYAREA_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                LogUtil.e("{" + e.toString() + "}");
            }

            @Override
            public void onSuccess(String response) {
                QueryAreaResult result = JSON.parseObject(response, QueryAreaResult.class);
                LogUtil.i(response);

                if (result.getResultCode() == 0) {
                    provinceList.clear();
                    List<Area> areaList = result.getAreaList();
                    for (Area area : areaList) {
                        provinceList.add(area.getName());
                    }
                    provinceAdapter.notifyDataSetChanged();
                } else {
                    OwerToastShow.show(result.getMessage());
                }
            }
        });
    }
}
