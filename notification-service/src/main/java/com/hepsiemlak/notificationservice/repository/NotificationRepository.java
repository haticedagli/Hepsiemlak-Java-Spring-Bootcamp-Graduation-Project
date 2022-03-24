package com.hepsiemlak.notificationservice.repository;

import com.hepsiemlak.notificationservice.model.NotificationRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends MongoRepository<NotificationRequest, String> {
}
