package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.GoodsDeliveryModel;
import cn.com.dyninfo.o2o.model.GoodsDeliveryModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsDeliveryModelMapper {
    int countByExample(GoodsDeliveryModelCriteria example);

    int deleteByExample(GoodsDeliveryModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsDeliveryModel record);

    int insertSelective(GoodsDeliveryModel record);

    List<GoodsDeliveryModel> selectByExample(GoodsDeliveryModelCriteria example);

    GoodsDeliveryModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsDeliveryModel record, @Param("example") GoodsDeliveryModelCriteria example);

    int updateByExample(@Param("record") GoodsDeliveryModel record, @Param("example") GoodsDeliveryModelCriteria example);

    int updateByPrimaryKeySelective(GoodsDeliveryModel record);

    int updateByPrimaryKey(GoodsDeliveryModel record);
}