package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.OgnzInfoModel;
import cn.com.dyninfo.o2o.model.OgnzInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OgnzInfoModelMapper {
    int countByExample(OgnzInfoModelCriteria example);

    int deleteByExample(OgnzInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(OgnzInfoModel record);

    int insertSelective(OgnzInfoModel record);

    List<OgnzInfoModel> selectByExampleWithBLOBs(OgnzInfoModelCriteria example);

    List<OgnzInfoModel> selectByExample(OgnzInfoModelCriteria example);

    OgnzInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OgnzInfoModel record, @Param("example") OgnzInfoModelCriteria example);

    int updateByExampleWithBLOBs(@Param("record") OgnzInfoModel record, @Param("example") OgnzInfoModelCriteria example);

    int updateByExample(@Param("record") OgnzInfoModel record, @Param("example") OgnzInfoModelCriteria example);

    int updateByPrimaryKeySelective(OgnzInfoModel record);

    int updateByPrimaryKeyWithBLOBs(OgnzInfoModel record);

    int updateByPrimaryKey(OgnzInfoModel record);
}