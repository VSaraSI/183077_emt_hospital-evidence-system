package com.example.patient.domain.valueobjects;

import com.example.patient.domain.models.PatientId;
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

    public static DoctorId of(String uuid) {
        DoctorId p = new DoctorId(uuid);
        return p;
    }


}
