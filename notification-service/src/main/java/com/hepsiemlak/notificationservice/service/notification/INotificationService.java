package com.hepsiemlak.notificationservice.service.notification;

import com.hepsiemlak.notificationservice.model.NotificationRequest;

public interface INotificationService {
    void sendNotification(NotificationRequest notificationRequest);
}
