package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.WebModel;
import cn.com.dyninfo.o2o.model.WebModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebModelMapper {
    int countByExample(WebModelCriteria example);

    int deleteByExample(WebModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(WebModel record);

    int insertSelective(WebModel record);

    List<WebModel> selectByExample(WebModelCriteria example);

    WebModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WebModel record, @Param("example") WebModelCriteria example);

    int updateByExample(@Param("record") WebModel record, @Param("example") WebModelCriteria example);

    int updateByPrimaryKeySelective(WebModel record);

    int updateByPrimaryKey(WebModel record);
}