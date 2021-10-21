package com.example.patient.services.form;

import com.example.patient.domain.valueobjects.DoctorId;
import com.example.patient.domain.valueobjects.NurseId;
import com.example.shared_kernel.domain.ward.Ward;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PatientForm {

    //forma koja ja koristime za da vlecime podatoci koi korisnikot ke gi vnese
    //za dodavanje ili promena na odreden pacient

    @NotNull
    private String name;

    private String address;

    @NotNull
    private String telephone;

    @NotNull
    private Ward ward;

    @NotNull
    private DoctorId doctorId;

    @NotNull
    private NurseId nurseId;

    public PatientForm(String name, String address, String telephone, Ward ward, DoctorId doctorId, NurseId nurseId) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.ward = ward;
        this.doctorId = doctorId;
        this.nurseId=nurseId;
    }
}
