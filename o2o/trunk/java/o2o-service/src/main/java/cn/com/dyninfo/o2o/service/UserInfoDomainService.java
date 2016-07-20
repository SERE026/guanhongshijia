package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.UserInfoModelMapper;
import cn.com.dyninfo.o2o.domain.UserInfoDomain;
import cn.com.dyninfo.o2o.mapper.UserInfoDomainMapper;
import cn.com.dyninfo.o2o.model.UserInfoModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class UserInfoDomainService extends BaseService<UserInfoDomain, UserInfoModelCriteria> {

    @Autowired
    UserInfoDomainMapper domainMapper;

    @Autowired
    UserInfoModelMapper modelMapper;

    @Override
    public BaseMapper<UserInfoDomain, UserInfoModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(UserInfoDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(UserInfoDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(UserInfoDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfoDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(UserInfoDomain domain, UserInfoModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(UserInfoDomain domain, UserInfoModelCriteria criteria) {
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
    public int deleteByModelCriteria(UserInfoModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
