package com.hepsiemlak.notificationservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class NotificationRequest {
    @Id
    private String id;
    private String to;
    private String subject;
    private String text;
    private NotificationType type;
}
