package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.ResInfoModel;
import cn.com.dyninfo.o2o.model.ResInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResInfoModelMapper {
    int countByExample(ResInfoModelCriteria example);

    int deleteByExample(ResInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ResInfoModel record);

    int insertSelective(ResInfoModel record);

    List<ResInfoModel> selectByExampleWithBLOBs(ResInfoModelCriteria example);

    List<ResInfoModel> selectByExample(ResInfoModelCriteria example);

    ResInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ResInfoModel record, @Param("example") ResInfoModelCriteria example);

    int updateByExampleWithBLOBs(@Param("record") ResInfoModel record, @Param("example") ResInfoModelCriteria example);

    int updateByExample(@Param("record") ResInfoModel record, @Param("example") ResInfoModelCriteria example);

    int updateByPrimaryKeySelective(ResInfoModel record);

    int updateByPrimaryKeyWithBLOBs(ResInfoModel record);

    int updateByPrimaryKey(ResInfoModel record);
}