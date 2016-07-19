package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.ReturneOrderModel;
import cn.com.dyninfo.o2o.model.ReturneOrderModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReturneOrderModelMapper {
    int countByExample(ReturneOrderModelCriteria example);

    int deleteByExample(ReturneOrderModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReturneOrderModel record);

    int insertSelective(ReturneOrderModel record);

    List<ReturneOrderModel> selectByExample(ReturneOrderModelCriteria example);

    ReturneOrderModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReturneOrderModel record, @Param("example") ReturneOrderModelCriteria example);

    int updateByExample(@Param("record") ReturneOrderModel record, @Param("example") ReturneOrderModelCriteria example);

    int updateByPrimaryKeySelective(ReturneOrderModel record);

    int updateByPrimaryKey(ReturneOrderModel record);
}