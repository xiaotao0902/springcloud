package com.tony.spring.boot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.spring.boot.entity.InventoryInfo;
import com.tony.spring.boot.mapper.InventoryInfoMapper;
import com.tony.spring.boot.utils.JsonUtil;


@RestController
@RequestMapping(value="/inventory")
public class InventoryController {
	
	@Autowired  
    private InventoryInfoMapper inventoryInfoMapper;  

	@GetMapping("/{id}")   
    public String getById(@PathVariable("id")int id){  
        try {
        	InventoryInfo inventory= inventoryInfoMapper.selectByPrimaryKey(id);
			return JsonUtil.getJsonString(inventory);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
	@GetMapping("/reduce") 
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
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

}
