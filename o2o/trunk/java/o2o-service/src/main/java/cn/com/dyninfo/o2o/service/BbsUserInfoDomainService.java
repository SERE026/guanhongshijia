package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.BbsUserInfoModelMapper;
import cn.com.dyninfo.o2o.domain.BbsUserInfoDomain;
import cn.com.dyninfo.o2o.mapper.BbsUserInfoDomainMapper;
import cn.com.dyninfo.o2o.model.BbsUserInfoModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class BbsUserInfoDomainService extends BaseService<BbsUserInfoDomain, BbsUserInfoModelCriteria> {

    @Autowired
    BbsUserInfoDomainMapper domainMapper;

    @Autowired
    BbsUserInfoModelMapper modelMapper;

    @Override
    public BaseMapper<BbsUserInfoDomain, BbsUserInfoModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(BbsUserInfoDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(BbsUserInfoDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(BbsUserInfoDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(BbsUserInfoDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(BbsUserInfoDomain domain, BbsUserInfoModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(BbsUserInfoDomain domain, BbsUserInfoModelCriteria criteria) {
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
    public int deleteByModelCriteria(BbsUserInfoModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
