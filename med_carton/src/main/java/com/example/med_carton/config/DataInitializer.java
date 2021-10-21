package com.example.med_carton.config;

import com.example.med_carton.domain.Med_carton;
import com.example.med_carton.domain.repository.Med_cartonRepository;
import com.example.med_carton.domain.valueobjects.PatientId;
import com.example.shared_kernel.domain.ward.Ward;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;


@Component
public class DataInitializer {

    private final Med_cartonRepository cartonRepository;

    public DataInitializer(Med_cartonRepository cartonRepository) {
        this.cartonRepository = cartonRepository;
    }


    @PostConstruct
    public void initData() {
        Med_carton carton =new Med_carton("Kardiovaskularni problemi",
                new Ward("Interno oddelenie"),
                LocalDate.now(),
                PatientId.of("37302c23-febe-45ab-8163-61310e37a8a1"));

        if (cartonRepository.findAll().isEmpty()) {
            cartonRepository.saveAll(Arrays.asList(carton));
        }
    }


}
