package cn.qingjiu.yys.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* @Description: 公共入参
* @Author: tjy
* @Date: 2020/3/4
*/
@Data
public class PublicParam {

    @ApiModelProperty(value = "登录人")
    private String loginUserNo;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "验证码")
    private String code;
}
