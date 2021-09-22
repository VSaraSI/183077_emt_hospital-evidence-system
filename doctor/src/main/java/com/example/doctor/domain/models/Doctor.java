package com.example.doctor.domain.models;

import com.example.shared_kernel.domain.base.AbstractEntity;
import com.example.shared_kernel.domain.ward.Ward;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
@Getter
public class Doctor extends AbstractEntity<DoctorId>{


    //atributi na entitetot Doctor
    private String name;
    private int salary;

    //enumeracija na kvalifikacija
    @Enumerated(EnumType.STRING)
    private Qualification qualification;

    private Ward ward;

    //metod za gradenje na instanca od Doctor
    public static Doctor build(String name, int salary, Qualification qualification, Ward ward) {
        Doctor doctor = new Doctor();
        doctor.name=name;
        doctor.salary=salary;
        doctor.qualification=qualification;
        doctor.ward=ward;
        return doctor;
    }

}
