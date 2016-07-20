package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.OrderModelMapper;
import cn.com.dyninfo.o2o.domain.OrderDomain;
import cn.com.dyninfo.o2o.mapper.OrderDomainMapper;
import cn.com.dyninfo.o2o.model.OrderModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class OrderDomainService extends BaseService<OrderDomain, OrderModelCriteria> {

    @Autowired
    OrderDomainMapper domainMapper;

    @Autowired
    OrderModelMapper modelMapper;

    @Override
    public BaseMapper<OrderDomain, OrderModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(OrderDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(OrderDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(OrderDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(OrderDomain domain, OrderModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(OrderDomain domain, OrderModelCriteria criteria) {
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
    public int deleteByModelCriteria(OrderModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
