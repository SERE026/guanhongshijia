package cn.com.dyninfo.o2o.entity;

/**
 * Created by dyninfo on 2016/8/23.
 */
public class AddressMember {

    private String receiveName;//收件人姓名
    private String receiveTel;//收件人电话
    private String receivePhone;//收件人手机
    private String address;//街道地址
    private String code;//邮政编码
    private String email;//邮箱
    private String receiveDate;//工作日期
    private String province;//省ID
    private String city;//市ID
    private String county;//区ID

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceiveTel() {
        return receiveTel;
    }

    public void setReceiveTel(String receiveTel) {
        this.receiveTel = receiveTel;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public String toString() {
        return "AddressMember{" +
                "receiveName='" + receiveName + '\'' +
                ", receiveTel='" + receiveTel + '\'' +
                ", receivePhone='" + receivePhone + '\'' +
                ", address='" + address + '\'' +
                ", code='" + code + '\'' +
                ", email='" + email + '\'' +
                ", receiveDate='" + receiveDate + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                '}';
    }
}
