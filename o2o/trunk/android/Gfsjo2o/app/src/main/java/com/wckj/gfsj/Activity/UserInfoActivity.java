package com.wckj.gfsj.Activity;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Bean.QueryPersonalRequest;
import com.wckj.gfsj.Bean.QueryPersonalResult;
import com.wckj.gfsj.Bean.entity.Personal;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.LogUtil;
import com.wckj.gfsj.Utils.OwerToastShow;

import okhttp3.Call;

/**
 * Created by rayco on 2016/7/25.
 */
public class UserInfoActivity extends BaseNewActivity implements View.OnClickListener {

    private static final int UPDATE_USER_INFO = 500;

    private TitleRelativeLayout mRlTitle;
    private View view;
    private EditText mEtNickname, mEtRealName;
    private TextView mTvTelephoneNumber, mTvBirthdayDate, mTvMobilePhoneNumber, mTvAddressDetail;

    private Personal mPersonal;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_USER_INFO:
                    updateUserInfo();
                    break;
            }
        }
    };

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
        view = inflater.inflate(R.layout.activity_user_info, null);
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_go_back:
                finish();
                break;
        }
    }

    private void initView() {
        mEtNickname = (EditText) view.findViewById(R.id.et_nickname);
        mEtRealName = (EditText) view.findViewById(R.id.et_real_name);
        mEtNickname.setKeyListener(null);
        mEtRealName.setKeyListener(null);
        mTvTelephoneNumber = (TextView) view.findViewById(R.id.tv_telephone_number);
        mTvBirthdayDate = (TextView) view.findViewById(R.id.tv_birthday_date);
        mTvMobilePhoneNumber = (TextView) view.findViewById(R.id.tv_mobile_phone_number);
        mTvAddressDetail = (TextView) view.findViewById(R.id.tv_address_detail);

        queryUserInfo();
    }

    private void updateUserInfo() {
        mEtNickname.setText(mPersonal.getNickName());
        mEtRealName.setText(mPersonal.getRealName());
        mTvTelephoneNumber.setText(mPersonal.getPhoneNo());
        mTvBirthdayDate.setText(mPersonal.getBirthday());
        mTvMobilePhoneNumber.setText(mPersonal.getMobileNo());
        mTvAddressDetail.setText(mPersonal.getAddress());
    }

    /**
     * 查询个人信息
     */
    private void queryUserInfo() {
        QueryPersonalRequest request = new QueryPersonalRequest();
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.PERSONAL_QUERY_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                LogUtil.e("{" + e.toString() + "}");
            }

            @Override
            public void onSuccess(String response) {
                QueryPersonalResult result = JSON.parseObject(response, QueryPersonalResult.class);
                LogUtil.i(response);

                if (result.getResultCode() == 0) {
                    mPersonal = result.getPersonal();
                    if (mHandler != null) {
                        mHandler.sendEmptyMessage(UPDATE_USER_INFO);
                    }
                } else {
                    OwerToastShow.show(result.getMessage());
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRlTitle.clearRegister();
    }
}
