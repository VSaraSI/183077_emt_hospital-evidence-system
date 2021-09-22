package com.example.patient.services.form;

import com.example.patient.domain.valueobjects.Doctor;
import com.example.patient.domain.valueobjects.Nurse;
import com.example.shared_kernel.domain.ward.Ward;
import lombok.Data;

@Data
public class PatientForm {

    private Doctor doctor;
    private String name;
    private String address;
    private String teleph_num;
    private Ward ward;
    private Nurse nurse;


}
