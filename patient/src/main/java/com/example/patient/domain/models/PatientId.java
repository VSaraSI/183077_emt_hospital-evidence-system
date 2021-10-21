package com.example.patient.domain.models;

import com.example.shared_kernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;


public class PatientId extends DomainObjectId{

    private PatientId() {
        super(PatientId.randomId(PatientId.class).getId());
    }

    public PatientId(@NonNull String uuid) {
        super(uuid);
    }

    public static PatientId of(String uuid) {
        PatientId p = new PatientId(uuid);
        return p;
    }

    public static PatientId convertByString (String id){
        PatientId newid=new PatientId(id);
        return newid;
    }


}
