package com.tony.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.tony.spring.boot.entity.ProductSales;
import com.tony.spring.boot.mapper.ProductInfoMapper;
import com.tony.spring.boot.utils.Utils;

@Configuration
public class MqReceiveMessages {
	
	@Autowired  
    private ProductInfoMapper productInfoMapper;  
	
	@StreamListener("product-sales")
	public void onReceive(byte[] msg) {
		Gson gson = new Gson();
		ProductSales productSales = gson.fromJson(new String(msg), ProductSales.class);
		productSales.setId(String.valueOf(Utils.getRandId()));
    	productInfoMapper.addProductSales(productSales);
		System.out.println("=============" + productSales);
	}
}
