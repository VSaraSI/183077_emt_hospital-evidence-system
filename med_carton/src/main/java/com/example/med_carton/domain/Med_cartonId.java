package com.example.med_carton.domain;

import com.example.shared_kernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class Med_cartonId extends DomainObjectId {

    private  Med_cartonId() {
        super( Med_cartonId.randomId( Med_cartonId.class).getId());
    }

    public  Med_cartonId(@NonNull String uuid) {
        super(uuid);
    }

    public static Med_cartonId convertByString (String id){
        Med_cartonId newid=new Med_cartonId(id);
        return newid;
    }



}
