package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.CkhdspModel;
import cn.com.dyninfo.o2o.model.CkhdspModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CkhdspModelMapper {
    int countByExample(CkhdspModelCriteria example);

    int deleteByExample(CkhdspModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CkhdspModel record);

    int insertSelective(CkhdspModel record);

    List<CkhdspModel> selectByExample(CkhdspModelCriteria example);

    CkhdspModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CkhdspModel record, @Param("example") CkhdspModelCriteria example);

    int updateByExample(@Param("record") CkhdspModel record, @Param("example") CkhdspModelCriteria example);

    int updateByPrimaryKeySelective(CkhdspModel record);

    int updateByPrimaryKey(CkhdspModel record);
}