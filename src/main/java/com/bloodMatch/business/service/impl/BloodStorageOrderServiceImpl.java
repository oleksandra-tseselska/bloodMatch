package com.bloodMatch.business.service.impl;

import com.bloodMatch.business.mappers.BloodStorageOrderMapper;
import com.bloodMatch.business.repository.BloodStorageOrderRepository;
import com.bloodMatch.business.service.BloodStorageOrderServer;
import com.bloodMatch.web_client.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class BloodStorageOrderServiceImpl implements BloodStorageOrderServer {
    final private BloodStorageOrderRepository repository;
    final private BloodStorageOrderMapper mapper;
    final private Client client;

    public ResponseEntity<List<Object>> orderBlood(String patientUniqueNumber) {
        Long patientBloodId = null;
        ResponseEntity<Long> patientResponse = client.findPatientByUniqueNumber(patientUniqueNumber);
        if (patientResponse.getStatusCode() == HttpStatus.BAD_REQUEST) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).header(
                    "Message", "blood info not found by patient unique number: " + patientUniqueNumber).build();
        }
        if (patientResponse.getStatusCode() == HttpStatus.OK && patientResponse.getBody() != null) {
            patientBloodId = patientResponse.getBody();
            log.info("Patient Blood id: {}", patientBloodId);
        }
        ResponseEntity<List<Object>> bloodInfoForPatient = client.findAllBloodInfoByBloodId(patientBloodId);
//        bloodInfoForPatient.getBody().stream().anyMatch("address1");
        return client.findAllBloodInfoByBloodId(patientBloodId);
    }
}
