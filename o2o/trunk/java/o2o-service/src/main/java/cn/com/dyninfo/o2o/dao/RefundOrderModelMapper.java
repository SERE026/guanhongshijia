package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.RefundOrderModel;
import cn.com.dyninfo.o2o.model.RefundOrderModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RefundOrderModelMapper {
    int countByExample(RefundOrderModelCriteria example);

    int deleteByExample(RefundOrderModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(RefundOrderModel record);

    int insertSelective(RefundOrderModel record);

    List<RefundOrderModel> selectByExample(RefundOrderModelCriteria example);

    RefundOrderModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RefundOrderModel record, @Param("example") RefundOrderModelCriteria example);

    int updateByExample(@Param("record") RefundOrderModel record, @Param("example") RefundOrderModelCriteria example);

    int updateByPrimaryKeySelective(RefundOrderModel record);

    int updateByPrimaryKey(RefundOrderModel record);
}