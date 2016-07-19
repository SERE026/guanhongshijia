package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.BbsUserInfoModel;
import cn.com.dyninfo.o2o.model.BbsUserInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsUserInfoModelMapper {
    int countByExample(BbsUserInfoModelCriteria example);

    int deleteByExample(BbsUserInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(BbsUserInfoModel record);

    int insertSelective(BbsUserInfoModel record);

    List<BbsUserInfoModel> selectByExample(BbsUserInfoModelCriteria example);

    BbsUserInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BbsUserInfoModel record, @Param("example") BbsUserInfoModelCriteria example);

    int updateByExample(@Param("record") BbsUserInfoModel record, @Param("example") BbsUserInfoModelCriteria example);

    int updateByPrimaryKeySelective(BbsUserInfoModel record);

    int updateByPrimaryKey(BbsUserInfoModel record);
}