package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.AMenuWzInfoModel;
import cn.com.dyninfo.o2o.model.AMenuWzInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AMenuWzInfoModelMapper {
    int countByExample(AMenuWzInfoModelCriteria example);

    int deleteByExample(AMenuWzInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AMenuWzInfoModel record);

    int insertSelective(AMenuWzInfoModel record);

    List<AMenuWzInfoModel> selectByExample(AMenuWzInfoModelCriteria example);

    AMenuWzInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AMenuWzInfoModel record, @Param("example") AMenuWzInfoModelCriteria example);

    int updateByExample(@Param("record") AMenuWzInfoModel record, @Param("example") AMenuWzInfoModelCriteria example);

    int updateByPrimaryKeySelective(AMenuWzInfoModel record);

    int updateByPrimaryKey(AMenuWzInfoModel record);
}