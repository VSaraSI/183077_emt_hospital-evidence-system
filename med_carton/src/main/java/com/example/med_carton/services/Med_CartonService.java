package com.example.med_carton.services;

import com.example.med_carton.domain.Med_carton;
import com.example.med_carton.domain.Med_cartonId;
import com.example.med_carton.services.form.Med_cartonForm;

public interface Med_CartonService {

    void deleteMedCarton(Med_cartonId id);
    Med_carton addMedCarton(Med_cartonForm form);
    Med_carton updateMedCarton(Med_cartonForm form);

}
