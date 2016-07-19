package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.ProductModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class ProductDomain extends ProductModel{
    private GoodsDomain good;
    private List<TryuseApplyDomain> applyList;
    private GoodsDeliveryDomain delivery;
    private ShangJiaInfoDomain merchants;
    private GoodsSortDomain goodsSort;
    private GoodsTypeDomain goodsType;
    private GoodsSortDomain customSort;
    private BrandDomain brand;

    public GoodsDomain getGood() {
        return good;
    }

    public void setGood(GoodsDomain good) {
        this.good = good;
    }

    public List<TryuseApplyDomain> getApplyList() {
        return applyList;
    }

    public void setApplyList(List<TryuseApplyDomain> applyList) {
        this.applyList = applyList;
    }

    public GoodsDeliveryDomain getDelivery() {
        return delivery;
    }

    public void setDelivery(GoodsDeliveryDomain delivery) {
        this.delivery = delivery;
    }

    public ShangJiaInfoDomain getMerchants() {
        return merchants;
    }

    public void setMerchants(ShangJiaInfoDomain merchants) {
        this.merchants = merchants;
    }

    public GoodsSortDomain getGoodsSort() {
        return goodsSort;
    }

    public void setGoodsSort(GoodsSortDomain goodsSort) {
        this.goodsSort = goodsSort;
    }

    public GoodsTypeDomain getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsTypeDomain goodsType) {
        this.goodsType = goodsType;
    }

    public GoodsSortDomain getCustomSort() {
        return customSort;
    }

    public void setCustomSort(GoodsSortDomain customSort) {
        this.customSort = customSort;
    }

    public BrandDomain getBrand() {
        return brand;
    }

    public void setBrand(BrandDomain brand) {
        this.brand = brand;
    }

    public List<GoodsSpecDomain> getSpecList() {
        return specList;
    }

    public void setSpecList(List<GoodsSpecDomain> specList) {
        this.specList = specList;
    }

    private List<GoodsSpecDomain> specList;
}
