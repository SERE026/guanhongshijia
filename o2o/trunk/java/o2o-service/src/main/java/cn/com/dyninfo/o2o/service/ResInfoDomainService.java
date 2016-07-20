package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.ResInfoModelMapper;
import cn.com.dyninfo.o2o.domain.ResInfoDomain;
import cn.com.dyninfo.o2o.mapper.ResInfoDomainMapper;
import cn.com.dyninfo.o2o.model.ResInfoModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class ResInfoDomainService extends BaseService<ResInfoDomain, ResInfoModelCriteria> {

    @Autowired
    ResInfoDomainMapper domainMapper;

    @Autowired
    ResInfoModelMapper modelMapper;

    @Override
    public BaseMapper<ResInfoDomain, ResInfoModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(ResInfoDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(ResInfoDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(ResInfoDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(ResInfoDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(ResInfoDomain domain, ResInfoModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(ResInfoDomain domain, ResInfoModelCriteria criteria) {
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
    public int deleteByModelCriteria(ResInfoModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
