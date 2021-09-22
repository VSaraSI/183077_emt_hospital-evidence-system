package com.example.patient.domain.valueobjects;

import com.example.shared_kernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class DoctorId extends DomainObjectId {

    protected DoctorId() {
        super(DoctorId.randomId(DoctorId.class).getId());
    }

    public DoctorId(String uuid) {
        super(uuid);
    }


}
