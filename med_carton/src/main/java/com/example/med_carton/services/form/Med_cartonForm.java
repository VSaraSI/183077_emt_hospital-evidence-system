package com.example.med_carton.services.form;

import com.example.med_carton.domain.Med_cartonId;
import com.example.med_carton.domain.valueobjects.Patient;
import com.example.med_carton.domain.valueobjects.PatientId;
import com.example.shared_kernel.domain.ward.Ward;
import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import java.util.Date;

@Data
public class Med_cartonForm {

    private Med_cartonId id;
    private String problem;
    private Ward ward;
    private Date creationDate;
    private PatientId patientId;

}
