package com.sapient.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sapient.application.entity.Product;
import com.sapient.application.service.ProductService;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ApplicationTests {

	@Autowired
	private ProductService productService;
	
	@Test
	@Order(1)
	public void test_createProduct() {
		Product product1 = new Product();
		Product product2 = new Product();
		
		product1.setBrand("Pepe");
		product1.setCategory("Shirts");
		product1.setColor("Red");
		product1.setPrice(2500.00);
		product1.setSize("XL");
		
		product2.setBrand("Pepe");
		product2.setCategory("Denims");
		product2.setColor("Blue");
		product2.setPrice(2999.00);
		product2.setSize("XXL");
		
		Product savedProduct1 = productService.createProduct(product1);
		Product savedProduct2 = productService.createProduct(product2);
		
		assertEquals(product1.getBrand(), savedProduct1.getBrand());
		assertEquals(product1.getCategory(), savedProduct1.getCategory());
		assertEquals(product1.getColor(), savedProduct1.getColor());
		assertEquals(product1.getPrice(), savedProduct1.getPrice());
		assertEquals(product1.getSize(), savedProduct1.getSize());
		
		assertEquals(product2.getBrand(), savedProduct2.getBrand());
		assertEquals(product2.getCategory(), savedProduct2.getCategory());
		assertEquals(product2.getColor(), savedProduct2.getColor());
		assertEquals(product2.getPrice(), savedProduct2.getPrice());
		assertEquals(product2.getSize(), savedProduct2.getSize());		
	}
	
	@Test
	@Order(2)
	public void test_getByBrand() {
		List<Product> products = productService.getByBrands("Pepe");
		
		products.stream().forEach(System.out:: println);
	}
	
	@Test
	@Order(2)
	public void test_getByColor() {
		List<Product> products = productService.getByColor("Red");
		
		products.stream().forEach(System.out:: println);
	}
	
	@Test
	@Order(3)
	public void test_getByPrice() {
		List<Product> products = productService.getByPrice(2999.00);
		
		products.stream().forEach(System.out:: println);
	}
	
	@Test
	@Order(4)
	public void test_getBySize() {
		List<Product> products = productService.getBySize("XXL");
		
		products.stream().forEach(System.out:: println);
	}
	
	@Test
	@Order(5)
	public void test_getCount() {
		Long count = productService.getNumberOfProducts();
		
		assertEquals(2, count);
	}
	
}
