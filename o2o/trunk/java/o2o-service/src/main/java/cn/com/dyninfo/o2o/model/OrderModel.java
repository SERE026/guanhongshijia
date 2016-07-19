package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class OrderModel implements Serializable {
    private Integer id;

    private String orderId;

    private String state;

    private String status;

    private String addressId;

    private String countId;

    private String cityId;

    private String provinceId;

    private String sendtime;

    private String sendstate;

    private String isPay;

    private String time;

    private String paytime;

    private String shouMen;

    private String postcode;

    private String address;

    private String shouPhone;

    private String shouTel;

    private String addressinfoId;

    private String payType;

    private String sendType;

    private String huiyuanId;

    private String goodsId;

    private String sendorderId;

    private String paymentId;

    private String refundorderId;

    private String returnedorderId;

    private String receiveAddress;

    private Integer applyRefundTime;

    private String receiveCode;

    private Integer createTime;

    private Double discountPrice;

    private String dlyCode;

    private String receiveEmail;

    private Integer ipaytime;

    private String isRefund;

    private Double orderPrice;

    private Double originalPrice;

    private Integer point;

    private Double protectPrice;

    private String receiveDate;

    private String receiveName;

    private String receivePhone;

    private Integer marchantsId;

    private String receiveTel;

    private Integer refundTime;

    private Double shippingPrice;

    private Double weight;

    private String countyId;

    private Integer dlytypeId;

    private Integer wlcompanyId;

    private String dly;

    private Integer playType;

    private String tradeno;

    private Double pointPrice;

    private Integer isendtime;

    private Integer isuretime;

    private String suretime;

    private Float priceSum;

    private String isReturn;

    private String endtime;

    private Integer account;

    private String huistat;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId == null ? null : addressId.trim();
    }

    public String getCountId() {
        return countId;
    }

    public void setCountId(String countId) {
        this.countId = countId == null ? null : countId.trim();
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime == null ? null : sendtime.trim();
    }

    public String getSendstate() {
        return sendstate;
    }

    public void setSendstate(String sendstate) {
        this.sendstate = sendstate == null ? null : sendstate.trim();
    }

    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay == null ? null : isPay.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime == null ? null : paytime.trim();
    }

    public String getShouMen() {
        return shouMen;
    }

    public void setShouMen(String shouMen) {
        this.shouMen = shouMen == null ? null : shouMen.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getShouPhone() {
        return shouPhone;
    }

    public void setShouPhone(String shouPhone) {
        this.shouPhone = shouPhone == null ? null : shouPhone.trim();
    }

    public String getShouTel() {
        return shouTel;
    }

    public void setShouTel(String shouTel) {
        this.shouTel = shouTel == null ? null : shouTel.trim();
    }

    public String getAddressinfoId() {
        return addressinfoId;
    }

    public void setAddressinfoId(String addressinfoId) {
        this.addressinfoId = addressinfoId == null ? null : addressinfoId.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType == null ? null : sendType.trim();
    }

    public String getHuiyuanId() {
        return huiyuanId;
    }

    public void setHuiyuanId(String huiyuanId) {
        this.huiyuanId = huiyuanId == null ? null : huiyuanId.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getSendorderId() {
        return sendorderId;
    }

    public void setSendorderId(String sendorderId) {
        this.sendorderId = sendorderId == null ? null : sendorderId.trim();
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId == null ? null : paymentId.trim();
    }

    public String getRefundorderId() {
        return refundorderId;
    }

    public void setRefundorderId(String refundorderId) {
        this.refundorderId = refundorderId == null ? null : refundorderId.trim();
    }

    public String getReturnedorderId() {
        return returnedorderId;
    }

    public void setReturnedorderId(String returnedorderId) {
        this.returnedorderId = returnedorderId == null ? null : returnedorderId.trim();
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress == null ? null : receiveAddress.trim();
    }

    public Integer getApplyRefundTime() {
        return applyRefundTime;
    }

    public void setApplyRefundTime(Integer applyRefundTime) {
        this.applyRefundTime = applyRefundTime;
    }

    public String getReceiveCode() {
        return receiveCode;
    }

    public void setReceiveCode(String receiveCode) {
        this.receiveCode = receiveCode == null ? null : receiveCode.trim();
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getDlyCode() {
        return dlyCode;
    }

    public void setDlyCode(String dlyCode) {
        this.dlyCode = dlyCode == null ? null : dlyCode.trim();
    }

    public String getReceiveEmail() {
        return receiveEmail;
    }

    public void setReceiveEmail(String receiveEmail) {
        this.receiveEmail = receiveEmail == null ? null : receiveEmail.trim();
    }

    public Integer getIpaytime() {
        return ipaytime;
    }

    public void setIpaytime(Integer ipaytime) {
        this.ipaytime = ipaytime;
    }

    public String getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(String isRefund) {
        this.isRefund = isRefund == null ? null : isRefund.trim();
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Double getProtectPrice() {
        return protectPrice;
    }

    public void setProtectPrice(Double protectPrice) {
        this.protectPrice = protectPrice;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate == null ? null : receiveDate.trim();
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName == null ? null : receiveName.trim();
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone == null ? null : receivePhone.trim();
    }

    public Integer getMarchantsId() {
        return marchantsId;
    }

    public void setMarchantsId(Integer marchantsId) {
        this.marchantsId = marchantsId;
    }

    public String getReceiveTel() {
        return receiveTel;
    }

    public void setReceiveTel(String receiveTel) {
        this.receiveTel = receiveTel == null ? null : receiveTel.trim();
    }

    public Integer getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Integer refundTime) {
        this.refundTime = refundTime;
    }

    public Double getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(Double shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId == null ? null : countyId.trim();
    }

    public Integer getDlytypeId() {
        return dlytypeId;
    }

    public void setDlytypeId(Integer dlytypeId) {
        this.dlytypeId = dlytypeId;
    }

    public Integer getWlcompanyId() {
        return wlcompanyId;
    }

    public void setWlcompanyId(Integer wlcompanyId) {
        this.wlcompanyId = wlcompanyId;
    }

    public String getDly() {
        return dly;
    }

    public void setDly(String dly) {
        this.dly = dly == null ? null : dly.trim();
    }

    public Integer getPlayType() {
        return playType;
    }

    public void setPlayType(Integer playType) {
        this.playType = playType;
    }

    public String getTradeno() {
        return tradeno;
    }

    public void setTradeno(String tradeno) {
        this.tradeno = tradeno == null ? null : tradeno.trim();
    }

    public Double getPointPrice() {
        return pointPrice;
    }

    public void setPointPrice(Double pointPrice) {
        this.pointPrice = pointPrice;
    }

    public Integer getIsendtime() {
        return isendtime;
    }

    public void setIsendtime(Integer isendtime) {
        this.isendtime = isendtime;
    }

    public Integer getIsuretime() {
        return isuretime;
    }

    public void setIsuretime(Integer isuretime) {
        this.isuretime = isuretime;
    }

    public String getSuretime() {
        return suretime;
    }

    public void setSuretime(String suretime) {
        this.suretime = suretime == null ? null : suretime.trim();
    }

    public Float getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(Float priceSum) {
        this.priceSum = priceSum;
    }

    public String getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(String isReturn) {
        this.isReturn = isReturn == null ? null : isReturn.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getHuistat() {
        return huistat;
    }

    public void setHuistat(String huistat) {
        this.huistat = huistat == null ? null : huistat.trim();
    }
}