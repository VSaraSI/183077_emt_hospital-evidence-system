package com.example.med_carton.services.impl;

import com.example.med_carton.domain.Med_carton;
import com.example.med_carton.domain.Med_cartonId;
import com.example.med_carton.domain.exceptions.Med_cartonNotFound;
import com.example.med_carton.domain.repository.Med_cartonRepository;
import com.example.med_carton.services.Med_CartonService;
import com.example.med_carton.services.form.Med_cartonForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Date;

@Service
@AllArgsConstructor
@Transactional
public class Med_CartonServiceImpl implements Med_CartonService {

    private final Med_cartonRepository cartonRepository;

    //metod za brishenje na karton

    @Override
    public void deleteMedCarton(Med_cartonId id) {
        Med_carton med_carton=this.cartonRepository.findById(id)
                .orElseThrow(Med_cartonNotFound::new);
        this.cartonRepository.deleteById(id);
    }

    //metod za dodavanje na karton

    @Override
    public Med_carton addMedCarton(Med_cartonForm form) {
        Med_carton med_carton=Med_carton.
                build(form.getProblem(), form.getWard(), Date.from(Instant.now()),form.getPatientId());
        this.cartonRepository.save(med_carton);
        return med_carton;
    }

    //metod za promena na vrednosti na atributi vo med.karton

    @Override
    public Med_carton updateMedCarton(Med_cartonForm form) {
        Med_carton med_carton=this.cartonRepository.findById(form.getId())
                .orElseThrow(Med_cartonNotFound::new);
        this.cartonRepository.deleteById(med_carton.getId());
        Med_carton med_carton1=Med_carton.
                build(form.getProblem(), form.getWard(), Date.from(Instant.now()),form.getPatientId());
        this.cartonRepository.save(med_carton1);
        return med_carton1;
    }
}
