package com.wannacode.productmicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wannacode.productmicroservice.entities.ProductEntity;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {

}
