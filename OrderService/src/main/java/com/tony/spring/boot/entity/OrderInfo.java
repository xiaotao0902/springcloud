package com.tony.spring.boot.entity;

import java.util.List;

public class OrderInfo {
    private Integer id;

    private String total;
    
    private String date;
    
    private String username;
    
    private List<CartInfo> carts;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<CartInfo> getCarts() {
		return carts;
	}

	public void setCarts(List<CartInfo> carts) {
		this.carts = carts;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}