package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.OrderProductModelMapper;
import cn.com.dyninfo.o2o.domain.OrderProductDomain;
import cn.com.dyninfo.o2o.mapper.OrderProductDomainMapper;
import cn.com.dyninfo.o2o.model.OrderProductModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class OrderProductDomainService extends BaseService<OrderProductDomain, OrderProductModelCriteria> {

    @Autowired
    OrderProductDomainMapper domainMapper;

    @Autowired
    OrderProductModelMapper modelMapper;

    @Override
    public BaseMapper<OrderProductDomain, OrderProductModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(OrderProductDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(OrderProductDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(OrderProductDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderProductDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(OrderProductDomain domain, OrderProductModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(OrderProductDomain domain, OrderProductModelCriteria criteria) {
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
    public int deleteByModelCriteria(OrderProductModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
