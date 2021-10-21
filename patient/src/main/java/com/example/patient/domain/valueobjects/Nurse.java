package com.example.patient.domain.valueobjects;

import com.example.shared_kernel.domain.base.ValueObject;
import com.example.shared_kernel.domain.ward.Ward;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Nurse implements ValueObject {

    private final NurseId id;
    private final String name;
    private final int salary;
    private final Ward ward;

    public Nurse(){
        this.id=NurseId.randomId(NurseId.class);
        this.name="";
        this.salary=0;
        this.ward=new Ward();
    }

    @JsonCreator
    public Nurse(@JsonProperty("id") NurseId id,
                  @JsonProperty("name") String name,
                  @JsonProperty("salary") int salary,
                  @JsonProperty("ward") Ward ward){
        this.id=id;
        this.name=name;
        this.salary=salary;
        this.ward=ward;
    }

}
