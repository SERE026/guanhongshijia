package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.AdvWzModel;
import cn.com.dyninfo.o2o.model.AdvWzModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvWzModelMapper {
    int countByExample(AdvWzModelCriteria example);

    int deleteByExample(AdvWzModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdvWzModel record);

    int insertSelective(AdvWzModel record);

    List<AdvWzModel> selectByExample(AdvWzModelCriteria example);

    AdvWzModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdvWzModel record, @Param("example") AdvWzModelCriteria example);

    int updateByExample(@Param("record") AdvWzModel record, @Param("example") AdvWzModelCriteria example);

    int updateByPrimaryKeySelective(AdvWzModel record);

    int updateByPrimaryKey(AdvWzModel record);
}