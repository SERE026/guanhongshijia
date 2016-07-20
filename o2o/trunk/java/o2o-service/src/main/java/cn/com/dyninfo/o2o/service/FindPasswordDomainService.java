package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.FindPasswordModelMapper;
import cn.com.dyninfo.o2o.domain.FindPasswordDomain;
import cn.com.dyninfo.o2o.mapper.FindPasswordDomainMapper;
import cn.com.dyninfo.o2o.model.FindPasswordModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class FindPasswordDomainService extends BaseService<FindPasswordDomain, FindPasswordModelCriteria> {

    @Autowired
    FindPasswordDomainMapper domainMapper;

    @Autowired
    FindPasswordModelMapper modelMapper;

    @Override
    public BaseMapper<FindPasswordDomain, FindPasswordModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(FindPasswordDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(FindPasswordDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(FindPasswordDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(FindPasswordDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(FindPasswordDomain domain, FindPasswordModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(FindPasswordDomain domain, FindPasswordModelCriteria criteria) {
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
    public int deleteByModelCriteria(FindPasswordModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
