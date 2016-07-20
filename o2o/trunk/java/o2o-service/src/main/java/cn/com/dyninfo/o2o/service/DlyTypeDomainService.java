package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.DlyTypeModelMapper;
import cn.com.dyninfo.o2o.domain.DlyTypeDomain;
import cn.com.dyninfo.o2o.mapper.DlyTypeDomainMapper;
import cn.com.dyninfo.o2o.model.DlyTypeModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class DlyTypeDomainService extends BaseService<DlyTypeDomain, DlyTypeModelCriteria> {

    @Autowired
    DlyTypeDomainMapper domainMapper;

    @Autowired
    DlyTypeModelMapper modelMapper;

    @Override
    public BaseMapper<DlyTypeDomain, DlyTypeModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(DlyTypeDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(DlyTypeDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(DlyTypeDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(DlyTypeDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(DlyTypeDomain domain, DlyTypeModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(DlyTypeDomain domain, DlyTypeModelCriteria criteria) {
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
    public int deleteByModelCriteria(DlyTypeModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
