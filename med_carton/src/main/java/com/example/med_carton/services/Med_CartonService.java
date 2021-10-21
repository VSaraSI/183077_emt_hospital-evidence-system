package com.example.med_carton.services;

import com.example.med_carton.domain.Med_carton;
import com.example.med_carton.services.form.Med_cartonForm;

import java.util.List;
import java.util.Optional;

public interface Med_CartonService {

    //metodi koi gi koristime za listanje na site kartoni, pronaogjanje na karton,
    // brishenje na karton
    List<Med_carton> getAll();
    Med_carton findById(String id);
    void deleteMedCarton(String id) throws Exception;

    //metodi so koi dodavame i brishime karton - istovremeno so ovie metodi
    //se publikuva i event za promena na oddelenie vo Patient
    Med_carton addMedCarton(Med_cartonForm form);
   void updateMedCarton(String id, Med_cartonForm form);

}
