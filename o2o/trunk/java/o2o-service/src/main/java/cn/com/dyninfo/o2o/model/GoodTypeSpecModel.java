package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class GoodTypeSpecModel implements Serializable {
    private Integer id;

    private String name;

    private String status;

    private String flag;

    private String valstr;

    private Integer goodsTypeId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getValstr() {
        return valstr;
    }

    public void setValstr(String valstr) {
        this.valstr = valstr == null ? null : valstr.trim();
    }

    public Integer getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }
}