package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.ShangjiaInfoModelMapper;
import cn.com.dyninfo.o2o.domain.ShangjiaInfoDomain;
import cn.com.dyninfo.o2o.mapper.ShangjiaInfoDomainMapper;
import cn.com.dyninfo.o2o.model.ShangjiaInfoModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class ShangjiaInfoDomainService extends BaseService<ShangjiaInfoDomain,ShangjiaInfoModelCriteria> {

    @Autowired
   ShangjiaInfoDomainMapper domainMapper;

    @Autowired
   ShangjiaInfoModelMapper modelMapper;

    @Override
    public BaseMapper<ShangjiaInfoDomain,ShangjiaInfoModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(ShangjiaInfoDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(ShangjiaInfoDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(ShangjiaInfoDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(ShangjiaInfoDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(ShangjiaInfoDomain domain,ShangjiaInfoModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(ShangjiaInfoDomain domain,ShangjiaInfoModelCriteria criteria) {
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
    public int deleteByModelCriteria(ShangjiaInfoModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
