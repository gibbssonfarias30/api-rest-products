package com.backfcdev.apirestproducts.controller;

import com.backfcdev.apirestproducts.dto.ProductDTO;
import com.backfcdev.apirestproducts.model.Product;
import com.backfcdev.apirestproducts.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final IProductService productService;

    @GetMapping
    ResponseEntity<List<ProductDTO>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping
    ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO){
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.save(productDTO));
    }

    @GetMapping("/{id}")
    ResponseEntity<ProductDTO> findById(@PathVariable long id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<ProductDTO> update(@PathVariable long id, @RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(productService.update(id, productDTO));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> delete(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(productService.delete(id));
    }
}
