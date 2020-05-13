package com.sapient.application.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sku;
	private String brand;
	private String category;
	private String color;
	private Double price;
	private String size;
	
	public Product() {}
	

	public Product(String brand, String category, String color, Double price, String size) {
		super();
		this.brand = brand;
		this.category = category;
		this.color = color;
		this.price = price;
		this.size = size;
	}



	public Product(Long sku, String brand, String category, String color, Double price, String size) {
		super();
		this.sku = sku;
		this.brand = brand;
		this.category = category;
		this.color = color;
		this.price = price;
		this.size = size;
	}



	public Long getSku() {
		return sku;
	}

	public void setSku(Long sku) {
		this.sku = sku;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}


	@Override
	public String toString() {
		return "Product [sku=" + sku + ", brand=" + brand + ", category=" + category + ", color=" + color + ", price="
				+ price + ", size=" + size + "]";
	}

}