package org.alvin.home.mvc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.EndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.HealthIndicatorAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricRepositoryAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Properties;

@Configuration
@Import({EndpointAutoConfiguration.class, HealthIndicatorAutoConfiguration.class, MetricRepositoryAutoConfiguration.class})
@ComponentScan(basePackages = {"org.alvin.home.mvc.component"})
@PropertySource("classpath:application.properties")
@EnableWebMvc
public class AppConfig {

    @Value("${management.shell.ssh.port}")
    private String port;
    @Value("${management.shell.auth.simple.user.name}")
    private String user;
    @Value("${management.shell.auth.simple.user.password}")
    private String password;

    @Bean
    public org.crsh.spring.SpringBootstrap springBootstrap(){
        org.crsh.spring.SpringBootstrap bootstrap = new org.crsh.spring.SpringBootstrap();
        Properties properties = new Properties();
        properties.put("crash.ssh.port",port);
        properties.put("crash.vfs.refresh_period","1");
        properties.put("crash.auth","simple");
        properties.put("crash.auth.simple.username",user);
        properties.put("crash.auth.simple.password",password);
        bootstrap.setConfig(properties);
        return bootstrap;
    }
}
