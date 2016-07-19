package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.AMenuWzInfoModelMapper;
import cn.com.dyninfo.o2o.domain.AMenuWzInfoDomain;
import cn.com.dyninfo.o2o.mapper.AMenuWzInfoDomainMapper;
import cn.com.dyninfo.o2o.model.AMenuWzInfoModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class AMenuWzInfoDomainService extends BaseService<AMenuWzInfoDomain, AMenuWzInfoModelCriteria> {

    @Autowired
    AMenuWzInfoDomainMapper domainMapper;

    @Autowired
    AMenuWzInfoModelMapper modelMapper;

    @Override
    public BaseMapper<AMenuWzInfoDomain, AMenuWzInfoModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(AMenuWzInfoDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(AMenuWzInfoDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(AMenuWzInfoDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(AMenuWzInfoDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(AMenuWzInfoDomain domain, AMenuWzInfoModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(AMenuWzInfoDomain domain, AMenuWzInfoModelCriteria criteria) {
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
    public int deleteByModelCriteria(AMenuWzInfoModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
