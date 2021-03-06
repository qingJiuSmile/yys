package cn.qingjiu.yys.web.user;

import cn.qingjiu.yys.annotation.IsUser;
import cn.qingjiu.yys.entity.JsonResult;
import cn.qingjiu.yys.entity.PublicParam;
import cn.qingjiu.yys.service.user.LoginUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
* @Description: 用户控制层
* @Author: tjy
* @Date: 2020/3/4
*/
@Controller
@RequestMapping("/user")
@Api(description = "用户相关")
@IsUser
public class UserController {

    @Autowired
    private LoginUserService loginUserService;


    @PostMapping("/getUserDetailed")
    @ApiOperation(value = "登录验证")
    public JsonResult<String> getUserDetailed(PublicParam search){
        if(StringUtils.isBlank(search.getCode()) || StringUtils.isBlank(search.getLoginUserNo()) ||
        StringUtils.isBlank(search.getPassword())){
            return new JsonResult<>();
        }
        return loginUserService.getUserDetailed(search);
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
