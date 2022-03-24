package com.hepsiemlak.userservice.model.event;

import lombok.Getter;

@Getter
public enum EventRoutingKeys {
    USER_CREATED("user.service.userCreated"),
    USER_DELETED("user.service.userDeleted"),
    ;

    private final String routingKey;

    EventRoutingKeys(final String routingKey) {
        this.routingKey = routingKey;
    }
}
