package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.AdvGoodsModel;
import cn.com.dyninfo.o2o.model.AdvGoodsModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvGoodsModelMapper {
    int countByExample(AdvGoodsModelCriteria example);

    int deleteByExample(AdvGoodsModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdvGoodsModel record);

    int insertSelective(AdvGoodsModel record);

    List<AdvGoodsModel> selectByExample(AdvGoodsModelCriteria example);

    AdvGoodsModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdvGoodsModel record, @Param("example") AdvGoodsModelCriteria example);

    int updateByExample(@Param("record") AdvGoodsModel record, @Param("example") AdvGoodsModelCriteria example);

    int updateByPrimaryKeySelective(AdvGoodsModel record);

    int updateByPrimaryKey(AdvGoodsModel record);
}