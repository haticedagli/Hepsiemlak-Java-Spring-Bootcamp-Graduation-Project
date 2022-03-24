package com.hepsiemlak.paymentservice.service.payment;

import com.hepsiemlak.paymentservice.model.PaymentRequest;

public class YapıKrediPaymentService implements IPaymentService {
    @Override
    public void makePayment(PaymentRequest paymentRequest) {
        LOGGER.info("Yapı Kredi Payment Servisinden ödeme yapıldı");
    }
}
