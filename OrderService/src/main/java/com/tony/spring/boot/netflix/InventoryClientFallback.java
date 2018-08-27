package com.tony.spring.boot.netflix;

import org.springframework.stereotype.Component;

@Component
public class InventoryClientFallback implements InventoryClient {
	
	public String getInventory(Integer id) {
		return "fallback";
	}

	public String reduceInventory(String id,String count) {
		return "fallback";
	}

	public String hello() {
		return "fallback";
	}

}
