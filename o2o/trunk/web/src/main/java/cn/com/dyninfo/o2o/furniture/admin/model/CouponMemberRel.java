package cn.com.dyninfo.o2o.furniture.admin.model;

import org.hibernate.annotations.AccessType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zengrc on 2016/7/26.
 */
@Entity
@Table(name="t_coupon_member_rel")
public class CouponMemberRel implements Serializable {
    @Id
    @AccessType(value = "property")
    @Column(name="ID")
    private int id;

    @AccessType(value = "property")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MEMBER_ID")
    private UserInfo user;

    @AccessType(value = "property")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="COUPON_ID")
    private Coupon coupon;

    @AccessType(value = "property")
    @Column(name = "COUNT")
    private int count;

    @AccessType(value = "property")
    @Column(name = "USED_COUNT")
    private int usedCount;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public UserInfo getUser() { return user; }

    public void setUser(UserInfo user) { this.user = user; }

    public Coupon getCoupon() { return coupon; }

    public void setCoupon(Coupon coupon) { this.coupon = coupon;}

    public int getCount() { return count; }

    public void setCount(int count) { this.count = count; }

    public int getUsedCount() { return usedCount; }

    public void setUsedCount(int usedCount) { this.usedCount = usedCount; }

}
