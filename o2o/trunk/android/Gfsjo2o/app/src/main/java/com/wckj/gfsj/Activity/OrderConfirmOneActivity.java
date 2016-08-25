package com.wckj.gfsj.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Adapter.AreaAdapter;
import com.wckj.gfsj.Bean.QueryAreaRequest;
import com.wckj.gfsj.Bean.QueryAreaResult;
import com.wckj.gfsj.Bean.entity.AddressMember;
import com.wckj.gfsj.Bean.entity.Area;
import com.wckj.gfsj.Bean.entity.CartItem;
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

public class OrderConfirmOneActivity extends BaseNewActivity implements View.OnClickListener,
        View.OnTouchListener {

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

    private EditText etUserName, etStreet, etZipCode, etCellPhoneNum, etPhoneOne, etPhoneTwo, etPhoneThree, etEmail;
    private EditText etProvince, etCity, etDistrict;

    private ListView lvProvince, lvCity, lvDistrict;
    private AreaAdapter provinceAdapter, cityAdapter, districtAdapter;

    private List<Area> provinceList = new ArrayList<Area>();
    private List<Area> cityList = new ArrayList<Area>();
    private List<Area> districtList = new ArrayList<Area>();

    private Area selectedProvince, selectedCity, selectedDistrict;
    private List<CartItem> cartItemList = new ArrayList<CartItem>();

    @Override
    protected void init() {
        Intent intent = this.getIntent();
        cartItemList = (List<CartItem>) intent.getSerializableExtra("cartItemList");
        provinceAdapter = new AreaAdapter(this, provinceList);
        cityAdapter = new AreaAdapter(this, cityList);
        districtAdapter = new AreaAdapter(this, districtList);
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
        queryArea(0, "");
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
//                String username = etUserName.getText().toString().trim();
//                if (username.isEmpty()) {
//                    OwerToastShow.show("请输入姓名");
//                    return;
//                }
//
//                String province = etProvince.getText().toString().trim();
//                if (province.isEmpty()) {
//                    OwerToastShow.show("请选择省份");
//                    return;
//                }
//
//                String city = etCity.getText().toString().trim();
//                if (city.isEmpty()) {
//                    OwerToastShow.show("请选择城市");
//                    return;
//                }
//
//                String district = etDistrict.getText().toString().trim();
//                if (username.isEmpty()) {
//                    OwerToastShow.show("请选择区县");
//                    return;
//                }
//
//                String street = etStreet.getText().toString().trim();
//                if (street.isEmpty()) {
//                    OwerToastShow.show("请输入街道地址");
//                    return;
//                }
//
//                String zipCode = etZipCode.getText().toString().trim();
//                if (zipCode.isEmpty()) {
//                    OwerToastShow.show("请输入邮编");
//                    return;
//                }
//
//                String cellPhoneNum = etCellPhoneNum.getText().toString().trim();
//                if (cellPhoneNum.isEmpty()) {
//                    OwerToastShow.show("请输入手机号码");
//                    return;
//                }
//
//                String email = etEmail.getText().toString().trim();
//                if (email.isEmpty()) {
//                    OwerToastShow.show("请输入邮箱");
//                    return;
//                }
//
//                String phoneOne = etPhoneOne.getText().toString().trim();
//                String phoneTwo = etPhoneTwo.getText().toString().trim();
//                String phoneThree = etPhoneThree.getText().toString().trim();
//                String tel = phoneOne + phoneTwo + phoneThree;
//
//                AddressMember addressMember = new AddressMember();
//                addressMember.setReceiveName(username);
//                addressMember.setProvince(selectedProvince.getId());
//                addressMember.setCity(selectedCity.getId());
//                addressMember.setCounty(selectedDistrict.getId());
//                addressMember.setAddress(street);
//                addressMember.setCode(zipCode);
//                addressMember.setReceivePhone(cellPhoneNum);
//                addressMember.setEmail(email);
//                addressMember.setReceiveTel(tel);

                AddressMember addressMember = new AddressMember();
                addressMember.setReceiveName("zhangrui");
                addressMember.setProvince("440000");
                addressMember.setCity("440300");
                addressMember.setCounty("440305");
                addressMember.setAddress("西丽镇珠光村");
                addressMember.setCode("518012");
                addressMember.setReceivePhone("15019289206");
                addressMember.setEmail("rayco.zhang@gmail.com");
                addressMember.setReceiveTel("");

                Bundle bundle = new Bundle();
                bundle.putSerializable("address", addressMember);

                Intent intent = new Intent();
                intent.setClass(this, OrderConfirmTwoActivity.class);
                intent.putExtras(bundle);
                intent.putExtra("cartItemList", (ArrayList<CartItem>)cartItemList);
                startActivity(intent);
                break;
            case R.id.et_province:
                if (lvProvince.getVisibility() == View.VISIBLE) {
                    lvProvince.setVisibility(View.GONE);
                } else {
                    lvProvince.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.et_city:
                if (lvCity.getVisibility() == View.VISIBLE) {
                    lvCity.setVisibility(View.GONE);
                } else {
                    lvCity.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.et_district:
                if (lvDistrict.getVisibility() == View.VISIBLE) {
                    lvDistrict.setVisibility(View.GONE);
                } else {
                    lvDistrict.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                // Disallow ScrollView to intercept touch events.
                v.getParent().requestDisallowInterceptTouchEvent(true);
                break;

            case MotionEvent.ACTION_UP:
                // Allow ScrollView to intercept touch events.
                v.getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }
        // Handle ListView touch events.
        v.onTouchEvent(event);
        return false;
    }

    private void initView() {
        tvOrderConfirm = (TextView) view.findViewById(R.id.tv_order_confirm);
//        tvSelectShipMethod = (TextView) view.findViewById(R.id.tv_select_ship_method);
//        rgShipMethod = (RadioGroup) view.findViewById(R.id.rg_ship_method);
//        tvSelectAddress = (TextView) view.findViewById(R.id.tv_select_address);
//        rgAddress = (RadioGroup) view.findViewById(R.id.rg_address);
//        btnNext = (Button) view.findViewById(R.id.btn_next);
//        btnNext.setOnClickListener(this);
        tvAddNewAddress = (TextView) view.findViewById(R.id.tv_add_new_address);
        tvUserName = (TextView) view.findViewById(R.id.tv_user_name);
        tvProvince = (TextView) view.findViewById(R.id.tv_province);
        tvStreet = (TextView) view.findViewById(R.id.tv_street);
        tvZipCode = (TextView) view.findViewById(R.id.tv_zip_code);
        tvCellPhoneNum = (TextView) view.findViewById(R.id.tv_cell_phone_num);
        tvPhoneNum = (TextView) view.findViewById(R.id.tv_phone_num);
        tvEmail = (TextView) view.findViewById(R.id.tv_email);
        tvEmailToast = (TextView) view.findViewById(R.id.tv_email_toast);

        etUserName = (EditText) view.findViewById(R.id.et_user_name);
        etStreet = (EditText) view.findViewById(R.id.et_street);
        etZipCode = (EditText) view.findViewById(R.id.et_zip_code);
        etCellPhoneNum = (EditText) view.findViewById(R.id.et_cell_phone_num);
        etPhoneOne = (EditText) view.findViewById(R.id.et_phone_one);
        etPhoneTwo = (EditText) view.findViewById(R.id.et_phone_two);
        etPhoneThree = (EditText) view.findViewById(R.id.et_phone_three);
        etEmail = (EditText) view.findViewById(R.id.et_email);

        etProvince = (EditText) view.findViewById(R.id.et_province);
        etCity = (EditText) view.findViewById(R.id.et_city);
        etDistrict = (EditText) view.findViewById(R.id.et_district);
        etProvince.setKeyListener(null);
        etCity.setKeyListener(null);
        etDistrict.setKeyListener(null);
        etProvince.setOnClickListener(this);
        etCity.setOnClickListener(this);
        etDistrict.setOnClickListener(this);
        btnNext = (Button) view.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);

        lvProvince = (ListView) view.findViewById(R.id.lv_province);
        lvProvince.setOnTouchListener(this);
        lvProvince.setAdapter(provinceAdapter);
        lvProvince.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedProvince = provinceList.get(position);
                etProvince.setText(selectedProvince.getName());
                queryArea(1, selectedProvince.getId());
                lvProvince.setVisibility(View.GONE);
            }
        });

        lvCity = (ListView) view.findViewById(R.id.lv_city);
        lvCity.setOnTouchListener(this);
        lvCity.setAdapter(cityAdapter);
        lvCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedCity = cityList.get(position);
                etCity.setText(selectedCity.getName());
                queryArea(2, selectedCity.getId());
                lvCity.setVisibility(View.GONE);
            }
        });

        lvDistrict = (ListView) view.findViewById(R.id.lv_district);
        lvDistrict.setOnTouchListener(this);
        lvDistrict.setAdapter(districtAdapter);
        lvDistrict.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedDistrict = districtList.get(position);
                etDistrict.setText(selectedDistrict.getName());
                lvDistrict.setVisibility(View.GONE);
            }
        });
    }

    /**
     * 查询省、市、区
     * @param type     0-省，1-市，2-区
     * @param parentId 为空代表查询省、不为空代表查询市、区
     */
    private void queryArea(final int type, String parentId) {
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
                    if (type == 0) {
                        provinceList.clear();
                        provinceList.addAll(result.getAreaList());
                        provinceAdapter.notifyDataSetChanged();
                    } else if (type == 1) {
                        cityList.clear();
                        cityList.addAll(result.getAreaList());
                        cityAdapter.notifyDataSetChanged();
                    } else if (type == 2) {
                        districtList.clear();
                        districtList.addAll(result.getAreaList());
                        districtAdapter.notifyDataSetChanged();
                    }
                } else {
                    OwerToastShow.show(result.getMessage());
                }
            }
        });
    }
}
