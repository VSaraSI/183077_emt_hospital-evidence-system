package com.example.med_carton.xport.rest;

import com.example.med_carton.domain.Med_carton;
import com.example.med_carton.domain.exceptions.Med_cartonNotFound;
import com.example.med_carton.domain.exceptions.PatientNotExist;
import com.example.med_carton.domain.valueobjects.Patient;
import com.example.med_carton.services.Med_CartonService;
import com.example.med_carton.services.form.Med_cartonForm;
import com.example.med_carton.xport.client.PatientClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/api")
public class CartonRestController {

    private final Med_CartonService cartonService;
    private final PatientClient patientClient;

    public CartonRestController(Med_CartonService cartonService, PatientClient patientClient) {
        this.cartonService = cartonService;
        this.patientClient = patientClient;
    }


    @GetMapping("/carton")
    public List<Med_carton> getAll(){
        return  this.cartonService.getAll();
    }

    @GetMapping("/carton/{id}")
    public Med_carton findCartonById(@PathVariable String id) throws Exception {
        return this.cartonService.findById(id);
    }

    @GetMapping("/carton/patients")
    public List<Patient> findAllPatients(){
        return patientClient.findAll();
    }

    @PostMapping("/carton/add")
    public void addCarton(@RequestBody Med_cartonForm cartonForm) {
       Med_carton m=this.cartonService.addMedCarton(cartonForm);
    }

    @DeleteMapping("/carton/delete/{id}")
    public void deleteCarton(@PathVariable String id) throws Exception {
        this.cartonService.deleteMedCarton(id);
    }

    @PutMapping("/carton/edit/{id}")
    public void updateCarton(@PathVariable String id, @RequestBody Med_cartonForm cartonForm) {
        this.cartonService.updateMedCarton(id,cartonForm );
    }


}
