package com.hepsiemlak.paymentservice.service.payment;

import com.hepsiemlak.paymentservice.model.PaymentRequest;

public class İşBankasıPaymentService implements IPaymentService {
    @Override
    public void makePayment(PaymentRequest paymentRequest) {
        LOGGER.info("İş bankası ödeme yapılıyor");
    }
}
