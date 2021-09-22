package com.example.patient.xport.events;

import com.example.patient.domain.models.PatientId;
import com.example.patient.services.PatientService;
import com.example.shared_kernel.domain.config.TopicHolder;
import com.example.shared_kernel.domain.events.DomainEvent;
import com.example.shared_kernel.domain.events.med_cartons.CartonRemoved;
import com.example.shared_kernel.domain.events.med_cartons.ChangeWard;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientEventListener {

    private final PatientService patientService;

    //listener koj biva kontaktiran dokolku vo med.karton nastane promena
    //na oddelenie na pacientot za istiot da se prefrli tamu
    @KafkaListener(topics= TopicHolder.TOPIC_CHANGE_WARD, groupId = "patient")
    public void consumeChangeWard(String jsonMessage) {
        try {
            ChangeWard event = DomainEvent.fromJson(jsonMessage,ChangeWard.class);
            patientService.changeWard(PatientId.of(event.getPatientId()), event.getWard());
        } catch (Exception e){

        }

    }

    //listener preku koj pacientot dobiva izvestuvanje dokolku med.karton se arhivira-brishe
    //i na toj nacin toj e sloboden odnosno se brise od baza na pacienti
    @KafkaListener(topics= TopicHolder.TOPIC_CARTON_REMOVED, groupId = "patient")
    public void consumeRemovedCarton(String jsonMessage) {
        try {
            CartonRemoved event = DomainEvent.fromJson(jsonMessage,CartonRemoved.class);
            patientService.deletePatient(PatientId.of(event.getPatientId()));
        } catch (Exception e){

        }

    }
}
