package com.hepsiemlak.notificationservice.controller;

import com.hepsiemlak.notificationservice.model.NotificationRequest;
import com.hepsiemlak.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void sendNotification(@RequestBody NotificationRequest request) {
        notificationService.sendNotification(request);
    }
}
