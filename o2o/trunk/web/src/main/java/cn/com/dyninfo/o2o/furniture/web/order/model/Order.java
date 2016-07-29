/*
 * Copyright (c) 2009-2016 SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 * All rights reserved.
 *
 * This file contains valuable properties of  SHENZHEN Eternal Dynasty
 * Technology Co.,Ltd.,  embodying  substantial  creative efforts  and
 * confidential information, ideas and expressions.    No part of this
 * file may be reproduced or distributed in any form or by  any  means,
 * or stored in a data base or a retrieval system,  without  the prior
 * written permission  of  SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 *
 */

package cn.com.dyninfo.o2o.furniture.web.order.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import cn.com.dyninfo.o2o.furniture.admin.model.CouponOrderRel;
import org.hibernate.annotations.AccessType;

import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.setting.model.Zffs;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.wuliu.model.Dlytype;
import cn.com.dyninfo.o2o.furniture.web.wuliu.model.Wlcompany;
/***
 * 定单
 * @author Administrator
 *
 */
@Entity
@Table(name="T_ORDER")
public class Order implements Serializable{

	
	private static final long serialVersionUID = 2169673533341100449L;
	
	@Id
	@AccessType(value = "property")
	@Column(name="ORDER_ID",length=32)
	private String order_id;
	
	@AccessType("property")
	@Column(name="TRADENO")
	private String tradeNo="0";//
	
	@AccessType("property")
	@Column(name="STATE")
	private String state="0";//0.等待付款 1.已付款 2.已发货3.确认完成4.申请退款5.申请退货6.交易失败 7.已付定金 8.代理商确认付款
	/**
	 * 0等待付款 可以删除订单
	 * 1已付款  可以申请退款 15天后自动退回账户  
	 * 2已发货  可以申请退款 退货 
	 * 					  退款 客户自己支付邮费
	 * 3确认完成
	 * 4申请退款
	 * 5申请退货
	 * 6交易失败(退款和客户取消订单)
	 */
	@AccessType("property")
	@Column(name="STATUS")
	private String status="0";//0.不删除 1.删除
	
	@AccessType("property")
	@Column(name="HUISTAT")
	private String huistat="0";//回收站状态 0.不删除 1.删除
	
	@AccessType("property")
	@Column(name="IS_REFUND")
	private String is_refund="0";//0无状态 1申请退款中 2已退款 
	
	@AccessType("property")
	@Column(name="IS_RETURN")
	private String is_return="0";//0无状态 1申请退货中 2已退货 
	
	@AccessType("property")
	@Column(name="APPLY_REFUND_TIME")
	private int applyRefundTime;//申请退款时间 
	 
	@AccessType("property")
	@Column(name="REFUND_TIME")
	private int refundTime;//退款时间
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLAY_TYPE")
	private Zffs playType ;  //支付方式
	
	@AccessType(value = "property")
	@Column(name = "DLY")
	private String dly;//1 物流 0上门提货
	
	@AccessType("property")
	@Column(name="IS_PAY")
	private String isPay="0";//是否支付0.没支付 1.已经支付
	
	@AccessType("property")
	@Column(name="CREATE_TIME")
	private int creatTime;//下单时间
	
	@AccessType("property")
	@Column(name="TIME")
	private String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//下单时间
	
	@AccessType("property")
	@Column(name="ISENDTIME")
	private int isendtime=0;//发货时间
	
	@AccessType("property")
	@Column(name="SENDTIME")
	private String sendtime;//发货时间
	
	@AccessType("property")
	@Column(name="ISURETIME")
	private int isuretime;//确认收货时间
	
	@AccessType("property")
	@Column(name="SURETIME")
	private String suretime;//确认收货时间 成交时间
	
	@AccessType("property")
	@Column(name="IPAYTIME")
	private int ipaytime=0;//付款时间
	
	@AccessType("property")
	@Column(name="PAYTIME")
	private String paytime;//付款时间
	
	@AccessType("property")
	@Column(name="ENDTIME")
	private String endTime;//订单完成时间
	
