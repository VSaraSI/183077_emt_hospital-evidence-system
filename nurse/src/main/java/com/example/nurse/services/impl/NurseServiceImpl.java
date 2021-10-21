package com.example.nurse.services.impl;

import com.example.nurse.domain.models.Nurse;
import com.example.nurse.domain.repository.NurseRepository;
import com.example.nurse.services.NurseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseServiceImpl implements NurseService {

    private final NurseRepository nurseRepository;

    public NurseServiceImpl(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    @Override
    public List<Nurse> getAll() {
        return this.nurseRepository.findAll();
    }
}
