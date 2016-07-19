package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.BrandModel;
import cn.com.dyninfo.o2o.model.BrandModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandModelMapper {
    int countByExample(BrandModelCriteria example);

    int deleteByExample(BrandModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(BrandModel record);

    int insertSelective(BrandModel record);

    List<BrandModel> selectByExample(BrandModelCriteria example);

    BrandModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BrandModel record, @Param("example") BrandModelCriteria example);

    int updateByExample(@Param("record") BrandModel record, @Param("example") BrandModelCriteria example);

    int updateByPrimaryKeySelective(BrandModel record);

    int updateByPrimaryKey(BrandModel record);
}