package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.AgentGradeModelMapper;
import cn.com.dyninfo.o2o.domain.AgentGradeDomain;
import cn.com.dyninfo.o2o.mapper.AgentGradeDomainMapper;
import cn.com.dyninfo.o2o.model.AgentGradeModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class AgentGradeDomainService extends BaseService<AgentGradeDomain, AgentGradeModelCriteria> {

    @Autowired
    AgentGradeDomainMapper domainMapper;

    @Autowired
    AgentGradeModelMapper modelMapper;

    @Override
    public BaseMapper<AgentGradeDomain, AgentGradeModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(AgentGradeDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(AgentGradeDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(AgentGradeDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(AgentGradeDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(AgentGradeDomain domain, AgentGradeModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(AgentGradeDomain domain, AgentGradeModelCriteria criteria) {
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
    public int deleteByModelCriteria(AgentGradeModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
