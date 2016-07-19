package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.GoodsTypeModel;
import cn.com.dyninfo.o2o.model.GoodsTypeModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsTypeModelMapper {
    int countByExample(GoodsTypeModelCriteria example);

    int deleteByExample(GoodsTypeModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsTypeModel record);

    int insertSelective(GoodsTypeModel record);

    List<GoodsTypeModel> selectByExampleWithBLOBs(GoodsTypeModelCriteria example);

    List<GoodsTypeModel> selectByExample(GoodsTypeModelCriteria example);

    GoodsTypeModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsTypeModel record, @Param("example") GoodsTypeModelCriteria example);

    int updateByExampleWithBLOBs(@Param("record") GoodsTypeModel record, @Param("example") GoodsTypeModelCriteria example);

    int updateByExample(@Param("record") GoodsTypeModel record, @Param("example") GoodsTypeModelCriteria example);

    int updateByPrimaryKeySelective(GoodsTypeModel record);

    int updateByPrimaryKeyWithBLOBs(GoodsTypeModel record);

    int updateByPrimaryKey(GoodsTypeModel record);
}