package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.ActiveGoodsModelMapper;
import cn.com.dyninfo.o2o.domain.ActiveGoodsDomain;
import cn.com.dyninfo.o2o.mapper.ActiveGoodsDomainMapper;
import cn.com.dyninfo.o2o.model.ActiveGoodsModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class ActiveGoodsDomainService extends BaseService<ActiveGoodsDomain, ActiveGoodsModelCriteria> {

    @Autowired
    ActiveGoodsDomainMapper domainMapper;

    @Autowired
    ActiveGoodsModelMapper modelMapper;

    @Override
    public BaseMapper<ActiveGoodsDomain, ActiveGoodsModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(ActiveGoodsDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(ActiveGoodsDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(ActiveGoodsDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(ActiveGoodsDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(ActiveGoodsDomain domain, ActiveGoodsModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(ActiveGoodsDomain domain, ActiveGoodsModelCriteria criteria) {
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
    public int deleteByModelCriteria(ActiveGoodsModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
