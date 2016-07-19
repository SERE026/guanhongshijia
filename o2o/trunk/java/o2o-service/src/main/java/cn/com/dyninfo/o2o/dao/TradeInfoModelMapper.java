package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.TradeInfoModel;
import cn.com.dyninfo.o2o.model.TradeInfoModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeInfoModelMapper {
    int countByExample(TradeInfoModelCriteria example);

    int deleteByExample(TradeInfoModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TradeInfoModel record);

    int insertSelective(TradeInfoModel record);

    List<TradeInfoModel> selectByExample(TradeInfoModelCriteria example);

    TradeInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TradeInfoModel record, @Param("example") TradeInfoModelCriteria example);

    int updateByExample(@Param("record") TradeInfoModel record, @Param("example") TradeInfoModelCriteria example);

    int updateByPrimaryKeySelective(TradeInfoModel record);

    int updateByPrimaryKey(TradeInfoModel record);
}