package cn.qingjiu.yys.service;

import cn.qingjiu.yys.entity.User;
import cn.qingjiu.yys.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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

    @PostMapping("/addUser")
    @ApiOperation(value = "添加用户信息")
    public List<User> addUser(@RequestBody User user){
        return null;
    }
}
