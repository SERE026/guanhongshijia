package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.OrderModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class OrderDomain extends OrderModel {


    private ZffsDomain zffsDomain ;
    private List<OrderProductDomain> orderProductList;
    private DlytypeDomain dlyType;
    private WlcompanyDomain wlcompany;
    private AreaInfoDomain province;
    private AreaInfoDomain city;
    private AreaInfoDomain county;
    private HuiyuanInfoDomain huiyuan;
    private ShangJiaInfoDomain merchants;
    private PaymentDomain payment;
    private RefundorderDomain refundorder;
    private ReturnedorderDomain returnedorder;
    private SendorderDomain sendorder;

    public ZffsDomain getZffsDomain() {
        return zffsDomain;
    }

    public void setZffsDomain(ZffsDomain zffsDomain) {
        this.zffsDomain = zffsDomain;
    }

    public List<OrderProductDomain> getOrderProductList() {
        return orderProductList;
    }

    public void setOrderProductList(List<OrderProductDomain> orderProductList) {
        this.orderProductList = orderProductList;
    }

    public DlytypeDomain getDlyType() {
        return dlyType;
    }

    public void setDlyType(DlytypeDomain dlyType) {
        this.dlyType = dlyType;
    }

    public WlcompanyDomain getWlcompany() {
        return wlcompany;
    }

    public void setWlcompany(WlcompanyDomain wlcompany) {
        this.wlcompany = wlcompany;
    }

    public AreaInfoDomain getProvince() {
        return province;
    }

    public void setProvince(AreaInfoDomain province) {
        this.province = province;
    }

    public AreaInfoDomain getCity() {
        return city;
    }

    public void setCity(AreaInfoDomain city) {
        this.city = city;
    }

    public AreaInfoDomain getCounty() {
        return county;
    }

    public void setCounty(AreaInfoDomain county) {
        this.county = county;
    }

    public HuiyuanInfoDomain getHuiyuan() {
        return huiyuan;
    }

    public void setHuiyuan(HuiyuanInfoDomain huiyuan) {
        this.huiyuan = huiyuan;
    }

    public ShangJiaInfoDomain getMerchants() {
        return merchants;
    }

    public void setMerchants(ShangJiaInfoDomain merchants) {
        this.merchants = merchants;
    }

    public PaymentDomain getPayment() {
        return payment;
    }

    public void setPayment(PaymentDomain payment) {
        this.payment = payment;
    }

    public RefundorderDomain getRefundorder() {
        return refundorder;
    }

    public void setRefundorder(RefundorderDomain refundorder) {
        this.refundorder = refundorder;
    }

    public ReturnedorderDomain getReturnedorder() {
        return returnedorder;
    }

    public void setReturnedorder(ReturnedorderDomain returnedorder) {
        this.returnedorder = returnedorder;
    }

    public SendorderDomain getSendorder() {
        return sendorder;
    }

    public void setSendorder(SendorderDomain sendorder) {
        this.sendorder = sendorder;
    }
}
