package com.hepsiemlak.userservice.model.event;

public class UserCreatedEvent implements DomainEvent{
    @Override
    public String getEventType() {
        return EventRoutingKeys.USER_CREATED.getRoutingKey();
    }
}
