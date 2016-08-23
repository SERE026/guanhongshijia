package com.wckj.gfsj.Activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
import com.wckj.gfsj.R;

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


    @Override
    protected void init() {
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
    }

    private View getLine(){
        return (View) findViewById(R.id.line);
    }

    private EditText getEtUserName(){
        return (EditText) findViewById(R.id.et_user_name);
    }

    private EditText getEtProvince(){
        return (EditText) findViewById(R.id.et_province);
    }

    private EditText getEtCity(){
        return (EditText) findViewById(R.id.et_city);
    }

    private EditText getEtDistrict(){
        return (EditText) findViewById(R.id.et_district);
    }

    private EditText getEtStreet(){
        return (EditText) findViewById(R.id.et_street);
    }

    private EditText getEtZipCode(){
        return (EditText) findViewById(R.id.et_zip_code);
    }

    private EditText getEtCellPhoneNum(){
        return (EditText) findViewById(R.id.et_cell_phone_num);
    }

    private EditText getEtPhoneOne(){
        return (EditText) findViewById(R.id.et_phone_one);
    }

    private View getLine2(){
        return (View) findViewById(R.id.line2);
    }

    private EditText getEtPhoneTwo(){
        return (EditText) findViewById(R.id.et_phone_two);
    }

    private View getLine3(){
        return (View) findViewById(R.id.line3);
    }

    private EditText getEtPhoneThree(){
        return (EditText) findViewById(R.id.et_phone_three);
    }

    private EditText getEtEmail(){
        return (EditText) findViewById(R.id.et_email);
    }
}
