package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.FaoritesModel;
import cn.com.dyninfo.o2o.model.FaoritesModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FaoritesModelMapper {
    int countByExample(FaoritesModelCriteria example);

    int deleteByExample(FaoritesModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(FaoritesModel record);

    int insertSelective(FaoritesModel record);

    List<FaoritesModel> selectByExample(FaoritesModelCriteria example);

    FaoritesModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FaoritesModel record, @Param("example") FaoritesModelCriteria example);

    int updateByExample(@Param("record") FaoritesModel record, @Param("example") FaoritesModelCriteria example);

    int updateByPrimaryKeySelective(FaoritesModel record);

    int updateByPrimaryKey(FaoritesModel record);
}