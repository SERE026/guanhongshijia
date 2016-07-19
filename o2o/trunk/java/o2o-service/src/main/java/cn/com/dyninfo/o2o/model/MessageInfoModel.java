package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class MessageInfoModel implements Serializable {
    private Integer id;

    private String flag;

    private String msg;

    private String revcInfo;

    private String revcName;

    private Integer status;

    private String time;

    private String title;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getRevcInfo() {
        return revcInfo;
    }

    public void setRevcInfo(String revcInfo) {
        this.revcInfo = revcInfo == null ? null : revcInfo.trim();
    }

    public String getRevcName() {
        return revcName;
    }

    public void setRevcName(String revcName) {
        this.revcName = revcName == null ? null : revcName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}