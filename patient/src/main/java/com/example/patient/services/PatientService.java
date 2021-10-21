package com.example.patient.services;

import com.example.patient.domain.models.Patient;
import com.example.patient.domain.models.PatientId;
import com.example.patient.domain.valueobjects.DoctorId;
import com.example.patient.domain.valueobjects.NurseId;
import com.example.patient.services.form.PatientForm;

import java.util.List;

public interface PatientService {

    //metodi za listanje na site pacienti, pronaogjanje na odreden pacient,
    //dodavanje i brishenje
    List<Patient> getAll();
    <Optional>Patient findById(String id);
    <Optional>Patient addPatient(PatientForm form);
    void deletePatient(String id);

    //ovie metodi se koristat za promena na doktor i/ili sestra i promena na oddelenie
    //na vekje postoecki pacient vo baza
    Patient changeDoctorOrNurse(String id, PatientForm patientForm);
    Patient changeWard(PatientId id, String ward);

}
