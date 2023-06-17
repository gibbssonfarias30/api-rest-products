package com.backfcdev.apirestproducts.mappers;

import com.backfcdev.apirestproducts.dto.CategoryDTO;
import com.backfcdev.apirestproducts.dto.ProductDTO;
import com.backfcdev.apirestproducts.dto.ProductRequest;
import com.backfcdev.apirestproducts.model.Category;
import com.backfcdev.apirestproducts.model.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataMapper {
    
    private final ModelMapper mapper;
    
    public ProductDTO convertToDto(Product entity){
        return mapper.map(entity, ProductDTO.class);
    }

//    public Product convertToEntity(ProductDTO dto){
//        return mapper.map(dto, Product.class);
//    }

    public CategoryDTO convertToDto(Category entity){
        return mapper.map(entity, CategoryDTO.class);
    }

    public Category convertToEntity(CategoryDTO dto){
        return mapper.map(dto, Category.class);
    }

    public Product convertToEntity(ProductRequest product) {
        return mapper.map(product, Product.class);
    }
}