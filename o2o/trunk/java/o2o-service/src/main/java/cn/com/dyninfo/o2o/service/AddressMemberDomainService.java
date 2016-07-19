package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.AddressMemberModelMapper;
import cn.com.dyninfo.o2o.domain.AddressMemberDomain;
import cn.com.dyninfo.o2o.mapper.AddressMemberDomainMapper;
import cn.com.dyninfo.o2o.model.AddressMemberModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class AddressMemberDomainService extends BaseService<AddressMemberDomain, AddressMemberModelCriteria> {

    @Autowired
    AddressMemberDomainMapper domainMapper;

    @Autowired
    AddressMemberModelMapper modelMapper;

    @Override
    public BaseMapper<AddressMemberDomain, AddressMemberModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(AddressMemberDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(AddressMemberDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(AddressMemberDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(AddressMemberDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(AddressMemberDomain domain, AddressMemberModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(AddressMemberDomain domain, AddressMemberModelCriteria criteria) {
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
    public int deleteByModelCriteria(AddressMemberModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
