package com.example.doctor.services.impl;

import com.example.doctor.domain.models.Doctor;
import com.example.doctor.domain.repository.DoctorRepository;
import com.example.doctor.services.DoctorService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }
}
