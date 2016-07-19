package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.RoleControlRelModel;
import cn.com.dyninfo.o2o.model.RoleControlRelModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleControlRelModelMapper {
    int countByExample(RoleControlRelModelCriteria example);

    int deleteByExample(RoleControlRelModelCriteria example);

    int insert(RoleControlRelModel record);

    int insertSelective(RoleControlRelModel record);

    List<RoleControlRelModel> selectByExample(RoleControlRelModelCriteria example);

    int updateByExampleSelective(@Param("record") RoleControlRelModel record, @Param("example") RoleControlRelModelCriteria example);

    int updateByExample(@Param("record") RoleControlRelModel record, @Param("example") RoleControlRelModelCriteria example);
}