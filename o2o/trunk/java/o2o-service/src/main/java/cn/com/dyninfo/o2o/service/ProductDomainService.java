package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.ProductModelMapper;
import cn.com.dyninfo.o2o.domain.ProductDomain;
import cn.com.dyninfo.o2o.mapper.ProductDomainMapper;
import cn.com.dyninfo.o2o.model.ProductModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class ProductDomainService extends BaseService<ProductDomain, ProductModelCriteria> {

    @Autowired
    ProductDomainMapper domainMapper;

    @Autowired
    ProductModelMapper modelMapper;

    @Override
    public BaseMapper<ProductDomain, ProductModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(ProductDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(ProductDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(ProductDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(ProductDomain domain, ProductModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(ProductDomain domain, ProductModelCriteria criteria) {
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
    public int deleteByModelCriteria(ProductModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
