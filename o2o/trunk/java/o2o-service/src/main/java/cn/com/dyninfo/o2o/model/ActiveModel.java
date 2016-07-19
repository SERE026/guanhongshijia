package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class ActiveModel implements Serializable {
    private Integer id;

    private String bdate;

    private String edate;

    private String btime;

    private String etime;

    private Integer btimel;

    private Integer etimel;

    private String type;

    private Double val;

    private String name;

    private Integer gameId;

    private Integer flag;

    private Integer goodsCount;

    private Integer status;

    private String role;

    private Integer marchantsId;

    private String ps;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate == null ? null : bdate.trim();
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate == null ? null : edate.trim();
    }

    public String getBtime() {
        return btime;
    }

    public void setBtime(String btime) {
        this.btime = btime == null ? null : btime.trim();
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime == null ? null : etime.trim();
    }

    public Integer getBtimel() {
        return btimel;
    }

    public void setBtimel(Integer btimel) {
        this.btimel = btimel;
    }

    public Integer getEtimel() {
        return etimel;
    }

    public void setEtimel(Integer etimel) {
        this.etimel = etimel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Double getVal() {
        return val;
    }

    public void setVal(Double val) {
        this.val = val;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public Integer getMarchantsId() {
        return marchantsId;
    }

    public void setMarchantsId(Integer marchantsId) {
        this.marchantsId = marchantsId;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps == null ? null : ps.trim();
    }
}