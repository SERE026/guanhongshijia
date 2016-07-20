package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.NrjModelMapper;
import cn.com.dyninfo.o2o.domain.NrjDomain;
import cn.com.dyninfo.o2o.mapper.NrjDomainMapper;
import cn.com.dyninfo.o2o.model.NrjModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class NrjDomainService extends BaseService<NrjDomain, NrjModelCriteria> {

    @Autowired
    NrjDomainMapper domainMapper;

    @Autowired
    NrjModelMapper modelMapper;

    @Override
    public BaseMapper<NrjDomain, NrjModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(NrjDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(NrjDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(NrjDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(NrjDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(NrjDomain domain, NrjModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(NrjDomain domain, NrjModelCriteria criteria) {
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
    public int deleteByModelCriteria(NrjModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
