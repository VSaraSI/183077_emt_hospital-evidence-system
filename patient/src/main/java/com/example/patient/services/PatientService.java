package com.example.patient.services;

import com.example.patient.domain.models.Patient;
import com.example.patient.domain.models.PatientId;
import com.example.patient.domain.valueobjects.DoctorId;
import com.example.patient.domain.valueobjects.NurseId;
import com.example.patient.services.form.PatientForm;

import java.util.List;

public interface PatientService {

    List<Patient> getAll();
    Patient findById(PatientId id);
    Patient addPatient(PatientForm form);
    void deletePatient(PatientId id);
    Patient changeDoctor(PatientId id, DoctorId newDoctor);
    Patient changeNurse(PatientId id, NurseId newNurse);
    Patient changeWard(PatientId id, String ward);

}
