package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.NoteModel;
import cn.com.dyninfo.o2o.model.NoteModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoteModelMapper {
    int countByExample(NoteModelCriteria example);

    int deleteByExample(NoteModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(NoteModel record);

    int insertSelective(NoteModel record);

    List<NoteModel> selectByExample(NoteModelCriteria example);

    NoteModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NoteModel record, @Param("example") NoteModelCriteria example);

    int updateByExample(@Param("record") NoteModel record, @Param("example") NoteModelCriteria example);

    int updateByPrimaryKeySelective(NoteModel record);

    int updateByPrimaryKey(NoteModel record);
}