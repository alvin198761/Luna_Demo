package org.alvin.home.mvc.config;

import org.crsh.shell.impl.command.CRaSH;
import org.springframework.boot.actuate.autoconfigure.EndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.HealthIndicatorAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricRepositoryAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import({EndpointAutoConfiguration.class, HealthIndicatorAutoConfiguration.class, MetricRepositoryAutoConfiguration.class})
@ComponentScan(basePackages = {"org.alvin.home.mvc.component", "org.springframework.boot.starter.remote.shell"})
@PropertySource("classpath:application.properties")
@EnableWebMvc
public class AppConfig {

    public AppConfig() {
        System.out.println("App");
        new Thread(()->{
            CRaSH cRaSH = new CRaSH();
        }).start();

    }
}
