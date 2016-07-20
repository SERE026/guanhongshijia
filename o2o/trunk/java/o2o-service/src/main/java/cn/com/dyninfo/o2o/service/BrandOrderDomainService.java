package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.BrandOrderModelMapper;
import cn.com.dyninfo.o2o.domain.BrandOrderDomain;
import cn.com.dyninfo.o2o.mapper.BrandOrderDomainMapper;
import cn.com.dyninfo.o2o.model.BrandOrderModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class BrandOrderDomainService extends BaseService<BrandOrderDomain, BrandOrderModelCriteria> {

    @Autowired
    BrandOrderDomainMapper domainMapper;

    @Autowired
    BrandOrderModelMapper modelMapper;

    @Override
    public BaseMapper<BrandOrderDomain, BrandOrderModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(BrandOrderDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(BrandOrderDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(BrandOrderDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(BrandOrderDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(BrandOrderDomain domain, BrandOrderModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(BrandOrderDomain domain, BrandOrderModelCriteria criteria) {
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
    public int deleteByModelCriteria(BrandOrderModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
