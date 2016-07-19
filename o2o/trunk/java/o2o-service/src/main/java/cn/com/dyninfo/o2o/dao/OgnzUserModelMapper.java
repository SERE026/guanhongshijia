package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.OgnzUserModel;
import cn.com.dyninfo.o2o.model.OgnzUserModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OgnzUserModelMapper {
    int countByExample(OgnzUserModelCriteria example);

    int deleteByExample(OgnzUserModelCriteria example);

    int insert(OgnzUserModel record);

    int insertSelective(OgnzUserModel record);

    List<OgnzUserModel> selectByExample(OgnzUserModelCriteria example);

    int updateByExampleSelective(@Param("record") OgnzUserModel record, @Param("example") OgnzUserModelCriteria example);

    int updateByExample(@Param("record") OgnzUserModel record, @Param("example") OgnzUserModelCriteria example);
}