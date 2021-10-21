package com.example.med_carton.xport.client;

import com.example.med_carton.domain.valueobjects.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;


@Service
public class PatientClient{

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public PatientClient(@Value("${app.patient.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }


    //so ova gi vlecheme site pacienti koi vekje postojat vo tabelata Patient, so vnes
    //na soodvetnata pateka na koja tie se naogjaat
    public List<Patient> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/patient").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<Patient>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }


}