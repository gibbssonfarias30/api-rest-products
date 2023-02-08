package com.backfcdev.apirestproducts.service;

import com.backfcdev.apirestproducts.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category save(Category category);
    Category findById(long id);
    Category update(long id, Category product);

    boolean delete(long id);
}
