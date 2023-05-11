package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Product;
import com.demo.repo.ProductRepo;

@RestController
public class ProductControllerr {

	@Autowired
	ProductRepo productRepo;

	@PostMapping(value = "addProduct", consumes = "application/json")
	ResponseEntity<String> addProduct(@RequestBody Product product) {
		productRepo.save(product);
		return new ResponseEntity<String>("Product Saved", HttpStatus.CREATED);
	}

	@GetMapping(value = "getProduct", produces = "application/json")
	ResponseEntity<List<Product>> addProduct() {
		List<Product> list = productRepo.findAll();
		return new ResponseEntity<>(list, HttpStatus.CREATED);
	}

}
