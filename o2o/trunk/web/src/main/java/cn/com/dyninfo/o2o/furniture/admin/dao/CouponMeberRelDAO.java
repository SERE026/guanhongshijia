package cn.com.dyninfo.o2o.furniture.admin.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by zengrc on 2016/7/26.
 */
@Repository("couponMeberRelDAO")
public class CouponMeberRelDAO extends BaseDAO{

    @Autowired
    public CouponMeberRelDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.table="CouponMeberRel";
    }
}
