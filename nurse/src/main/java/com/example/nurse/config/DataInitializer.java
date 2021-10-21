package com.example.nurse.config;

import com.example.nurse.domain.models.Nurse;
import com.example.nurse.domain.repository.NurseRepository;
import com.example.shared_kernel.domain.ward.Ward;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;


@Component
public class DataInitializer {

    private final NurseRepository nurseRepository;

    public DataInitializer(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }


    @PostConstruct
    public void initData() {
        Nurse nurse=Nurse.build("Monika Jovanoska" ,16000, new Ward("interno"));
        Nurse nurse1=Nurse.build("Elena Gavreska", 21000, new Ward("hirurgija"));
        Nurse nurse2=Nurse.build("Natalija Todoroska", 23000,new Ward("anasteziologija"));
        if (nurseRepository.findAll().isEmpty()) {
            nurseRepository.saveAll(Arrays.asList(nurse,nurse1,nurse2));
        }
    }

}
