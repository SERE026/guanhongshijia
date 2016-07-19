package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class NoteModel implements Serializable {
    private Integer id;

    private String address;

    private String accout;

    private String password;

    private String sendmen;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAccout() {
        return accout;
    }

    public void setAccout(String accout) {
        this.accout = accout == null ? null : accout.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSendmen() {
        return sendmen;
    }

    public void setSendmen(String sendmen) {
        this.sendmen = sendmen == null ? null : sendmen.trim();
    }
}