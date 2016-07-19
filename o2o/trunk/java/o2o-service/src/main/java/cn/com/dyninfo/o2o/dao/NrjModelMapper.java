package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.NrjModel;
import cn.com.dyninfo.o2o.model.NrjModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NrjModelMapper {
    int countByExample(NrjModelCriteria example);

    int deleteByExample(NrjModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(NrjModel record);

    int insertSelective(NrjModel record);

    List<NrjModel> selectByExample(NrjModelCriteria example);

    NrjModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NrjModel record, @Param("example") NrjModelCriteria example);

    int updateByExample(@Param("record") NrjModel record, @Param("example") NrjModelCriteria example);

    int updateByPrimaryKeySelective(NrjModel record);

    int updateByPrimaryKey(NrjModel record);
}