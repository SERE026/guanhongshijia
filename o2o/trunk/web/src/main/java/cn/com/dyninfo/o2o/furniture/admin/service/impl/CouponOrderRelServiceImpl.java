package cn.com.dyninfo.o2o.furniture.admin.service.impl;

import cn.com.dyninfo.o2o.furniture.admin.dao.CouponOrderRelDAO;
import cn.com.dyninfo.o2o.furniture.admin.service.BaseService;
import cn.com.dyninfo.o2o.furniture.admin.service.CouponOrderRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dyninfo on 2016/7/26.
 */
@Service("couponOrderRelService")
public class CouponOrderRelServiceImpl extends BaseService implements CouponOrderRelService {
    @Resource
    private CouponOrderRelDAO couponOrderRelDAO;

    @Override
    public void initDao(){
        this.baseDao=couponOrderRelDAO;
    }
}
