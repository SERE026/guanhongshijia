package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.CarsModel;
import cn.com.dyninfo.o2o.model.CarsModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarsModelMapper {
    int countByExample(CarsModelCriteria example);

    int deleteByExample(CarsModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarsModel record);

    int insertSelective(CarsModel record);

    List<CarsModel> selectByExample(CarsModelCriteria example);

    CarsModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CarsModel record, @Param("example") CarsModelCriteria example);

    int updateByExample(@Param("record") CarsModel record, @Param("example") CarsModelCriteria example);

    int updateByPrimaryKeySelective(CarsModel record);

    int updateByPrimaryKey(CarsModel record);
}