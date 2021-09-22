package com.example.shared_kernel.domain.ward;

import com.example.shared_kernel.domain.base.ValueObject;
import lombok.Getter;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class Ward implements ValueObject {

    //vrednosen objekt koj e del od site 4 entiteti
    private final String wardName;

    public Ward(){
        this.wardName="";
    }

    public Ward(String wardName){
        this.wardName=wardName;
    }

    public Ward change(String value) {
        return new Ward(value);
    }

    @Override
    public String toString() {
        return wardName;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ward that = (Ward) o;
        return Objects.equals(wardName, that.wardName);
    }

}
