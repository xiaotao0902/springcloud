package com.tony.spring.boot.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ReceiveService {

	@Input("product-sales")
	SubscribableChannel reProductSales();
}
