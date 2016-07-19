package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.ActiveGoodsModel;
import cn.com.dyninfo.o2o.model.ActiveGoodsModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActiveGoodsModelMapper {
    int countByExample(ActiveGoodsModelCriteria example);

    int deleteByExample(ActiveGoodsModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActiveGoodsModel record);

    int insertSelective(ActiveGoodsModel record);

    List<ActiveGoodsModel> selectByExample(ActiveGoodsModelCriteria example);

    ActiveGoodsModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActiveGoodsModel record, @Param("example") ActiveGoodsModelCriteria example);

    int updateByExample(@Param("record") ActiveGoodsModel record, @Param("example") ActiveGoodsModelCriteria example);

    int updateByPrimaryKeySelective(ActiveGoodsModel record);

    int updateByPrimaryKey(ActiveGoodsModel record);
}