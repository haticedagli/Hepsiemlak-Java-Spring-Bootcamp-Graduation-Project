package com.hepsiemlak.paymentservice.service.payment;

import com.hepsiemlak.paymentservice.model.PaymentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface IPaymentService {

    Logger LOGGER = LoggerFactory.getLogger(IPaymentService.class);
    void makePayment(PaymentRequest paymentRequest);
}
