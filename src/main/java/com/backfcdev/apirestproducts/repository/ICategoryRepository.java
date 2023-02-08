package com.backfcdev.apirestproducts.repository;

import com.backfcdev.apirestproducts.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
