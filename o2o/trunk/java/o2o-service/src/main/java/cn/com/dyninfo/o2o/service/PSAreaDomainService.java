package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.PSAreaModelMapper;
import cn.com.dyninfo.o2o.domain.PSAreaDomain;
import cn.com.dyninfo.o2o.mapper.PSAreaDomainMapper;
import cn.com.dyninfo.o2o.model.PSAreaModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class PSAreaDomainService extends BaseService<PSAreaDomain, PSAreaModelCriteria> {

    @Autowired
    PSAreaDomainMapper domainMapper;

    @Autowired
    PSAreaModelMapper modelMapper;

    @Override
    public BaseMapper<PSAreaDomain, PSAreaModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(PSAreaDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(PSAreaDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(PSAreaDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(PSAreaDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(PSAreaDomain domain, PSAreaModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(PSAreaDomain domain, PSAreaModelCriteria criteria) {
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
    public int deleteByModelCriteria(PSAreaModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
