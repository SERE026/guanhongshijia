package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.CommentSayModelMapper;
import cn.com.dyninfo.o2o.domain.CommentSayDomain;
import cn.com.dyninfo.o2o.mapper.CommentSayDomainMapper;
import cn.com.dyninfo.o2o.model.CommentSayModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class CommentSayDomainService extends BaseService<CommentSayDomain, CommentSayModelCriteria> {

    @Autowired
    CommentSayDomainMapper domainMapper;

    @Autowired
    CommentSayModelMapper modelMapper;

    @Override
    public BaseMapper<CommentSayDomain, CommentSayModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(CommentSayDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(CommentSayDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(CommentSayDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(CommentSayDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(CommentSayDomain domain, CommentSayModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(CommentSayDomain domain, CommentSayModelCriteria criteria) {
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
    public int deleteByModelCriteria(CommentSayModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
