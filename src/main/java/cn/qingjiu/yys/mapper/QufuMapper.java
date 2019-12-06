package cn.qingjiu.yys.mapper;

import cn.qingjiu.yys.entity.Qufu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QufuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Qufu record);

    int insertSelective(Qufu record);

    Qufu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Qufu record);

    int updateByPrimaryKey(Qufu record);
}