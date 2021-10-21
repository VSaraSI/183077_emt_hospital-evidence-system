package com.example.patient.xport.client;

import com.example.patient.domain.valueobjects.Doctor;
import com.example.patient.domain.valueobjects.Nurse;
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
public class NurseClient {

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public NurseClient(@Value("${app.nurse.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    //so ovoj metod gi vlecheme site med.sestri koi postojat vo baza i se del od drug modul
    public List<Nurse> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/nurse").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<Nurse>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
