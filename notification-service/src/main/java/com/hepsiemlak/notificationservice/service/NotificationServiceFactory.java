package com.hepsiemlak.notificationservice.service;

import com.hepsiemlak.notificationservice.config.EmailConfig;
import com.hepsiemlak.notificationservice.model.NotificationType;
import com.hepsiemlak.notificationservice.service.notification.INotificationService;
import com.hepsiemlak.notificationservice.service.notification.MailService;
import com.hepsiemlak.notificationservice.service.notification.PushNotificationService;
import com.hepsiemlak.notificationservice.service.notification.SlackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceFactory {

    private final EmailConfig emailConfig;

    public INotificationService getNotificationService(NotificationType notificationType) {
        switch (notificationType) {
            case SLACK:
                return new SlackService();
            case MAIL:
                return new MailService(emailConfig);
            case PUSH_NOTIFICATION:
                return new PushNotificationService();
            default:
                return null;
        }
    }
}
