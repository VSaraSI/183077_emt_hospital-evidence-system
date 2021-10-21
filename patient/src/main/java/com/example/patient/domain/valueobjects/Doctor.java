package com.example.patient.domain.valueobjects;

import com.example.shared_kernel.domain.base.ValueObject;
import com.example.shared_kernel.domain.ward.Ward;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Doctor implements ValueObject {

    private final DoctorId id;
    private final String name;
    private final int salary;
    private final Qualification qualification;
    private final Ward ward;

    public Doctor(){
        this.id=DoctorId.randomId(DoctorId.class);
        this.name="";
        this.salary=0;
        this.qualification=getQualification();
        this.ward=new Ward();
    }

    @JsonCreator
    public Doctor(@JsonProperty("id") DoctorId id,
                  @JsonProperty("name") String name,
                  @JsonProperty("qualification") Qualification qualification,
                  @JsonProperty("salary") int salary,
                  @JsonProperty("ward") Ward ward){
        this.id=id;
        this.name=name;
        this.salary=salary;
        this.qualification=qualification;
        this.ward=ward;
    }

}
