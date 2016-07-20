package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.ReturneOrderModelMapper;
import cn.com.dyninfo.o2o.domain.ReturneOrderDomain;
import cn.com.dyninfo.o2o.mapper.ReturneOrderDomainMapper;
import cn.com.dyninfo.o2o.model.ReturneOrderModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class ReturneOrderDomainService extends BaseService<ReturneOrderDomain, ReturneOrderModelCriteria> {

    @Autowired
    ReturneOrderDomainMapper domainMapper;

    @Autowired
    ReturneOrderModelMapper modelMapper;

    @Override
    public BaseMapper<ReturneOrderDomain, ReturneOrderModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(ReturneOrderDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(ReturneOrderDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(ReturneOrderDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(ReturneOrderDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(ReturneOrderDomain domain, ReturneOrderModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(ReturneOrderDomain domain, ReturneOrderModelCriteria criteria) {
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
    public int deleteByModelCriteria(ReturneOrderModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
