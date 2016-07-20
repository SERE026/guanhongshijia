package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.SendOrderModelMapper;
import cn.com.dyninfo.o2o.domain.SendOrderDomain;
import cn.com.dyninfo.o2o.mapper.SendOrderDomainMapper;
import cn.com.dyninfo.o2o.model.SendOrderModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class SendOrderDomainService extends BaseService<SendOrderDomain, SendOrderModelCriteria> {

    @Autowired
    SendOrderDomainMapper domainMapper;

    @Autowired
    SendOrderModelMapper modelMapper;

    @Override
    public BaseMapper<SendOrderDomain, SendOrderModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(SendOrderDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(SendOrderDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(SendOrderDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(SendOrderDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(SendOrderDomain domain, SendOrderModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(SendOrderDomain domain, SendOrderModelCriteria criteria) {
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
    public int deleteByModelCriteria(SendOrderModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
