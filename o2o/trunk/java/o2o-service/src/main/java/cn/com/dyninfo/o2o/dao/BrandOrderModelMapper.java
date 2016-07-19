package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.BrandOrderModel;
import cn.com.dyninfo.o2o.model.BrandOrderModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandOrderModelMapper {
    int countByExample(BrandOrderModelCriteria example);

    int deleteByExample(BrandOrderModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(BrandOrderModel record);

    int insertSelective(BrandOrderModel record);

    List<BrandOrderModel> selectByExample(BrandOrderModelCriteria example);

    BrandOrderModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BrandOrderModel record, @Param("example") BrandOrderModelCriteria example);

    int updateByExample(@Param("record") BrandOrderModel record, @Param("example") BrandOrderModelCriteria example);

    int updateByPrimaryKeySelective(BrandOrderModel record);

    int updateByPrimaryKey(BrandOrderModel record);
}