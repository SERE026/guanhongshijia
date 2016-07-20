package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.GoodsModelMapper;
import cn.com.dyninfo.o2o.domain.GoodsDomain;
import cn.com.dyninfo.o2o.mapper.GoodsDomainMapper;
import cn.com.dyninfo.o2o.model.GoodsModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class GoodsDomainService extends BaseService<GoodsDomain, GoodsModelCriteria> {

    @Autowired
    GoodsDomainMapper domainMapper;

    @Autowired
    GoodsModelMapper modelMapper;

    @Override
    public BaseMapper<GoodsDomain, GoodsModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(GoodsDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(GoodsDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(GoodsDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(GoodsDomain domain, GoodsModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(GoodsDomain domain, GoodsModelCriteria criteria) {
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
    public int deleteByModelCriteria(GoodsModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
