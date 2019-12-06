package cn.qingjiu.yys.service;

import cn.qingjiu.yys.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
* @Description: 用户信息业务类
* @Param:  
* @return:  
* @Author: tjy
* @Date: 2019/12/6 
*/ 
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


}
