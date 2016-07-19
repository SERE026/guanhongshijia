package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.ArticlesModel;
import cn.com.dyninfo.o2o.model.ArticlesModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticlesModelMapper {
    int countByExample(ArticlesModelCriteria example);

    int deleteByExample(ArticlesModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticlesModel record);

    int insertSelective(ArticlesModel record);

    List<ArticlesModel> selectByExampleWithBLOBs(ArticlesModelCriteria example);

    List<ArticlesModel> selectByExample(ArticlesModelCriteria example);

    ArticlesModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArticlesModel record, @Param("example") ArticlesModelCriteria example);

    int updateByExampleWithBLOBs(@Param("record") ArticlesModel record, @Param("example") ArticlesModelCriteria example);

    int updateByExample(@Param("record") ArticlesModel record, @Param("example") ArticlesModelCriteria example);

    int updateByPrimaryKeySelective(ArticlesModel record);

    int updateByPrimaryKeyWithBLOBs(ArticlesModel record);

    int updateByPrimaryKey(ArticlesModel record);
}