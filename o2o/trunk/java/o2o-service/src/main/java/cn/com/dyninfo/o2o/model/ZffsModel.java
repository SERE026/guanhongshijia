package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class ZffsModel implements Serializable {
    private Integer id;

    private String type;

    private String name;

    private String zfbId;

    private String zfbCode;

    private String zfbZhanghao;

    private String cftjsZhanghao;

    private String cftjsKey;

    private String cftdbZhanghao;

    private String cftdbKey;

    private String value1;

    private String value2;

    private String value3;

    private String value4;

    private String ps;

    private Integer status;

    private String zfbKey;

    private String widgetName;

    private String body;

    private String notifyUrl;

    private String returnUrl;

    private String showUrl;

    private String subject;

    private String jianchen;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getZfbId() {
        return zfbId;
    }

    public void setZfbId(String zfbId) {
        this.zfbId = zfbId == null ? null : zfbId.trim();
    }

    public String getZfbCode() {
        return zfbCode;
    }

    public void setZfbCode(String zfbCode) {
        this.zfbCode = zfbCode == null ? null : zfbCode.trim();
    }

    public String getZfbZhanghao() {
        return zfbZhanghao;
    }

    public void setZfbZhanghao(String zfbZhanghao) {
        this.zfbZhanghao = zfbZhanghao == null ? null : zfbZhanghao.trim();
    }

    public String getCftjsZhanghao() {
        return cftjsZhanghao;
    }

    public void setCftjsZhanghao(String cftjsZhanghao) {
        this.cftjsZhanghao = cftjsZhanghao == null ? null : cftjsZhanghao.trim();
    }

    public String getCftjsKey() {
        return cftjsKey;
    }

    public void setCftjsKey(String cftjsKey) {
        this.cftjsKey = cftjsKey == null ? null : cftjsKey.trim();
    }

    public String getCftdbZhanghao() {
        return cftdbZhanghao;
    }

    public void setCftdbZhanghao(String cftdbZhanghao) {
        this.cftdbZhanghao = cftdbZhanghao == null ? null : cftdbZhanghao.trim();
    }

    public String getCftdbKey() {
        return cftdbKey;
    }

    public void setCftdbKey(String cftdbKey) {
        this.cftdbKey = cftdbKey == null ? null : cftdbKey.trim();
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1 == null ? null : value1.trim();
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2 == null ? null : value2.trim();
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3 == null ? null : value3.trim();
    }

    public String getValue4() {
        return value4;
    }

    public void setValue4(String value4) {
        this.value4 = value4 == null ? null : value4.trim();
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps == null ? null : ps.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getZfbKey() {
        return zfbKey;
    }

    public void setZfbKey(String zfbKey) {
        this.zfbKey = zfbKey == null ? null : zfbKey.trim();
    }

    public String getWidgetName() {
        return widgetName;
    }

    public void setWidgetName(String widgetName) {
        this.widgetName = widgetName == null ? null : widgetName.trim();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl == null ? null : returnUrl.trim();
    }

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl == null ? null : showUrl.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getJianchen() {
        return jianchen;
    }

    public void setJianchen(String jianchen) {
        this.jianchen = jianchen == null ? null : jianchen.trim();
    }
}