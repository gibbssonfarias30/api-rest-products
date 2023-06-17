package com.backfcdev.apirestproducts.service;

import com.backfcdev.apirestproducts.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product save(Product product);
    Product findById(Long id);
    Product update(Long id, Product product);
    void delete(Long id);
}
