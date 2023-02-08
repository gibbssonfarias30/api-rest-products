package com.backfcdev.apirestproducts.service.impl;

import com.backfcdev.apirestproducts.dto.ProductDTO;
import com.backfcdev.apirestproducts.dto.converter.ConvertToDtoOrEntity;
import com.backfcdev.apirestproducts.exception.ProductNotFoundException;
import com.backfcdev.apirestproducts.model.Product;
import com.backfcdev.apirestproducts.repository.IProductRepository;
import com.backfcdev.apirestproducts.service.IProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository;
    private final ConvertToDtoOrEntity convertDtoAndEntity;

    @Override
    public List<ProductDTO> findAll() {
        if(productRepository.findAll().isEmpty()){
            // pronto excepciones personalizadas - NO FOUND
            throw new EntityNotFoundException();
        }
        return productRepository.findAll().stream()
                .map(convertDtoAndEntity::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = convertDtoAndEntity.convertToEntity(productDTO);
        return convertDtoAndEntity.convertToDto(productRepository.save(product));
    }

    @Override
    public ProductDTO findById(long id) {
        return productRepository.findById(id)
                .map(product -> convertDtoAndEntity.convertToDto(product))
                .orElseThrow(() -> new ProductNotFoundException(id));

    }

    @Override
    public ProductDTO update(long id, ProductDTO productDTO) {
        return productRepository.findById(id)
                .map(productUpdate -> {
                    productUpdate.setName(productDTO.getName());
                    productUpdate.setPrice(productDTO.getPrice());
                    productUpdate.setAmount(productDTO.getAmount());
                    productUpdate.setImageUrl(productDTO.getImageUrl());
                    productUpdate.setCategory(productDTO.getCategory());
                    return convertDtoAndEntity.convertToDto(productRepository.save(productUpdate));
                }).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public boolean delete(long id) {
        Product product = productRepository.findById(id)
                        .orElseThrow(() -> new ProductNotFoundException(id));
        productRepository.delete(product);
        return true;
    }
}
