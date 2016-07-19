package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.AreaXInfoModel;
import cn.com.dyninfo.o2o.model.AreaXInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AreaXInfoModelMapper {
    int countByExample(AreaXInfoModelCriteria example);

    int deleteByExample(AreaXInfoModelCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(AreaXInfoModel record);

    int insertSelective(AreaXInfoModel record);

    List<AreaXInfoModel> selectByExampleWithBLOBs(AreaXInfoModelCriteria example);

    List<AreaXInfoModel> selectByExample(AreaXInfoModelCriteria example);

    AreaXInfoModel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AreaXInfoModel record, @Param("example") AreaXInfoModelCriteria example);

    int updateByExampleWithBLOBs(@Param("record") AreaXInfoModel record, @Param("example") AreaXInfoModelCriteria example);

    int updateByExample(@Param("record") AreaXInfoModel record, @Param("example") AreaXInfoModelCriteria example);

    int updateByPrimaryKeySelective(AreaXInfoModel record);

    int updateByPrimaryKeyWithBLOBs(AreaXInfoModel record);

    int updateByPrimaryKey(AreaXInfoModel record);
}