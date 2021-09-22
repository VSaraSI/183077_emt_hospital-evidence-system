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
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    //metod za vlecenje na site pacienti
    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }



    @Override
    public Patient findById(PatientId id) {
        return patientRepository.findById(id)
                .orElseThrow(PatientNotFoundException::new);
    }


    //metod za dodavanje na pacient
    @Override
    public Patient addPatient(PatientForm form) {
        Patient patient=Patient.build(form.getName(),form.getAddress(),form.getTeleph_num(),form.getWard(),
                form.getDoctor().getId(),form.getNurse().getId());
        patientRepository.save(patient);
        return patient;
    }

    //metod za brishenje na pacient
    @Override
    public void deletePatient(PatientId id) {
        Patient patient=patientRepository.findById(id)
                .orElseThrow(PatientNotFoundException::new);
        patientRepository.deleteById(id);
    }

    //metod za promena na doktor na daden pacient
    @Override
    public Patient changeDoctor(PatientId id, DoctorId newDoctor) {
        Patient patient=patientRepository.findById(id)
                .orElseThrow(PatientNotFoundException::new);
        Patient patient1=
                Patient.build(patient.getName(),
                        patient.getAddress(),
                        patient.getTeleph_num(),
                        patient.getWard(),
                        newDoctor, patient.getNurseId());
        patientRepository.deleteById(patient.getId());
        patientRepository.save(patient1);
        return patient1;
    }

    //metod za promena na med.sestra na odreden pacient
    @Override
    public Patient changeNurse(PatientId id, NurseId newNurse) {
        Patient patient=patientRepository.findById(id)
                .orElseThrow(PatientNotFoundException::new);
        Patient patient1=
                Patient.build(patient.getName(),
                        patient.getAddress(),
                        patient.getTeleph_num(),
                        patient.getWard(),
                        patient.getDoctorId(), newNurse);
        patientRepository.deleteById(patient.getId());
        patientRepository.save(patient1);
        return patient1;
    }

    //metod za promnena na oddelenie na pacientot
    @Override
    public Patient changeWard(PatientId id, String ward) {
        Patient patient=patientRepository.findById(id)
                .orElseThrow(PatientNotFoundException::new);
        Ward ward1=new Ward(ward);
        Patient patient1=
                Patient.build(patient.getName(),
                        patient.getAddress(),
                        patient.getTeleph_num(),
                        ward1,
                        patient.getDoctorId(), patient.getNurseId());
        patientRepository.deleteById(id);
        patientRepository.save(patient1);
        return patient1;
    }
}
