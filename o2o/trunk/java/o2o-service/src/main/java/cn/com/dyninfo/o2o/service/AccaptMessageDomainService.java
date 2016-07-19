package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.AccaptMessageModelMapper;
import cn.com.dyninfo.o2o.domain.AccaptMessageDomain;
import cn.com.dyninfo.o2o.mapper.AccaptMessageDomainMapper;
import cn.com.dyninfo.o2o.model.AccaptMessageModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class AccaptMessageDomainService extends BaseService<AccaptMessageDomain, AccaptMessageModelCriteria> {

    @Autowired
    AccaptMessageDomainMapper domainMapper;

    @Autowired
    AccaptMessageModelMapper modelMapper;

    @Override
    public BaseMapper<AccaptMessageDomain, AccaptMessageModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(AccaptMessageDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(AccaptMessageDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(AccaptMessageDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(AccaptMessageDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(AccaptMessageDomain domain, AccaptMessageModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(AccaptMessageDomain domain, AccaptMessageModelCriteria criteria) {
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
    public int deleteByModelCriteria(AccaptMessageModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
