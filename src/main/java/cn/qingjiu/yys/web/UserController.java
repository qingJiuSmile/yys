package cn.qingjiu.yys.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "用户信息接口")
@RequestMapping("/user")
public class UserController {

    @PostMapping("/demo")
    @ApiOperation(value = "测试")
    public String getDemo(){
        return "desds";
    }
}
