package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class BbsPostInfoModel implements Serializable {
    private Integer id;

    private String userId;

    private String title;

    private String parentId;

    private Integer flag;

    private Integer type;

    private String time;

    private String htime;

    private String huserId;

    private Integer hnum;

    private Integer snum;

    private Integer status;

    private Integer top;

    private String context;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getHtime() {
        return htime;
    }

    public void setHtime(String htime) {
        this.htime = htime == null ? null : htime.trim();
    }

    public String getHuserId() {
        return huserId;
    }

    public void setHuserId(String huserId) {
        this.huserId = huserId == null ? null : huserId.trim();
    }

    public Integer getHnum() {
        return hnum;
    }

    public void setHnum(Integer hnum) {
        this.hnum = hnum;
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }
}