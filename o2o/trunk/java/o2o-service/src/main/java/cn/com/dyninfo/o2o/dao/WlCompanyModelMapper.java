package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.WlCompanyModel;
import cn.com.dyninfo.o2o.model.WlCompanyModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WlCompanyModelMapper {
    int countByExample(WlCompanyModelCriteria example);

    int deleteByExample(WlCompanyModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(WlCompanyModel record);

    int insertSelective(WlCompanyModel record);

    List<WlCompanyModel> selectByExample(WlCompanyModelCriteria example);

    WlCompanyModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WlCompanyModel record, @Param("example") WlCompanyModelCriteria example);

    int updateByExample(@Param("record") WlCompanyModel record, @Param("example") WlCompanyModelCriteria example);

    int updateByPrimaryKeySelective(WlCompanyModel record);

    int updateByPrimaryKey(WlCompanyModel record);
}