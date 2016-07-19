package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.HuiyuanInfoModel;
import cn.com.dyninfo.o2o.model.HuiyuanInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HuiyuanInfoModelMapper {
    int countByExample(HuiyuanInfoModelCriteria example);

    int deleteByExample(HuiyuanInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(HuiyuanInfoModel record);

    int insertSelective(HuiyuanInfoModel record);

    List<HuiyuanInfoModel> selectByExample(HuiyuanInfoModelCriteria example);

    HuiyuanInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HuiyuanInfoModel record, @Param("example") HuiyuanInfoModelCriteria example);

    int updateByExample(@Param("record") HuiyuanInfoModel record, @Param("example") HuiyuanInfoModelCriteria example);

    int updateByPrimaryKeySelective(HuiyuanInfoModel record);

    int updateByPrimaryKey(HuiyuanInfoModel record);
}