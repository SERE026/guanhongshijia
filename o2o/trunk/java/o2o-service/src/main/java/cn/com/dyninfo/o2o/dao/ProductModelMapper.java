package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.ProductModel;
import cn.com.dyninfo.o2o.model.ProductModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductModelMapper {
    int countByExample(ProductModelCriteria example);

    int deleteByExample(ProductModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductModel record);

    int insertSelective(ProductModel record);

    List<ProductModel> selectByExampleWithBLOBs(ProductModelCriteria example);

    List<ProductModel> selectByExample(ProductModelCriteria example);

    ProductModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductModel record, @Param("example") ProductModelCriteria example);

    int updateByExampleWithBLOBs(@Param("record") ProductModel record, @Param("example") ProductModelCriteria example);

    int updateByExample(@Param("record") ProductModel record, @Param("example") ProductModelCriteria example);

    int updateByPrimaryKeySelective(ProductModel record);

    int updateByPrimaryKeyWithBLOBs(ProductModel record);

    int updateByPrimaryKey(ProductModel record);
}