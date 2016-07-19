package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.SmsLogModel;
import cn.com.dyninfo.o2o.model.SmsLogModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsLogModelMapper {
    int countByExample(SmsLogModelCriteria example);

    int deleteByExample(SmsLogModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(SmsLogModel record);

    int insertSelective(SmsLogModel record);

    List<SmsLogModel> selectByExample(SmsLogModelCriteria example);

    SmsLogModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SmsLogModel record, @Param("example") SmsLogModelCriteria example);

    int updateByExample(@Param("record") SmsLogModel record, @Param("example") SmsLogModelCriteria example);

    int updateByPrimaryKeySelective(SmsLogModel record);

    int updateByPrimaryKey(SmsLogModel record);
}