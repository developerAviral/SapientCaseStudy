package com.sapient.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.sapient.application.entity.Product;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductServiceApplicationIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	@Order(1)
	public void createFirstProduct() {
		Product product = new Product("peterengland", "shirts", "red", 2500.01, "xl");
		HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Product> request = new HttpEntity<>(product, httpHeaders);
		ResponseEntity<String> result = this.restTemplate.postForEntity("/products", request, String.class);
		assertEquals(201, result.getStatusCodeValue());
	}
	
	@Test
	@Order(2)
	public void createSecondProduct() {
		Product product = new Product("pepe", "denims", "blue", 4500.99, "l");
		HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Product> request = new HttpEntity<>(product, httpHeaders);
		ResponseEntity<String> result = this.restTemplate.postForEntity("/products", request, String.class);
		assertEquals(201, result.getStatusCodeValue());
	}
	
	@Test
	@Order(3)
	public void getProductBySku() {
		Product product = this.restTemplate.getForObject("/products/1", Product.class);
		
		assertEquals("peterengland",product.getBrand());
		assertEquals("shirts",product.getCategory());
		assertEquals("red",product.getColor());
		assertEquals(2500.01,product.getPrice());
		assertEquals("xl",product.getSize());
		
	}
	
	@Test
	@Order(3)
	public void getProductByBrand() {
		Product[] product = this.restTemplate.getForObject("/products/product/brand/pepe", Product [].class);
		assertEquals(1,product.length);

		
	}
	
	@Test
	@Order(3)
	public void getProductByColor() {
		Product[] product = this.restTemplate.getForObject("/products/product/color/red", Product[].class);
		
		assertEquals(1,product.length);
		
	}
	
	@Test
	@Order(3)
	public void getProductByPrice() {
		Product[] product = this.restTemplate.getForObject("/products/product/price/2500.01", Product[].class);
		assertEquals(1,product.length);
	}
	
	@Test
	@Order(3)
	public void getProductBySize() {
		Product[] product = this.restTemplate.getForObject("/products/product/size/xl", Product[].class);
		assertEquals(1,product.length);
	}
	
	@Test
	@Order(3)
	public void getNumberOfProducts() {
		Long count = this.restTemplate.getForObject("/products/product/count/productcount", Long.class);
		assertEquals(2,count);
	}
	
	
}
