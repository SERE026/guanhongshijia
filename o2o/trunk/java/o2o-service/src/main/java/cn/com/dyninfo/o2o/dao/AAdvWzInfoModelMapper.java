package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.AAdvWzInfoModel;
import cn.com.dyninfo.o2o.model.AAdvWzInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AAdvWzInfoModelMapper {
    int countByExample(AAdvWzInfoModelCriteria example);

    int deleteByExample(AAdvWzInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AAdvWzInfoModel record);

    int insertSelective(AAdvWzInfoModel record);

    List<AAdvWzInfoModel> selectByExample(AAdvWzInfoModelCriteria example);

    AAdvWzInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AAdvWzInfoModel record, @Param("example") AAdvWzInfoModelCriteria example);

    int updateByExample(@Param("record") AAdvWzInfoModel record, @Param("example") AAdvWzInfoModelCriteria example);

    int updateByPrimaryKeySelective(AAdvWzInfoModel record);

    int updateByPrimaryKey(AAdvWzInfoModel record);
}