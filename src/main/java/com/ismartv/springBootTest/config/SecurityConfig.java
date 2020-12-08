package com.ismartv.springBootTest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ismartv.springBootTest.dao.api.UserDaoInterface;
import com.ismartv.springBootTest.entity.User;

import lombok.extern.log4j.Log4j2;


/**
 * 自定义安全配置
 *
 * @ClassName: SecurityConfig
 * @Description:
 * @date 2020年9月14日 下午6:13:02
 * https://docs.spring.io/spring-security/site/docs/4.2.18.RELEASE/guides/html5/helloworld-boot.html
 */
@Configuration
@EnableWebSecurity
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDaoInterface userDaoInterface;
    //密码加密方式
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
                .loginPage("/loginPage")           // 设置登录页面
                .loginProcessingUrl("/user/login")  // 自定义的登录接口
                .and()
                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers("/loginPage").permitAll()     // 设置所有人都可以访问登录页面
                .anyRequest()               // 任何请求,登录后可以访问
                .authenticated()
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                log.info("secrity configure username:{}", username);
//                return userDaoInterface.findById(username).get();
                User user = new User();
                user.setFullname("tom");
                user.setUsername("admin");
                user.setPassword(bCryptPasswordEncoder.encode("admin"));
                return user;
            }
        }).passwordEncoder(bCryptPasswordEncoder);
//        auth.inMemoryAuthentication().withUser("user").password("user").roles(User.Role.USER.getValue());
    }
}
