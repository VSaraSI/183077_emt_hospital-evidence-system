package com.example.patient.services.impl;

import com.example.patient.domain.exceptions.PatientNotFoundException;
import com.example.patient.domain.models.Patient;
import com.example.patient.domain.models.PatientId;
import com.example.patient.domain.repository.PatientRepository;
import com.example.patient.domain.valueobjects.DoctorId;
import com.example.patient.domain.valueobjects.NurseId;
import com.example.patient.services.PatientService;
import com.example.patient.services.form.PatientForm;
import com.example.shared_kernel.domain.ward.Ward;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public <Optional>Patient findById(String id) {
        PatientId patientId=PatientId.convertByString(id);
        return patientRepository.findById(patientId).orElseThrow(PatientNotFoundException::new);
    }

    @Override
    public Patient addPatient(PatientForm form) {
        Patient patient=new Patient(form.getName(),
                form.getAddress(),
                form.getTelephone(),
                form.getWard(),
                form.getDoctorId(),
                form.getNurseId());
        patientRepository.save(patient);
        return patient;
    }

    @Override
    public void deletePatient(String id) {
        PatientId patientId=PatientId.convertByString(id);
        System.out.println(patientId);
        Patient patient=patientRepository.findById(patientId)
                .orElseThrow(PatientNotFoundException::new);
        patientRepository.deleteById(patientId);
    }

    @Override
    public Patient changeDoctorOrNurse(String id, PatientForm patientForm) {
        Patient patient=patientRepository.findById(PatientId.of(id))
                .orElseThrow(PatientNotFoundException::new);
        patient.changeDoctor(patientForm.getDoctorId());
        patient.changeNurse(patientForm.getNurseId());
        patientRepository.saveAndFlush(patient);
        return patient;
    }

    @Override
    public Patient changeWard(PatientId id, String ward) {
        Patient patient=patientRepository.findById(id)
                .orElseThrow(PatientNotFoundException::new);
        Ward ward1=new Ward(ward);
        patient.changeWard(ward1);
        patientRepository.saveAndFlush(patient);
        return patient;
    }

}
