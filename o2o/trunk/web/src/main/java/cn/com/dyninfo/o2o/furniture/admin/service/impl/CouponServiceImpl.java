package cn.com.dyninfo.o2o.furniture.admin.service.impl;

import cn.com.dyninfo.o2o.furniture.admin.dao.CouponDAO;
import cn.com.dyninfo.o2o.furniture.admin.service.BaseService;
import cn.com.dyninfo.o2o.furniture.admin.service.CouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zengrc on 2016/7/26.
 */
@Service("couponService")
public class CouponServiceImpl extends BaseService implements CouponService{
    @Resource
    private CouponDAO couponDAO;

    @Override
    public void initDao(){
        this.baseDao=couponDAO;
    }
}
