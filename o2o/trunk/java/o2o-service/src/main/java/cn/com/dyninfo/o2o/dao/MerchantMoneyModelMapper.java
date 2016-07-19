package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.MerchantMoneyModel;
import cn.com.dyninfo.o2o.model.MerchantMoneyModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantMoneyModelMapper {
    int countByExample(MerchantMoneyModelCriteria example);

    int deleteByExample(MerchantMoneyModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(MerchantMoneyModel record);

    int insertSelective(MerchantMoneyModel record);

    List<MerchantMoneyModel> selectByExample(MerchantMoneyModelCriteria example);

    MerchantMoneyModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MerchantMoneyModel record, @Param("example") MerchantMoneyModelCriteria example);

    int updateByExample(@Param("record") MerchantMoneyModel record, @Param("example") MerchantMoneyModelCriteria example);

    int updateByPrimaryKeySelective(MerchantMoneyModel record);

    int updateByPrimaryKey(MerchantMoneyModel record);
}