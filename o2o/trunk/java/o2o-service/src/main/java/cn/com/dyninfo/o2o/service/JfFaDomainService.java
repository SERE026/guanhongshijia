package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.JfFaModelMapper;
import cn.com.dyninfo.o2o.domain.JfFaDomain;
import cn.com.dyninfo.o2o.mapper.JfFaDomainMapper;
import cn.com.dyninfo.o2o.model.JfFaModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class JfFaDomainService extends BaseService<JfFaDomain, JfFaModelCriteria> {

    @Autowired
    JfFaDomainMapper domainMapper;

    @Autowired
    JfFaModelMapper modelMapper;

    @Override
    public BaseMapper<JfFaDomain, JfFaModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(JfFaDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(JfFaDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(JfFaDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(JfFaDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(JfFaDomain domain, JfFaModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(JfFaDomain domain, JfFaModelCriteria criteria) {
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
    public int deleteByModelCriteria(JfFaModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
