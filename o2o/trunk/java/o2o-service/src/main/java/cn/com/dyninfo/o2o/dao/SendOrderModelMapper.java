package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.SendOrderModel;
import cn.com.dyninfo.o2o.model.SendOrderModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SendOrderModelMapper {
    int countByExample(SendOrderModelCriteria example);

    int deleteByExample(SendOrderModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(SendOrderModel record);

    int insertSelective(SendOrderModel record);

    List<SendOrderModel> selectByExample(SendOrderModelCriteria example);

    SendOrderModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SendOrderModel record, @Param("example") SendOrderModelCriteria example);

    int updateByExample(@Param("record") SendOrderModel record, @Param("example") SendOrderModelCriteria example);

    int updateByPrimaryKeySelective(SendOrderModel record);

    int updateByPrimaryKey(SendOrderModel record);
}