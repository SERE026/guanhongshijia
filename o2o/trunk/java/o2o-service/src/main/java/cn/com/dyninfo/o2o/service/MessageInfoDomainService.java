package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.MessageInfoModelMapper;
import cn.com.dyninfo.o2o.domain.MessageInfoDomain;
import cn.com.dyninfo.o2o.mapper.MessageInfoDomainMapper;
import cn.com.dyninfo.o2o.model.MessageInfoModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class MessageInfoDomainService extends BaseService<MessageInfoDomain, MessageInfoModelCriteria> {

    @Autowired
    MessageInfoDomainMapper domainMapper;

    @Autowired
    MessageInfoModelMapper modelMapper;

    @Override
    public BaseMapper<MessageInfoDomain, MessageInfoModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(MessageInfoDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(MessageInfoDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(MessageInfoDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(MessageInfoDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(MessageInfoDomain domain, MessageInfoModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(MessageInfoDomain domain, MessageInfoModelCriteria criteria) {
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
    public int deleteByModelCriteria(MessageInfoModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
