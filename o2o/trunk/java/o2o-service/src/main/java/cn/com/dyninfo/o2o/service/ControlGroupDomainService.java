package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.ControlGroupModelMapper;
import cn.com.dyninfo.o2o.domain.ControlGroupDomain;
import cn.com.dyninfo.o2o.mapper.ControlGroupDomainMapper;
import cn.com.dyninfo.o2o.model.ControlGroupModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class ControlGroupDomainService extends BaseService<ControlGroupDomain, ControlGroupModelCriteria> {

    @Autowired
    ControlGroupDomainMapper domainMapper;

    @Autowired
    ControlGroupModelMapper modelMapper;

    @Override
    public BaseMapper<ControlGroupDomain, ControlGroupModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(ControlGroupDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(ControlGroupDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(ControlGroupDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(ControlGroupDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(ControlGroupDomain domain, ControlGroupModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(ControlGroupDomain domain, ControlGroupModelCriteria criteria) {
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
    public int deleteByModelCriteria(ControlGroupModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
