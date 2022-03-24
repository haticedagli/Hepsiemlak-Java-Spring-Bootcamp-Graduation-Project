package com.hepsiemlak.packageservice.service;

import com.hepsiemlak.packageservice.exception.NotFoundException;
import com.hepsiemlak.packageservice.model.SubscriptionRequest;
import com.hepsiemlak.packageservice.model.SubscriptionStatus;
import com.hepsiemlak.packageservice.model.domain.Subscription;
import com.hepsiemlak.packageservice.repository.PackageRepository;
import com.hepsiemlak.packageservice.model.domain.Package;
import com.hepsiemlak.packageservice.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final PackageRepository packageRepository;

    public void subscribe(SubscriptionRequest request) {
        Subscription subscription = subscriptionRepository.findByUserId(request.getUserId())
                .orElse(new Subscription());
        subscription.setUserId(request.getUserId());
        subscription.setPackageId(request.getPackageId());
        Package packageToSubscribe = packageRepository.findById(request.getPackageId())
                .orElseThrow(() -> new NotFoundException("Package not found"));
        LocalDateTime now = LocalDateTime.now();
        subscription.setStartDate(now);
        subscription.setEndDate(now.plusMonths(packageToSubscribe.getAvailableMountCount()));
        subscription.setStatus(SubscriptionStatus.INACTIVE);
        subscriptionRepository.save(subscription);
    }

    public void unsubscribe(Long userId) {
        Subscription subscription = subscriptionRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("Subscription not found"));
        subscriptionRepository.delete(subscription);
    }

    public Subscription getSubscription(Long userId) {
        return subscriptionRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("Subscription not found"));
    }
}
