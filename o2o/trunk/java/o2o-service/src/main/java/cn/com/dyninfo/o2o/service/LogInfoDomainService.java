package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.LogInfoModelMapper;
import cn.com.dyninfo.o2o.domain.LogInfoDomain;
import cn.com.dyninfo.o2o.mapper.LogInfoDomainMapper;
import cn.com.dyninfo.o2o.model.LogInfoModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class LogInfoDomainService extends BaseService<LogInfoDomain, LogInfoModelCriteria> {

    @Autowired
    LogInfoDomainMapper domainMapper;

    @Autowired
    LogInfoModelMapper modelMapper;

    @Override
    public BaseMapper<LogInfoDomain, LogInfoModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(LogInfoDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(LogInfoDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(LogInfoDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(LogInfoDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(LogInfoDomain domain, LogInfoModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(LogInfoDomain domain, LogInfoModelCriteria criteria) {
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
    public int deleteByModelCriteria(LogInfoModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
