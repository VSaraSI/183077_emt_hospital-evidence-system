package com.example.doctor.domain.repository;

import com.example.doctor.domain.models.Doctor;
import com.example.doctor.domain.models.DoctorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, DoctorId> {
}
