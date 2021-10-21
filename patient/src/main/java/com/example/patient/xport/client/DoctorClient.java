package com.example.patient.xport.client;

import com.example.patient.domain.valueobjects.Doctor;
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
public class DoctorClient{

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public DoctorClient(@Value("${app.doctor.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    //so ovoj metod nie gi vlecheme site doktori koi se vo baza i se del od drug modul
    public List<Doctor> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/doctor").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<Doctor>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }


}