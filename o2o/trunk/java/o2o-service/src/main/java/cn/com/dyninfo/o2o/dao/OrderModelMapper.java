package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.OrderModel;
import cn.com.dyninfo.o2o.model.OrderModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderModelMapper {
    int countByExample(OrderModelCriteria example);

    int deleteByExample(OrderModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderModel record);

    int insertSelective(OrderModel record);

    List<OrderModel> selectByExample(OrderModelCriteria example);

    OrderModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderModel record, @Param("example") OrderModelCriteria example);

    int updateByExample(@Param("record") OrderModel record, @Param("example") OrderModelCriteria example);

    int updateByPrimaryKeySelective(OrderModel record);

    int updateByPrimaryKey(OrderModel record);
}