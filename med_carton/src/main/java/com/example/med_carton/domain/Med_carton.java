package com.example.med_carton.domain;

import com.example.med_carton.domain.valueobjects.PatientId;
import com.example.shared_kernel.domain.base.AbstractEntity;
import com.example.shared_kernel.domain.base.DomainObjectId;
import com.example.shared_kernel.domain.ward.Ward;
import lombok.Getter;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="med_carton")
@Getter
public class Med_carton extends AbstractEntity<Med_cartonId> {

    //atributi na klasata med.karton od koj eden e override poradi toa shto
    //nivnite id-a se od ist tip i se so cel da ne nastane meshanje na
    //istite vo bazata id-to na pacientot trpi "promena"

    private String problem;
    private Ward ward;
    private LocalDate creationDate;

    @AttributeOverride(name = "id", column = @Column(name = "patient_id", nullable = false))
    private PatientId patientId;

    public Med_carton(){super(Med_cartonId.randomId(Med_cartonId.class));}

    public Med_carton(String problem,Ward ward,LocalDate date, PatientId patientId){
        super(DomainObjectId.randomId(Med_cartonId.class));
        this.ward=ward;
        this.problem=problem;
        this.creationDate=date;
        this.patientId=patientId;
    }

}
