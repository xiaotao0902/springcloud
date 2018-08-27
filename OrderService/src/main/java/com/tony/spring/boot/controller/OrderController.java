package com.tony.spring.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tony.spring.boot.entity.CartInfo;
import com.tony.spring.boot.entity.InventoryInfo;
import com.tony.spring.boot.entity.OrderCartResult;
import com.tony.spring.boot.entity.OrderInfo;
import com.tony.spring.boot.mapper.OrderInfoMapper;
import com.tony.spring.boot.netflix.InventoryClient;
import com.tony.spring.boot.utils.JsonUtil;
import com.tony.spring.boot.utils.Utils;


@RestController
@RequestMapping(value="/v1/order")
@Configuration
public class OrderController {
	
	@Autowired
	private InventoryClient inventoryClient;
	
	@Autowired  
    private OrderInfoMapper orderInfoMapper;  
	
	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String hello() {
		return inventoryClient.hello();
	}
    
    @GetMapping()  
    public String getByName(@RequestParam(value = "username",required = false) String username){  
        try {
        	List<OrderCartResult> orders = new ArrayList<OrderCartResult>();
        	List<OrderCartResult> results = new ArrayList<OrderCartResult>();
        	
        	if(username != null && !"".equals(username)) {
        		orders= orderInfoMapper.selectByName(username);
        		for(OrderCartResult order :orders) {
        			OrderCartResult result = new OrderCartResult();
        			List<CartInfo> carts = new ArrayList<CartInfo>();
        			result.setId(order.getId());
        			result.setDate(order.getDate());
        			result.setTotal(order.getTotal());
        			String [] names = order.getNames().split(",");
        			String [] images = order.getImages().split(",");
        			String [] counts = order.getCounts().split(",");
        			if(names != null) {
        				for(int i = 0; i < names.length; i++) {
        					CartInfo cart = new CartInfo();
        					cart.setName(names[i]);
        					cart.setImage(images[i]);
        					cart.setCount(counts[i]);
        					carts.add(cart);
        				}
        			}
        			result.setCarts(carts);
        			results.add(result);
        		}
        	}
			return JsonUtil.getJsonString(results);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
    
    @PostMapping(produces="application/json;charset=UTF-8")  
    public String addOrder(@RequestBody OrderInfo order){  
        try {
        	for(CartInfo cart : order.getCarts()) {
        		Gson gson = new Gson();
        		String inventoryStr = inventoryClient.getInventory(Integer.parseInt(cart.getProduct_id()));
        		if(!"fallback".equals(inventoryStr)) {
        			InventoryInfo ii = gson.fromJson(inventoryStr,InventoryInfo.class);
            		int inventory = ii.getInventory();
            		if(inventory < Integer.parseInt(cart.getCount())) {
            			return "out of stock for " + cart.getName();
            		}
        		}else {
        			return "fallback from inventory ";
        		}
        	}
        	
        	int order_id = Utils.getRandId();
        	if(order != null) {
        		order.setId(order_id);
        		order.setDate(Utils.getTimeStampToTD());
            	orderInfoMapper.add(order);
            	
            	for(CartInfo cart : order.getCarts()) {
            		int id = Utils.getRandId();
            		cart.setId(id);
            		cart.setOrder_id(order_id);
            		orderInfoMapper.addCart(cart);
            		String inventoryStr = inventoryClient.reduceInventory(cart.getProduct_id(),cart.getCount());
            		if("fallback".equals(inventoryStr)) {
            			return "fallback from inventory ";
            		}
            	}
        	}
			return JsonUtil.getJsonString(order);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
    
    @DeleteMapping(value="/{id}", produces="application/json;charset=UTF-8")  
    public String deleteOrder(@PathVariable("id")int id){  
        try {
        	orderInfoMapper.delete(id);
			return JsonUtil.getJsonString("success");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
    

}
