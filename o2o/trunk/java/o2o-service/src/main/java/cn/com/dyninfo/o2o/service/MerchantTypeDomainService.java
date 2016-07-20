package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.MerchantTypeModelMapper;
import cn.com.dyninfo.o2o.domain.MerchantTypeDomain;
import cn.com.dyninfo.o2o.mapper.MerchantTypeDomainMapper;
import cn.com.dyninfo.o2o.model.MerchantTypeModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class MerchantTypeDomainService extends BaseService<MerchantTypeDomain, MerchantTypeModelCriteria> {

    @Autowired
    MerchantTypeDomainMapper domainMapper;

    @Autowired
    MerchantTypeModelMapper modelMapper;

    @Override
    public BaseMapper<MerchantTypeDomain, MerchantTypeModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(MerchantTypeDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(MerchantTypeDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(MerchantTypeDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(MerchantTypeDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(MerchantTypeDomain domain, MerchantTypeModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(MerchantTypeDomain domain, MerchantTypeModelCriteria criteria) {
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
    public int deleteByModelCriteria(MerchantTypeModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
