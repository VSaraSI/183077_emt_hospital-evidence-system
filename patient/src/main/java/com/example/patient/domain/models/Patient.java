package com.example.patient.domain.models;

import com.example.patient.domain.valueobjects.DoctorId;
import com.example.patient.domain.valueobjects.NurseId;
import com.example.shared_kernel.domain.base.AbstractEntity;
import com.example.shared_kernel.domain.base.DomainObjectId;
import com.example.shared_kernel.domain.ward.Ward;
import lombok.Getter;
import org.springframework.lang.NonNull;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
@Getter
public class Patient extends AbstractEntity<PatientId> {


    //atributi na entitetot patient megju koj se i id-ata na Doctor i Nurse
    //i na istite se pravi override za da ne nastane zabuna vo bazata,
    //bidejkji stanuva zbor za id-a od ist tip so isto ime
    private String name;
    private String address;
    private String telephone;
    private Ward ward;

    @AttributeOverride(name = "id", column = @Column(name = "doctor_id"))
    private DoctorId doctorId;

    @AttributeOverride(name = "id", column = @Column(name = "nurse_id"))
    private NurseId nurseId;

    public Patient(){
        super(PatientId.randomId(PatientId.class));
    }

    public Patient(String name,String address, String telephone, Ward ward, DoctorId doctorId, NurseId nurseId) {
        super(DomainObjectId.randomId(PatientId.class));
        this.ward=ward;
        this.name=name;
        this.address=address;
        this.telephone=telephone;
        this.doctorId=doctorId;
        this.nurseId=nurseId;
    }

    //metodi za promena na oddlenie,doktor i sestra
    public void changeWard(Ward ward) {
        this.ward=ward;
    }

    public void changeDoctor(DoctorId doctorId){
        this.doctorId=doctorId;
    }

    public void changeNurse(NurseId nurseId){
        this.nurseId=nurseId;
    }


}
