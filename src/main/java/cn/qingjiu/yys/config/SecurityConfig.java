package cn.qingjiu.yys.config;

import cn.qingjiu.yys.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * TokenBasedRememberMeServices的生成密钥，
     * 算法实现详见文档：https://docs.spring.io/spring-security/site/docs/5.1.3.RELEASE/reference/htmlsingle/#remember-me-hash-token
     */
    private final String SECRET_KEY = "123456";

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login") // 自定义用户登入页面
                .failureUrl("/login?error") // 自定义登入失败页面，前端可以通过url中是否有error来提供友好的用户登入提示
                .and()
                .logout()
                .logoutUrl("/logout")// 自定义用户登出页面
                .logoutSuccessUrl("/")
                .and()
                .rememberMe() // 开启记住密码功能
                .rememberMeServices(getRememberMeServices()) // 必须提供
                .key(SECRET_KEY) // 此SECRET需要和生成TokenBasedRememberMeServices的密钥相同
                .and()
                /*
                 * 默认允许所有路径所有人都可以访问，确保静态资源的正常访问。
                 * 后面再通过方法注解的方式来控制权限。
                 */
                .authorizeRequests().anyRequest().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

  /*  @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(customUserDetailsService);
    }*/


    /**
     * 如果要设置cookie过期时间或其他相关配置，请在下方自行配置
     */
    private TokenBasedRememberMeServices getRememberMeServices() {
        TokenBasedRememberMeServices services = new TokenBasedRememberMeServices(SECRET_KEY, customUserDetailsService);
        services.setCookieName("remember-cookie");
        services.setTokenValiditySeconds(100); // 默认14天
        return services;
    }
}
