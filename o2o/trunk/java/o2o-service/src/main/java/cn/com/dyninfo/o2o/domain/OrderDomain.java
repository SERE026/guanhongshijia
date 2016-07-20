package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.OrderModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class OrderDomain extends OrderModel {


    private ZffsDomain zffsDomain ;
    private List<OrderProductDomain> orderProductList;
    private DlyTypeDomain dlyType;
    private WlCompanyDomain wlcompany;
    private AreaXInfoDomain province;
    private AreaXInfoDomain city;
    private AreaXInfoDomain county;
    private HuiyuanInfoDomain huiyuan;
    private ShangjiaInfoDomain merchants;
    private PaymentDomain payment;
    private RefundOrderDomain refundorder;
    private ReturneOrderDomain returnedorder;
    private SendOrderDomain sendorder;

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

    public DlyTypeDomain getDlyType() {
        return dlyType;
    }

    public void setDlyType(DlyTypeDomain dlyType) {
        this.dlyType = dlyType;
    }

    public WlCompanyDomain getWlcompany() {
        return wlcompany;
    }

    public void setWlcompany(WlCompanyDomain wlcompany) {
        this.wlcompany = wlcompany;
    }

    public AreaXInfoDomain getProvince() {
        return province;
    }

    public void setProvince(AreaXInfoDomain province) {
        this.province = province;
    }

    public AreaXInfoDomain getCity() {
        return city;
    }

    public void setCity(AreaXInfoDomain city) {
        this.city = city;
    }

    public AreaXInfoDomain getCounty() {
        return county;
    }

    public void setCounty(AreaXInfoDomain county) {
        this.county = county;
    }

    public HuiyuanInfoDomain getHuiyuan() {
        return huiyuan;
    }

    public void setHuiyuan(HuiyuanInfoDomain huiyuan) {
        this.huiyuan = huiyuan;
    }

    public ShangjiaInfoDomain getMerchants() {
        return merchants;
    }

    public void setMerchants(ShangjiaInfoDomain merchants) {
        this.merchants = merchants;
    }

    public PaymentDomain getPayment() {
        return payment;
    }

    public void setPayment(PaymentDomain payment) {
        this.payment = payment;
    }

    public RefundOrderDomain getRefundorder() {
        return refundorder;
    }

    public void setRefundorder(RefundOrderDomain refundorder) {
        this.refundorder = refundorder;
    }

    public ReturneOrderDomain getReturnedorder() {
        return returnedorder;
    }

    public void setReturnedorder(ReturneOrderDomain returnedorder) {
        this.returnedorder = returnedorder;
    }

    public SendOrderDomain getSendorder() {
        return sendorder;
    }

    public void setSendorder(SendOrderDomain sendorder) {
        this.sendorder = sendorder;
    }
}
