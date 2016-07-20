package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.ShowGoodModelMapper;
import cn.com.dyninfo.o2o.domain.ShowGoodDomain;
import cn.com.dyninfo.o2o.mapper.ShowGoodDomainMapper;
import cn.com.dyninfo.o2o.model.ShowGoodModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class ShowGoodDomainService extends BaseService<ShowGoodDomain, ShowGoodModelCriteria> {

    @Autowired
    ShowGoodDomainMapper domainMapper;

    @Autowired
    ShowGoodModelMapper modelMapper;

    @Override
    public BaseMapper<ShowGoodDomain, ShowGoodModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(ShowGoodDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(ShowGoodDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(ShowGoodDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(ShowGoodDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(ShowGoodDomain domain, ShowGoodModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(ShowGoodDomain domain, ShowGoodModelCriteria criteria) {
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
    public int deleteByModelCriteria(ShowGoodModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
