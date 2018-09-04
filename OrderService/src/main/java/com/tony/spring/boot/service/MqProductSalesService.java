package com.tony.spring.boot.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface MqProductSalesService {

	@Output("product-sales")
	SubscribableChannel sendProductSales();
}
