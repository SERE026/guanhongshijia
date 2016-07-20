package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.CarsModelMapper;
import cn.com.dyninfo.o2o.domain.CarsDomain;
import cn.com.dyninfo.o2o.mapper.CarsDomainMapper;
import cn.com.dyninfo.o2o.model.CarsModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class CarsDomainService extends BaseService<CarsDomain, CarsModelCriteria> {

    @Autowired
    CarsDomainMapper domainMapper;

    @Autowired
    CarsModelMapper modelMapper;

    @Override
    public BaseMapper<CarsDomain, CarsModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(CarsDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(CarsDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(CarsDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(CarsDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(CarsDomain domain, CarsModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(CarsDomain domain, CarsModelCriteria criteria) {
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
    public int deleteByModelCriteria(CarsModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
