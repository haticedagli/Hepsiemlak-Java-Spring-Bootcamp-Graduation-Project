package com.hepsiemlak.userservice.model.event;

public class UserDeletedEvent implements DomainEvent {
    @Override
    public String getEventType() {
        return EventRoutingKeys.USER_DELETED.getRoutingKey();
    }
}
