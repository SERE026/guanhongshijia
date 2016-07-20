package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.PageModuleInGoodsModelMapper;
import cn.com.dyninfo.o2o.domain.PageModuleInGoodsDomain;
import cn.com.dyninfo.o2o.mapper.PageModuleInGoodsDomainMapper;
import cn.com.dyninfo.o2o.model.PageModuleInGoodsModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class PageModuleInGoodsDomainService extends BaseService<PageModuleInGoodsDomain, PageModuleInGoodsModelCriteria> {

    @Autowired
    PageModuleInGoodsDomainMapper domainMapper;

    @Autowired
    PageModuleInGoodsModelMapper modelMapper;

    @Override
    public BaseMapper<PageModuleInGoodsDomain, PageModuleInGoodsModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(PageModuleInGoodsDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(PageModuleInGoodsDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(PageModuleInGoodsDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(PageModuleInGoodsDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(PageModuleInGoodsDomain domain, PageModuleInGoodsModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(PageModuleInGoodsDomain domain, PageModuleInGoodsModelCriteria criteria) {
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
    public int deleteByModelCriteria(PageModuleInGoodsModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
