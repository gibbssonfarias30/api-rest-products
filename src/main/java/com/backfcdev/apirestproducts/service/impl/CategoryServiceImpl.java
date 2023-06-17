package com.backfcdev.apirestproducts.service.impl;

import com.backfcdev.apirestproducts.exception.EntityNotFoundException;
import com.backfcdev.apirestproducts.model.Category;
import com.backfcdev.apirestproducts.repository.ICategoryRepository;
import com.backfcdev.apirestproducts.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements ICategoryService {
    private final ICategoryRepository categoryRepository;


    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Category update(Long id, Category category) {
        categoryRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.findById(id)
                        .orElseThrow(EntityNotFoundException::new);
        categoryRepository.deleteById(id);
    }
}
