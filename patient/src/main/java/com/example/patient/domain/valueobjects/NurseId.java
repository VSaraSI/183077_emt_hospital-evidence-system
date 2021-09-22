package com.example.patient.domain.valueobjects;

import com.example.shared_kernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class NurseId extends DomainObjectId {

    protected NurseId() {
        super(NurseId.randomId(NurseId.class).getId());
    }

    public NurseId(String uuid) {
        super(uuid);
    }


}
