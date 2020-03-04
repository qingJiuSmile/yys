package cn.qingjiu.yys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
/**
* @Description: 用户信息主表
* @Author: tjy
* @Date: 2020/3/4
*/
@Data
public class LoginUser {

    private Integer id;

    private String userName;

    private String userNo;

    private Integer userState;

    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Timestamp createTime;
}