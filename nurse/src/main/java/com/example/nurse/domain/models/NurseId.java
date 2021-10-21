package com.example.nurse.domain.models;

import com.example.shared_kernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class NurseId extends DomainObjectId {

    private NurseId() {
        super(NurseId.randomId(NurseId.class).getId());
    }

    public NurseId(@NonNull String uuid) {
        super(uuid);
    }

    public static NurseId of(String uuid) {
        NurseId p = new NurseId(uuid);
        return p;
    }

}
