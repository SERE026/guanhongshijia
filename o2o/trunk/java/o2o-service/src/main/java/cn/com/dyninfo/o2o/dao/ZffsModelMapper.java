package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.ZffsModel;
import cn.com.dyninfo.o2o.model.ZffsModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZffsModelMapper {
    int countByExample(ZffsModelCriteria example);

    int deleteByExample(ZffsModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZffsModel record);

    int insertSelective(ZffsModel record);

    List<ZffsModel> selectByExample(ZffsModelCriteria example);

    ZffsModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZffsModel record, @Param("example") ZffsModelCriteria example);

    int updateByExample(@Param("record") ZffsModel record, @Param("example") ZffsModelCriteria example);

    int updateByPrimaryKeySelective(ZffsModel record);

    int updateByPrimaryKey(ZffsModel record);
}