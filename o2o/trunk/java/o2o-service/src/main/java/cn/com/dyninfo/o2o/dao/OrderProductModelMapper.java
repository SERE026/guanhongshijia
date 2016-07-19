package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.OrderProductModel;
import cn.com.dyninfo.o2o.model.OrderProductModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderProductModelMapper {
    int countByExample(OrderProductModelCriteria example);

    int deleteByExample(OrderProductModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderProductModel record);

    int insertSelective(OrderProductModel record);

    List<OrderProductModel> selectByExample(OrderProductModelCriteria example);

    OrderProductModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderProductModel record, @Param("example") OrderProductModelCriteria example);

    int updateByExample(@Param("record") OrderProductModel record, @Param("example") OrderProductModelCriteria example);

    int updateByPrimaryKeySelective(OrderProductModel record);

    int updateByPrimaryKey(OrderProductModel record);
}