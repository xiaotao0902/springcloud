package com;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 
 * @ClassName Application
 * @author Zhang.Tony
 * @version V2.0.0
 */

@SpringBootApplication(exclude = MybatisAutoConfiguration.class)
@EnableAutoConfiguration
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.tony.spring.boot.mapper")
public class OrderApp  extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {

	@Value("${server.port}")
	private int port;//应用的端口
	/**
	 * 启动入口
	 * @param args
	 */
    public static void main(String ... args){
        SpringApplication.run(OrderApp.class, args);
    }

    /**
     * 自定义端口
     */
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(port);
	}

}
