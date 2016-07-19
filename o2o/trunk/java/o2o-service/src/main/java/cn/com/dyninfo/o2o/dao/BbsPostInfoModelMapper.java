package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.BbsPostInfoModel;
import cn.com.dyninfo.o2o.model.BbsPostInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsPostInfoModelMapper {
    int countByExample(BbsPostInfoModelCriteria example);

    int deleteByExample(BbsPostInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(BbsPostInfoModel record);

    int insertSelective(BbsPostInfoModel record);

    List<BbsPostInfoModel> selectByExampleWithBLOBs(BbsPostInfoModelCriteria example);

    List<BbsPostInfoModel> selectByExample(BbsPostInfoModelCriteria example);

    BbsPostInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BbsPostInfoModel record, @Param("example") BbsPostInfoModelCriteria example);

    int updateByExampleWithBLOBs(@Param("record") BbsPostInfoModel record, @Param("example") BbsPostInfoModelCriteria example);

    int updateByExample(@Param("record") BbsPostInfoModel record, @Param("example") BbsPostInfoModelCriteria example);

    int updateByPrimaryKeySelective(BbsPostInfoModel record);

    int updateByPrimaryKeyWithBLOBs(BbsPostInfoModel record);

    int updateByPrimaryKey(BbsPostInfoModel record);
}