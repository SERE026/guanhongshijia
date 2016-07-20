package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.RefundOrderModelMapper;
import cn.com.dyninfo.o2o.domain.RefundOrderDomain;
import cn.com.dyninfo.o2o.mapper.RefundOrderDomainMapper;
import cn.com.dyninfo.o2o.model.RefundOrderModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class RefundOrderDomainService extends BaseService<RefundOrderDomain, RefundOrderModelCriteria> {

    @Autowired
    RefundOrderDomainMapper domainMapper;

    @Autowired
    RefundOrderModelMapper modelMapper;

    @Override
    public BaseMapper<RefundOrderDomain, RefundOrderModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(RefundOrderDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(RefundOrderDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(RefundOrderDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(RefundOrderDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(RefundOrderDomain domain, RefundOrderModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(RefundOrderDomain domain, RefundOrderModelCriteria criteria) {
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
    public int deleteByModelCriteria(RefundOrderModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
