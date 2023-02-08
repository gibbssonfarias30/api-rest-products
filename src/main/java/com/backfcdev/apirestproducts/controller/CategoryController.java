package com.backfcdev.apirestproducts.controller;

import com.backfcdev.apirestproducts.model.Category;
import com.backfcdev.apirestproducts.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping
    ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PostMapping
    ResponseEntity<Category> save(@RequestBody Category category){
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryService.save(category));
    }

    @GetMapping("/{id}")
    ResponseEntity<Category> findById(@PathVariable long id){
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<Category> update(@PathVariable long id, @RequestBody Category category){
        return ResponseEntity.ok(categoryService.update(id, category));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> delete(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(categoryService.delete(id));
    }
}
