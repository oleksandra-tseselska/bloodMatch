package com.bloodMatch.web_client;

import com.bloodMatch.business.exceptions.NotExistInDBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class Client {
    @Autowired
    private WebClient webClient;

//    public ResponseEntity<List<Object>> findAllBloodInfoByBloodId(Long bloodGroupId) {
//        return webClient.get()
//                .uri("http://localhost:8002/api/blood/info?bloodGroupId=" + bloodGroupId)
//                .retrieve()
//                .toEntity(new ParameterizedTypeReference<List<Object>>() {
//                })
//                .block();
//    }
    public ResponseEntity<List<Object>> findAllBloodInfoByBloodId(Long bloodGroupId) {
        return webClient.get()
                .uri("http://localhost:8002/api/blood/info?bloodGroupId=" + bloodGroupId)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<List<Object>>() {
                })
                .block();
    }

    public ResponseEntity<Object> findBloodGroupByIdWebClient(Long bloodGroupId) {
        return webClient.get()
                .uri("http://localhost:8002/api/blood/group/{id}", bloodGroupId)
                .retrieve()
                .toEntity(Object.class)
                .block();
    }

    public ResponseEntity<Long> findPatientByUniqueNumber(String uniqueNumber) {
        return webClient.get()
                .uri("http://localhost:8001/api/patient/findId?uniqueNumber="+uniqueNumber)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> {
                    throw new NotExistInDBException("Patient with unique number: "  + uniqueNumber + " not exists");
                })
                .toEntity(Long.class)
                .block();
    }
}
