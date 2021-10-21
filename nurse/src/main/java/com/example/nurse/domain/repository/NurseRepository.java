package com.example.nurse.domain.repository;

import com.example.nurse.domain.models.Nurse;
import com.example.nurse.domain.models.NurseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, NurseId> {
}
