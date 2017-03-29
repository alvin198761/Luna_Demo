package org.alvin.mvc.config.security;


import org.alvin.mvc.system.security.SecurityAuthenticationProvider;
import org.alvin.mvc.system.security.SecurityUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tangzhichao on 2016/8/17.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        SecurityUserDetailService userDetailService = new SecurityUserDetailService();
        auth.authenticationProvider(new SecurityAuthenticationProvider(userDetailService));
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //放过的url
                .antMatchers("/login", "/j_spring_security_check").permitAll()
                .antMatchers("/code", "/check").permitAll()
                //所有登录用户都可以访问
                .antMatchers("/user/**").access("hasRole('ADMIN')")
                .antMatchers("/**").fullyAuthenticated()

                //登录页面设置
                .and().formLogin().loginPage("/login")
                .failureUrl("/login?error")
                .loginProcessingUrl("/j_spring_security_check")
                .defaultSuccessUrl("/index")
                .usernameParameter("j_username") // 用户名参数
                .passwordParameter("j_password") // 密码参数;
                .and()
                .logout().logoutSuccessUrl("/index") //退出登录
                .and()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint("/login")) //入口点
                .and()
                .csrf().disable();
        //
        UsernamePasswordAuthenticationFilter filter = this.usernamePasswordAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager());
        http.addFilter(filter);
    }

    private LoginUrlAuthenticationEntryPoint authenticationEntryPoint(String url) {
        return new LoginUrlAuthenticationEntryPoint(url) {
            @Override
            public void commence(HttpServletRequest request, HttpServletResponse response,
                                 AuthenticationException authException) throws IOException, ServletException {
                if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                } else {
                    super.commence(request, response, authException);
                }
            }
        };
    }

    private UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter( ) {
        UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter() {
            @Override
            public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
                    throws AuthenticationException {
              //  String codeInSession = SessionUtils.getSession(request).getCode();
//                Object codeObj = request.getParameter("code");
//                if (codeObj == null || codeInSession == null) {
//                    request.setAttribute("j_username", request.getParameter("j_username"));
//                    request.setAttribute("j_password", request.getParameter("j_password"));
//                    throw new BadCredentialsException("验证码为空");
//                }
//                if (!codeInSession.equalsIgnoreCase(codeObj.toString())) {
//                    request.setAttribute("j_username", request.getParameter("j_username"));
//                    request.setAttribute("j_password", request.getParameter("j_password"));
//                    throw new BadCredentialsException("验证码不匹配");
//                }
                return super.attemptAuthentication(request, response);
            }
        };

        return filter;
    }


}
