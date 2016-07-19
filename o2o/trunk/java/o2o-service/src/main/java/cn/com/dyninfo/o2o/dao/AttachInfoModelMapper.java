package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.AttachInfoModel;
import cn.com.dyninfo.o2o.model.AttachInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttachInfoModelMapper {
    int countByExample(AttachInfoModelCriteria example);

    int deleteByExample(AttachInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AttachInfoModel record);

    int insertSelective(AttachInfoModel record);

    List<AttachInfoModel> selectByExample(AttachInfoModelCriteria example);

    AttachInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AttachInfoModel record, @Param("example") AttachInfoModelCriteria example);

    int updateByExample(@Param("record") AttachInfoModel record, @Param("example") AttachInfoModelCriteria example);

    int updateByPrimaryKeySelective(AttachInfoModel record);

    int updateByPrimaryKey(AttachInfoModel record);
}