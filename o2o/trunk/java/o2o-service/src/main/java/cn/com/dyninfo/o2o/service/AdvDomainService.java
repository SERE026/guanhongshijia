package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.AdvModelMapper;
import cn.com.dyninfo.o2o.domain.AdvDomain;
import cn.com.dyninfo.o2o.mapper.AdvDomainMapper;
import cn.com.dyninfo.o2o.model.AdvModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class AdvDomainService extends BaseService<AdvDomain, AdvModelCriteria> {

    @Autowired
    AdvDomainMapper domainMapper;

    @Autowired
    AdvModelMapper modelMapper;

    @Override
    public BaseMapper<AdvDomain, AdvModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(AdvDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(AdvDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(AdvDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(AdvDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(AdvDomain domain, AdvModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(AdvDomain domain, AdvModelCriteria criteria) {
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
    public int deleteByModelCriteria(AdvModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
