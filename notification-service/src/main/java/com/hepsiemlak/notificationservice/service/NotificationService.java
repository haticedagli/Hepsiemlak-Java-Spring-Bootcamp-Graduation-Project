package com.hepsiemlak.notificationservice.service;

import com.hepsiemlak.notificationservice.model.NotificationRequest;
import com.hepsiemlak.notificationservice.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationServiceFactory notificationServiceFactory;

    public void sendNotification(NotificationRequest request) {
        notificationServiceFactory.getNotificationService(request.getType())
                .sendNotification(request);

        notificationRepository.save(request);
    }

}
