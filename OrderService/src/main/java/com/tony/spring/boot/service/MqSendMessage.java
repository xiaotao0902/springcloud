package com.tony.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import com.google.gson.Gson;
import com.tony.spring.boot.entity.ProductSales;

@Configuration
public class MqSendMessage {
	
	@Autowired
	private MqProductSalesService mqProductSalesService;
	
	public void SendProductSales(ProductSales productSales) {
		Gson gson = new Gson();
    	Message<byte[]> msg = MessageBuilder.withPayload(gson.toJson(productSales).getBytes()).build();
    	mqProductSalesService.sendProductSales().send(msg);
	}
}
