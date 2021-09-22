package com.example.patient.domain.valueobjects;

import com.example.shared_kernel.domain.base.ValueObject;
import com.example.shared_kernel.domain.ward.Ward;
import lombok.Getter;

@Getter
public class Doctor implements ValueObject {

    private final DoctorId id;
    private final String name;
    private final int salary;
    private final Qualification qualification;
    private final Ward ward;

    public Doctor(String name,int salary,Qualification qualification,Ward ward){
        this.id=DoctorId.randomId(DoctorId.class);
        this.name=name;
        this.salary=salary;
        this.qualification=qualification;
        this.ward=ward;
    }

    public Doctor(){
        this.id=DoctorId.randomId(DoctorId.class);
        this.name="";
        this.salary=0;
        this.qualification=getQualification();
        this.ward=new Ward();
    }

}
