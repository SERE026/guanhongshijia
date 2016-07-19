package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.ActiveMemberInfoModel;
import cn.com.dyninfo.o2o.model.ActiveMemberInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActiveMemberInfoModelMapper {
    int countByExample(ActiveMemberInfoModelCriteria example);

    int deleteByExample(ActiveMemberInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActiveMemberInfoModel record);

    int insertSelective(ActiveMemberInfoModel record);

    List<ActiveMemberInfoModel> selectByExample(ActiveMemberInfoModelCriteria example);

    ActiveMemberInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActiveMemberInfoModel record, @Param("example") ActiveMemberInfoModelCriteria example);

    int updateByExample(@Param("record") ActiveMemberInfoModel record, @Param("example") ActiveMemberInfoModelCriteria example);

    int updateByPrimaryKeySelective(ActiveMemberInfoModel record);

    int updateByPrimaryKey(ActiveMemberInfoModel record);
}