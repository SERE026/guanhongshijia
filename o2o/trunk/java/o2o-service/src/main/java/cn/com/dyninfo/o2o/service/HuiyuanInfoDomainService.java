package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.HuiyuanInfoModelMapper;
import cn.com.dyninfo.o2o.domain.HuiyuanInfoDomain;
import cn.com.dyninfo.o2o.mapper.HuiyuanInfoDomainMapper;
import cn.com.dyninfo.o2o.model.HuiyuanInfoModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class HuiyuanInfoDomainService extends BaseService<HuiyuanInfoDomain, HuiyuanInfoModelCriteria> {

    @Autowired
    HuiyuanInfoDomainMapper domainMapper;

    @Autowired
    HuiyuanInfoModelMapper modelMapper;

    @Override
    public BaseMapper<HuiyuanInfoDomain, HuiyuanInfoModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(HuiyuanInfoDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(HuiyuanInfoDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(HuiyuanInfoDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(HuiyuanInfoDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(HuiyuanInfoDomain domain, HuiyuanInfoModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(HuiyuanInfoDomain domain, HuiyuanInfoModelCriteria criteria) {
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
    public int deleteByModelCriteria(HuiyuanInfoModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
