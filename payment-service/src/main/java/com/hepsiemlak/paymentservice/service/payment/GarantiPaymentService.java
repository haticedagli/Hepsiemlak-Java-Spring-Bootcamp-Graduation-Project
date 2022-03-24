package com.hepsiemlak.paymentservice.service.payment;

import com.hepsiemlak.paymentservice.model.PaymentRequest;

public class GarantiPaymentService implements IPaymentService {
    @Override
    public void makePayment(PaymentRequest paymentRequest) {
        LOGGER.info("Garanti payment service is making payment");
    }
}
