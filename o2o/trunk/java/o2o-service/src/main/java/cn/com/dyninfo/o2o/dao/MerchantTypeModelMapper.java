package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.MerchantTypeModel;
import cn.com.dyninfo.o2o.model.MerchantTypeModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantTypeModelMapper {
    int countByExample(MerchantTypeModelCriteria example);

    int deleteByExample(MerchantTypeModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(MerchantTypeModel record);

    int insertSelective(MerchantTypeModel record);

    List<MerchantTypeModel> selectByExample(MerchantTypeModelCriteria example);

    MerchantTypeModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MerchantTypeModel record, @Param("example") MerchantTypeModelCriteria example);

    int updateByExample(@Param("record") MerchantTypeModel record, @Param("example") MerchantTypeModelCriteria example);

    int updateByPrimaryKeySelective(MerchantTypeModel record);

    int updateByPrimaryKey(MerchantTypeModel record);
}