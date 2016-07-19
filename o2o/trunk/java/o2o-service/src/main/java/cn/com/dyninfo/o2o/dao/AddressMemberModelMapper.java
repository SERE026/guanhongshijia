package cn.com.dyninfo.o2o.dao;

import cn.com.dyninfo.o2o.model.AddressMemberModel;
import cn.com.dyninfo.o2o.model.AddressMemberModelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressMemberModelMapper {
    int countByExample(AddressMemberModelCriteria example);

    int deleteByExample(AddressMemberModelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AddressMemberModel record);

    int insertSelective(AddressMemberModel record);

    List<AddressMemberModel> selectByExample(AddressMemberModelCriteria example);

    AddressMemberModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AddressMemberModel record, @Param("example") AddressMemberModelCriteria example);

    int updateByExample(@Param("record") AddressMemberModel record, @Param("example") AddressMemberModelCriteria example);

    int updateByPrimaryKeySelective(AddressMemberModel record);

    int updateByPrimaryKey(AddressMemberModel record);
}