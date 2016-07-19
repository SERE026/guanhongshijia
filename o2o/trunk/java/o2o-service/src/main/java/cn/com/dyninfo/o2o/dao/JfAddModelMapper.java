package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.JfAddModel;
import cn.com.dyninfo.o2o.model.JfAddModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JfAddModelMapper {
    int countByExample(JfAddModelCriteria example);

    int deleteByExample(JfAddModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(JfAddModel record);

    int insertSelective(JfAddModel record);

    List<JfAddModel> selectByExample(JfAddModelCriteria example);

    JfAddModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JfAddModel record, @Param("example") JfAddModelCriteria example);

    int updateByExample(@Param("record") JfAddModel record, @Param("example") JfAddModelCriteria example);

    int updateByPrimaryKeySelective(JfAddModel record);

    int updateByPrimaryKey(JfAddModel record);
}