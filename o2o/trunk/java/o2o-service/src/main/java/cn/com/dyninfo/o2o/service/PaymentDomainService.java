package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.PaymentModelMapper;
import cn.com.dyninfo.o2o.domain.PaymentDomain;
import cn.com.dyninfo.o2o.mapper.PaymentDomainMapper;
import cn.com.dyninfo.o2o.model.PaymentModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class PaymentDomainService extends BaseService<PaymentDomain, PaymentModelCriteria> {

    @Autowired
    PaymentDomainMapper domainMapper;

    @Autowired
    PaymentModelMapper modelMapper;

    @Override
    public BaseMapper<PaymentDomain, PaymentModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(PaymentDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(PaymentDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(PaymentDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(PaymentDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(PaymentDomain domain, PaymentModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(PaymentDomain domain, PaymentModelCriteria criteria) {
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
    public int deleteByModelCriteria(PaymentModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
