package com.example.doctor.xport.rest;

import com.example.doctor.domain.models.Doctor;
import com.example.doctor.services.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorResource {

    private final DoctorService doctorService;

    public DoctorResource(DoctorService doctorService) {
        this.doctorService=doctorService;
    }


    //ovoj mapping go koristime samo za da izvleceme podatoci koi ke ni se potrebni
    //  za entitetot Patient

    @GetMapping
    public List<Doctor> getAll() {
        return doctorService.getAll();
    }

}
