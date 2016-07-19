package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.AdvWzModelMapper;
import cn.com.dyninfo.o2o.domain.AdvWzDomain;
import cn.com.dyninfo.o2o.mapper.AdvWzDomainMapper;
import cn.com.dyninfo.o2o.model.AdvWzModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class AdvWzDomainService extends BaseService<AdvWzDomain, AdvWzModelCriteria> {

    @Autowired
    AdvWzDomainMapper domainMapper;

    @Autowired
    AdvWzModelMapper modelMapper;

    @Override
    public BaseMapper<AdvWzDomain, AdvWzModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(AdvWzDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(AdvWzDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(AdvWzDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(AdvWzDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(AdvWzDomain domain, AdvWzModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(AdvWzDomain domain, AdvWzModelCriteria criteria) {
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
    public int deleteByModelCriteria(AdvWzModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
