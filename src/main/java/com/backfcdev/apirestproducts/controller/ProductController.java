package com.backfcdev.apirestproducts.controller;

import com.backfcdev.apirestproducts.dto.ProductDTO;
import com.backfcdev.apirestproducts.dto.ProductRequest;
import com.backfcdev.apirestproducts.mappers.DataMapper;
import com.backfcdev.apirestproducts.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final IProductService productService;
    private final DataMapper mapper;


    @GetMapping
    ResponseEntity<List<ProductDTO>> findAll(){
        return ResponseEntity.ok(productService.findAll()
                .stream()
                .map(mapper::convertToDto)
                .toList());
    }

    @PostMapping
    ResponseEntity<ProductDTO> save(@RequestBody ProductRequest product){
        return ResponseEntity.status(CREATED)
                .body(mapper.convertToDto(productService.save(mapper.convertToEntity(product))));
    }

    @GetMapping("/{id}")
    ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(mapper.convertToDto(productService.findById(id)));
    }

    @PutMapping("/{id}")
    ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductRequest product){
        return ResponseEntity.ok(mapper.convertToDto(productService.update(id, mapper.convertToEntity(product))));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
