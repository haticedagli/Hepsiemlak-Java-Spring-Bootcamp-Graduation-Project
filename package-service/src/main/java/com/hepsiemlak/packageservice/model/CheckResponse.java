package com.hepsiemlak.packageservice.model;

import lombok.Data;

@Data
public class CheckResponse {
    private Integer limit;
    private Integer remaining;
    private VerifyStatus status;
}
