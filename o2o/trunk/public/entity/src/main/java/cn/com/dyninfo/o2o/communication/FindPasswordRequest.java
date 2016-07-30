package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseRequest;

/**
 * 找回锁定/登录密码请求类
 * request URL: https://serverurl/app/user/findLockPassword
 * request URL: https://serverurl/app/user/findLoginPassword
 * request method: post
 */
public class FindPasswordRequest extends BaseRequest {

    private String mobileNo;

    private String validateCode;

    private String newPassword;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
