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

package cn.com.dyninfo.o2o.furniture.web.goods.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.AccessType;

import cn.com.dyninfo.o2o.furniture.util.HtmlToText;

import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;


/**
 * 上架销售的产品
 * 当一个产品进行上架时 就添加一个货品对象 货品对象有产品的所有属性
 * 当商家修改产品时 判断货品是否有过卖出记录如果有就将货品下架 同时新增一个货品 关联当前产品
 * 
 * @author 王敏
 *
 */
@Entity
@Table(name="T_PRODUCT")
public class Product {

	@Id
	@AccessType(value = "property")
	@Column(name="PRODUCT_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int product_id;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GOODS_ID")
	private Goods good;
	
	@AccessType(value = "property")
	@Column(name="CODE")
	private String code;//商品编号
	
	@AccessType(value = "property")
	@Column(name="NAME")
	private String name;//商品名称
	
	@AccessType(value = "property")
	@Column(name="SHELVES")
	private String shelves="0";//是否上架 0是 1不是
	
	@AccessType(value = "property")
	@Column(name="TRYUSE")
	private String tryuse="0";//是否试用 0不是 1是
	
	@AccessType(value = "property")
	@Column(name="MFIMAGES")
	private String mfimages;//免费试用封面图片;分开

	@AccessType(value = "property")
	@Column(name="TRYNO")
	private int tryno=0;//试用份数
	
	@AccessType(value = "property")
	@Column(name="PEPOLENO")
	private int pepoleno=0;//试用人数
	
	@AccessType(value = "property")
	@OneToMany(fetch=FetchType.LAZY,mappedBy="goods")
	private List<TryuseApply> applyList;//试用申请
	
	@AccessType(value = "property")
	@Column(name="BTIME")
	private String btime;//试用开始时间
	
	@AccessType(value = "property")
	@Column(name="ETIME")
	private String etime;///试用结束时间
	
	@AccessType(value = "property")
	@Column(name="IMG")
	private String img;//商品图片路径
	
	@AccessType(value = "property")
	@Column(name="SALESNUM")
	private int salesNum=0;//销量
	
	@AccessType(value = "property")
	@Column(name="SALESMONEY")
	private Double salesMoney = 0.0;//销售价格
	
	@AccessType(value = "property")
	@Column(name="BAZAARMONEY")
	private Double bazaarMoney = 0.0;//市场价格
	
	@AccessType(value = "property")
	@Column(name="HUIYUANMONEY")
	private Double huiyuanMoney = 0.0;//会员价格
	
	@AccessType(value = "property")
	@Column(name="COSTSMONEY")
	private Double costsMoney = 0.0;//成本价格
	
	@AccessType(value = "property")
	@Column(name="WEIGHT")
	private Double weight = 0.0;//重量
	
	
	@AccessType(value = "property")
	@Column(name="INVENTORY")
	private Double inventory = 0.0;//库存数量
	
	
	@AccessType(value = "property")
	@Column(name="GOODSDESCRIPTION")
	private String goodsDescription;//产品描述
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DELIVERY_ID")
	private GoodsDelivery delivery;//配送方式
	
	@AccessType(value = "property")
	@Column(name="GOODSPARAMETER")
	private String goodsParameter;//产品参数
	
	@AccessType(value = "property")
	@Column(name="GOODSSTORY")
	private String goodsStory;//产品故事
	
	@AccessType(value = "property")
	@Column(name="GOODSAUTHORIZATION")
	private String goodsAuthorization;//产品授权
	
	/**
	 * 0最新商品1促销2精品推荐3热销产品  以逗号分割
	 */
	@AccessType(value = "property")
	@Column(name="BIAOQIAN")
	private String biaoqian;//标签 
	
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MARCHANTS_ID")
	private ShangJiaInfo merchants;//如果对象是商家 此字段应有值
	
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GOODSSORT_ID")
	private GoodsSort goodsSort;// 商品分类
	
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GOODSTYPE_ID")
	private GoodsType goodsType;//商品类型
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOM_SORT_ID")
	private GoodsSort customSort;//自定义分类
	
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRAND_ID")
	private Brand brand;//品牌
	
	@AccessType(value = "property")
	@Column(name="INDEXS")
	private String indexs;
	
	
	@AccessType(value = "property")
	@Column(name="SJ_TIME")
	private String sj_time;//上架时间
	
	
	@AccessType(value = "property")
	@Column(name="SYS_TIME")
	private String sys_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//系统时间
	
	@AccessType(value = "property")
	@Column(name="STATE")
	private String state="0";//0 不删 1删除
	
	@AccessType(value = "property")
	@Column(name="TYPESPEC")
	private String typeSpec;//类型属性
	
