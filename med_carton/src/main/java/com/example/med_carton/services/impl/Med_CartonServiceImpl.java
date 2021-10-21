package com.example.med_carton.services.impl;

import com.example.med_carton.domain.Med_carton;
import com.example.med_carton.domain.Med_cartonId;
import com.example.med_carton.domain.exceptions.Med_cartonNotFound;
import com.example.med_carton.domain.repository.Med_cartonRepository;
import com.example.med_carton.services.Med_CartonService;
import com.example.med_carton.services.form.Med_cartonForm;
import com.example.shared_kernel.domain.events.med_cartons.ChangeWard;
import com.example.shared_kernel.infra.DomainEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class Med_CartonServiceImpl implements Med_CartonService {

    private final Med_cartonRepository cartonRepository;
    private final DomainEventPublisher domainEventPublisher;

    public Med_CartonServiceImpl(Med_cartonRepository cartonRepository, DomainEventPublisher domainEventPublisher) {
        this.cartonRepository = cartonRepository;
        this.domainEventPublisher = domainEventPublisher;
    }

    @Override
    public List<Med_carton> getAll() {
        return cartonRepository.findAll();
    }

    @Override
    public Med_carton findById(String id){
        Med_cartonId cartonId=Med_cartonId.convertByString(id);
        Med_carton carton=cartonRepository.findById(cartonId)
                .orElse(new Med_carton());
        return carton;
    }

    @Override
    public void deleteMedCarton(String id){
        Med_cartonId cartonId=Med_cartonId.convertByString(id);
        Med_carton carton=cartonRepository.findById(cartonId)
                .orElseThrow(Med_cartonNotFound::new);
        cartonRepository.deleteById(cartonId);
    }

    @Override
    public Med_carton addMedCarton(Med_cartonForm form) {
        Med_carton med_carton=
                new Med_carton(form.getProblem(), form.getWard(),
                        LocalDate.now()
                        ,form.getPatientId());
        this.cartonRepository.save(med_carton);
        domainEventPublisher.publish(new ChangeWard(form.getPatientId().getId(),
                form.getWard().getWardName()));
        return med_carton;
    }

    @Override
    public void updateMedCarton(String id, Med_cartonForm form) {
        Med_carton med_carton=this.cartonRepository.findById(Med_cartonId.convertByString(id))
                .orElseThrow(Med_cartonNotFound::new);
        Med_carton med_carton1=new Med_carton(form.getProblem(), form.getWard(),
                med_carton.getCreationDate(),
                form.getPatientId());
        this.cartonRepository.deleteById(Med_cartonId.convertByString(id));
        this.cartonRepository.saveAndFlush(med_carton1);
        domainEventPublisher.publish(new ChangeWard(form.getPatientId().getId(),
                form.getWard().getWardName()));
    }
}
