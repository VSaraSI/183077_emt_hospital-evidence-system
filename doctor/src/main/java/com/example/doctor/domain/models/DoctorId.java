package com.example.doctor.domain.models;

import com.example.shared_kernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class DoctorId extends DomainObjectId {

    private DoctorId() {
        super(DoctorId.randomId(DoctorId.class).getId());
    }

    public DoctorId(@NonNull String uuid) {
        super(uuid);
    }

    public static DoctorId of(String uuid) {
        DoctorId p = new DoctorId(uuid);
        return p;
}}
