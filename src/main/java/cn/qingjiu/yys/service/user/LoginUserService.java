package cn.qingjiu.yys.service.user;

import cn.qingjiu.yys.constant.CommConstant;
import cn.qingjiu.yys.entity.JsonResult;
import cn.qingjiu.yys.entity.LoginUser;
import cn.qingjiu.yys.mapper.user.LoginUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description: 用户业务层
* @Author: tjy
* @Date: 2020/3/4
*/
@Service
public class LoginUserService {


    @Autowired
    private LoginUserMapper loginUserMapper;


    public JsonResult<List<LoginUser>> getUserDetailed(){
        JsonResult<List<LoginUser>> js = new JsonResult<>();
        js.setCode(CommConstant.SUCCESSED_FLAG);
        js.setData(loginUserMapper.getLoginUserAll());
        js.setMsg(CommConstant.SUCCESSED_MSG);
        return js;
    }
}
