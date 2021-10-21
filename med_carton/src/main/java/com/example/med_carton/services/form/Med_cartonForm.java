package com.example.med_carton.services.form;

import com.example.med_carton.domain.valueobjects.PatientId;
import com.example.shared_kernel.domain.ward.Ward;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class Med_cartonForm {

    //ovaa forma ja koristime za gi izvleceme podatocite za med.karton
    //koj se kreira ili editira i potoa istite da gi vneseme vo bazata

    @NotNull
    private String problem;

    @NotNull
    private Ward ward;

    @NotNull
    private PatientId patientId;

}
