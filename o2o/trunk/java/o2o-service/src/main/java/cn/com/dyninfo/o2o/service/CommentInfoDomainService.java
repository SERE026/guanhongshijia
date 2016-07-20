package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.CommentInfoModelMapper;
import cn.com.dyninfo.o2o.domain.CommentInfoDomain;
import cn.com.dyninfo.o2o.mapper.CommentInfoDomainMapper;
import cn.com.dyninfo.o2o.model.CommentInfoModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class CommentInfoDomainService extends BaseService<CommentInfoDomain, CommentInfoModelCriteria> {

    @Autowired
    CommentInfoDomainMapper domainMapper;

    @Autowired
    CommentInfoModelMapper modelMapper;

    @Override
    public BaseMapper<CommentInfoDomain, CommentInfoModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(CommentInfoDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(CommentInfoDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(CommentInfoDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(CommentInfoDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(CommentInfoDomain domain, CommentInfoModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(CommentInfoDomain domain, CommentInfoModelCriteria criteria) {
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
    public int deleteByModelCriteria(CommentInfoModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
