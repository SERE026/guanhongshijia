package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.NoteModelMapper;
import cn.com.dyninfo.o2o.domain.NoteDomain;
import cn.com.dyninfo.o2o.mapper.NoteDomainMapper;
import cn.com.dyninfo.o2o.model.NoteModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class NoteDomainService extends BaseService<NoteDomain, NoteModelCriteria> {

    @Autowired
    NoteDomainMapper domainMapper;

    @Autowired
    NoteModelMapper modelMapper;

    @Override
    public BaseMapper<NoteDomain, NoteModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(NoteDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(NoteDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(NoteDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(NoteDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(NoteDomain domain, NoteModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(NoteDomain domain, NoteModelCriteria criteria) {
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
    public int deleteByModelCriteria(NoteModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
