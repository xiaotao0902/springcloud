package com.tony.spring.boot.mapper;

import java.util.List;

import com.tony.spring.boot.entity.CartInfo;
import com.tony.spring.boot.entity.OrderCartResult;
import com.tony.spring.boot.entity.OrderInfo;

public interface OrderInfoMapper {

	OrderInfo selectByPrimaryKey(Integer id);
    
    List<OrderCartResult> selectByName(String name);
    
    List<OrderInfo> selectByAll();
    
    void add(OrderInfo order);
    
    void addCart(CartInfo cart);
    
    void update(OrderInfo order);
    
    void delete(Integer id);
}