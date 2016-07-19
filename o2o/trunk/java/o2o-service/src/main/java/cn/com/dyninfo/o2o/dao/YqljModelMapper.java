package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.YqljModel;
import cn.com.dyninfo.o2o.model.YqljModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YqljModelMapper {
    int countByExample(YqljModelCriteria example);

    int deleteByExample(YqljModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(YqljModel record);

    int insertSelective(YqljModel record);

    List<YqljModel> selectByExample(YqljModelCriteria example);

    YqljModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") YqljModel record, @Param("example") YqljModelCriteria example);

    int updateByExample(@Param("record") YqljModel record, @Param("example") YqljModelCriteria example);

    int updateByPrimaryKeySelective(YqljModel record);

    int updateByPrimaryKey(YqljModel record);
}