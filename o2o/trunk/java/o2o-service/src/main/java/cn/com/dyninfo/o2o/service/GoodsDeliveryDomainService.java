package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.GoodsDeliveryModelMapper;
import cn.com.dyninfo.o2o.domain.GoodsDeliveryDomain;
import cn.com.dyninfo.o2o.mapper.GoodsDeliveryDomainMapper;
import cn.com.dyninfo.o2o.model.GoodsDeliveryModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class GoodsDeliveryDomainService extends BaseService<GoodsDeliveryDomain, GoodsDeliveryModelCriteria> {

    @Autowired
    GoodsDeliveryDomainMapper domainMapper;

    @Autowired
    GoodsDeliveryModelMapper modelMapper;

    @Override
    public BaseMapper<GoodsDeliveryDomain, GoodsDeliveryModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(GoodsDeliveryDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(GoodsDeliveryDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(GoodsDeliveryDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsDeliveryDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(GoodsDeliveryDomain domain, GoodsDeliveryModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(GoodsDeliveryDomain domain, GoodsDeliveryModelCriteria criteria) {
        return modelMapper.updateByExample(domain, criteria);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return modelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByMapCriteria(Map<String, Object> criteria) {
        return 0;
    }

    @Override
    public int deleteByModelCriteria(GoodsDeliveryModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
