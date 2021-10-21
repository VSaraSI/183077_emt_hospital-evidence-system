package com.example.nurse.xport.rest;

import com.example.nurse.domain.models.Nurse;
import com.example.nurse.services.NurseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nurse")
public class NurseResource {

    private final NurseService nurseService;

    public NurseResource(NurseService nurseService) {
        this.nurseService = nurseService;
    }

    //ovoj mapping go koristime samo za da izvleceme podatoci koi ke ni se potrebni
    //  za entitetot Patient odnosno lista na postoecki med.sestri vo baza

    @GetMapping
    public List<Nurse> getAll() {
        return nurseService.getAll();
    }

}