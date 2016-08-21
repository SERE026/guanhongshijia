package com.wckj.gfsj.Bean.entity;

import com.wckj.gfsj.Bean.entity.common.BaseEntity;

import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2016/7/25.
 */
public class GoodsDetail extends BaseEntity {
    //商品名称
    private String name="";
    //参数列表
    private List<GoodsSpec> specList;
    //商品说明，显示在商品名称下方
    private String shortDesc="";
    //商品价格
    private double price;

    //商品类型
    private String type="";

    //收藏
    private String collection="";
    //默认图片
    private String defaultImage="";

    //购物车规格
    private String specVal="";

    //商品类别
//    private Category category;
    //品牌
    private Brand brand;
    //销量
    private int saleCount;
    //图片列表
    private List<String> imageList;
    //商品详情，html格式
    private String goodsDesc="";
    //商品的类型，颜色，参数属性
    List<Map> specMap;

    public List<Map> getSpecMap() {
        return specMap;
    }

    public void setSpecMap(List<Map> specMap) {
        this.specMap = specMap;
    }

    public String getSpecVal() {
        return specVal;
    }

    public void setSpecVal(String specVal) {
        this.specVal = specVal;
    }


    public String getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(String defaultImage) {
        this.defaultImage = defaultImage;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GoodsSpec> getSpecList() {
        return specList;
    }

    public void setSpecList(List<GoodsSpec> specList) {
        this.specList = specList;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(int saleCount) {
        this.saleCount = saleCount;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    @Override
    public String toString() {
        return "GoodsDetail{" +
                "name='" + name + '\'' +
                ", specList=" + specList +
                ", shortDesc='" + shortDesc + '\'' +
                ", price=" + price +
//                ", category=" + category +
                ", brand=" + brand +
                ", saleCount=" + saleCount +
                ", imageList=" + imageList +
                ", goodsDesc='" + goodsDesc + '\'' +
                '}';
    }
}
