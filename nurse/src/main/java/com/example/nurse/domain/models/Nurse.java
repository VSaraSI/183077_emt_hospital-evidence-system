package com.example.nurse.domain.models;

import com.example.shared_kernel.domain.base.AbstractEntity;
import com.example.shared_kernel.domain.ward.Ward;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nurse")
@Getter
public class Nurse extends AbstractEntity<NurseId> {

    private String name;
    private int salary;
    private Ward ward;

    public Nurse(){
        super(NurseId.randomId(NurseId.class));
    }

    public static Nurse build(String name, int salary,Ward ward) {
        Nurse nurse = new Nurse();
        nurse.name=name;
        nurse.salary=salary;
        nurse.ward=ward;
        return nurse;
    }

}
