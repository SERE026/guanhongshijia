package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.MessageSendModel;
import cn.com.dyninfo.o2o.model.MessageSendModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageSendModelMapper {
    int countByExample(MessageSendModelCriteria example);

    int deleteByExample(MessageSendModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(MessageSendModel record);

    int insertSelective(MessageSendModel record);

    List<MessageSendModel> selectByExampleWithBLOBs(MessageSendModelCriteria example);

    List<MessageSendModel> selectByExample(MessageSendModelCriteria example);

    MessageSendModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MessageSendModel record, @Param("example") MessageSendModelCriteria example);

    int updateByExampleWithBLOBs(@Param("record") MessageSendModel record, @Param("example") MessageSendModelCriteria example);

    int updateByExample(@Param("record") MessageSendModel record, @Param("example") MessageSendModelCriteria example);

    int updateByPrimaryKeySelective(MessageSendModel record);

    int updateByPrimaryKeyWithBLOBs(MessageSendModel record);

    int updateByPrimaryKey(MessageSendModel record);
}