package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.PagePathModelMapper;
import cn.com.dyninfo.o2o.domain.PagePathDomain;
import cn.com.dyninfo.o2o.mapper.PagePathDomainMapper;
import cn.com.dyninfo.o2o.model.PagePathModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class PagePathDomainService extends BaseService<PagePathDomain, PagePathModelCriteria> {

    @Autowired
    PagePathDomainMapper domainMapper;

    @Autowired
    PagePathModelMapper modelMapper;

    @Override
    public BaseMapper<PagePathDomain, PagePathModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(PagePathDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(PagePathDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(PagePathDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(PagePathDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(PagePathDomain domain, PagePathModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(PagePathDomain domain, PagePathModelCriteria criteria) {
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
    public int deleteByModelCriteria(PagePathModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
