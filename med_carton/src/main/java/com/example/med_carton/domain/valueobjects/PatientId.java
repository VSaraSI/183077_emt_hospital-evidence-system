package com.example.med_carton.domain.valueobjects;

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

}
