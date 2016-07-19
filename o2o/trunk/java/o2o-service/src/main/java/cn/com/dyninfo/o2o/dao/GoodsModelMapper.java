package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.GoodsModel;
import cn.com.dyninfo.o2o.model.GoodsModelCriteria;
import cn.com.dyninfo.o2o.model.GoodsModelWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsModelMapper {
    int countByExample(GoodsModelCriteria example);

    int deleteByExample(GoodsModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsModelWithBLOBs record);

    int insertSelective(GoodsModelWithBLOBs record);

    List<GoodsModelWithBLOBs> selectByExampleWithBLOBs(GoodsModelCriteria example);

    List<GoodsModel> selectByExample(GoodsModelCriteria example);

    GoodsModelWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsModelWithBLOBs record, @Param("example") GoodsModelCriteria example);

    int updateByExampleWithBLOBs(@Param("record") GoodsModelWithBLOBs record, @Param("example") GoodsModelCriteria example);

    int updateByExample(@Param("record") GoodsModel record, @Param("example") GoodsModelCriteria example);

    int updateByPrimaryKeySelective(GoodsModelWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GoodsModelWithBLOBs record);

    int updateByPrimaryKey(GoodsModel record);
}