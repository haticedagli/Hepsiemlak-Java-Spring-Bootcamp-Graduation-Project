package com.hepsiemlak.lookupservice.repository;

import com.hepsiemlak.lookupservice.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
