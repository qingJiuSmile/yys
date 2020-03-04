package cn.qingjiu.yys.filter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/*@Component("authControllerFilter")
@Order(Ordered.LOWEST_PRECEDENCE)*/
public class AuthControllerFilter implements Filter {
    @Override
    public void destroy() {
    }


    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {

       /* HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        Sysuser user = (Sysuser) request.getSession().getAttribute("user");
        StringBuffer url = request.getRequestURL();
        if(user == null && url.indexOf("login") == -1){
            response.sendRedirect(request.getContextPath() + "/index.html");
        }else{
            arg2.doFilter(arg0, arg1);
        }*/

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }
}
