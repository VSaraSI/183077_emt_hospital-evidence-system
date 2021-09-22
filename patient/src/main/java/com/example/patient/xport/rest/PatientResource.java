package com.example.patient.xport.rest;

import com.example.patient.domain.models.Patient;
import com.example.patient.services.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/patient")
@AllArgsConstructor
public class PatientResource {

    private final PatientService patientService;

    @GetMapping
    public List<Patient> getAll() {
        return patientService.getAll();
    }

}
