package com.hepsiemlak.paymentservice.controller;

import com.hepsiemlak.paymentservice.model.BankDto;
import com.hepsiemlak.paymentservice.model.Payment;
import com.hepsiemlak.paymentservice.model.PaymentRequest;
import com.hepsiemlak.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void makePayment(@RequestBody PaymentRequest paymentRequest) {
        paymentService.makePayment(paymentRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Payment>> getPayments() {
        return new ResponseEntity<>(paymentService.getPayments(), HttpStatus.OK);
    }

    @GetMapping("/bank")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BankDto>> getAvailableBanks() {
        return new ResponseEntity<>(paymentService.getAvailableBanks(), HttpStatus.OK);
    }
}
