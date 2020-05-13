package com.sapient.application.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sapient.application.entity.Product;
import com.sapient.application.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable Long id) {
		return service.getBySku(id);
	}

	@GetMapping("/product/brand/{brand}")
	public List<Product> getByBrands(@PathVariable String brand) {
		return service.getByBrands(brand.toLowerCase());
	}

	@GetMapping("/product/color/{color}")
	public List<Product> getByColor(@PathVariable String color) {
		return service.getByColor(color.toLowerCase());
	}

	@GetMapping("/product/price/{price}")
	public List<Product> getByPrice(@PathVariable Double price) {
		return service.getByPrice(price);
	}
	
	@GetMapping("/product/size/{size}")
	public List<Product> getByPrice(@PathVariable String size) {
		return service.getBySize(size.toLowerCase());
	}

	@GetMapping("/product/count/productcount")
	public Long getNumberOfProducts() {
		return service.getNumberOfProducts();
	}
	
	@PostMapping("/products")
	public ResponseEntity<Void> createProduct(@Valid @RequestBody Product product){
		Product savedProduct = service.createProduct(product);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedProduct.getSku()).toUri();
		return ResponseEntity.created(location).build();
	}
}
