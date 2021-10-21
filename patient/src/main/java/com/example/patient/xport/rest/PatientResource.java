package com.example.patient.xport.rest;

import com.example.patient.domain.models.Patient;
import com.example.patient.domain.valueobjects.Doctor;
import com.example.patient.domain.valueobjects.Nurse;
import com.example.patient.services.PatientService;
import com.example.patient.services.form.PatientForm;
import com.example.patient.xport.client.DoctorClient;
import com.example.patient.xport.client.NurseClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/patient")
public class PatientResource {

    private final PatientService patientService;
    private final DoctorClient doctorClient;
    private final NurseClient nurseClient;

    public PatientResource(PatientService patientService, DoctorClient doctorClient, NurseClient nurseClient) {
        this.patientService = patientService;
        this.doctorClient = doctorClient;
        this.nurseClient = nurseClient;
    }

    @GetMapping
    public List<Patient> getAll() {
        return patientService.getAll();
    }

    @PostMapping("/add")
    public void save(@RequestBody PatientForm patientForm) {
        Patient pa=this.patientService.addPatient(patientForm);
    }

    @GetMapping("/doctors")
    public List<Doctor> findAllDoctors(){
        return doctorClient.findAll();
    }

    @GetMapping("/nurses")
    public List<Nurse> findAllNurses(){
        return nurseClient.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) {
        this.patientService.deletePatient(id);
    }

    @PutMapping("/changeDoctorOrNurse/{id}")
    public void changeDoctor(@PathVariable String id, @RequestBody PatientForm patientForm) {
        this.patientService.changeDoctorOrNurse(id,patientForm);
    }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable String id){
        return this.patientService.findById(id);
    }

}
