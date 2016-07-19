package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.ActiveModel;
import cn.com.dyninfo.o2o.model.ActiveModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActiveModelMapper {
    int countByExample(ActiveModelCriteria example);

    int deleteByExample(ActiveModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActiveModel record);

    int insertSelective(ActiveModel record);

    List<ActiveModel> selectByExampleWithBLOBs(ActiveModelCriteria example);

    List<ActiveModel> selectByExample(ActiveModelCriteria example);

    ActiveModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActiveModel record, @Param("example") ActiveModelCriteria example);

    int updateByExampleWithBLOBs(@Param("record") ActiveModel record, @Param("example") ActiveModelCriteria example);

    int updateByExample(@Param("record") ActiveModel record, @Param("example") ActiveModelCriteria example);

    int updateByPrimaryKeySelective(ActiveModel record);

    int updateByPrimaryKeyWithBLOBs(ActiveModel record);

    int updateByPrimaryKey(ActiveModel record);
}