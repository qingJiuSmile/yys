package cn.qingjiu.yys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index.html").permitAll()
                .antMatchers("");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.inMemoryAuthentication().passwordEncoder(new PasswordEncoder() {
             @Override
             public String encode(CharSequence charSequence) {
                 return charSequence.toString();
             }
             @Override
             public boolean matches(CharSequence charSequence, String s) {
                 return s.equals(charSequence.toString());
             }
         }).withUser("卢本伟").password("111").roles("go")
                 .and().withUser("mafei").password("111").roles("go");
    }
}
