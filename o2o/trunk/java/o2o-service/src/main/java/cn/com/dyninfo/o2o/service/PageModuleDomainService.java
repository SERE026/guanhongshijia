package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.PageModuleModelMapper;
import cn.com.dyninfo.o2o.domain.PageModuleDomain;
import cn.com.dyninfo.o2o.mapper.PageModuleDomainMapper;
import cn.com.dyninfo.o2o.model.PageModuleModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class PageModuleDomainService extends BaseService<PageModuleDomain, PageModuleModelCriteria> {

    @Autowired
    PageModuleDomainMapper domainMapper;

    @Autowired
    PageModuleModelMapper modelMapper;

    @Override
    public BaseMapper<PageModuleDomain, PageModuleModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(PageModuleDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(PageModuleDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(PageModuleDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(PageModuleDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(PageModuleDomain domain, PageModuleModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(PageModuleDomain domain, PageModuleModelCriteria criteria) {
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
    public int deleteByModelCriteria(PageModuleModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
