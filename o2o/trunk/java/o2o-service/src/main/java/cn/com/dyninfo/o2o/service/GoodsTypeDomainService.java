package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.GoodsTypeModelMapper;
import cn.com.dyninfo.o2o.domain.GoodsTypeDomain;
import cn.com.dyninfo.o2o.mapper.GoodsTypeDomainMapper;
import cn.com.dyninfo.o2o.model.GoodsTypeModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class GoodsTypeDomainService extends BaseService<GoodsTypeDomain, GoodsTypeModelCriteria> {

    @Autowired
    GoodsTypeDomainMapper domainMapper;

    @Autowired
    GoodsTypeModelMapper modelMapper;

    @Override
    public BaseMapper<GoodsTypeDomain, GoodsTypeModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(GoodsTypeDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(GoodsTypeDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(GoodsTypeDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsTypeDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(GoodsTypeDomain domain, GoodsTypeModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(GoodsTypeDomain domain, GoodsTypeModelCriteria criteria) {
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
    public int deleteByModelCriteria(GoodsTypeModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
