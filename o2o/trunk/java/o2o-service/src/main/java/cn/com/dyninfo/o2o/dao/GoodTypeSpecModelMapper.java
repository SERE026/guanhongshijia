package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.GoodTypeSpecModel;
import cn.com.dyninfo.o2o.model.GoodTypeSpecModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodTypeSpecModelMapper {
    int countByExample(GoodTypeSpecModelCriteria example);

    int deleteByExample(GoodTypeSpecModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodTypeSpecModel record);

    int insertSelective(GoodTypeSpecModel record);

    List<GoodTypeSpecModel> selectByExample(GoodTypeSpecModelCriteria example);

    GoodTypeSpecModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodTypeSpecModel record, @Param("example") GoodTypeSpecModelCriteria example);

    int updateByExample(@Param("record") GoodTypeSpecModel record, @Param("example") GoodTypeSpecModelCriteria example);

    int updateByPrimaryKeySelective(GoodTypeSpecModel record);

    int updateByPrimaryKey(GoodTypeSpecModel record);
}