package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.AMenuInfoModelMapper;
import cn.com.dyninfo.o2o.domain.AMenuInfoDomain;
import cn.com.dyninfo.o2o.mapper.AMenuInfoDomainMapper;
import cn.com.dyninfo.o2o.model.AMenuInfoModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class AMenuInfoDomainService extends BaseService<AMenuInfoDomain, AMenuInfoModelCriteria> {

    @Autowired
    AMenuInfoDomainMapper domainMapper;

    @Autowired
    AMenuInfoModelMapper modelMapper;

    @Override
    public BaseMapper<AMenuInfoDomain, AMenuInfoModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(AMenuInfoDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(AMenuInfoDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(AMenuInfoDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(AMenuInfoDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(AMenuInfoDomain domain, AMenuInfoModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(AMenuInfoDomain domain, AMenuInfoModelCriteria criteria) {
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
    public int deleteByModelCriteria(AMenuInfoModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
