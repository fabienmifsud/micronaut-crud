package com.fmi.micronaut.repository;

import com.fmi.micronaut.data.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

    Boolean createProduct(Product product);
}
