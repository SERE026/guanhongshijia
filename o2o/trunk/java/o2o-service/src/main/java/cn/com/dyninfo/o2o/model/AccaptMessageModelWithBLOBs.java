package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class AccaptMessageModelWithBLOBs extends AccaptMessageModel implements Serializable {
    private String descInfo;

    private byte[] agent;

    private static final long serialVersionUID = 1L;

    public String getDescInfo() {
        return descInfo;
    }

    public void setDescInfo(String descInfo) {
        this.descInfo = descInfo == null ? null : descInfo.trim();
    }

    public byte[] getAgent() {
        return agent;
    }

    public void setAgent(byte[] agent) {
        this.agent = agent;
    }
}