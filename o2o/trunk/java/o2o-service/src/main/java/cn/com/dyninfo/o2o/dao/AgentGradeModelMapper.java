package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.AgentGradeModel;
import cn.com.dyninfo.o2o.model.AgentGradeModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AgentGradeModelMapper {
    int countByExample(AgentGradeModelCriteria example);

    int deleteByExample(AgentGradeModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AgentGradeModel record);

    int insertSelective(AgentGradeModel record);

    List<AgentGradeModel> selectByExample(AgentGradeModelCriteria example);

    AgentGradeModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AgentGradeModel record, @Param("example") AgentGradeModelCriteria example);

    int updateByExample(@Param("record") AgentGradeModel record, @Param("example") AgentGradeModelCriteria example);

    int updateByPrimaryKeySelective(AgentGradeModel record);

    int updateByPrimaryKey(AgentGradeModel record);
}