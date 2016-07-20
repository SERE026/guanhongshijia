package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.HuiyuanMoneyModelMapper;
import cn.com.dyninfo.o2o.domain.HuiyuanMoneyDomain;
import cn.com.dyninfo.o2o.mapper.HuiyuanMoneyDomainMapper;
import cn.com.dyninfo.o2o.model.HuiyuanMoneyModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class HuiyuanMoneyDomainService extends BaseService<HuiyuanMoneyDomain, HuiyuanMoneyModelCriteria> {

    @Autowired
    HuiyuanMoneyDomainMapper domainMapper;

    @Autowired
    HuiyuanMoneyModelMapper modelMapper;

    @Override
    public BaseMapper<HuiyuanMoneyDomain, HuiyuanMoneyModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(HuiyuanMoneyDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(HuiyuanMoneyDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(HuiyuanMoneyDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(HuiyuanMoneyDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(HuiyuanMoneyDomain domain, HuiyuanMoneyModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(HuiyuanMoneyDomain domain, HuiyuanMoneyModelCriteria criteria) {
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
    public int deleteByModelCriteria(HuiyuanMoneyModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
