package cn.qingjiu.yys.mapper;

import cn.qingjiu.yys.entity.Shishen;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShishenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shishen record);

    int insertSelective(Shishen record);

    Shishen selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shishen record);

    int updateByPrimaryKey(Shishen record);
}