package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.ShangjiaInfoModel;
import cn.com.dyninfo.o2o.model.ShangjiaInfoModelCriteria;
import cn.com.dyninfo.o2o.model.ShangjiaInfoModelWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShangjiaInfoModelMapper {
    int countByExample(ShangjiaInfoModelCriteria example);

    int deleteByExample(ShangjiaInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShangjiaInfoModelWithBLOBs record);

    int insertSelective(ShangjiaInfoModelWithBLOBs record);

    List<ShangjiaInfoModelWithBLOBs> selectByExampleWithBLOBs(ShangjiaInfoModelCriteria example);

    List<ShangjiaInfoModel> selectByExample(ShangjiaInfoModelCriteria example);

    ShangjiaInfoModelWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShangjiaInfoModelWithBLOBs record, @Param("example") ShangjiaInfoModelCriteria example);

    int updateByExampleWithBLOBs(@Param("record") ShangjiaInfoModelWithBLOBs record, @Param("example") ShangjiaInfoModelCriteria example);

    int updateByExample(@Param("record") ShangjiaInfoModel record, @Param("example") ShangjiaInfoModelCriteria example);

    int updateByPrimaryKeySelective(ShangjiaInfoModelWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShangjiaInfoModelWithBLOBs record);

    int updateByPrimaryKey(ShangjiaInfoModel record);
}