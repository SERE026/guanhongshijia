package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.HuiyuanMoneyModel;
import cn.com.dyninfo.o2o.model.HuiyuanMoneyModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HuiyuanMoneyModelMapper {
    int countByExample(HuiyuanMoneyModelCriteria example);

    int deleteByExample(HuiyuanMoneyModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(HuiyuanMoneyModel record);

    int insertSelective(HuiyuanMoneyModel record);

    List<HuiyuanMoneyModel> selectByExample(HuiyuanMoneyModelCriteria example);

    HuiyuanMoneyModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HuiyuanMoneyModel record, @Param("example") HuiyuanMoneyModelCriteria example);

    int updateByExample(@Param("record") HuiyuanMoneyModel record, @Param("example") HuiyuanMoneyModelCriteria example);

    int updateByPrimaryKeySelective(HuiyuanMoneyModel record);

    int updateByPrimaryKey(HuiyuanMoneyModel record);
}