package com.backfcdev.apirestproducts.controller;

import com.backfcdev.apirestproducts.dto.ProductDTO;
import com.backfcdev.apirestproducts.dto.ProductRequest;
import com.backfcdev.apirestproducts.mappers.DataMapper;
import com.backfcdev.apirestproducts.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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



    @Operation(summary = "Get all products", description = "Provides the operation to return a list of all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @GetMapping
    ResponseEntity<List<ProductDTO>> findAll(){
        return ResponseEntity.ok(productService.findAll()
                .stream()
                .map(mapper::convertToDto)
                .toList());
    }


    @Operation(summary = "Create a new product", description = "Provides the operation to create a new Product from a ProductRequest and returns the created object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @PostMapping
    ResponseEntity<ProductDTO> save(@RequestBody ProductRequest product){
        return ResponseEntity.status(CREATED)
                .body(mapper.convertToDto(productService.save(mapper.convertToEntity(product))));
    }


    @Operation(summary = "Get product by ID", description = "Provides a mechanism to get all the data of a product by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    @GetMapping("/{id}")
    ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(mapper.convertToDto(productService.findById(id)));
    }


    @Operation(summary = "Update an existing product", description = "Provides a mechanism to update an existing product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @PutMapping("/{id}")
    ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductRequest product){
        return ResponseEntity.ok(mapper.convertToDto(productService.update(id, mapper.convertToEntity(product))));
    }


    @Operation(summary = "Delete an existing product", description = "Provides a mechanism to remove a product by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
