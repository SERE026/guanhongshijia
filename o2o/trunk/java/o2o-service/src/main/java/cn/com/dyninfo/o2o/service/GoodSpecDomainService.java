package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.GoodSpecModelMapper;
import cn.com.dyninfo.o2o.domain.GoodSpecDomain;
import cn.com.dyninfo.o2o.mapper.GoodSpecDomainMapper;
import cn.com.dyninfo.o2o.model.GoodSpecModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class GoodSpecDomainService extends BaseService<GoodSpecDomain, GoodSpecModelCriteria> {

    @Autowired
    GoodSpecDomainMapper domainMapper;

    @Autowired
    GoodSpecModelMapper modelMapper;

    @Override
    public BaseMapper<GoodSpecDomain, GoodSpecModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(GoodSpecDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(GoodSpecDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(GoodSpecDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodSpecDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(GoodSpecDomain domain, GoodSpecModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(GoodSpecDomain domain, GoodSpecModelCriteria criteria) {
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
    public int deleteByModelCriteria(GoodSpecModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
