package org.alvin.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 主要程序，
 */
@SpringBootApplication
@EnableEurekaClient
public class CenterServerApp {

	public static void main(String[] args) {
		SpringApplication.run(CenterServerApp.class, args);
	}
}
