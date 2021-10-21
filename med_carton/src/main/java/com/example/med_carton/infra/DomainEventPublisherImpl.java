package com.example.med_carton.infra;

import com.example.shared_kernel.domain.events.DomainEvent;
import com.example.shared_kernel.infra.DomainEventPublisher;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DomainEventPublisherImpl implements DomainEventPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;


    //metod so chija pomosh pravime publish (isprakjanje) na eventot koj se kreira vo
    // med.karton i istiot treba da bide slushnat od kafka listener vo Patient za da
    //nastanat soodvetnite promeni
    @Override
    public void publish(DomainEvent event) {
        this.kafkaTemplate.send(event.topic(),event.toJson());
    }
}
