package com.hepsiemlak.packageservice.listener;

import com.hepsiemlak.packageservice.listener.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserCreatedEventListener {

    @RabbitListener(
            bindings = @QueueBinding(
                value = @Queue(value = "userQueue"),
                exchange = @Exchange(value = "user.service.events"),
                key = "user.service.userCreated"
            ),
            containerFactory = "rabbitListenerContainerFactory"
    )
    public void consumeUserCreated(Object user) {
        log.info("User created event received: {}", user);
    }
}
