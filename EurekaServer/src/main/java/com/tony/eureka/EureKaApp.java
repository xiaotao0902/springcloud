package com.tony.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EureKaApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EureKaApp.class).web(true).run(args);
	}

}
