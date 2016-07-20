package cn.com.dyninfo.o2o.service;

import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import cn.com.dyninfo.o2o.common.service.BaseService;
import cn.com.dyninfo.o2o.dao.BbsPostInfoModelMapper;
import cn.com.dyninfo.o2o.domain.BbsPostInfoDomain;
import cn.com.dyninfo.o2o.mapper.BbsPostInfoDomainMapper;
import cn.com.dyninfo.o2o.model.BbsPostInfoModelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
@Transactional
public class BbsPostInfoDomainService extends BaseService<BbsPostInfoDomain, BbsPostInfoModelCriteria> {

    @Autowired
    BbsPostInfoDomainMapper domainMapper;

    @Autowired
    BbsPostInfoModelMapper modelMapper;

    @Override
    public BaseMapper<BbsPostInfoDomain, BbsPostInfoModelCriteria> getDomainMapper() {
        return domainMapper;
    }

    @Override
    public int insert(BbsPostInfoDomain domain) {
        return modelMapper.insert(domain);
    }

    @Override
    public int insertSelective(BbsPostInfoDomain domain) {
        return modelMapper.insertSelective(domain);
    }

    @Override
    public int updateByPrimaryKey(BbsPostInfoDomain domain) {
        return modelMapper.updateByPrimaryKey(domain);
    }

    @Override
    public int updateByPrimaryKeySelective(BbsPostInfoDomain domain) {
        return modelMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public int updateByModelCriteriaSelective(BbsPostInfoDomain domain, BbsPostInfoModelCriteria criteria) {
        return modelMapper.updateByExampleSelective(domain, criteria);
    }

    @Override
    public int updateByModelCriteria(BbsPostInfoDomain domain, BbsPostInfoModelCriteria criteria) {
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
    public int deleteByModelCriteria(BbsPostInfoModelCriteria criteria) {
        return modelMapper.deleteByExample(criteria);
    }
}
