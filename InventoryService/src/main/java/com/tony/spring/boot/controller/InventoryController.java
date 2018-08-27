package com.tony.spring.boot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.spring.boot.entity.InventoryInfo;
import com.tony.spring.boot.mapper.InventoryInfoMapper;
import com.tony.spring.boot.utils.JsonUtil;


@RestController
public class InventoryController {
	
	@Autowired  
    private InventoryInfoMapper inventoryInfoMapper;  

	@RequestMapping(value = "/v1/inventory/{id}", method = RequestMethod.GET)  
    public String getById(@PathVariable("id")int id){  
        try {
        	InventoryInfo inventory= inventoryInfoMapper.selectByPrimaryKey(id);
			return JsonUtil.getJsonString(inventory);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
    
	@RequestMapping(value="/v1/inventory/reduce", method = RequestMethod.GET,produces="application/json;charset=UTF-8")  
    public String updateInventory(@RequestParam(value = "id",required = false) String id,
    							  @RequestParam(value = "count",required = false) String count){  
        try {
        	InventoryInfo inventory= inventoryInfoMapper.selectByPrimaryKey(Integer.parseInt(id));
        	inventory.setInventory(inventory.getInventory()-Integer.parseInt(count));
        	inventoryInfoMapper.updateInventory(inventory);
			return JsonUtil.getJsonString("success");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}

}
