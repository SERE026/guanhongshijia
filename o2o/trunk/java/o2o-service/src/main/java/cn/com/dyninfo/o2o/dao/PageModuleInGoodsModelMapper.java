package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.PageModuleInGoodsModel;
import cn.com.dyninfo.o2o.model.PageModuleInGoodsModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PageModuleInGoodsModelMapper {
    int countByExample(PageModuleInGoodsModelCriteria example);

    int deleteByExample(PageModuleInGoodsModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(PageModuleInGoodsModel record);

    int insertSelective(PageModuleInGoodsModel record);

    List<PageModuleInGoodsModel> selectByExample(PageModuleInGoodsModelCriteria example);

    PageModuleInGoodsModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PageModuleInGoodsModel record, @Param("example") PageModuleInGoodsModelCriteria example);

    int updateByExample(@Param("record") PageModuleInGoodsModel record, @Param("example") PageModuleInGoodsModelCriteria example);

    int updateByPrimaryKeySelective(PageModuleInGoodsModel record);

    int updateByPrimaryKey(PageModuleInGoodsModel record);
}