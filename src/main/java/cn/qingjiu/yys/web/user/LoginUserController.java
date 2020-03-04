package cn.qingjiu.yys.web.user;

import cn.qingjiu.yys.constant.CommConstant;
import cn.qingjiu.yys.entity.JsonResult;
import cn.qingjiu.yys.entity.LoginUser;
import cn.qingjiu.yys.service.user.LoginUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* @Description: 用户控制层
* @Author: tjy
* @Date: 2020/3/4
*/
@RestController
@RequestMapping("/user")
@Api(description = "用户相关")
public class LoginUserController {

    @Autowired
    private LoginUserService loginUserService;


    @PostMapping("/getUserDetailed")
    @ApiOperation(value = "测试")
    public JsonResult<List<LoginUser>> getUserDetailed(){
        return loginUserService.getUserDetailed();
    }
}
