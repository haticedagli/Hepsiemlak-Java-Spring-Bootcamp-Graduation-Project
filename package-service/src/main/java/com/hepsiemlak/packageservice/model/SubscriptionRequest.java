package com.hepsiemlak.packageservice.model;

import lombok.Data;

@Data
public class SubscriptionRequest {
    private Long userId;
    private String packageId;
}
