package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.PaymentModel;
import cn.com.dyninfo.o2o.model.PaymentModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymentModelMapper {
    int countByExample(PaymentModelCriteria example);

    int deleteByExample(PaymentModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(PaymentModel record);

    int insertSelective(PaymentModel record);

    List<PaymentModel> selectByExample(PaymentModelCriteria example);

    PaymentModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PaymentModel record, @Param("example") PaymentModelCriteria example);

    int updateByExample(@Param("record") PaymentModel record, @Param("example") PaymentModelCriteria example);

    int updateByPrimaryKeySelective(PaymentModel record);

    int updateByPrimaryKey(PaymentModel record);
}