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
    //i na istite se pravi override za da ne nastane zabuna vo bazata
    private String name;
    private String address;
    private String teleph_num;
    private Ward ward;

    @AttributeOverride(name = "id", column = @Column(name = "doctor_id", nullable = false))
    private DoctorId doctorId;

    @AttributeOverride(name = "id", column = @Column(name = "nurse_id", nullable = false))
    private NurseId nurseId;

    public Patient(){
        super(PatientId.randomId(PatientId.class));
    }

    public Patient(@NonNull DoctorId doctorId, @NonNull Ward ward,@NonNull NurseId nurseId, String name, String address, String teleph_num) {
        super(DomainObjectId.randomId(PatientId.class));
        this.doctorId =doctorId;
        this.nurseId=nurseId;
        this.ward=ward;
        this.name=name;
        this.address=address;
        this.teleph_num=teleph_num;
    }



    public static Patient build(String name, String address, String teleph_num,Ward ward,DoctorId doctorId, NurseId nurseId) {
        Patient p = new Patient();
        p.name=name;
        p.address=address;
        p.nurseId=nurseId;
        p.teleph_num=teleph_num;
        p.ward=ward;
        p.doctorId=doctorId;
        return p;
    }


}
