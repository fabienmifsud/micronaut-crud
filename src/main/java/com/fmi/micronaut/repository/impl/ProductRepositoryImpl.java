package com.fmi.micronaut.repository.impl;

import com.fmi.micronaut.data.Product;
import com.fmi.micronaut.repository.ProductRepository;
import io.micronaut.transaction.annotation.ReadOnly;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class ProductRepositoryImpl implements ProductRepository {

    private final EntityManager entityManager;

    public ProductRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @ReadOnly
    public List<Product> findAll() {
        String qlString = "SELECT p FROM Product as p";
        TypedQuery<Product> query = entityManager.createQuery(qlString, Product.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Boolean createProduct(Product product) {
        this.entityManager.persist(product);
        return true;
    }
}
