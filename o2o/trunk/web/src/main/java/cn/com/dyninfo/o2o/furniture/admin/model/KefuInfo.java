package cn.com.dyninfo.o2o.furniture.admin.model;

import org.hibernate.annotations.AccessType;

import javax.persistence.*;

/**
 * Created by zengrc on 2016/7/26.
 */

@Entity
@Table(name="t_kefu_info")
public class KefuInfo {

    @Id
    @AccessType(value = "property")
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @AccessType(value = "property")
    @Column(name="ROOM_ID")
    private  String roomId;

    @AccessType(value = "property")
    @Column(name="GOODS_ID ")
    private String goodsId;

    @AccessType(value = "property")
    @Column(name = "STATUS")
    private String status;//1-上线；0-未上线

    @AccessType(value = "property")
    @Column(name = "IN_TIME")
    private  String inTime;     //上线时间

    @AccessType(value = "property")
    @Column(name = "OUT_TIME")
    private String outTime;  //下线时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }
}
