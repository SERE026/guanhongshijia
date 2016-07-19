package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class CarsBoxModel implements Serializable {
    private Integer id;

    private String carId;

    private String goodsName;

    private String merchantsName;

    private Float price;

    private Integer productId;

    private Integer num;

    private String actInfo;

    private String specVal;

    private Integer goodId;

    private Integer huiyuanId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName == null ? null : merchantsName.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getActInfo() {
        return actInfo;
    }

    public void setActInfo(String actInfo) {
        this.actInfo = actInfo == null ? null : actInfo.trim();
    }

    public String getSpecVal() {
        return specVal;
    }

    public void setSpecVal(String specVal) {
        this.specVal = specVal == null ? null : specVal.trim();
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getHuiyuanId() {
        return huiyuanId;
    }

    public void setHuiyuanId(Integer huiyuanId) {
        this.huiyuanId = huiyuanId;
    }
}