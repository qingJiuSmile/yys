package cn.qingjiu.yys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
/**
* @Description: 用户信息主表
* @Author: tjy
* @Date: 2020/3/4
*/
@Data
public class LoginUser {

    private Integer id;

    private String userName;

    private Integer userStart;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Timestamp createTime;
}