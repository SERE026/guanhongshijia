package cn.com.dyninfo.o2o.furniture.admin.service.impl;

import cn.com.dyninfo.o2o.furniture.admin.dao.CouponMeberRelDAO;
import cn.com.dyninfo.o2o.furniture.admin.service.BaseService;
import cn.com.dyninfo.o2o.furniture.admin.service.CouponMeberRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dyninfo on 2016/7/26.
 */
@Service("couponMeberRelService")
public class CouponMeberRelServiceImpl extends BaseService implements CouponMeberRelService{
    @Resource
    private CouponMeberRelDAO couponMeberRelDAO;

    @Override
    public void initDao(){
        this.baseDao=couponMeberRelDAO;
    }
}
