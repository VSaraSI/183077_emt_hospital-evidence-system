package com.example.patient.domain.valueobjects;

import com.example.shared_kernel.domain.base.ValueObject;
import com.example.shared_kernel.domain.ward.Ward;
import lombok.Getter;

@Getter
public class Nurse implements ValueObject {

    private final NurseId id;
    private final String name;
    private final int salary;
    private final Ward ward;

    public Nurse(String name,int salary,Ward ward){
        this.id=NurseId.randomId(NurseId.class);
        this.name=name;
        this.salary=salary;
        this.ward=ward;
    }

    public Nurse(){
        this.id=NurseId.randomId(NurseId.class);
        this.name="";
        this.salary=0;
        this.ward=new Ward();
    }

}
