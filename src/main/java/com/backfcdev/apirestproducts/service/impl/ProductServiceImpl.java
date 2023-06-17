package com.backfcdev.apirestproducts.service.impl;

import com.backfcdev.apirestproducts.exception.EntityNotFoundException;
import com.backfcdev.apirestproducts.model.Category;
import com.backfcdev.apirestproducts.model.Product;
import com.backfcdev.apirestproducts.repository.ICategoryRepository;
import com.backfcdev.apirestproducts.repository.IProductRepository;
import com.backfcdev.apirestproducts.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        Category category = categoryRepository.findById(product.getCategory().getId())
                .orElseThrow(EntityNotFoundException::new);

        Product productSaved = Product.builder()
                .name(product.getName())
                .price(product.getPrice())
                .amount(product.getAmount())
                .imageUrl(product.getImageUrl())
                .category(category)
                .build();
        return productRepository.save(productSaved);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Product update(Long id, Product product) {
        productRepository.findById(id).
                orElseThrow(EntityNotFoundException::new);
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.findById(id)
                        .orElseThrow(EntityNotFoundException::new);
        productRepository.deleteById(id);
    }
}
