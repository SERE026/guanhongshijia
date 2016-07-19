package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.AccaptMessageModel;
import cn.com.dyninfo.o2o.model.AccaptMessageModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccaptMessageModelMapper {
    int countByExample(AccaptMessageModelCriteria example);

    int deleteByExample(AccaptMessageModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccaptMessageModel record);

    int insertSelective(AccaptMessageModel record);

    List<AccaptMessageModel> selectByExampleWithBLOBs(AccaptMessageModelCriteria example);

    List<AccaptMessageModel> selectByExample(AccaptMessageModelCriteria example);

    AccaptMessageModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccaptMessageModel record, @Param("example") AccaptMessageModelCriteria example);

    int updateByExampleWithBLOBs(@Param("record") AccaptMessageModel record, @Param("example") AccaptMessageModelCriteria example);

    int updateByExample(@Param("record") AccaptMessageModel record, @Param("example") AccaptMessageModelCriteria example);

    int updateByPrimaryKeySelective(AccaptMessageModel record);

    int updateByPrimaryKeyWithBLOBs(AccaptMessageModel record);

    int updateByPrimaryKey(AccaptMessageModel record);
}