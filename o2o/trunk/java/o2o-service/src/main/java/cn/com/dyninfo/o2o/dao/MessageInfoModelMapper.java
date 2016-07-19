package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.MessageInfoModel;
import cn.com.dyninfo.o2o.model.MessageInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageInfoModelMapper {
    int countByExample(MessageInfoModelCriteria example);

    int deleteByExample(MessageInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(MessageInfoModel record);

    int insertSelective(MessageInfoModel record);

    List<MessageInfoModel> selectByExample(MessageInfoModelCriteria example);

    MessageInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MessageInfoModel record, @Param("example") MessageInfoModelCriteria example);

    int updateByExample(@Param("record") MessageInfoModel record, @Param("example") MessageInfoModelCriteria example);

    int updateByPrimaryKeySelective(MessageInfoModel record);

    int updateByPrimaryKey(MessageInfoModel record);
}