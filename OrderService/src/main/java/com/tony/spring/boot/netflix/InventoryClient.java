package com.tony.spring.boot.netflix;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "inventory-service", fallback = InventoryClientFallback.class)
public interface InventoryClient {

	@RequestMapping(method = RequestMethod.GET, value = "/inventory/{id}")
	public String getInventory(@PathVariable("id") Integer id);
	
	@RequestMapping(method = RequestMethod.GET, value = "/inventory/reduce")
	public String reduceInventory(@RequestParam(value = "id",required = false) String id,
			  					  @RequestParam(value = "count",required = false) String count);

	@RequestMapping(method = RequestMethod.GET, value = "/inventory/hello")
	public String hello();
}
