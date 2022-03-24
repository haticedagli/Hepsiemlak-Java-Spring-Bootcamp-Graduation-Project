package com.hepsiemlak.packageservice.repository;

import com.hepsiemlak.packageservice.model.domain.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, String> {
    Optional<Subscription> findByUserId(Long userId);
}
