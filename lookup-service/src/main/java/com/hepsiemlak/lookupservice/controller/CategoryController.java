package com.hepsiemlak.lookupservice.controller;

import com.hepsiemlak.lookupservice.model.Category;
import com.hepsiemlak.lookupservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Category request) {
        categoryService.create(request);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Category> update(@RequestBody Category request) {
        return new ResponseEntity<>(categoryService.update(request), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Category> getAttributeById(@PathVariable("id") String id) {
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFAttributeById(@PathVariable("id") String id) {
        categoryService.deleteById(id);
    }
}
