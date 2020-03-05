package cn.qingjiu.yys.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/go")
    public String goLogin(){
        return "test";
    }
    @GetMapping("/go1")
    public String goLogin1(){
        return "index";
    }

    @GetMapping("/go2")
    public String goLogin2(){
        return "loginpage";
    }

}
