package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class GoodsSpecValModel implements Serializable {
    private Integer id;

    private Integer goodsSpecId;

    private Integer goodsId;

    private String val;

    private Float specSales;

    private Float specBazaar;

    private Float specCost;

    private Float specWeight;

    private Float inventory;

    private Integer status;

    private String img;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsSpecId() {
        return goodsSpecId;
    }

    public void setGoodsSpecId(Integer goodsSpecId) {
        this.goodsSpecId = goodsSpecId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val == null ? null : val.trim();
    }

    public Float getSpecSales() {
        return specSales;
    }

    public void setSpecSales(Float specSales) {
        this.specSales = specSales;
    }

    public Float getSpecBazaar() {
        return specBazaar;
    }

    public void setSpecBazaar(Float specBazaar) {
        this.specBazaar = specBazaar;
    }

    public Float getSpecCost() {
        return specCost;
    }

    public void setSpecCost(Float specCost) {
        this.specCost = specCost;
    }

    public Float getSpecWeight() {
        return specWeight;
    }

    public void setSpecWeight(Float specWeight) {
        this.specWeight = specWeight;
    }

    public Float getInventory() {
        return inventory;
    }

    public void setInventory(Float inventory) {
        this.inventory = inventory;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}