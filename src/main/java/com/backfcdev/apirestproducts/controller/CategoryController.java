package com.backfcdev.apirestproducts.controller;

import com.backfcdev.apirestproducts.dto.CategoryDTO;
import com.backfcdev.apirestproducts.mappers.DataMapper;
import com.backfcdev.apirestproducts.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final ICategoryService categoryService;
    private final DataMapper mapper;


    @GetMapping
    ResponseEntity<List<CategoryDTO>> findAll(){
        return ResponseEntity.ok(categoryService.findAll()
                .stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList()));
    }

    @PostMapping
    ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO category){
        return ResponseEntity.status(CREATED)
                .body(mapper.convertToDto(categoryService.save(mapper.convertToEntity(category))));
    }

    @GetMapping("/{id}")
    ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(mapper.convertToDto(categoryService.findById(id)));
    }

    @PutMapping("/{id}")
    ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO category){
        return ResponseEntity.ok(mapper.convertToDto(categoryService.update(id, mapper.convertToEntity(category))));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
