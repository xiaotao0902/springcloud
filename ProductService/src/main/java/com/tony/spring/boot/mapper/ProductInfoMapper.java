package com.tony.spring.boot.mapper;

import java.util.List;

import com.tony.spring.boot.entity.ProductInfo;

public interface ProductInfoMapper {

    ProductInfo selectByPrimaryKey(Integer id);
    
    List<ProductInfo> selectByName(String name);
    
    List<ProductInfo> selectByAll();
    
    void addProduct(ProductInfo product);
    
    void updateProduct(ProductInfo product);
    
    void deleteProduct(Integer id);
}