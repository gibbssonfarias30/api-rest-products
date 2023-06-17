package com.backfcdev.apirestproducts.service;

import com.backfcdev.apirestproducts.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category save(Category category);
    Category findById(Long id);
    Category update(Long id, Category category);
    void delete(Long id);
}
