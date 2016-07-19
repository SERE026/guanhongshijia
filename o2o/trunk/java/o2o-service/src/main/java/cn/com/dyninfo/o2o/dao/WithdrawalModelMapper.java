package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.WithdrawalModel;
import cn.com.dyninfo.o2o.model.WithdrawalModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WithdrawalModelMapper {
    int countByExample(WithdrawalModelCriteria example);

    int deleteByExample(WithdrawalModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(WithdrawalModel record);

    int insertSelective(WithdrawalModel record);

    List<WithdrawalModel> selectByExample(WithdrawalModelCriteria example);

    WithdrawalModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WithdrawalModel record, @Param("example") WithdrawalModelCriteria example);

    int updateByExample(@Param("record") WithdrawalModel record, @Param("example") WithdrawalModelCriteria example);

    int updateByPrimaryKeySelective(WithdrawalModel record);

    int updateByPrimaryKey(WithdrawalModel record);
}