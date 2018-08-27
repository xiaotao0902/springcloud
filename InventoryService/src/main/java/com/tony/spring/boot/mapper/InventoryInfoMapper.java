package com.tony.spring.boot.mapper;

import com.tony.spring.boot.entity.InventoryInfo;

public interface InventoryInfoMapper {

    InventoryInfo selectByPrimaryKey(Integer id);
    
    void updateInventory(InventoryInfo product);
    
}