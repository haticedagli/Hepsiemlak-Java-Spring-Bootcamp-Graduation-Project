package com.hepsiemlak.packageservice.model;

import lombok.Data;

@Data
public class CheckRequest {
    private Long userId;
    private Integer value;
}
