package com.hepsiemlak.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankDto {
    private String name;
    private String code;
}