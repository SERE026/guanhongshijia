package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.CouponMemberRelModel;
import cn.com.dyninfo.o2o.model.CouponMemberRelModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponMemberRelModelMapper {
    int countByExample(CouponMemberRelModelCriteria example);

    int deleteByExample(CouponMemberRelModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouponMemberRelModel record);

    int insertSelective(CouponMemberRelModel record);

    List<CouponMemberRelModel> selectByExample(CouponMemberRelModelCriteria example);

    CouponMemberRelModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouponMemberRelModel record, @Param("example") CouponMemberRelModelCriteria example);

    int updateByExample(@Param("record") CouponMemberRelModel record, @Param("example") CouponMemberRelModelCriteria example);

    int updateByPrimaryKeySelective(CouponMemberRelModel record);

    int updateByPrimaryKey(CouponMemberRelModel record);
}