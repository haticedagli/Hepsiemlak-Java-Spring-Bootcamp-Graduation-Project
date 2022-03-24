package com.hepsiemlak.paymentservice.service;

import com.hepsiemlak.paymentservice.model.Bank;
import com.hepsiemlak.paymentservice.service.payment.*;

public class PaymentServiceFactory {

    public IPaymentService getPaymentService(Bank bank) {
        IPaymentService service = null;
        switch (bank) {
            case AKBANK:
                service = new AkbankPaymentService();
                break;
            case GARANTİ:
                service = new GarantiPaymentService();
                break;
            case İŞ_BANKASI:
                service = new İşBankasıPaymentService();
                break;
            case YAPI_KREDİ:
                service = new YapıKrediPaymentService();
                break;
            case ZİRAAT:
                service = new ZiraatPaymentService();
                break;
        }
        return service;
    }
}
