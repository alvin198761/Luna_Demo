package org.alvin.ui.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private AuthenticationProvider authProvider;
//
//
//    @Autowired
//    UsernamePasswordAuthenticationExtendedFilter usernamePasswordAuthenticationExtendedFilter;
//
//    @Autowired
//    UserLogoutFilter userLogoutFilter;
//
//
//    private Logger logger = Logger.getLogger(getClass());
//
//
//

    @Override
    public void configure(WebSecurity web) throws Exception {
        //super.configure(web);
        web.ignoring().antMatchers("/img/**", "/*.css", "/css/*.css", "/font/**", "/*.js", "/lib/**");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
            http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/demo/**").permitAll()
                    .antMatchers("/captcha").permitAll()
                    .antMatchers("/afterLogout").permitAll()
                    .antMatchers("/rest/**").permitAll()
                    .anyRequest().authenticated()
                    .and().formLogin().loginPage("/login").failureUrl("/login").permitAll();
                   // .and().addFilter(usernamePasswordAuthenticationExtendedFilter).addFilter(userLogoutFilter);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.authenticationProvider(authProvider);
    }

    @Bean(name = "frameAuthManager")
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


}
