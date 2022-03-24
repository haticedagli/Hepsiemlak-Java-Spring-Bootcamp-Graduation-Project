package com.hepsiemlak.packageservice.model.domain;

import com.hepsiemlak.packageservice.model.SubscriptionStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Subscription {
    @Id
    private String id;
    private String packageId;
    private Long userId;
    private SubscriptionStatus status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
