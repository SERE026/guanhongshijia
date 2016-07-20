package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.MerchantsApplyModelMapper;
import cn.com.dyninfo.o2o.domain.MerchantsApplyDomain;
import cn.com.dyninfo.o2o.mapper.MerchantsApplyDomainMapper;
import cn.com.dyninfo.o2o.model.MerchantsApplyModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class MerchantsApplyDomainService extends BaseService<MerchantsApplyDomain, MerchantsApplyModelCriteria> {

    @Autowired
    MerchantsApplyDomainMapper domainMapper;

    @Autowired
    MerchantsApplyModelMapper modelMapper;

    @Override
    public BaseMapper<MerchantsApplyDomain, MerchantsApplyModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(MerchantsApplyDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(MerchantsApplyDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(MerchantsApplyDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(MerchantsApplyDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(MerchantsApplyDomain domain, MerchantsApplyModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(MerchantsApplyDomain domain, MerchantsApplyModelCriteria criteria) {
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
    public int deleteByModelCriteria(MerchantsApplyModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
