package com.hepsiemlak.lookupservice.service;

import com.hepsiemlak.lookupservice.exception.BadRequestException;
import com.hepsiemlak.lookupservice.exception.NotFoundException;
import com.hepsiemlak.lookupservice.model.Category;
import com.hepsiemlak.lookupservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public void create(Category categoryRequest) {
        if(categoryRequest.getId() != null) throw new BadRequestException("Category id must be null");
        categoryRepository.save(categoryRequest);
    }

    public Category findById(String id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found"));
    }

    public void deleteById(String id) {
        categoryRepository.deleteById(id);
    }

    public Category update(Category categoryRequest) {
        if (!categoryRepository.existsById(categoryRequest.getId())) {
            throw new NotFoundException("Category not found");
        }
        return categoryRepository.save(categoryRequest);
    }
}
