package cn.qingjiu.yys.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

/**
* @Description: 用户详细信息表
* @Author: tjy
* @Date: 2020/3/4
*/
@Data
public class LoginUserDetailed {

    private Integer userId;

    private String phone;

    private String sex;

    private String email;

    private String qq;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Timestamp createTime;

    @ApiModelProperty(value = "修改日期时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Timestamp lateTime;

}
