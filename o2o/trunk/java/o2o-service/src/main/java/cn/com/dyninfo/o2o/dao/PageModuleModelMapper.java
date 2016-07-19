package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.PageModuleModel;
import cn.com.dyninfo.o2o.model.PageModuleModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PageModuleModelMapper {
    int countByExample(PageModuleModelCriteria example);

    int deleteByExample(PageModuleModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(PageModuleModel record);

    int insertSelective(PageModuleModel record);

    List<PageModuleModel> selectByExample(PageModuleModelCriteria example);

    PageModuleModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PageModuleModel record, @Param("example") PageModuleModelCriteria example);

    int updateByExample(@Param("record") PageModuleModel record, @Param("example") PageModuleModelCriteria example);

    int updateByPrimaryKeySelective(PageModuleModel record);

    int updateByPrimaryKey(PageModuleModel record);
}