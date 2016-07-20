package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.GoodsSortModelMapper;
import cn.com.dyninfo.o2o.domain.GoodsSortDomain;
import cn.com.dyninfo.o2o.mapper.GoodsSortDomainMapper;
import cn.com.dyninfo.o2o.model.GoodsSortModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class GoodsSortDomainService extends BaseService<GoodsSortDomain, GoodsSortModelCriteria> {

    @Autowired
    GoodsSortDomainMapper domainMapper;

    @Autowired
    GoodsSortModelMapper modelMapper;

    @Override
    public BaseMapper<GoodsSortDomain, GoodsSortModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(GoodsSortDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(GoodsSortDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(GoodsSortDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsSortDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(GoodsSortDomain domain, GoodsSortModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(GoodsSortDomain domain, GoodsSortModelCriteria criteria) {
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
    public int deleteByModelCriteria(GoodsSortModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
