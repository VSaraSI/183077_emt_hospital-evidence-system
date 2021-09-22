package com.example.med_carton.domain.valueobjects;

import com.example.shared_kernel.domain.base.ValueObject;
import com.example.shared_kernel.domain.ward.Ward;
import lombok.Getter;

@Getter
public class Patient implements ValueObject {

    //klasata med.karton go sodrzi vrednosniot objekt Patient za da moze da se ovozmozi
    //taa vrska pomegju niv, a nema potreba da se vo ist agregat zatoa sto ne mora vednas
    //da nastanat promenite koga i vo pacient

    private final PatientId id;
    private final String name;
    private final  String address;
    private  final String teleph_num;
    private final  Ward ward;

    public Patient(PatientId id, String name, String address, String teleph_num, Ward ward){
        this.id=id;
        this.name=name;
        this.address=address;
        this.teleph_num=teleph_num;
        this.ward=ward;
    }

    public Patient(){
        this.id=PatientId.randomId(PatientId.class);
        this.name="";
        this.address="";
        this.teleph_num="";
        this.ward=new Ward();
    }


}
