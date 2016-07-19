package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.TryUseApplyModel;
import cn.com.dyninfo.o2o.model.TryUseApplyModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TryUseApplyModelMapper {
    int countByExample(TryUseApplyModelCriteria example);

    int deleteByExample(TryUseApplyModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TryUseApplyModel record);

    int insertSelective(TryUseApplyModel record);

    List<TryUseApplyModel> selectByExample(TryUseApplyModelCriteria example);

    TryUseApplyModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TryUseApplyModel record, @Param("example") TryUseApplyModelCriteria example);

    int updateByExample(@Param("record") TryUseApplyModel record, @Param("example") TryUseApplyModelCriteria example);

    int updateByPrimaryKeySelective(TryUseApplyModel record);

    int updateByPrimaryKey(TryUseApplyModel record);
}