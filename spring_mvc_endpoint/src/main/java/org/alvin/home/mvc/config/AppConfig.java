package org.alvin.home.mvc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.EndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.HealthIndicatorAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricRepositoryAutoConfiguration;
import org.springframework.boot.actuate.endpoint.*;
import org.springframework.boot.actuate.endpoint.jmx.EndpointMBeanExporter;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;
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

    @Bean
    public EndpointMBeanExporter endpointMBeanExporter(){
        return  new EndpointMBeanExporter();
    }

    @Bean
    public DumpEndpoint dumpEndpoint(){
        return new DumpEndpoint();
    }

    @Bean
    public EnvironmentEndpoint environmentEndpoint(){
        return  new EnvironmentEndpoint();
    }

//    @Bean
//    public FlywayEndpoint flywayEndpoint(){
//        return new FlywayEndpoint():
//    }

//    @Bean
//    public HealthEndpoint healthEndpoint(){
//        return new  HealthEndpoint();
//    }

    @Bean
    public MetricsEndpoint metricsEndpoint(){
        List<PublicMetrics> list = new ArrayList<>();
        list.add(new SystemPublicMetrics());
        list.add(new TomcatPublicMetrics());
        return new MetricsEndpoint(list);
    }

    @Bean
    public BeansEndpoint beansEndpoint(){
        return new BeansEndpoint();
    }

    @Bean
    public AutoConfigurationReportEndpoint autoConfigurationReportEndpoint(){
        return new AutoConfigurationReportEndpoint();
    }

}
