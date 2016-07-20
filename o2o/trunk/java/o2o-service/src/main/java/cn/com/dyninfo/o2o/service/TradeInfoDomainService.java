package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.TradeInfoModelMapper;
import cn.com.dyninfo.o2o.domain.TradeInfoDomain;
import cn.com.dyninfo.o2o.mapper.TradeInfoDomainMapper;
import cn.com.dyninfo.o2o.model.TradeInfoModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class TradeInfoDomainService extends BaseService<TradeInfoDomain, TradeInfoModelCriteria> {

    @Autowired
    TradeInfoDomainMapper domainMapper;

    @Autowired
    TradeInfoModelMapper modelMapper;

    @Override
    public BaseMapper<TradeInfoDomain, TradeInfoModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(TradeInfoDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(TradeInfoDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(TradeInfoDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(TradeInfoDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(TradeInfoDomain domain, TradeInfoModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(TradeInfoDomain domain, TradeInfoModelCriteria criteria) {
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
    public int deleteByModelCriteria(TradeInfoModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
