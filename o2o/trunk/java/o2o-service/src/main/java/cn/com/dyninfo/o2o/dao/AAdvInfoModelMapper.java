package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.AAdvInfoModel;
import cn.com.dyninfo.o2o.model.AAdvInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AAdvInfoModelMapper {
    int countByExample(AAdvInfoModelCriteria example);

    int deleteByExample(AAdvInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AAdvInfoModel record);

    int insertSelective(AAdvInfoModel record);

    List<AAdvInfoModel> selectByExample(AAdvInfoModelCriteria example);

    AAdvInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AAdvInfoModel record, @Param("example") AAdvInfoModelCriteria example);

    int updateByExample(@Param("record") AAdvInfoModel record, @Param("example") AAdvInfoModelCriteria example);

    int updateByPrimaryKeySelective(AAdvInfoModel record);

    int updateByPrimaryKey(AAdvInfoModel record);
}