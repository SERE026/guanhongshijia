package cn.com.dyninfo.o2o.entity;

import cn.com.dyninfo.o2o.entity.common.BaseEntity;

/**
 * Created by Administrator on 2016/7/25.
 */
public class GoodsSummary extends BaseEntity {

    //商品显示图片
    private String mainPicUrl="";
    //商品名称
    private String title="";
    //商品价格
    private double price;

    public String getMainPicUrl() {
        return mainPicUrl;
    }

    public void setMainPicUrl(String mainPicUrl) {
        this.mainPicUrl = mainPicUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GoodsSummary{" +
                "mainPicUrl='" + mainPicUrl + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
