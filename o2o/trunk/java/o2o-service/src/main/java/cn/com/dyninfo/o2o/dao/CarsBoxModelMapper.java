package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.CarsBoxModel;
import cn.com.dyninfo.o2o.model.CarsBoxModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarsBoxModelMapper {
    int countByExample(CarsBoxModelCriteria example);

    int deleteByExample(CarsBoxModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarsBoxModel record);

    int insertSelective(CarsBoxModel record);

    List<CarsBoxModel> selectByExample(CarsBoxModelCriteria example);

    CarsBoxModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CarsBoxModel record, @Param("example") CarsBoxModelCriteria example);

    int updateByExample(@Param("record") CarsBoxModel record, @Param("example") CarsBoxModelCriteria example);

    int updateByPrimaryKeySelective(CarsBoxModel record);

    int updateByPrimaryKey(CarsBoxModel record);
}