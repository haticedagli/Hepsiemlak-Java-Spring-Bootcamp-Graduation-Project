package com.hepsiemlak.userservice.service;

import com.hepsiemlak.userservice.model.User;
import com.hepsiemlak.userservice.model.event.DomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MqNotifyService {

    @Value("${mq.producer.user.exchange}")
    private String userExchange;
    private final RabbitTemplate rabbitTemplate;

    public void notifyUser(User user, DomainEvent event) {
        rabbitTemplate.convertAndSend(userExchange, event.getEventType(), user,
                message -> {
                    message.getMessageProperties().setHeader("X-Type", event.getEventType());
                    return message;
                });
    }
}
