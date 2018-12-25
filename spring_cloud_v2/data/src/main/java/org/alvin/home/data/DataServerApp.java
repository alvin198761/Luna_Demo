package org.alvin.home.data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 数据访问
 */
@SpringBootApplication
@EnableEurekaClient
public class DataServerApp {

	public static void main(String[] args) {
		SpringApplication.run(DataServerApp.class, args);
	}
}