	@AccessType(value = "property")
	@Column(name="DEFAULT_IAMAGE")
	private String defaultImage;//商品默认图片
	
	@AccessType(value = "property")
	@Column(name="IMAGES")
	private String images;//;分开
	
	@AccessType(value = "property")
	@OneToMany(fetch=FetchType.LAZY,mappedBy="product")
	private List<GoodsSpec> specList;//产品参数
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_0")
	private String specValue0;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_1")
	private String specValue1;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_2")
	private String specValue2;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_3")
	private String specValue3;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_4")
	private String specValue4;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_5")
	private String specValue5;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_6")
	private String specValue6;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_7")
	private String specValue7;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_8")
	private String specValue8;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_9")
	private String specValue9;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_10")
	private String specValue10;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_11")
	private String specValue11;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_12")
	private String specValue12;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_13")
	private String specValue13;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_14")
	private String specValue14;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_15")
	private String specValue15;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_16")
	private String specValue16;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_17")
	private String specValue17;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_18")
	private String specValue18;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_19")
	private String specValue19;

	@Transient
	private String pz;
	/**
	 * @return the product_id
	 */
	public int getProduct_id() {
		return product_id;
	}

	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	/**
	 * @return the good
	 */
	public Goods getGood() {
		return good;
	}

	/**
	 * @param good the good to set
	 */
	public void setGood(Goods good) {
		this.good = good;
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
	 * @return the shelves
	 */
	public String getShelves() {
		return shelves;
	}

	/**
	 * @param shelves the shelves to set
	 */
	public void setShelves(String shelves) {
		this.shelves = shelves;
	}

	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}

	/**
	 * @return the salesMoney
	 */
	public Double getSalesMoney() {
		return salesMoney;
	}

	/**
	 * @param salesMoney the salesMoney to set
	 */
	public void setSalesMoney(Double salesMoney) {
		this.salesMoney = salesMoney;
	}

	/**
	 * @return the bazaarMoney
	 */
	public Double getBazaarMoney() {
		return bazaarMoney;
	}

	/**
	 * @param bazaarMoney the bazaarMoney to set
	 */
	public void setBazaarMoney(Double bazaarMoney) {
		this.bazaarMoney = bazaarMoney;
	}

	/**
	 * @return the huiyuanMoney
	 */
	public Double getHuiyuanMoney() {
		return huiyuanMoney;
	}

	/**
	 * @param huiyuanMoney the huiyuanMoney to set
	 */
	public void setHuiyuanMoney(Double huiyuanMoney) {
		this.huiyuanMoney = huiyuanMoney;
	}

	/**
	 * @return the costsMoney
	 */
	public Double getCostsMoney() {
		return costsMoney;
	}

