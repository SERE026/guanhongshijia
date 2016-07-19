package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.UserRoleRelModel;
import cn.com.dyninfo.o2o.model.UserRoleRelModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleRelModelMapper {
    int countByExample(UserRoleRelModelCriteria example);

    int deleteByExample(UserRoleRelModelCriteria example);

    int insert(UserRoleRelModel record);

    int insertSelective(UserRoleRelModel record);

    List<UserRoleRelModel> selectByExample(UserRoleRelModelCriteria example);

    int updateByExampleSelective(@Param("record") UserRoleRelModel record, @Param("example") UserRoleRelModelCriteria example);

    int updateByExample(@Param("record") UserRoleRelModel record, @Param("example") UserRoleRelModelCriteria example);
}