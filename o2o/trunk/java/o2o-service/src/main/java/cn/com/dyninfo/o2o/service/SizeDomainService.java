package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.SizeModelMapper;
import cn.com.dyninfo.o2o.domain.SizeDomain;
import cn.com.dyninfo.o2o.mapper.SizeDomainMapper;
import cn.com.dyninfo.o2o.model.SizeModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class SizeDomainService extends BaseService<SizeDomain, SizeModelCriteria> {

    @Autowired
    SizeDomainMapper domainMapper;

    @Autowired
    SizeModelMapper modelMapper;

    @Override
    public BaseMapper<SizeDomain, SizeModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(SizeDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(SizeDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(SizeDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(SizeDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(SizeDomain domain, SizeModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(SizeDomain domain, SizeModelCriteria criteria) {
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
    public int deleteByModelCriteria(SizeModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
