package com.hepsiemlak.packageservice.controller;

import com.hepsiemlak.packageservice.model.SubscriptionRequest;
import com.hepsiemlak.packageservice.model.domain.Subscription;
import com.hepsiemlak.packageservice.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscription")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping("/subscribe")
    @ResponseStatus(HttpStatus.OK)
    public void subscribe(@RequestBody SubscriptionRequest request) {
        subscriptionService.subscribe(request);
    }

    @PostMapping("/unsubscribe/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void unsubscribe(@PathVariable("userId") Long userId) {
        subscriptionService.unsubscribe(userId);
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Subscription> getSubscription(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(subscriptionService.getSubscription(userId), HttpStatus.OK);
    }

}
