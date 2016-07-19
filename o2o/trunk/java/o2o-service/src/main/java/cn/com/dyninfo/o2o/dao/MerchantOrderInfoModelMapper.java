package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.MerchantOrderInfoModel;
import cn.com.dyninfo.o2o.model.MerchantOrderInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantOrderInfoModelMapper {
    int countByExample(MerchantOrderInfoModelCriteria example);

    int deleteByExample(MerchantOrderInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(MerchantOrderInfoModel record);

    int insertSelective(MerchantOrderInfoModel record);

    List<MerchantOrderInfoModel> selectByExample(MerchantOrderInfoModelCriteria example);

    MerchantOrderInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MerchantOrderInfoModel record, @Param("example") MerchantOrderInfoModelCriteria example);

    int updateByExample(@Param("record") MerchantOrderInfoModel record, @Param("example") MerchantOrderInfoModelCriteria example);

    int updateByPrimaryKeySelective(MerchantOrderInfoModel record);

    int updateByPrimaryKey(MerchantOrderInfoModel record);
}