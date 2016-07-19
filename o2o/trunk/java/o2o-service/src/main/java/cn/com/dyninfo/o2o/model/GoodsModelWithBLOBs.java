package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class GoodsModelWithBLOBs extends GoodsModel implements Serializable {
    private String goodsdescription;

    private String biaoqian;

    private static final long serialVersionUID = 1L;

    public String getGoodsdescription() {
        return goodsdescription;
    }

    public void setGoodsdescription(String goodsdescription) {
        this.goodsdescription = goodsdescription == null ? null : goodsdescription.trim();
    }

    public String getBiaoqian() {
        return biaoqian;
    }

    public void setBiaoqian(String biaoqian) {
        this.biaoqian = biaoqian == null ? null : biaoqian.trim();
    }
}