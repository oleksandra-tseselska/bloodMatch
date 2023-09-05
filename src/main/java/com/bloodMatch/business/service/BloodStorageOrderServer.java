package com.bloodMatch.business.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BloodStorageOrderServer {
    ResponseEntity<List<Object>> orderBlood(String patientUniqueNumber);
}
