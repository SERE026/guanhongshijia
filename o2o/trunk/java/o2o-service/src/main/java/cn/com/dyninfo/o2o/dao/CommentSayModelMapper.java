package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.CommentSayModel;
import cn.com.dyninfo.o2o.model.CommentSayModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentSayModelMapper {
    int countByExample(CommentSayModelCriteria example);

    int deleteByExample(CommentSayModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommentSayModel record);

    int insertSelective(CommentSayModel record);

    List<CommentSayModel> selectByExample(CommentSayModelCriteria example);

    CommentSayModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommentSayModel record, @Param("example") CommentSayModelCriteria example);

    int updateByExample(@Param("record") CommentSayModel record, @Param("example") CommentSayModelCriteria example);

    int updateByPrimaryKeySelective(CommentSayModel record);

    int updateByPrimaryKey(CommentSayModel record);
}