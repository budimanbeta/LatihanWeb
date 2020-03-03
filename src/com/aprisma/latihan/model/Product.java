package com.aprisma.latihan.model;

public class Product {

	private int id;
	private int code;
	private String name;
	private String type;
	private int price;
	
	
	public Product() {
		
	}
	public Product(int code, String name, String type, int price) {
		this.code = code;
		this.name = name;
		this.type = type;
		this.price = price;
	}
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
