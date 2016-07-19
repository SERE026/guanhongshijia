package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.UserInfoModel;
import cn.com.dyninfo.o2o.model.UserInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoModelMapper {
    int countByExample(UserInfoModelCriteria example);

    int deleteByExample(UserInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfoModel record);

    int insertSelective(UserInfoModel record);

    List<UserInfoModel> selectByExampleWithBLOBs(UserInfoModelCriteria example);

    List<UserInfoModel> selectByExample(UserInfoModelCriteria example);

    UserInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserInfoModel record, @Param("example") UserInfoModelCriteria example);

    int updateByExampleWithBLOBs(@Param("record") UserInfoModel record, @Param("example") UserInfoModelCriteria example);

    int updateByExample(@Param("record") UserInfoModel record, @Param("example") UserInfoModelCriteria example);

    int updateByPrimaryKeySelective(UserInfoModel record);

    int updateByPrimaryKeyWithBLOBs(UserInfoModel record);

    int updateByPrimaryKey(UserInfoModel record);
}