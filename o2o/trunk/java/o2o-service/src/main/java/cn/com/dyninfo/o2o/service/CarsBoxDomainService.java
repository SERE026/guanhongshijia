package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.CarsBoxModelMapper;
import cn.com.dyninfo.o2o.domain.CarsBoxDomain;
import cn.com.dyninfo.o2o.mapper.CarsBoxDomainMapper;
import cn.com.dyninfo.o2o.model.CarsBoxModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class CarsBoxDomainService extends BaseService<CarsBoxDomain, CarsBoxModelCriteria> {

    @Autowired
    CarsBoxDomainMapper domainMapper;

    @Autowired
    CarsBoxModelMapper modelMapper;

    @Override
    public BaseMapper<CarsBoxDomain, CarsBoxModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(CarsBoxDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(CarsBoxDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(CarsBoxDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(CarsBoxDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(CarsBoxDomain domain, CarsBoxModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(CarsBoxDomain domain, CarsBoxModelCriteria criteria) {
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
    public int deleteByModelCriteria(CarsBoxModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
