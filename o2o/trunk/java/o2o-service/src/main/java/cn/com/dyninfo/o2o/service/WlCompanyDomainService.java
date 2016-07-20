package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.WlCompanyModelMapper;
import cn.com.dyninfo.o2o.domain.WlCompanyDomain;
import cn.com.dyninfo.o2o.mapper.WlCompanyDomainMapper;
import cn.com.dyninfo.o2o.model.WlCompanyModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class WlCompanyDomainService extends BaseService<WlCompanyDomain, WlCompanyModelCriteria> {

    @Autowired
    WlCompanyDomainMapper domainMapper;

    @Autowired
    WlCompanyModelMapper modelMapper;

    @Override
    public BaseMapper<WlCompanyDomain, WlCompanyModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(WlCompanyDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(WlCompanyDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(WlCompanyDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(WlCompanyDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(WlCompanyDomain domain, WlCompanyModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(WlCompanyDomain domain, WlCompanyModelCriteria criteria) {
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
    public int deleteByModelCriteria(WlCompanyModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
