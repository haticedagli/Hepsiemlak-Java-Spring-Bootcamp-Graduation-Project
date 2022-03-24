package com.hepsiemlak.notificationservice.messaging;

import com.hepsiemlak.notificationservice.model.NotificationRequest;
import com.hepsiemlak.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationListener {

    private final NotificationService notificationService;

    //@RabbitListener(queues = "${notification.queue}")
    public void receiveMessage(NotificationRequest request) {
        notificationService.sendNotification(request);
    }
}
