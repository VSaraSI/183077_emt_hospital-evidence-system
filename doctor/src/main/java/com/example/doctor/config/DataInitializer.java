package com.example.doctor.config;

import com.example.doctor.domain.models.Doctor;
import com.example.doctor.domain.models.Qualification;
import com.example.doctor.domain.repository.DoctorRepository;
import com.example.shared_kernel.domain.ward.Ward;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;


@Component
public class DataInitializer {

    private final DoctorRepository doctorRepository;

    public DataInitializer(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    @PostConstruct
    public void initData() {
        Doctor doctor=Doctor.build("Riste Petreski",25000, Qualification.Surgeon,new Ward("hirurgija"));
        Doctor doctor1=Doctor.build("Hristina Kostova",23000, Qualification.Internist,new Ward("interno"));
        Doctor doctor2=Doctor.build("Nikola Poposki",31000, Qualification.Anesthesiologist,new Ward("anasteziologija"));
        Doctor doctor3=Doctor.build("Martina Mitreska",29000, Qualification.Pediatrician,new Ward("pedijatrija"));
        if (doctorRepository.findAll().isEmpty()) {
           doctorRepository.saveAll(Arrays.asList(doctor,doctor1,doctor2, doctor3));
        }
    }

}
