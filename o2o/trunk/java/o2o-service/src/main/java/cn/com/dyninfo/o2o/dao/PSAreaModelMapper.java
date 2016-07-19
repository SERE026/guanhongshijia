package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.PSAreaModel;
import cn.com.dyninfo.o2o.model.PSAreaModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PSAreaModelMapper {
    int countByExample(PSAreaModelCriteria example);

    int deleteByExample(PSAreaModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(PSAreaModel record);

    int insertSelective(PSAreaModel record);

    List<PSAreaModel> selectByExampleWithBLOBs(PSAreaModelCriteria example);

    List<PSAreaModel> selectByExample(PSAreaModelCriteria example);

    PSAreaModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PSAreaModel record, @Param("example") PSAreaModelCriteria example);

    int updateByExampleWithBLOBs(@Param("record") PSAreaModel record, @Param("example") PSAreaModelCriteria example);

    int updateByExample(@Param("record") PSAreaModel record, @Param("example") PSAreaModelCriteria example);

    int updateByPrimaryKeySelective(PSAreaModel record);

    int updateByPrimaryKeyWithBLOBs(PSAreaModel record);

    int updateByPrimaryKey(PSAreaModel record);
}