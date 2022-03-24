package com.hepsiemlak.paymentservice.service.payment;

import com.hepsiemlak.paymentservice.model.PaymentRequest;

public class ZiraatPaymentService implements IPaymentService {
    @Override
    public void makePayment(PaymentRequest paymentRequest) {
        LOGGER.info("Ziraat Payment Service");
    }
}
