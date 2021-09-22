package com.example.patient.config;

import com.example.patient.domain.models.Patient;
import com.example.patient.domain.repository.PatientRepository;
import com.example.patient.domain.valueobjects.Doctor;
import com.example.patient.domain.valueobjects.Nurse;
import com.example.patient.domain.valueobjects.Qualification;
import com.example.shared_kernel.domain.ward.Ward;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final PatientRepository patientRepository;


    @PostConstruct
    public void initData() {
        Nurse nurse=new Nurse("Marija",12000,new Ward("hirurgija"));
        Doctor doctor=new Doctor("Riste",25000, Qualification.Surgeon,new Ward("hirurgija"));
        Patient patient1=new Patient(doctor.getId(),new Ward("hirurgija"),
                nurse.getId(), "Petko Petkoski","Skopje", "38974526784"
                );
        Nurse nurse1=new Nurse("Nikola",12000,new Ward("interno"));
        Doctor doctor1=new Doctor("Hristina",25000, Qualification.Internist,new Ward("interno"));
        Patient patient2=new Patient(doctor1.getId(),new Ward("interno"),
                nurse1.getId(),"Malina Petroska","Bitola", "389854123652");
        if (patientRepository.findAll().isEmpty()) {
            patientRepository.saveAll(Arrays.asList(patient1,patient2));
        }
    }


}
