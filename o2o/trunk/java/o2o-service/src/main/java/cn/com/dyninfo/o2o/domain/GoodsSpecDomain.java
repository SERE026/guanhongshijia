package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.GoodsSpecValModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class GoodsSpecDomain{
    private GoodsDomain goods;
    private List<GoodsSpecValDomain> valList;
    private ProductDomain product;

    public GoodsDomain getGoods() {
        return goods;
    }

    public void setGoods(GoodsDomain goods) {
        this.goods = goods;
    }

    public List<GoodsSpecValDomain> getValList() {
        return valList;
    }

    public void setValList(List<GoodsSpecValDomain> valList) {
        this.valList = valList;
    }

    public ProductDomain getProduct() {
        return product;
    }

    public void setProduct(ProductDomain product) {
        this.product = product;
    }
}
