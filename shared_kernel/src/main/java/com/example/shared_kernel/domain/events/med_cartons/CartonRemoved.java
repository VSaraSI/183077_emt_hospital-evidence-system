package com.example.shared_kernel.domain.events.med_cartons;

import com.example.shared_kernel.domain.config.TopicHolder;
import com.example.shared_kernel.domain.events.DomainEvent;
import lombok.Getter;

@Getter
public class CartonRemoved extends DomainEvent {

    private String patientId;
    private String ward;

    public CartonRemoved(String topic) {
        super(TopicHolder.TOPIC_CARTON_REMOVED);
    }

    public CartonRemoved(String patientId,String ward) {
        super(TopicHolder.TOPIC_CARTON_REMOVED);
        this.patientId =patientId;
        this.ward=ward;
    }
}
