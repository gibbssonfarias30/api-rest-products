package com.backfcdev.apirestproducts.dto.converter;

import com.backfcdev.apirestproducts.dto.ProductDTO;
import com.backfcdev.apirestproducts.model.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ConvertToDtoOrEntity {
    private final ModelMapper mapper;

    public ProductDTO convertToDto(Product dto){
        return mapper.map(dto, ProductDTO.class);
    }
    public Product convertToEntity(ProductDTO entity){
        return mapper.map(entity, Product.class);
    }
}
