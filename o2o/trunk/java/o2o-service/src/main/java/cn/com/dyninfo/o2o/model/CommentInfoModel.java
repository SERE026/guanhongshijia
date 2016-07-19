package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class CommentInfoModel implements Serializable {
    private Integer id;

    private Integer infoId;

    private Integer sinfoId;

    private Integer ginfoId;

    private String content;

    private String replyContent;

    private String status;

    private String uinfoId;

    private String imageSrc;

    private String isShow;

    private Double leve;

    private String phototitle;

    private Integer orderproductId;

    private String time;

    private String saycontent;

    private String indexs;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getSinfoId() {
        return sinfoId;
    }

    public void setSinfoId(Integer sinfoId) {
        this.sinfoId = sinfoId;
    }

    public Integer getGinfoId() {
        return ginfoId;
    }

    public void setGinfoId(Integer ginfoId) {
        this.ginfoId = ginfoId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getUinfoId() {
        return uinfoId;
    }

    public void setUinfoId(String uinfoId) {
        this.uinfoId = uinfoId == null ? null : uinfoId.trim();
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc == null ? null : imageSrc.trim();
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow == null ? null : isShow.trim();
    }

    public Double getLeve() {
        return leve;
    }

    public void setLeve(Double leve) {
        this.leve = leve;
    }

    public String getPhototitle() {
        return phototitle;
    }

    public void setPhototitle(String phototitle) {
        this.phototitle = phototitle == null ? null : phototitle.trim();
    }

    public Integer getOrderproductId() {
        return orderproductId;
    }

    public void setOrderproductId(Integer orderproductId) {
        this.orderproductId = orderproductId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getSaycontent() {
        return saycontent;
    }

    public void setSaycontent(String saycontent) {
        this.saycontent = saycontent == null ? null : saycontent.trim();
    }

    public String getIndexs() {
        return indexs;
    }

    public void setIndexs(String indexs) {
        this.indexs = indexs == null ? null : indexs.trim();
    }
}