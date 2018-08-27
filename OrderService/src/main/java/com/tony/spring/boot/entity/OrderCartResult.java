package com.tony.spring.boot.entity;

import java.util.List;

public class OrderCartResult {
	
	private String id;
	
	private String total;
	
	private String date;
	
	private String names;
	
	private String images;
	
	private String counts;
	
	private List<CartInfo> carts;
	
	public List<CartInfo> getCarts() {
		return carts;
	}

	public void setCarts(List<CartInfo> carts) {
		this.carts = carts;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getCounts() {
		return counts;
	}

	public void setCounts(String counts) {
		this.counts = counts;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
