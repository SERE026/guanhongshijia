package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.GoodsTypeOrBrandModel;
import cn.com.dyninfo.o2o.model.GoodsTypeOrBrandModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsTypeOrBrandModelMapper {
    int countByExample(GoodsTypeOrBrandModelCriteria example);

    int deleteByExample(GoodsTypeOrBrandModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsTypeOrBrandModel record);

    int insertSelective(GoodsTypeOrBrandModel record);

    List<GoodsTypeOrBrandModel> selectByExample(GoodsTypeOrBrandModelCriteria example);

    GoodsTypeOrBrandModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsTypeOrBrandModel record, @Param("example") GoodsTypeOrBrandModelCriteria example);

    int updateByExample(@Param("record") GoodsTypeOrBrandModel record, @Param("example") GoodsTypeOrBrandModelCriteria example);

    int updateByPrimaryKeySelective(GoodsTypeOrBrandModel record);

    int updateByPrimaryKey(GoodsTypeOrBrandModel record);
}