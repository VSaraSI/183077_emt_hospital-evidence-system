package com.example.med_carton.domain;

import com.example.med_carton.domain.valueobjects.PatientId;
import com.example.shared_kernel.domain.base.AbstractEntity;
import com.example.shared_kernel.domain.ward.Ward;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="med_carton")
public class Med_carton extends AbstractEntity<Med_cartonId> {

    //atributi na klasata med.karton od koj eden e override poradi toa shto
    //nivnite id-a se od isti tip i se so cel da ne nastane meshanje na
    //istite vo bazata id-to na pacientot trpi "promena"
    private String problem;
    private Ward ward;
    private Date creationDate;
    @AttributeOverride(name = "id", column = @Column(name = "patient_id", nullable = false))
    private PatientId patientId;


    public static Med_carton build(String problem,Ward ward,Date creationDate,PatientId patientId){
        Med_carton med_carton=new Med_carton();
        med_carton.creationDate=creationDate;
        med_carton.problem=problem;
        med_carton.ward=ward;
        med_carton.patientId=patientId;
        return med_carton;
    }

}
