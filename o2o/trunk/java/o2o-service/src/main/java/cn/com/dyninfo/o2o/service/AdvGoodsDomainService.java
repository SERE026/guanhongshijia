package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.AdvGoodsModelMapper;
import cn.com.dyninfo.o2o.domain.AdvGoodsDomain;
import cn.com.dyninfo.o2o.mapper.AdvGoodsDomainMapper;
import cn.com.dyninfo.o2o.model.AdvGoodsModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class AdvGoodsDomainService extends BaseService<AdvGoodsDomain, AdvGoodsModelCriteria> {

    @Autowired
    AdvGoodsDomainMapper domainMapper;

    @Autowired
    AdvGoodsModelMapper modelMapper;

    @Override
    public BaseMapper<AdvGoodsDomain, AdvGoodsModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(AdvGoodsDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(AdvGoodsDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(AdvGoodsDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(AdvGoodsDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(AdvGoodsDomain domain, AdvGoodsModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(AdvGoodsDomain domain, AdvGoodsModelCriteria criteria) {
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
    public int deleteByModelCriteria(AdvGoodsModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
