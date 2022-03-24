package com.hepsiemlak.packageservice.model;

import lombok.Data;

@Data
public class IncrementRequest {
    private Long userId;
    private Integer count;
}
