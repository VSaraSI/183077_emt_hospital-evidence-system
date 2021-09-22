package com.example.med_carton.domain.repository;

import com.example.med_carton.domain.Med_carton;
import com.example.med_carton.domain.Med_cartonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Med_cartonRepository extends JpaRepository<Med_carton, Med_cartonId> {
}
