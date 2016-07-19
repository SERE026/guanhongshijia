package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.ShowGoodModel;
import cn.com.dyninfo.o2o.model.ShowGoodModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShowGoodModelMapper {
    int countByExample(ShowGoodModelCriteria example);

    int deleteByExample(ShowGoodModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShowGoodModel record);

    int insertSelective(ShowGoodModel record);

    List<ShowGoodModel> selectByExample(ShowGoodModelCriteria example);

    ShowGoodModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShowGoodModel record, @Param("example") ShowGoodModelCriteria example);

    int updateByExample(@Param("record") ShowGoodModel record, @Param("example") ShowGoodModelCriteria example);

    int updateByPrimaryKeySelective(ShowGoodModel record);

    int updateByPrimaryKey(ShowGoodModel record);
}