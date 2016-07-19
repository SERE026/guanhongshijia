package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.SizeModel;
import cn.com.dyninfo.o2o.model.SizeModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SizeModelMapper {
    int countByExample(SizeModelCriteria example);

    int deleteByExample(SizeModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(SizeModel record);

    int insertSelective(SizeModel record);

    List<SizeModel> selectByExample(SizeModelCriteria example);

    SizeModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SizeModel record, @Param("example") SizeModelCriteria example);

    int updateByExample(@Param("record") SizeModel record, @Param("example") SizeModelCriteria example);

    int updateByPrimaryKeySelective(SizeModel record);

    int updateByPrimaryKey(SizeModel record);
}