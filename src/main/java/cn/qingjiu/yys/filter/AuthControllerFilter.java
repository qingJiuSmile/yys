package cn.qingjiu.yys.filter;

import com.alibaba.fastjson.JSONObject;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component("authControllerFilter")
@Order(Ordered.LOWEST_PRECEDENCE)
public class AuthControllerFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain chain) throws IOException, ServletException {
        String jwtData = request1.getParameter("jwtData");
        if(jwtData != null){
            JSONObject obj = JSONObject.parseObject(jwtData);
            request1.setAttribute("loginUserId",obj.get("userID"));
            request1.setAttribute("loginClient",obj.get("Client"));
        }
        chain.doFilter(request1, response1);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }
}
