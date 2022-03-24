package com.hepsiemlak.packageservice.repository;

import com.hepsiemlak.packageservice.model.domain.Usage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsageRepository extends MongoRepository<Usage, String> {
    Optional<Usage> findByUserId(Long userId);
}
