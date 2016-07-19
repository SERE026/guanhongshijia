package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.RoleInfoModel;
import cn.com.dyninfo.o2o.model.RoleInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleInfoModelMapper {
    int countByExample(RoleInfoModelCriteria example);

    int deleteByExample(RoleInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleInfoModel record);

    int insertSelective(RoleInfoModel record);

    List<RoleInfoModel> selectByExample(RoleInfoModelCriteria example);

    RoleInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleInfoModel record, @Param("example") RoleInfoModelCriteria example);

    int updateByExample(@Param("record") RoleInfoModel record, @Param("example") RoleInfoModelCriteria example);

    int updateByPrimaryKeySelective(RoleInfoModel record);

    int updateByPrimaryKey(RoleInfoModel record);
}