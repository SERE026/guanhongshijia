package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.JfAddInfoModel;
import cn.com.dyninfo.o2o.model.JfAddInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JfAddInfoModelMapper{
    int countByExample(JfAddInfoModelCriteria example);

    int deleteByExample(JfAddInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(JfAddInfoModel record);

    int insertSelective(JfAddInfoModel record);

    List<JfAddInfoModel> selectByExample(JfAddInfoModelCriteria example);

    JfAddInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JfAddInfoModel record, @Param("example") JfAddInfoModelCriteria example);

    int updateByExample(@Param("record") JfAddInfoModel record, @Param("example") JfAddInfoModelCriteria example);

    int updateByPrimaryKeySelective(JfAddInfoModel record);

    int updateByPrimaryKey(JfAddInfoModel record);
}