package com.hepsiemlak.lookupservice.repository;

import com.hepsiemlak.lookupservice.model.Attribute;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends MongoRepository<Attribute, String> {
}
