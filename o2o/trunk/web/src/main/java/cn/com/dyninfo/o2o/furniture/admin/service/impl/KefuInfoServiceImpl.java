package cn.com.dyninfo.o2o.furniture.admin.service.impl;

import cn.com.dyninfo.o2o.furniture.admin.dao.CouponDAO;
import cn.com.dyninfo.o2o.furniture.admin.dao.KefuInfoDAO;
import cn.com.dyninfo.o2o.furniture.admin.service.BaseService;
import cn.com.dyninfo.o2o.furniture.admin.service.CouponService;
import cn.com.dyninfo.o2o.furniture.admin.service.KefuInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zengrc on 2016/7/26.
 */
@Service("kefuInfoService")
public class KefuInfoServiceImpl extends BaseService implements KefuInfoService {
    @Resource
    private KefuInfoDAO kefuInfoDAO;

    @Override
    public void initDao(){
        this.baseDao=kefuInfoDAO;
    }
}
