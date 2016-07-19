package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.ControlGroupModel;
import cn.com.dyninfo.o2o.model.ControlGroupModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ControlGroupModelMapper {
    int countByExample(ControlGroupModelCriteria example);

    int deleteByExample(ControlGroupModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ControlGroupModel record);

    int insertSelective(ControlGroupModel record);

    List<ControlGroupModel> selectByExample(ControlGroupModelCriteria example);

    ControlGroupModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ControlGroupModel record, @Param("example") ControlGroupModelCriteria example);

    int updateByExample(@Param("record") ControlGroupModel record, @Param("example") ControlGroupModelCriteria example);

    int updateByPrimaryKeySelective(ControlGroupModel record);

    int updateByPrimaryKey(ControlGroupModel record);
}