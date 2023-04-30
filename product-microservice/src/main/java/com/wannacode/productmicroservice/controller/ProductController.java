package com.wannacode.productmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

import com.wannacode.productmicroservice.entities.ProductEntity;
import com.wannacode.productmicroservice.repository.ProductRepository;

@RestController
@RequestMapping("/api/product") // localhost:8080/api/product
public class ProductController {

    @Autowired // Inyeccion de dependencias
    private ProductRepository productRepository;

    @GetMapping // localhost:8080/api/product`
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        ResponseEntity<List<ProductEntity>> response = new ResponseEntity<>(products, HttpStatus.OK);
        return response;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createProduct(@RequestBody ProductEntity product) {
        productRepository.save(product);
    }
}
