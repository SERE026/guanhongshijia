package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.TryUseApplyModelMapper;
import cn.com.dyninfo.o2o.domain.TryUseApplyDomain;
import cn.com.dyninfo.o2o.mapper.TryUseApplyDomainMapper;
import cn.com.dyninfo.o2o.model.TryUseApplyModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class TryUseApplyDomainService extends BaseService<TryUseApplyDomain, TryUseApplyModelCriteria> {

    @Autowired
    TryUseApplyDomainMapper domainMapper;

    @Autowired
    TryUseApplyModelMapper modelMapper;

    @Override
    public BaseMapper<TryUseApplyDomain, TryUseApplyModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(TryUseApplyDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(TryUseApplyDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(TryUseApplyDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(TryUseApplyDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(TryUseApplyDomain domain, TryUseApplyModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(TryUseApplyDomain domain, TryUseApplyModelCriteria criteria) {
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
    public int deleteByModelCriteria(TryUseApplyModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
