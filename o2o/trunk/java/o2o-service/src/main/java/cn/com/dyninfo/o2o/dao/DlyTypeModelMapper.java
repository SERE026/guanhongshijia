package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.DlyTypeModel;
import cn.com.dyninfo.o2o.model.DlyTypeModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DlyTypeModelMapper {
    int countByExample(DlyTypeModelCriteria example);

    int deleteByExample(DlyTypeModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(DlyTypeModel record);

    int insertSelective(DlyTypeModel record);

    List<DlyTypeModel> selectByExample(DlyTypeModelCriteria example);

    DlyTypeModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DlyTypeModel record, @Param("example") DlyTypeModelCriteria example);

    int updateByExample(@Param("record") DlyTypeModel record, @Param("example") DlyTypeModelCriteria example);

    int updateByPrimaryKeySelective(DlyTypeModel record);

    int updateByPrimaryKey(DlyTypeModel record);
}