	@AccessType("property")
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="order")
	private List<OrderProduct> orderProductList; //订单物品信息
	
	@AccessType("property")
	@Column(name="ORIGINAL_PRICE")
	private Double originalPrice; //原始总价,未经过任何优惠的
	
	@AccessType("property")
	@Column(name="PRICE_SUM")
	private Double goodsPrice; //商品价格，经过优惠过的(商品销售价 减去 活动优惠价格)
	
	@AccessType("property")
	@Column(name="ORDER_PRICE")
	private Double orderPrice;//订单总价，优惠过的，包含商品价格 减去优惠价格 减去积分支付金额 加上配送费用 加上保价费用
	
	@AccessType("property")
	@Column(name="ACCOUNT")
	private int account=1;//是否优先使用账户支付 0 是 1否



	@AccessType("property")
	@Column(name="AGENCY_FEE")
	private Double agencyFee=0d; //佣金金额

	@AccessType("property")
	@Column(name = "AGENCY_PAY")
	private Byte agencyPay;//是否已确认佣金-0：否；1-是

	@AccessType("property")
	@Column(name="DEPOSIT_AMOUNT")
	private Double depositAmount=0d; //存入金额


	@AccessType("property")
	@Column(name = "PAY_DESC")
	private String payDesc;//支付备注，代理商填写，用于线下支付填写付款人、付款帐号等

	/**
	 * 如果优先使用账户支付，先检查账户金额，如果账户金额不足，再使用在线支付方式
	 */
	
	@AccessType("property")
	@Column(name="DISCOUNT_PRICE")
	private Double discountPrice; //优惠的价格
	
	@AccessType("property")
	@Column(name="POINT_PRICE")
	private Double pointPrice; //积分支付金额
	
	@AccessType("property")
	@Column(name="SHIPPING_PRICE")
	private Double shippingPrice; //配送费用
	
	@AccessType("property")
	@Column(name="PROTECT_PRICE")
	private  Double protectPrice=0d; //保价费用
	
	@AccessType("property")
	@Column(name="WEIGHT")
	private Double weight=0d ; //商品重量
	
	@AccessType("property")
	@Column(name="POINT")
	private Integer point=0; //可获得积分
	
	
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DLYTYPE_ID")
	private Dlytype dlyType; //配送方式
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WLCOMPANY_ID")
	private Wlcompany wlcompany; //物流公司
	 
	@AccessType(value = "property")
	@Column(name = "DLY_CODE")
	private String dlyCode; //物流编号 发货物流(运单号码)
	
	@AccessType("property")
	@Column(name="SENDSTATE")
	private String sendstate="0";//是否发货 0.未发货 1.已发货  
	
	 @AccessType(value="property")
	  @Column(name="RECEIVE_NAME")
	  private String receiveName;//收件人姓名
	  
	  @AccessType(value="property")
	  @Column(name="RECEIVE_TEL")
	  private String receiveTel;//收件人电话
	  
	  @AccessType(value="property")
	  @Column(name="RECEIVE_PHONE")
	  private String receivePhone;//收件人手机
	  
	  @AccessType(value = "property")
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "PROVINCE_ID")
	  private AreaInfo province;
	  
	  @AccessType(value = "property")
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "CITY_ID")
	  private AreaInfo city;
	  
	  @AccessType(value = "property")
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "COUNTY_ID")
	  private AreaInfo county;
	  
	  @AccessType(value="property")
	  @Column(name="RECEIVE_ADDRESS")
	  private String address;
	  
	  @AccessType(value="property")
	  @Column(name="RECEIVE_CODE")
	  private String code;

	  
	  @AccessType(value="property")
	  @Column(name="RECEIVE_EMAIL")
	  private String email;
	  
	  
	@AccessType(value="property")
	@Column(name="RECEIVE_DATE")
	private String receiveDate;
	
	@AccessType("property")
	@Column(name="PAY_TYPE")
	private String payType="0";//弃用
	
	@AccessType("property")
	@Column(name="SEND_TYPE")
	private String sendType;//快递  请查看 dlyType 0自己上门提货 1快递
	
	@AccessType("property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="HUIYUAN_ID")
	private HuiyuanInfo huiyuan;//会员
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MARCHANTS_ID")
	private ShangJiaInfo merchants;//如果对象是商家 此字段应有值
	

	@AccessType(value = "property")
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PAYMENT_ID")
	private Payment payment;  //收款单
	
	@AccessType(value = "property")
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="REFUNDORDER_ID")
	private Refundorder refundorder;  //退款单
	
	@AccessType(value = "property")
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RETURNEDORDER_ID")
	private Returnedorder returnedorder;  //退货单
	
	@AccessType(value = "property")
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SENDORDER_ID")
	private Sendorder sendorder;  //发货单


	@AccessType(value = "property")
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="order")
	private List<CouponOrderRel> couponOrderRel;

	public Double getAgencyFee() {
		return agencyFee;
	}

	public void setAgencyFee(Double agencyFee) {
		this.agencyFee = agencyFee;
	}

	public String getPayDesc() {
		return payDesc;
	}

	public void setPayDesc(String payDesc) {
		this.payDesc = payDesc;
	}
	public Double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}
	/**
	 * @return the order_id
	 */
	public String getOrder_id() {
		return order_id;
	}

	/**
	 * @param order_id the order_id to set
	 */
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the isPay
	 */
	public String getIsPay() {
		return isPay;
	}

	/**
	 * @param isPay the isPay to set
	 */
	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}

	/**
	 * @return the creatTime
	 */
	public int getCreatTime() {
		return creatTime;
	}

	/**
	 * @param creatTime the creatTime to set
	 */
	public void setCreatTime(int creatTime) {
		this.creatTime = creatTime;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the ipaytime
	 */
	public int getIpaytime() {
		return ipaytime;
	}

	/**
	 * @param ipaytime the ipaytime to set
	 */
	public void setIpaytime(int ipaytime) {
		this.ipaytime = ipaytime;
	}

	/**
	 * @return the paytime
	 */
	public String getPaytime() {
		return paytime;
	}

	/**
	 * @param paytime the paytime to set
	 */
	public void setPaytime(String paytime) {
		this.paytime = paytime;
	}

	/**
	 * @return the originalPrice
	 */
	public Double getOriginalPrice() {
		return originalPrice;
	}

	/**
	 * @param originalPrice the originalPrice to set
	 */
	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	/**
	 * @return the goodsPrice
	 */
	public Double getGoodsPrice() {
		return goodsPrice;
	}

	/**
	 * @param goodsPrice the goodsPrice to set
	 */
	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	/**
	 * @return the orderPrice
	 */
	public Double getOrderPrice() {
		return orderPrice;
	}

	/**
	 * @param orderPrice the orderPrice to set
	 */
	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	/**
	 * @return the discountPrice
	 */
	public Double getDiscountPrice() {
		return discountPrice;
	}

	/**
	 * @param discountPrice the discountPrice to set
	 */
	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	/**
	 * @return the shippingPrice
	 */
	public Double getShippingPrice() {
		return shippingPrice;
	}

	/**
	 * @param shippingPrice the shippingPrice to set
	 */
	public void setShippingPrice(Double shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	/**
	 * @return the protectPrice
	 */
	public Double getProtectPrice() {
		return protectPrice;
	}

	/**
	 * @param protectPrice the protectPrice to set
	 */
	public void setProtectPrice(Double protectPrice) {
		this.protectPrice = protectPrice;
	}

	/**
	 * @return the weight
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	/**
	 * @return the point
	 */
	public Integer getPoint() {
		return point;
	}

	/**
	 * @param point the point to set
	 */
	public void setPoint(Integer point) {
		this.point = point;
	}

	/**
	 * @return the dlyType
	 */
	public Dlytype getDlyType() {
		return dlyType;
	}

	/**
	 * @param dlyType the dlyType to set
	 */
	public void setDlyType(Dlytype dlyType) {
		this.dlyType = dlyType;
	}

	/**
	 * @return the wlcompany
	 */
	public Wlcompany getWlcompany() {
		return wlcompany;
	}

	/**
	 * @param wlcompany the wlcompany to set
	 */
	public void setWlcompany(Wlcompany wlcompany) {
		this.wlcompany = wlcompany;
	}

	/**
	 * @return the dlyCode
	 */
	public String getDlyCode() {
		return dlyCode;
	}

	/**
	 * @param dlyCode the dlyCode to set
	 */
	public void setDlyCode(String dlyCode) {
		this.dlyCode = dlyCode;
	}

	/**
	 * @return the sendstate
	 */
	public String getSendstate() {
		return sendstate;
	}

	/**
	 * @param sendstate the sendstate to set
	 */
	public void setSendstate(String sendstate) {
		this.sendstate = sendstate;
	}

	/**
	 * @return the receiveName
	 */
	public String getReceiveName() {
		return receiveName;
	}

	/**
	 * @param receiveName the receiveName to set
	 */
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	/**
	 * @return the receiveTel
	 */
	public String getReceiveTel() {
		return receiveTel;
	}

	/**
	 * @param receiveTel the receiveTel to set
	 */
	public void setReceiveTel(String receiveTel) {
		this.receiveTel = receiveTel;
	}

	/**
	 * @return the receivePhone
	 */
	public String getReceivePhone() {
		return receivePhone;
	}

	/**
	 * @param receivePhone the receivePhone to set
	 */
	public void setReceivePhone(String receivePhone) {
		this.receivePhone = receivePhone;
	}

	/**
	 * @return the province
	 */
	public AreaInfo getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(AreaInfo province) {
		this.province = province;
	}

	/**
	 * @return the city
	 */
	public AreaInfo getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(AreaInfo city) {
		this.city = city;
	}

	/**
	 * @return the county
	 */
	public AreaInfo getCounty() {
		return county;
	}

	/**
	 * @param county the county to set
	 */
	public void setCounty(AreaInfo county) {
		this.county = county;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the receiveDate
	 */
	public String getReceiveDate() {
		return receiveDate;
	}

	/**
	 * @param receiveDate the receiveDate to set
	 */
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}

	/**
	 * @return the payType
	 */
	public String getPayType() {
		return payType;
	}

	/**
	 * @param payType the payType to set
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}

	/**
	 * @return the sendType
	 */
	public String getSendType() {
		return sendType;
	}

	/**
	 * @param sendType the sendType to set
	 */
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	/**
	 * @return the huiyuan
	 */
	public HuiyuanInfo getHuiyuan() {
		return huiyuan;
	}

	/**
	 * @param huiyuan the huiyuan to set
	 */
	public void setHuiyuan(HuiyuanInfo huiyuan) {
		this.huiyuan = huiyuan;
	}

	/**
	 * @return the merchants
	 */
	public ShangJiaInfo getMerchants() {
		return merchants;
	}

	/**
	 * @param merchants the merchants to set
	 */
	public void setMerchants(ShangJiaInfo merchants) {
		this.merchants = merchants;
	}

	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/**
	 * @return the refundorder
	 */
	public Refundorder getRefundorder() {
		return refundorder;
	}

	/**
	 * @param refundorder the refundorder to set
	 */
	public void setRefundorder(Refundorder refundorder) {
		this.refundorder = refundorder;
	}

	/**
	 * @return the returnedorder
	 */
	public Returnedorder getReturnedorder() {
		return returnedorder;
	}

	/**
	 * @param returnedorder the returnedorder to set
	 */
	public void setReturnedorder(Returnedorder returnedorder) {
		this.returnedorder = returnedorder;
	}

	/**
	 * @return the sendorder
	 */
	public Sendorder getSendorder() {
		return sendorder;
	}

	/**
	 * @param sendorder the sendorder to set
	 */
	public void setSendorder(Sendorder sendorder) {
		this.sendorder = sendorder;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * @return the orderProductList
	 */
	public List<OrderProduct> getOrderProductList() {
		return orderProductList;
	}

	/**
	 * @param orderProductList the orderProductList to set
	 */
	public void setOrderProductList(List<OrderProduct> orderProductList) {
		this.orderProductList = orderProductList;
	}

	/**
	 * @return the is_refund
	 */
	public String getIs_refund() {
		return is_refund;
	}

	/**
	 * @param is_refund the is_refund to set
	 */
	public void setIs_refund(String is_refund) {
		this.is_refund = is_refund;
	}

	/**
	 * @return the applyRefundTime
	 */
	public int getApplyRefundTime() {
		return applyRefundTime;
	}

	/**
	 * @param applyRefundTime the applyRefundTime to set
	 */
	public void setApplyRefundTime(int applyRefundTime) {
		this.applyRefundTime = applyRefundTime;
	}

	/**
	 * @return the refundTime
	 */
	public int getRefundTime() {
		return refundTime;
	}

	/**
	 * @param refundTime the refundTime to set
	 */
	public void setRefundTime(int refundTime) {
		this.refundTime = refundTime;
	}

	/**
	 * @return the playType
	 */
	public Zffs getPlayType() {
		return playType;
	}

	/**
	 * @param playType the playType to set
	 */
	public void setPlayType(Zffs playType) {
		this.playType = playType;
	}

	/**
	 * @return the dly
	 */
	public String getDly() {
		return dly;
	}

	/**
	 * @param dly the dly to set
	 */
	public void setDly(String dly) {
		this.dly = dly;
	}

	/**
	 * @return the tradeNo
	 */
	public String getTradeNo() {
		return tradeNo;
	}

	/**
	 * @param tradeNo the tradeNo to set
	 */
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	/**
	 * @return the pointPrice
	 */
	public Double getPointPrice() {
		return pointPrice;
	}

	/**
	 * @param pointPrice the pointPrice to set
	 */
	public void setPointPrice(Double pointPrice) {
		this.pointPrice = pointPrice;
	}

	public int getIsendtime() {
		return isendtime;
	}

	public void setIsendtime(int isendtime) {
		this.isendtime = isendtime;
	}

	public String getSendtime() {
		return sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public int getIsuretime() {
		return isuretime;
	}

	public void setIsuretime(int isuretime) {
		this.isuretime = isuretime;
	}

	public String getSuretime() {
		return suretime;
	}

	public void setSuretime(String suretime) {
		this.suretime = suretime;
	}

	/**
	 * @return the is_return
	 */
	public String getIs_return() {
		return is_return;
	}

	/**
	 * @param is_return the is_return to set
	 */
	public void setIs_return(String is_return) {
		this.is_return = is_return;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the account
	 */
	public int getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(int account) {
		this.account = account;
	}

	public String getHuistat() {
		return huistat;
	}

	public void setHuistat(String huistat) {
		this.huistat = huistat;
	}

	public List<CouponOrderRel> getCouponOrderRel() {
		return couponOrderRel;
	}

	public void setCouponOrderRel(List<CouponOrderRel> couponOrderRel) {
		this.couponOrderRel = couponOrderRel;
	}

	public Byte getAgencyPay() {
		return agencyPay;
	}

	public void setAgencyPay(Byte agencyPay) {
		this.agencyPay = agencyPay;
	}
}
