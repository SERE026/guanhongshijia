package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.CommentInfoModel;
import cn.com.dyninfo.o2o.model.CommentInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentInfoModelMapper {
    int countByExample(CommentInfoModelCriteria example);

    int deleteByExample(CommentInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommentInfoModel record);

    int insertSelective(CommentInfoModel record);

    List<CommentInfoModel> selectByExample(CommentInfoModelCriteria example);

    CommentInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommentInfoModel record, @Param("example") CommentInfoModelCriteria example);

    int updateByExample(@Param("record") CommentInfoModel record, @Param("example") CommentInfoModelCriteria example);

    int updateByPrimaryKeySelective(CommentInfoModel record);

    int updateByPrimaryKey(CommentInfoModel record);
}