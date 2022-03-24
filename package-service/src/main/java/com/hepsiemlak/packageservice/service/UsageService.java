package com.hepsiemlak.packageservice.service;

import com.hepsiemlak.packageservice.exception.BadRequestException;
import com.hepsiemlak.packageservice.model.CheckRequest;
import com.hepsiemlak.packageservice.model.CheckResponse;
import com.hepsiemlak.packageservice.model.IncrementRequest;
import com.hepsiemlak.packageservice.model.VerifyStatus;
import com.hepsiemlak.packageservice.model.domain.Subscription;
import com.hepsiemlak.packageservice.model.domain.Usage;
import com.hepsiemlak.packageservice.repository.PackageRepository;
import com.hepsiemlak.packageservice.repository.SubscriptionRepository;
import com.hepsiemlak.packageservice.repository.UsageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import com.hepsiemlak.packageservice.model.domain.Package;

@Service
@RequiredArgsConstructor
public class UsageService {

    private final UsageRepository usageRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final PackageRepository packageRepository;

    public void increment(IncrementRequest request) {
        Usage usage = usageRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> new BadRequestException("Usage not found"));
        usage.setCount(usage.getCount() + request.getCount());
        usageRepository.save(usage);
    }

    public CheckResponse check(CheckRequest request) {
        Subscription subscription = subscriptionRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> new BadRequestException("Subscription not found"));

        if(LocalDateTime.now().isAfter(subscription.getEndDate())) {
            throw new BadRequestException("Subscription expired");
        }

        Usage usage = usageRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> new BadRequestException("Usage not found"));

        Package packageInfo = packageRepository.findById(subscription.getPackageId())
                .orElseThrow(() -> new BadRequestException("Package not found"));

        CheckResponse response = new CheckResponse();
        response.setLimit(packageInfo.getAdvertCount());
        response.setRemaining(packageInfo.getAdvertCount() - usage.getCount());

        if(usage.getCount() + request.getValue() > packageInfo.getAdvertCount()) {
            response.setStatus(VerifyStatus.LIMIT_EXCEEDED);
        } else {
            response.setStatus(VerifyStatus.LIMIT_AVAILABLE);
        }

        return response;
    }
}
