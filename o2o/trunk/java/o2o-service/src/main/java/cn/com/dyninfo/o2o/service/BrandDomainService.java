package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.BrandModelMapper;
import cn.com.dyninfo.o2o.domain.BrandDomain;
import cn.com.dyninfo.o2o.mapper.BrandDomainMapper;
import cn.com.dyninfo.o2o.model.BrandModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class BrandDomainService extends BaseService<BrandDomain, BrandModelCriteria> {

    @Autowired
    BrandDomainMapper domainMapper;

    @Autowired
    BrandModelMapper modelMapper;

    @Override
    public BaseMapper<BrandDomain, BrandModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(BrandDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(BrandDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(BrandDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(BrandDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(BrandDomain domain, BrandModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(BrandDomain domain, BrandModelCriteria criteria) {
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
    public int deleteByModelCriteria(BrandModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
