package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.JfFaInfoModel;
import cn.com.dyninfo.o2o.model.JfFaInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JfFaInfoModelMapper {
    int countByExample(JfFaInfoModelCriteria example);

    int deleteByExample(JfFaInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(JfFaInfoModel record);

    int insertSelective(JfFaInfoModel record);

    List<JfFaInfoModel> selectByExample(JfFaInfoModelCriteria example);

    JfFaInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JfFaInfoModel record, @Param("example") JfFaInfoModelCriteria example);

    int updateByExample(@Param("record") JfFaInfoModel record, @Param("example") JfFaInfoModelCriteria example);

    int updateByPrimaryKeySelective(JfFaInfoModel record);

    int updateByPrimaryKey(JfFaInfoModel record);
}