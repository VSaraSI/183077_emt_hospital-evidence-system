package com.example.shared_kernel.domain.events.med_cartons;

import com.example.shared_kernel.domain.config.TopicHolder;
import com.example.shared_kernel.domain.events.DomainEvent;
import lombok.Getter;

@Getter
public class ChangeWard extends DomainEvent {

    private String patientId;
    private String ward;

    public ChangeWard()
    {
        super();
    }

    public ChangeWard(String topic) {
        super(TopicHolder.TOPIC_CHANGE_WARD);
    }

    public ChangeWard(String patientId, String ward) {
        super(TopicHolder.TOPIC_CHANGE_WARD);
        this.patientId = patientId;
        this.ward = ward;
    }
}
