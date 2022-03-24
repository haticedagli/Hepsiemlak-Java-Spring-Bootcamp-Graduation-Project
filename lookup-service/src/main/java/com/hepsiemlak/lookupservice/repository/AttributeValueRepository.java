package com.hepsiemlak.lookupservice.repository;

import com.hepsiemlak.lookupservice.model.AttributeValue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeValueRepository extends MongoRepository<AttributeValue, String> {
}
