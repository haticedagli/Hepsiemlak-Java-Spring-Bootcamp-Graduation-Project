package com.hepsiemlak.paymentservice.service.payment;

import com.hepsiemlak.paymentservice.model.PaymentRequest;

public class AkbankPaymentService implements IPaymentService{

    @Override
    public void makePayment(PaymentRequest paymentRequest) {
        LOGGER.info("Akbank payment service is making payment");
    }
}
