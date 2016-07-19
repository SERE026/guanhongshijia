package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.ResControlRelModel;
import cn.com.dyninfo.o2o.model.ResControlRelModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResControlRelModelMapper {
    int countByExample(ResControlRelModelCriteria example);

    int deleteByExample(ResControlRelModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ResControlRelModel record);

    int insertSelective(ResControlRelModel record);

    List<ResControlRelModel> selectByExample(ResControlRelModelCriteria example);

    ResControlRelModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ResControlRelModel record, @Param("example") ResControlRelModelCriteria example);

    int updateByExample(@Param("record") ResControlRelModel record, @Param("example") ResControlRelModelCriteria example);

    int updateByPrimaryKeySelective(ResControlRelModel record);

    int updateByPrimaryKey(ResControlRelModel record);
}