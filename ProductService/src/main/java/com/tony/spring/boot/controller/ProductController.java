package com.tony.spring.boot.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.spring.boot.entity.ProductInfo;
import com.tony.spring.boot.mapper.ProductInfoMapper;
import com.tony.spring.boot.utils.JsonUtil;
import com.tony.spring.boot.utils.Utils;


@RestController
@RequestMapping(value="/v1/product")
public class ProductController {
	
	@Autowired  
    private ProductInfoMapper productInfoMapper;  

    @GetMapping("/{id}")  
    public String getById(@PathVariable("id")int id){  
        try {
        	ProductInfo product= productInfoMapper.selectByPrimaryKey(id);
			return JsonUtil.getJsonString(product);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
    
    @GetMapping()  
    public String getByName(@RequestParam(value = "name",required = false) String name){  
        try {
        	List<ProductInfo> products = new ArrayList<ProductInfo>();
        	if(name != null && !"".equals(name)) {
        		products= productInfoMapper.selectByName(name);
        	}else {
        		products= productInfoMapper.selectByAll();
        	}
			return JsonUtil.getJsonString(products);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
    
    @PostMapping(produces="application/json;charset=UTF-8")  
    public String addProduct(@RequestBody ProductInfo product){  
        try {
        	product.setId(Utils.getRandId());
        	productInfoMapper.addProduct(product);
        	
			return JsonUtil.getJsonString(product);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
    
    @PutMapping(value="/{id}", produces="application/json;charset=UTF-8")  
    public String updateProduct(@PathVariable("id")int id,@RequestBody ProductInfo product){  
        try {
        	product.setId(id);
        	productInfoMapper.updateProduct(product);
			return JsonUtil.getJsonString("success");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
    
    @DeleteMapping(value="/{id}", produces="application/json;charset=UTF-8")  
    public String deleteProduct(@PathVariable("id")int id){  
        try {
        	productInfoMapper.deleteProduct(id);
			return JsonUtil.getJsonString("success");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
    

}
