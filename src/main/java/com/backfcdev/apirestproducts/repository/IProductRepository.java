package com.backfcdev.apirestproducts.repository;

import com.backfcdev.apirestproducts.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
