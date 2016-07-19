package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.LogInfoModel;
import cn.com.dyninfo.o2o.model.LogInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogInfoModelMapper {
    int countByExample(LogInfoModelCriteria example);

    int deleteByExample(LogInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(LogInfoModel record);

    int insertSelective(LogInfoModel record);

    List<LogInfoModel> selectByExample(LogInfoModelCriteria example);

    LogInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LogInfoModel record, @Param("example") LogInfoModelCriteria example);

    int updateByExample(@Param("record") LogInfoModel record, @Param("example") LogInfoModelCriteria example);

    int updateByPrimaryKeySelective(LogInfoModel record);

    int updateByPrimaryKey(LogInfoModel record);
}