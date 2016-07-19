package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.GoodsSpecValModel;
import cn.com.dyninfo.o2o.model.GoodsSpecValModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsSpecValModelMapper {
    int countByExample(GoodsSpecValModelCriteria example);

    int deleteByExample(GoodsSpecValModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsSpecValModel record);

    int insertSelective(GoodsSpecValModel record);

    List<GoodsSpecValModel> selectByExample(GoodsSpecValModelCriteria example);

    GoodsSpecValModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsSpecValModel record, @Param("example") GoodsSpecValModelCriteria example);

    int updateByExample(@Param("record") GoodsSpecValModel record, @Param("example") GoodsSpecValModelCriteria example);

    int updateByPrimaryKeySelective(GoodsSpecValModel record);

    int updateByPrimaryKey(GoodsSpecValModel record);
}