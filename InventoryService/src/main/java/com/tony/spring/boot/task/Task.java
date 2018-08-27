package com.tony.spring.boot.task;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableScheduling // 启用定时任务
public class Task {
	
//    @Scheduled(cron="0 0/1 * * * ?")
	public void run(){
		System.out.println("Scheduled Running...");
	}
}
