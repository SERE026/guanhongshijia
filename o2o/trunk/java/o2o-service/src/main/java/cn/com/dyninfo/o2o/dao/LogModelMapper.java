package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.LogModel;
import cn.com.dyninfo.o2o.model.LogModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogModelMapper {
    int countByExample(LogModelCriteria example);

    int deleteByExample(LogModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(LogModel record);

    int insertSelective(LogModel record);

    List<LogModel> selectByExample(LogModelCriteria example);

    LogModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LogModel record, @Param("example") LogModelCriteria example);

    int updateByExample(@Param("record") LogModel record, @Param("example") LogModelCriteria example);

    int updateByPrimaryKeySelective(LogModel record);

    int updateByPrimaryKey(LogModel record);
}