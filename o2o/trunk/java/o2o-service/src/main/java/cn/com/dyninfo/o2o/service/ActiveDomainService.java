package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.ActiveModelMapper;
import cn.com.dyninfo.o2o.domain.ActiveDomain;
import cn.com.dyninfo.o2o.mapper.ActiveDomainMapper;
import cn.com.dyninfo.o2o.model.ActiveModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class ActiveDomainService extends BaseService<ActiveDomain, ActiveModelCriteria> {

    @Autowired
    ActiveDomainMapper domainMapper;

    @Autowired
    ActiveModelMapper modelMapper;

    @Override
    public BaseMapper<ActiveDomain, ActiveModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(ActiveDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(ActiveDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(ActiveDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(ActiveDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(ActiveDomain domain, ActiveModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(ActiveDomain domain, ActiveModelCriteria criteria) {
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
    public int deleteByModelCriteria(ActiveModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
