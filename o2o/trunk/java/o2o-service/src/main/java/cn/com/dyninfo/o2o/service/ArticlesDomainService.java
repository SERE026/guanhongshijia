package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.ArticlesModelMapper;
import cn.com.dyninfo.o2o.domain.ArticlesDomain;
import cn.com.dyninfo.o2o.mapper.ArticlesDomainMapper;
import cn.com.dyninfo.o2o.model.ArticlesModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class ArticlesDomainService extends BaseService<ArticlesDomain, ArticlesModelCriteria> {

    @Autowired
    ArticlesDomainMapper domainMapper;

    @Autowired
    ArticlesModelMapper modelMapper;

    @Override
    public BaseMapper<ArticlesDomain, ArticlesModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(ArticlesDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(ArticlesDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(ArticlesDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(ArticlesDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(ArticlesDomain domain, ArticlesModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(ArticlesDomain domain, ArticlesModelCriteria criteria) {
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
    public int deleteByModelCriteria(ArticlesModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
