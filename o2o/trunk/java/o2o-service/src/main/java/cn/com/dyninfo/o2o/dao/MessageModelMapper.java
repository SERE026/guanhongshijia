package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.MessageModel;
import cn.com.dyninfo.o2o.model.MessageModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageModelMapper {
    int countByExample(MessageModelCriteria example);

    int deleteByExample(MessageModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(MessageModel record);

    int insertSelective(MessageModel record);

    List<MessageModel> selectByExampleWithBLOBs(MessageModelCriteria example);

    List<MessageModel> selectByExample(MessageModelCriteria example);

    MessageModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MessageModel record, @Param("example") MessageModelCriteria example);

    int updateByExampleWithBLOBs(@Param("record") MessageModel record, @Param("example") MessageModelCriteria example);

    int updateByExample(@Param("record") MessageModel record, @Param("example") MessageModelCriteria example);

    int updateByPrimaryKeySelective(MessageModel record);

    int updateByPrimaryKeyWithBLOBs(MessageModel record);

    int updateByPrimaryKey(MessageModel record);
}