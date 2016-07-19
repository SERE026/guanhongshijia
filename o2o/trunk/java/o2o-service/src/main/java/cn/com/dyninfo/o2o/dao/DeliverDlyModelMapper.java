package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.DeliverDlyModel;
import cn.com.dyninfo.o2o.model.DeliverDlyModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeliverDlyModelMapper {
    int countByExample(DeliverDlyModelCriteria example);

    int deleteByExample(DeliverDlyModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(DeliverDlyModel record);

    int insertSelective(DeliverDlyModel record);

    List<DeliverDlyModel> selectByExample(DeliverDlyModelCriteria example);

    DeliverDlyModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DeliverDlyModel record, @Param("example") DeliverDlyModelCriteria example);

    int updateByExample(@Param("record") DeliverDlyModel record, @Param("example") DeliverDlyModelCriteria example);

    int updateByPrimaryKeySelective(DeliverDlyModel record);

    int updateByPrimaryKey(DeliverDlyModel record);
}