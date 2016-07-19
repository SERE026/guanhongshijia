package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.GoodsCopyModel;
import cn.com.dyninfo.o2o.model.GoodsCopyModelCriteria;
import cn.com.dyninfo.o2o.model.GoodsCopyModelWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsCopyModelMapper {
    int countByExample(GoodsCopyModelCriteria example);

    int deleteByExample(GoodsCopyModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsCopyModelWithBLOBs record);

    int insertSelective(GoodsCopyModelWithBLOBs record);

    List<GoodsCopyModelWithBLOBs> selectByExampleWithBLOBs(GoodsCopyModelCriteria example);

    List<GoodsCopyModel> selectByExample(GoodsCopyModelCriteria example);

    GoodsCopyModelWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsCopyModelWithBLOBs record, @Param("example") GoodsCopyModelCriteria example);

    int updateByExampleWithBLOBs(@Param("record") GoodsCopyModelWithBLOBs record, @Param("example") GoodsCopyModelCriteria example);

    int updateByExample(@Param("record") GoodsCopyModel record, @Param("example") GoodsCopyModelCriteria example);

    int updateByPrimaryKeySelective(GoodsCopyModelWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GoodsCopyModelWithBLOBs record);

    int updateByPrimaryKey(GoodsCopyModel record);
}