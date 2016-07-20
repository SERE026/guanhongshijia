package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.LogModelMapper;
import cn.com.dyninfo.o2o.domain.LogDomain;
import cn.com.dyninfo.o2o.mapper.LogDomainMapper;
import cn.com.dyninfo.o2o.model.LogModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class LogDomainService extends BaseService<LogDomain, LogModelCriteria> {

    @Autowired
    LogDomainMapper domainMapper;

    @Autowired
    LogModelMapper modelMapper;

    @Override
    public BaseMapper<LogDomain, LogModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(LogDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(LogDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(LogDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(LogDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(LogDomain domain, LogModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(LogDomain domain, LogModelCriteria criteria) {
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
    public int deleteByModelCriteria(LogModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
