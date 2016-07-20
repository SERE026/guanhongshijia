package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.OgnzInfoModelMapper;
import cn.com.dyninfo.o2o.domain.OgnzInfoDomain;
import cn.com.dyninfo.o2o.mapper.OgnzInfoDomainMapper;
import cn.com.dyninfo.o2o.model.OgnzInfoModelCriteria;
import cn.com.dyninfo.o2o.model.OgnzInfoModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class OgnzInfoDomainService extends BaseService<OgnzInfoDomain, OgnzInfoModelCriteria> {

    @Autowired
    OgnzInfoDomainMapper domainMapper;

    @Autowired
    OgnzInfoModelMapper modelMapper;

    @Override
    public BaseMapper<OgnzInfoDomain, OgnzInfoModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(OgnzInfoDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(OgnzInfoDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(OgnzInfoDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(OgnzInfoDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(OgnzInfoDomain domain, OgnzInfoModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(OgnzInfoDomain domain, OgnzInfoModelCriteria criteria) {
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
    public int deleteByModelCriteria(OgnzInfoModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
