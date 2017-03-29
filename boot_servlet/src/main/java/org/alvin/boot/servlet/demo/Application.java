package org.alvin.boot.servlet.demo;

import org.alvin.boot.servlet.demo.controller.DemoServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangzhichao on 2017/3/29.
 */
@SpringBootApplication
@Configuration
@ServletComponentScan
@EnableWebSocket
public class Application extends SpringBootServletInitializer implements WebSocketConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean dispatcherServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new DemoServlet(),"/xs/*");// ServletName默认值为首字母小写，即demoServlet
        Map<String, String> params = new HashMap<>();
        params.put("org.atmosphere.servlet", "org.springframework.web.servlet.DispatcherServlet");
        params.put("contextClass", "org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
        params.put("contextConfigLocation", "net.org.selector.animals.config.ComponentConfiguration");
        registration.setInitParameters(params);
        return registration;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {

    }
    //https://segmentfault.com/a/1190000007397316

}
