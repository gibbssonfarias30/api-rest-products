package com.backfcdev.apirestproducts.service.impl;

import com.backfcdev.apirestproducts.exception.ProductNotFoundException;
import com.backfcdev.apirestproducts.model.Category;
import com.backfcdev.apirestproducts.repository.ICategoryRepository;
import com.backfcdev.apirestproducts.service.ICategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements ICategoryService {
    private final ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        if(categoryRepository.findAll().isEmpty()){
            // pronto excepciones personalizadas - NO FOUND
            throw new EntityNotFoundException();
        }
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

    }

    @Override
    public Category update(long id, Category category) {
        return categoryRepository.findById(id)
                .map(categoryUpdate -> {
                    categoryUpdate.setName(category.getName());
                    categoryUpdate.setDescription(category.getDescription());
                    return categoryRepository.save(categoryUpdate);
                }).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public boolean delete(long id) {
        Category category = categoryRepository.findById(id)
                        .orElseThrow(() -> new ProductNotFoundException(id));
        categoryRepository.delete(category);
        return true;
    }
}
