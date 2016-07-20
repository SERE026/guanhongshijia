package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.CkhdspModelMapper;
import cn.com.dyninfo.o2o.domain.CkhdspDomain;
import cn.com.dyninfo.o2o.mapper.CkhdspDomainMapper;
import cn.com.dyninfo.o2o.model.CkhdspModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class CkhdspDomainService extends BaseService<CkhdspDomain, CkhdspModelCriteria> {

    @Autowired
    CkhdspDomainMapper domainMapper;

    @Autowired
    CkhdspModelMapper modelMapper;

    @Override
    public BaseMapper<CkhdspDomain, CkhdspModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(CkhdspDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(CkhdspDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(CkhdspDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(CkhdspDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(CkhdspDomain domain, CkhdspModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(CkhdspDomain domain, CkhdspModelCriteria criteria) {
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
    public int deleteByModelCriteria(CkhdspModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
