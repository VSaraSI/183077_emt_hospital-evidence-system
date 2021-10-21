package com.example.med_carton.domain.valueobjects;

import com.example.med_carton.domain.Med_cartonId;
import com.example.shared_kernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class PatientId extends DomainObjectId {

    protected PatientId() {
        super(PatientId.randomId(PatientId.class).getId());
    }

    public PatientId(String uuid) {
        super(uuid);
    }

    public static PatientId of (String uuid){
        PatientId p=new PatientId(uuid);
        return p;
    }

}
