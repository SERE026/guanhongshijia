package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.MerchantsApplyModel;
import cn.com.dyninfo.o2o.model.MerchantsApplyModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantsApplyModelMapper {
    int countByExample(MerchantsApplyModelCriteria example);

    int deleteByExample(MerchantsApplyModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(MerchantsApplyModel record);

    int insertSelective(MerchantsApplyModel record);

    List<MerchantsApplyModel> selectByExample(MerchantsApplyModelCriteria example);

    MerchantsApplyModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MerchantsApplyModel record, @Param("example") MerchantsApplyModelCriteria example);

    int updateByExample(@Param("record") MerchantsApplyModel record, @Param("example") MerchantsApplyModelCriteria example);

    int updateByPrimaryKeySelective(MerchantsApplyModel record);

    int updateByPrimaryKey(MerchantsApplyModel record);
}