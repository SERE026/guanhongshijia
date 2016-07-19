package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.AAdvInfoModelMapper;
import cn.com.dyninfo.o2o.domain.AAdvInfoDomain;
import cn.com.dyninfo.o2o.mapper.AAdvInfoDomainMapper;
import cn.com.dyninfo.o2o.model.AAdvInfoModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class AAdvInfoDomainService extends BaseService<AAdvInfoDomain, AAdvInfoModelCriteria> {

    @Autowired
    AAdvInfoDomainMapper domainMapper;

    @Autowired
    AAdvInfoModelMapper modelMapper;

    @Override
    public BaseMapper<AAdvInfoDomain, AAdvInfoModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(AAdvInfoDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(AAdvInfoDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(AAdvInfoDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(AAdvInfoDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(AAdvInfoDomain domain, AAdvInfoModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(AAdvInfoDomain domain, AAdvInfoModelCriteria criteria) {
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
    public int deleteByModelCriteria(AAdvInfoModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
