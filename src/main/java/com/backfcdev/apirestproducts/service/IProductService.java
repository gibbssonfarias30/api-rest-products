package com.backfcdev.apirestproducts.service;

import com.backfcdev.apirestproducts.dto.ProductDTO;
import com.backfcdev.apirestproducts.model.Product;

import java.util.List;

public interface IProductService {
    List<ProductDTO> findAll();
    ProductDTO save(ProductDTO productDTO);
    ProductDTO findById(long id);
    ProductDTO update(long id, ProductDTO product);

    boolean delete(long id);
}
