package cn.qingjiu.yys.mapper.user;

import cn.qingjiu.yys.entity.LoginUser;
import cn.qingjiu.yys.entity.PublicParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @Description: 用户持久化层
* @Author: tjy
* @Date: 2020/3/4
*/
@Mapper
@Component
public interface LoginUserMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(LoginUser record);

    int updateByPrimaryKeySelective(LoginUser record);

    LoginUser getLoginUserAll(PublicParam search);
}