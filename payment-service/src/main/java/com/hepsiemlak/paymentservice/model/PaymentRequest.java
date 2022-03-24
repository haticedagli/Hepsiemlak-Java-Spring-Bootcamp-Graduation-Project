package com.hepsiemlak.paymentservice.model;

import lombok.Data;

@Data
public class PaymentRequest {
    private Long packageId;
    private Long userId;
    private Bank bank;
    private String cardNumber;
    private String cardHolderName;
    private String cardExpiryMonth;
    private String cardExpiryYear;
    private String cardCVV;
}
