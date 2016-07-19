package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.AttachInfoModelMapper;
import cn.com.dyninfo.o2o.domain.AttachInfoDomain;
import cn.com.dyninfo.o2o.mapper.AttachInfoDomainMapper;
import cn.com.dyninfo.o2o.model.AttachInfoModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class AttachInfoDomainService extends BaseService<AttachInfoDomain, AttachInfoModelCriteria> {

    @Autowired
    AttachInfoDomainMapper domainMapper;

    @Autowired
    AttachInfoModelMapper modelMapper;

    @Override
    public BaseMapper<AttachInfoDomain, AttachInfoModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(AttachInfoDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(AttachInfoDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(AttachInfoDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(AttachInfoDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(AttachInfoDomain domain, AttachInfoModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(AttachInfoDomain domain, AttachInfoModelCriteria criteria) {
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
    public int deleteByModelCriteria(AttachInfoModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
