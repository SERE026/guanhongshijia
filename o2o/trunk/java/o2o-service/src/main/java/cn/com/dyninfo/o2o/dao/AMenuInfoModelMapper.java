package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.AMenuInfoModel;
import cn.com.dyninfo.o2o.model.AMenuInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AMenuInfoModelMapper {
    int countByExample(AMenuInfoModelCriteria example);

    int deleteByExample(AMenuInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AMenuInfoModel record);

    int insertSelective(AMenuInfoModel record);

    List<AMenuInfoModel> selectByExample(AMenuInfoModelCriteria example);

    AMenuInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AMenuInfoModel record, @Param("example") AMenuInfoModelCriteria example);

    int updateByExample(@Param("record") AMenuInfoModel record, @Param("example") AMenuInfoModelCriteria example);

    int updateByPrimaryKeySelective(AMenuInfoModel record);

    int updateByPrimaryKey(AMenuInfoModel record);
}