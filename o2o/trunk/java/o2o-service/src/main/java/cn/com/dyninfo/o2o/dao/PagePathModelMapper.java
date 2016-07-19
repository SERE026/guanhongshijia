package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.PagePathModel;
import cn.com.dyninfo.o2o.model.PagePathModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PagePathModelMapper {
    int countByExample(PagePathModelCriteria example);

    int deleteByExample(PagePathModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(PagePathModel record);

    int insertSelective(PagePathModel record);

    List<PagePathModel> selectByExample(PagePathModelCriteria example);

    PagePathModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PagePathModel record, @Param("example") PagePathModelCriteria example);

    int updateByExample(@Param("record") PagePathModel record, @Param("example") PagePathModelCriteria example);

    int updateByPrimaryKeySelective(PagePathModel record);

    int updateByPrimaryKey(PagePathModel record);
}