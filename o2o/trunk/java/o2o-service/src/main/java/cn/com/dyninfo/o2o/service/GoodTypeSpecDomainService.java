package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.GoodTypeSpecModelMapper;
import cn.com.dyninfo.o2o.domain.GoodTypeSpecDomain;
import cn.com.dyninfo.o2o.mapper.GoodTypeSpecDomainMapper;
import cn.com.dyninfo.o2o.model.GoodTypeSpecModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class GoodTypeSpecDomainService extends BaseService<GoodTypeSpecDomain, GoodTypeSpecModelCriteria> {

    @Autowired
    GoodTypeSpecDomainMapper domainMapper;

    @Autowired
    GoodTypeSpecModelMapper modelMapper;

    @Override
    public BaseMapper<GoodTypeSpecDomain, GoodTypeSpecModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(GoodTypeSpecDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(GoodTypeSpecDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(GoodTypeSpecDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodTypeSpecDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(GoodTypeSpecDomain domain, GoodTypeSpecModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(GoodTypeSpecDomain domain, GoodTypeSpecModelCriteria criteria) {
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
    public int deleteByModelCriteria(GoodTypeSpecModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
