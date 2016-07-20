package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.GoodsSpecValModelMapper;
import cn.com.dyninfo.o2o.domain.GoodsSpecValDomain;
import cn.com.dyninfo.o2o.mapper.GoodsSpecValDomainMapper;
import cn.com.dyninfo.o2o.model.GoodsSpecValModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class GoodsSpecValDomainService extends BaseService<GoodsSpecValDomain, GoodsSpecValModelCriteria> {

    @Autowired
    GoodsSpecValDomainMapper domainMapper;

    @Autowired
    GoodsSpecValModelMapper modelMapper;

    @Override
    public BaseMapper<GoodsSpecValDomain, GoodsSpecValModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(GoodsSpecValDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(GoodsSpecValDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(GoodsSpecValDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsSpecValDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(GoodsSpecValDomain domain, GoodsSpecValModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(GoodsSpecValDomain domain, GoodsSpecValModelCriteria criteria) {
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
    public int deleteByModelCriteria(GoodsSpecValModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
