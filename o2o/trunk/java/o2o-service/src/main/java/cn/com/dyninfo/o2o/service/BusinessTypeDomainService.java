package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.BusinessTypeModelMapper;
import cn.com.dyninfo.o2o.domain.BusinessTypeDomain;
import cn.com.dyninfo.o2o.mapper.BusinessTypeDomainMapper;
import cn.com.dyninfo.o2o.model.BusinessTypeModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class BusinessTypeDomainService extends BaseService<BusinessTypeDomain, BusinessTypeModelCriteria> {

    @Autowired
    BusinessTypeDomainMapper domainMapper;

    @Autowired
    BusinessTypeModelMapper modelMapper;

    @Override
    public BaseMapper<BusinessTypeDomain, BusinessTypeModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(BusinessTypeDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(BusinessTypeDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(BusinessTypeDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(BusinessTypeDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(BusinessTypeDomain domain, BusinessTypeModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(BusinessTypeDomain domain, BusinessTypeModelCriteria criteria) {
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
    public int deleteByModelCriteria(BusinessTypeModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
