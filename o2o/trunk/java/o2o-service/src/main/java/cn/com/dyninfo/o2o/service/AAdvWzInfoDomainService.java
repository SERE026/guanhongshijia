package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.AAdvWzInfoModelMapper;
import cn.com.dyninfo.o2o.domain.AAdvWzInfoDomain;
import cn.com.dyninfo.o2o.mapper.AAdvWzInfoDomainMapper;
import cn.com.dyninfo.o2o.model.AAdvWzInfoModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class AAdvWzInfoDomainService extends BaseService<AAdvWzInfoDomain, AAdvWzInfoModelCriteria> {

    @Autowired
    AAdvWzInfoDomainMapper domainMapper;

    @Autowired
    AAdvWzInfoModelMapper modelMapper;

    @Override
    public BaseMapper<AAdvWzInfoDomain, AAdvWzInfoModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(AAdvWzInfoDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(AAdvWzInfoDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(AAdvWzInfoDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(AAdvWzInfoDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(AAdvWzInfoDomain domain, AAdvWzInfoModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(AAdvWzInfoDomain domain, AAdvWzInfoModelCriteria criteria) {
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
    public int deleteByModelCriteria(AAdvWzInfoModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
