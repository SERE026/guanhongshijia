package com.wckj.gfsj.Bean.entity;


import com.wckj.gfsj.Bean.entity.common.BaseEntity;

/**
 * Created by Administrator on 2016/7/29.
 */
public class Personal extends BaseEntity {

    //昵称
    private String nickName;
    //真实姓名
    private String realName;
    //手机号码
    private String mobileNo;
    //邮箱
    private String email;
    //生日
    private String birthday;
    //电话号码
    private String phoneNo;
    //地址
    private String address;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "nickName='" + nickName + '\'' +
                ", realName='" + realName + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
