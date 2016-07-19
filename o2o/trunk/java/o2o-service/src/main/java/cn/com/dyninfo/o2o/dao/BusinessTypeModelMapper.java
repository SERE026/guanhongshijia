package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.BusinessTypeModel;
import cn.com.dyninfo.o2o.model.BusinessTypeModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessTypeModelMapper {
    int countByExample(BusinessTypeModelCriteria example);

    int deleteByExample(BusinessTypeModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusinessTypeModel record);

    int insertSelective(BusinessTypeModel record);

    List<BusinessTypeModel> selectByExample(BusinessTypeModelCriteria example);

    BusinessTypeModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusinessTypeModel record, @Param("example") BusinessTypeModelCriteria example);

    int updateByExample(@Param("record") BusinessTypeModel record, @Param("example") BusinessTypeModelCriteria example);

    int updateByPrimaryKeySelective(BusinessTypeModel record);

    int updateByPrimaryKey(BusinessTypeModel record);
}