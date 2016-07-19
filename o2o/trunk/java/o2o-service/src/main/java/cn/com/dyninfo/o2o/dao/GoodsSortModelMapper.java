package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.GoodsSortModel;
import cn.com.dyninfo.o2o.model.GoodsSortModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsSortModelMapper {
    int countByExample(GoodsSortModelCriteria example);

    int deleteByExample(GoodsSortModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsSortModel record);

    int insertSelective(GoodsSortModel record);

    List<GoodsSortModel> selectByExample(GoodsSortModelCriteria example);

    GoodsSortModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsSortModel record, @Param("example") GoodsSortModelCriteria example);

    int updateByExample(@Param("record") GoodsSortModel record, @Param("example") GoodsSortModelCriteria example);

    int updateByPrimaryKeySelective(GoodsSortModel record);

    int updateByPrimaryKey(GoodsSortModel record);
}