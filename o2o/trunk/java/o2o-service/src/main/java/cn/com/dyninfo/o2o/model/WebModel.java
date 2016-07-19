package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class WebModel implements Serializable {
    private Integer id;

    private String sltW;

    private String sltH;

    private String goodsxxW;

    private String goodxxH;

    private String goodW;

    private String goodH;

    private String isSy;

    private String syName;

    private String syLocation;

    private String fontColor;

    private String fontSize;

    private String isCode;

    private String pageSize;

    private String isLmpl;

    private String isDispaly;

    private String description;

    private String keyword;

    private String title;

    private String bgColor;

    private String bgImg;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSltW() {
        return sltW;
    }

    public void setSltW(String sltW) {
        this.sltW = sltW == null ? null : sltW.trim();
    }

    public String getSltH() {
        return sltH;
    }

    public void setSltH(String sltH) {
        this.sltH = sltH == null ? null : sltH.trim();
    }

    public String getGoodsxxW() {
        return goodsxxW;
    }

    public void setGoodsxxW(String goodsxxW) {
        this.goodsxxW = goodsxxW == null ? null : goodsxxW.trim();
    }

    public String getGoodxxH() {
        return goodxxH;
    }

    public void setGoodxxH(String goodxxH) {
        this.goodxxH = goodxxH == null ? null : goodxxH.trim();
    }

    public String getGoodW() {
        return goodW;
    }

    public void setGoodW(String goodW) {
        this.goodW = goodW == null ? null : goodW.trim();
    }

    public String getGoodH() {
        return goodH;
    }

    public void setGoodH(String goodH) {
        this.goodH = goodH == null ? null : goodH.trim();
    }

    public String getIsSy() {
        return isSy;
    }

    public void setIsSy(String isSy) {
        this.isSy = isSy == null ? null : isSy.trim();
    }

    public String getSyName() {
        return syName;
    }

    public void setSyName(String syName) {
        this.syName = syName == null ? null : syName.trim();
    }

    public String getSyLocation() {
        return syLocation;
    }

    public void setSyLocation(String syLocation) {
        this.syLocation = syLocation == null ? null : syLocation.trim();
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor == null ? null : fontColor.trim();
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize == null ? null : fontSize.trim();
    }

    public String getIsCode() {
        return isCode;
    }

    public void setIsCode(String isCode) {
        this.isCode = isCode == null ? null : isCode.trim();
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize == null ? null : pageSize.trim();
    }

    public String getIsLmpl() {
        return isLmpl;
    }

    public void setIsLmpl(String isLmpl) {
        this.isLmpl = isLmpl == null ? null : isLmpl.trim();
    }

    public String getIsDispaly() {
        return isDispaly;
    }

    public void setIsDispaly(String isDispaly) {
        this.isDispaly = isDispaly == null ? null : isDispaly.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor == null ? null : bgColor.trim();
    }

    public String getBgImg() {
        return bgImg;
    }

    public void setBgImg(String bgImg) {
        this.bgImg = bgImg == null ? null : bgImg.trim();
    }
}