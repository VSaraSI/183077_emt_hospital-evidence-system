package com.example.shared_kernel.infra;

import com.example.shared_kernel.domain.events.DomainEvent;

public interface DomainEventPublisher{
    void publish(DomainEvent event);
}
