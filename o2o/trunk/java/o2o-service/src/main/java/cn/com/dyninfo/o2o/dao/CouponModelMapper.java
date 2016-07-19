package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.CouponModel;
import cn.com.dyninfo.o2o.model.CouponModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponModelMapper {
    int countByExample(CouponModelCriteria example);

    int deleteByExample(CouponModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouponModel record);

    int insertSelective(CouponModel record);

    List<CouponModel> selectByExample(CouponModelCriteria example);

    CouponModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouponModel record, @Param("example") CouponModelCriteria example);

    int updateByExample(@Param("record") CouponModel record, @Param("example") CouponModelCriteria example);

    int updateByPrimaryKeySelective(CouponModel record);

    int updateByPrimaryKey(CouponModel record);
}