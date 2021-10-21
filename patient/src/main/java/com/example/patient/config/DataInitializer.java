package com.example.patient.config;
import com.example.patient.domain.models.Patient;
import com.example.patient.domain.repository.PatientRepository;
import com.example.patient.domain.valueobjects.*;
import com.example.shared_kernel.domain.ward.Ward;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;


@Component
public class DataInitializer {

    private final PatientRepository patientRepository;

    public DataInitializer(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @PostConstruct
    public void initData() {
        Patient patient=new Patient("Marijan Mitreski",
                                    "ul.Ljubjanska - Karposh3",
                                    "046785412",
                                    new Ward("interno"),
                                    DoctorId.of("4c97ab86-ee43-4615-b6ad-49a79cfe0a70"),
                                     NurseId.of("10cd8340-91ee-4e08-af97-a62cdedae6f8"));
        Patient patient1=new Patient("Eleonora Bandoska",
                "ul.Marshal Tito br.5- Bitola",
                "0785412362",
                new Ward("hirurgija"),
                DoctorId.of("3caa9ef1-bd16-4c63-ab47-abf84f0f7702"),
                NurseId.of("664fe361-2930-43a0-9fa7-1942330c75a9"));
        if (patientRepository.findAll().isEmpty()) {
            patientRepository.saveAll(Arrays.asList(patient,patient1));
        }
    }


}