	/**
	 * @param costsMoney the costsMoney to set
	 */
	public void setCostsMoney(Double costsMoney) {
		this.costsMoney = costsMoney;
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
	 * @return the inventory
	 */
	public Double getInventory() {
		return inventory;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(Double inventory) {
		this.inventory = inventory;
	}

	/**
	 * @return the goodsDescription
	 */
	public String getGoodsDescription() {
		return goodsDescription;
	}

	/**
	 * @param goodsDescription the goodsDescription to set
	 */
	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}

	/**
	 * @return the goodsParameter
	 */
	public String getGoodsParameter() {
		return goodsParameter;
	}

	/**
	 * @param goodsParameter the goodsParameter to set
	 */
	public void setGoodsParameter(String goodsParameter) {
		this.goodsParameter = goodsParameter;
	}

	/**
	 * @return the goodsStory
	 */
	public String getGoodsStory() {
		return goodsStory;
	}

	/**
	 * @param goodsStory the goodsStory to set
	 */
	public void setGoodsStory(String goodsStory) {
		this.goodsStory = goodsStory;
	}

	/**
	 * @return the goodsAuthorization
	 */
	public String getGoodsAuthorization() {
		return goodsAuthorization;
	}

	/**
	 * @param goodsAuthorization the goodsAuthorization to set
	 */
	public void setGoodsAuthorization(String goodsAuthorization) {
		this.goodsAuthorization = goodsAuthorization;
	}

	/**
	 * @return the biaoqian
	 */
	public String getBiaoqian() {
		return biaoqian;
	}

	/**
	 * @param biaoqian the biaoqian to set
	 */
	public void setBiaoqian(String biaoqian) {
		this.biaoqian = biaoqian;
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
	 * @return the goodsSort
	 */
	public GoodsSort getGoodsSort() {
		return goodsSort;
	}

	/**
	 * @param goodsSort the goodsSort to set
	 */
	public void setGoodsSort(GoodsSort goodsSort) {
		this.goodsSort = goodsSort;
	}

	/**
	 * @return the goodsType
	 */
	public GoodsType getGoodsType() {
		return goodsType;
	}

	/**
	 * @param goodsType the goodsType to set
	 */
	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	/**
	 * @return the brand
	 */
	public Brand getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	/**
	 * @return the indexs
	 */
	public String getIndexs() {
		return indexs;
	}

	/**
	 * @param indexs the indexs to set
	 */
	public void setIndexs(String indexs) {
		this.indexs = indexs;
	}

	/**
	 * @return the sj_time
	 */
	public String getSj_time() {
		return sj_time;
	}

	/**
	 * @param sj_time the sj_time to set
	 */
	public void setSj_time(String sj_time) {
		this.sj_time = sj_time;
	}

	/**
	 * @return the sys_time
	 */
	public String getSys_time() {
		return sys_time;
	}

	/**
	 * @param sys_time the sys_time to set
	 */
	public void setSys_time(String sys_time) {
		this.sys_time = sys_time;
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
	 * @return the typeSpec
	 */
	public String getTypeSpec() {
		return typeSpec;
	}

	/**
	 * @param typeSpec the typeSpec to set
	 */
	public void setTypeSpec(String typeSpec) {
		this.typeSpec = typeSpec;
	}

	/**
	 * @return the defaultImage
	 */
	public String getDefaultImage() {
		return defaultImage;
	}

	/**
	 * @param defaultImage the defaultImage to set
	 */
	public void setDefaultImage(String defaultImage) {
		this.defaultImage = defaultImage;
	}

	/**
	 * @return the images
	 */
	public String getImages() {
		return images;
	}

	/**
	 * @param images the images to set
	 */
	public void setImages(String images) {
		this.images = images;
	}

	/**
	 * @return the specList
	 */
	public List<GoodsSpec> getSpecList() {
		return specList;
	}

	/**
	 * @param specList the specList to set
	 */
	public void setSpecList(List<GoodsSpec> specList) {
		this.specList = specList;
	}

	/**
	 * @return the specValue0
	 */
	public String getSpecValue0() {
		return specValue0;
	}

	/**
	 * @param specValue0 the specValue0 to set
	 */
	public void setSpecValue0(String specValue0) {
		this.specValue0 = specValue0;
	}

	/**
	 * @return the specValue1
	 */
	public String getSpecValue1() {
		return specValue1;
	}

	/**
	 * @param specValue1 the specValue1 to set
	 */
	public void setSpecValue1(String specValue1) {
		this.specValue1 = specValue1;
	}

	/**
	 * @return the specValue2
	 */
	public String getSpecValue2() {
		return specValue2;
	}

	/**
	 * @param specValue2 the specValue2 to set
	 */
	public void setSpecValue2(String specValue2) {
		this.specValue2 = specValue2;
	}

	/**
	 * @return the specValue3
	 */
	public String getSpecValue3() {
		return specValue3;
	}

	/**
	 * @param specValue3 the specValue3 to set
	 */
	public void setSpecValue3(String specValue3) {
		this.specValue3 = specValue3;
	}

	/**
	 * @return the specValue4
	 */
	public String getSpecValue4() {
		return specValue4;
	}

	/**
	 * @param specValue4 the specValue4 to set
	 */
	public void setSpecValue4(String specValue4) {
		this.specValue4 = specValue4;
	}

	/**
	 * @return the specValue5
	 */
	public String getSpecValue5() {
		return specValue5;
	}

	/**
	 * @param specValue5 the specValue5 to set
	 */
	public void setSpecValue5(String specValue5) {
		this.specValue5 = specValue5;
	}

	/**
	 * @return the specValue6
	 */
	public String getSpecValue6() {
		return specValue6;
	}

	/**
	 * @param specValue6 the specValue6 to set
	 */
	public void setSpecValue6(String specValue6) {
		this.specValue6 = specValue6;
	}

	/**
	 * @return the specValue7
	 */
	public String getSpecValue7() {
		return specValue7;
	}

	/**
	 * @param specValue7 the specValue7 to set
	 */
	public void setSpecValue7(String specValue7) {
		this.specValue7 = specValue7;
	}

	/**
	 * @return the specValue8
	 */
	public String getSpecValue8() {
		return specValue8;
	}

	/**
	 * @param specValue8 the specValue8 to set
	 */
	public void setSpecValue8(String specValue8) {
		this.specValue8 = specValue8;
	}

	/**
	 * @return the specValue9
	 */
	public String getSpecValue9() {
		return specValue9;
	}

	/**
	 * @param specValue9 the specValue9 to set
	 */
	public void setSpecValue9(String specValue9) {
		this.specValue9 = specValue9;
	}

	/**
	 * @return the specValue10
	 */
	public String getSpecValue10() {
		return specValue10;
	}

	/**
	 * @param specValue10 the specValue10 to set
	 */
	public void setSpecValue10(String specValue10) {
		this.specValue10 = specValue10;
	}

	/**
	 * @return the specValue11
	 */
	public String getSpecValue11() {
		return specValue11;
	}

	/**
	 * @param specValue11 the specValue11 to set
	 */
	public void setSpecValue11(String specValue11) {
		this.specValue11 = specValue11;
	}

	/**
	 * @return the specValue12
	 */
	public String getSpecValue12() {
		return specValue12;
	}

	/**
	 * @param specValue12 the specValue12 to set
	 */
	public void setSpecValue12(String specValue12) {
		this.specValue12 = specValue12;
	}

	/**
	 * @return the specValue13
	 */
	public String getSpecValue13() {
		return specValue13;
	}

	/**
	 * @param specValue13 the specValue13 to set
	 */
	public void setSpecValue13(String specValue13) {
		this.specValue13 = specValue13;
	}

	/**
	 * @return the specValue14
	 */
	public String getSpecValue14() {
		return specValue14;
	}

	/**
	 * @param specValue14 the specValue14 to set
	 */
	public void setSpecValue14(String specValue14) {
		this.specValue14 = specValue14;
	}

	/**
	 * @return the specValue15
	 */
	public String getSpecValue15() {
		return specValue15;
	}

	/**
	 * @param specValue15 the specValue15 to set
	 */
	public void setSpecValue15(String specValue15) {
		this.specValue15 = specValue15;
	}

	/**
	 * @return the specValue16
	 */
	public String getSpecValue16() {
		return specValue16;
	}

	/**
	 * @param specValue16 the specValue16 to set
	 */
	public void setSpecValue16(String specValue16) {
		this.specValue16 = specValue16;
	}

	/**
	 * @return the specValue17
	 */
	public String getSpecValue17() {
		return specValue17;
	}

	/**
	 * @param specValue17 the specValue17 to set
	 */
	public void setSpecValue17(String specValue17) {
		this.specValue17 = specValue17;
	}

	/**
	 * @return the specValue18
	 */
	public String getSpecValue18() {
		return specValue18;
	}

	/**
	 * @param specValue18 the specValue18 to set
	 */
	public void setSpecValue18(String specValue18) {
		this.specValue18 = specValue18;
	}

	/**
	 * @return the specValue19
	 */
	public String getSpecValue19() {
		return specValue19;
	}

	/**
	 * @param specValue19 the specValue19 to set
	 */
	public void setSpecValue19(String specValue19) {
		this.specValue19 = specValue19;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the delivery
	 */
	public GoodsDelivery getDelivery() {
		return delivery;
	}

	/**
	 * @param delivery the delivery to set
	 */
	public void setDelivery(GoodsDelivery delivery) {
		this.delivery = delivery;
	}

	/**
	 * @return the salesNum
	 */
	public int getSalesNum() {
		return salesNum;
	}

	/**
	 * @param salesNum the salesNum to set
	 */
	public void setSalesNum(int salesNum) {
		this.salesNum = salesNum;
	}

	/**
	 * @return the customSort
	 */
	public GoodsSort getCustomSort() {
		return customSort;
	}

	/**
	 * @param customSort the customSort to set
	 */
	public void setCustomSort(GoodsSort customSort) {
		this.customSort = customSort;
	}

	public String getPz() {//过虑掉描述中的HTML标签
		String str="";
		if(this.getGoodsDescription()!=null){
			HtmlToText text=new HtmlToText();
			 str = text.Html2Text(this.getGoodsDescription());
		}
		return str;
	}

	public String getTryuse() {
		return tryuse;
	}

	public void setTryuse(String tryuse) {
		this.tryuse = tryuse;
	}

	public int getTryno() {
		return tryno;
	}

	public void setTryno(int tryno) {
		this.tryno = tryno;
	}

	public int getPepoleno() {
		return pepoleno;
	}

	public void setPepoleno(int pepoleno) {
		this.pepoleno = pepoleno;
	}

	public List<TryuseApply> getApplyList() {
		return applyList;
	}

	public void setApplyList(List<TryuseApply> applyList) {
		this.applyList = applyList;
	}

	public String getBtime() {
		return btime;
	}

	public void setBtime(String btime) {
		this.btime = btime;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public void setPz(String pz) {
		this.pz = pz;
	}

	public String getMfimages() {
		return mfimages;
	}

	public void setMfimages(String mfimages) {
		this.mfimages = mfimages;
	}

	
}
