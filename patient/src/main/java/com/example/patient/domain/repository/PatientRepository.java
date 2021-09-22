package com.example.patient.domain.repository;

import com.example.patient.domain.models.Patient;
import com.example.patient.domain.models.PatientId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, PatientId>{
}
