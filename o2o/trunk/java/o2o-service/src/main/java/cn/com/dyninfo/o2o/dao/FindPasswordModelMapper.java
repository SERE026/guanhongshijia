package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.FindPasswordModel;
import cn.com.dyninfo.o2o.model.FindPasswordModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FindPasswordModelMapper {
    int countByExample(FindPasswordModelCriteria example);

    int deleteByExample(FindPasswordModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(FindPasswordModel record);

    int insertSelective(FindPasswordModel record);

    List<FindPasswordModel> selectByExample(FindPasswordModelCriteria example);

    FindPasswordModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FindPasswordModel record, @Param("example") FindPasswordModelCriteria example);

    int updateByExample(@Param("record") FindPasswordModel record, @Param("example") FindPasswordModelCriteria example);

    int updateByPrimaryKeySelective(FindPasswordModel record);

    int updateByPrimaryKey(FindPasswordModel record);
}