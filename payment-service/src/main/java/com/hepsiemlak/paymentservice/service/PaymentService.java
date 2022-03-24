package com.hepsiemlak.paymentservice.service;

import com.hepsiemlak.paymentservice.exception.BadRequestException;
import com.hepsiemlak.paymentservice.model.Bank;
import com.hepsiemlak.paymentservice.model.BankDto;
import com.hepsiemlak.paymentservice.model.Payment;
import com.hepsiemlak.paymentservice.model.PaymentRequest;
import com.hepsiemlak.paymentservice.repository.PaymentRepository;
import com.hepsiemlak.paymentservice.service.payment.IPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    public final PaymentServiceFactory factory = new PaymentServiceFactory();

    public void makePayment(PaymentRequest paymentRequest) {
        validatePaymentRequest(paymentRequest);
        IPaymentService paymentService = factory.getPaymentService(paymentRequest.getBank());
        paymentService.makePayment(paymentRequest);
        paymentRepository.save(getPayment(paymentRequest));
    }

    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }

    public List<BankDto> getAvailableBanks() {
        return Arrays.stream(Bank.values()).map(
                bank -> new BankDto(bank.name(), bank.bankName)
        ).collect(Collectors.toList());
    }

    private Payment getPayment(PaymentRequest paymentRequest) {
        Payment payment = new Payment();
        payment.setPackageId(paymentRequest.getPackageId());
        payment.setUserId(paymentRequest.getUserId());
        payment.setCreatedAt(Instant.now());
        return payment;
    }

    private void validatePaymentRequest(PaymentRequest paymentRequest) {
        if (paymentRequest.getPackageId() == null) {
            throw new BadRequestException("Package id cannot be null");
        }
        if (paymentRequest.getUserId() == null) {
            throw new BadRequestException("User id cannot be null");
        }
        if (paymentRequest.getBank() == null) {
            throw new BadRequestException("Bank cannot be null");
        }
        if (paymentRequest.getCardNumber() == null) {
            throw new BadRequestException("Card number cannot be null");
        }
        if (paymentRequest.getCardHolderName() == null) {
            throw new BadRequestException("Card holder name cannot be null");
        }
        if (paymentRequest.getCardExpiryMonth() == null) {
            throw new BadRequestException("Expiry month cannot be null");
        }
        if (paymentRequest.getCardExpiryYear() == null) {
            throw new BadRequestException("Expiry year cannot be null");
        }
        if (paymentRequest.getCardCVV() == null) {
            throw new BadRequestException("Card cvv cannot be null");
        }
    }
}