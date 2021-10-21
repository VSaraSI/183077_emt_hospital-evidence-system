package com.example.med_carton.domain.valueobjects;

import com.example.shared_kernel.domain.base.ValueObject;
import com.example.shared_kernel.domain.ward.Ward;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Patient implements ValueObject {

    //klasata med.karton go sodrzi vrednosniot objekt Patient za da moze da se ovozmozi
    //taa vrska pomegju niv, a nema potreba da se vo ist agregat zatoa sto ne mora vednas
    //da nastanat promenite koga i vo Patient

    private final PatientId id;
    private final String name;
    private final  String address;
    private  final String telephone;
    private final  Ward ward;


    @JsonCreator
    public Patient(@JsonProperty("id") PatientId id,
                   @JsonProperty("name") String name,
                   @JsonProperty("address")String address,
                   @JsonProperty("telephone") String telephone,
                   @JsonProperty("ward") Ward ward){
        this.id=id;
        this.name=name;
        this.address=address;
        this.telephone=telephone;
        this.ward=ward;
    }


}
