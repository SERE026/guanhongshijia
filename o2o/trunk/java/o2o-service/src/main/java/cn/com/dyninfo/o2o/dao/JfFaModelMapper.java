package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.JfFaModel;
import cn.com.dyninfo.o2o.model.JfFaModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JfFaModelMapper {
    int countByExample(JfFaModelCriteria example);

    int deleteByExample(JfFaModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(JfFaModel record);

    int insertSelective(JfFaModel record);

    List<JfFaModel> selectByExample(JfFaModelCriteria example);

    JfFaModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JfFaModel record, @Param("example") JfFaModelCriteria example);

    int updateByExample(@Param("record") JfFaModel record, @Param("example") JfFaModelCriteria example);

    int updateByPrimaryKeySelective(JfFaModel record);

    int updateByPrimaryKey(JfFaModel record);
}