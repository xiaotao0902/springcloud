package com.tony.spring.boot.entity;

public class ProductSales {
	
	private String id;
	
	private String product_id;
	
	private String product_sale_time;
	
	private String product_sales_count;
	
	private String product_sales_user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_sale_time() {
		return product_sale_time;
	}

	public void setProduct_sale_time(String product_sale_time) {
		this.product_sale_time = product_sale_time;
	}

	public String getProduct_sales_count() {
		return product_sales_count;
	}

	public void setProduct_sales_count(String product_sales_count) {
		this.product_sales_count = product_sales_count;
	}

	public String getProduct_sales_user() {
		return product_sales_user;
	}

	public void setProduct_sales_user(String product_sales_user) {
		this.product_sales_user = product_sales_user;
	}

	@Override
	public String toString() {
		return "ProductSales [id=" + id + ", product_id=" + product_id + ", product_sale_time=" + product_sale_time
				+ ", product_sales_count=" + product_sales_count + ", product_sales_user=" + product_sales_user + "]";
	}
	
}
