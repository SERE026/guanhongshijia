package cn.com.dyninfo.o2o.furniture.admin.model;

import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

/**
 * Created by zengrc on 2016/7/26.
 */
@Entity
@Table(name="t_coupon_order_rel")
public class CouponOrderRel {

    @Id
    @AccessType(value = "property")
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @AccessType(value = "property")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ORDER_ID")
    private Order order;

    @AccessType(value = "property")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="COUPON_ID")
    private Coupon coupon;

    @AccessType(value = "property")
    @Column(name = "COUNT")
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
