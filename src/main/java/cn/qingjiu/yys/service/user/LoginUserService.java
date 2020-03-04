package cn.qingjiu.yys.service.user;

import cn.qingjiu.yys.constant.CommConstant;
import cn.qingjiu.yys.entity.JsonResult;
import cn.qingjiu.yys.entity.LoginUser;
import cn.qingjiu.yys.entity.PublicParam;
import cn.qingjiu.yys.mapper.user.LoginUserMapper;
import cn.qingjiu.yys.util.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
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


    /**
    * @Description: 用户登录验证
    * @Param: []
    * @return: cn.qingjiu.yys.entity.JsonResult<java.util.List<cn.qingjiu.yys.entity.LoginUser>>
    * @Author: tjy
    * @Date: 2020/3/4
    */
    public JsonResult<String> getUserDetailed(PublicParam search){
        search.setPassword(Md5.getMD5(search.getPassword()));
        LoginUser user = loginUserMapper.getLoginUserAll(search);
        JsonResult<String> js = new JsonResult<>();
        if(user != null){
            js.setData("ok");
        }
        return js;
    }
}
