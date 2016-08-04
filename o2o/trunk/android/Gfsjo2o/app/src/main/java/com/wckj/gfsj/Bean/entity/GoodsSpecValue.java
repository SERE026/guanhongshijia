package com.wckj.gfsj.Bean.entity;


import com.wckj.gfsj.Bean.entity.common.BaseEntity;

/**
 * Created by Administrator on 2016/7/25.
 */
public class GoodsSpecValue extends BaseEntity {

    private GoodsSpec spec;

    private String value;

    private double price;

    private String imageUrl;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public GoodsSpec getSpec() {
        return spec;
    }

    public void setSpec(GoodsSpec spec) {
        this.spec = spec;
    }

    @Override
    public String toString() {
        return "GoodsSpecValue{" +
                "spec=" + spec +
                ", value='" + value + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
