package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.GoodSpecModel;
import cn.com.dyninfo.o2o.model.GoodSpecModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodSpecModelMapper {
    int countByExample(GoodSpecModelCriteria example);

    int deleteByExample(GoodSpecModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodSpecModel record);

    int insertSelective(GoodSpecModel record);

    List<GoodSpecModel> selectByExample(GoodSpecModelCriteria example);

    GoodSpecModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodSpecModel record, @Param("example") GoodSpecModelCriteria example);

    int updateByExample(@Param("record") GoodSpecModel record, @Param("example") GoodSpecModelCriteria example);

    int updateByPrimaryKeySelective(GoodSpecModel record);

    int updateByPrimaryKey(GoodSpecModel record);
}