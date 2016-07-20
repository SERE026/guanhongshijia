package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.JfAddModelMapper;
import cn.com.dyninfo.o2o.domain.JfAddDomain;
import cn.com.dyninfo.o2o.mapper.JfAddDomainMapper;
import cn.com.dyninfo.o2o.model.JfAddModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class JfAddDomainService extends BaseService<JfAddDomain, JfAddModelCriteria> {

    @Autowired
    JfAddDomainMapper domainMapper;

    @Autowired
    JfAddModelMapper modelMapper;

    @Override
    public BaseMapper<JfAddDomain, JfAddModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(JfAddDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(JfAddDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(JfAddDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(JfAddDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(JfAddDomain domain, JfAddModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(JfAddDomain domain, JfAddModelCriteria criteria) {
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
    public int deleteByModelCriteria(JfAddModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
