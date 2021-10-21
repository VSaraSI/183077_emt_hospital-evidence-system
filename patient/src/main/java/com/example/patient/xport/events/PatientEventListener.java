package com.example.patient.xport.events;

import com.example.patient.domain.models.PatientId;
import com.example.patient.services.PatientService;
import com.example.shared_kernel.domain.config.TopicHolder;
import com.example.shared_kernel.domain.events.DomainEvent;
import com.example.shared_kernel.domain.events.med_cartons.ChangeWard;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientEventListener {

    private final PatientService patientService;


    //listener koj biva kontaktiran dokolku vo med.karton nastane promena
    //na oddelenie na pacient, za koj vekje e kreiran med.karton

    @KafkaListener(topics= TopicHolder.TOPIC_CHANGE_WARD, groupId = "patient")
    public void consumeChangeWard(String jsonMessage) {
        try {
            ChangeWard event = DomainEvent.fromJson(jsonMessage,ChangeWard.class);
            patientService.changeWard(PatientId.of(event.getPatientId()), event.getWard());
        } catch (JsonProcessingException e){
        }

    }

}
