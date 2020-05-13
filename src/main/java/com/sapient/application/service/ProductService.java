package com.sapient.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.application.entity.Product;
import com.sapient.application.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public Product getBySku(Long sku){
		return repository.findById(sku).orElse(null);
	}
	
	public List<Product> getByBrands(String brand){
		return repository.findByBrand(brand);
	}
	
	public List<Product> getByPrice(Double price){
		return repository.findByPrice(price);
	}
	
	public List<Product> getByColor(String color){
		return repository.findByColor(color);
	}
	
	public List<Product> getBySize(String size){
		return repository.findBySize(size);
	}
	
	public Long getNumberOfProducts(){
		return repository.count();
	}
	
	public Product createProduct(Product product){
		return repository.save(product);
	}
	
}
