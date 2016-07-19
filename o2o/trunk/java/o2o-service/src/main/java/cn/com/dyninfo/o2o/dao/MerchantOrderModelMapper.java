package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.MerchantOrderModel;
import cn.com.dyninfo.o2o.model.MerchantOrderModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantOrderModelMapper {
    int countByExample(MerchantOrderModelCriteria example);

    int deleteByExample(MerchantOrderModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(MerchantOrderModel record);

    int insertSelective(MerchantOrderModel record);

    List<MerchantOrderModel> selectByExample(MerchantOrderModelCriteria example);

    MerchantOrderModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MerchantOrderModel record, @Param("example") MerchantOrderModelCriteria example);

    int updateByExample(@Param("record") MerchantOrderModel record, @Param("example") MerchantOrderModelCriteria example);

    int updateByPrimaryKeySelective(MerchantOrderModel record);

    int updateByPrimaryKey(MerchantOrderModel record);
}