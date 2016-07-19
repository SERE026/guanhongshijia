package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.AdvModel;
import cn.com.dyninfo.o2o.model.AdvModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvModelMapper {
    int countByExample(AdvModelCriteria example);

    int deleteByExample(AdvModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdvModel record);

    int insertSelective(AdvModel record);

    List<AdvModel> selectByExample(AdvModelCriteria example);

    AdvModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdvModel record, @Param("example") AdvModelCriteria example);

    int updateByExample(@Param("record") AdvModel record, @Param("example") AdvModelCriteria example);

    int updateByPrimaryKeySelective(AdvModel record);

    int updateByPrimaryKey(AdvModel record);
}