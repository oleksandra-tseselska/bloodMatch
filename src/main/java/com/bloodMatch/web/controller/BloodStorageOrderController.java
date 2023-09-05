package com.bloodMatch.web.controller;

import com.bloodMatch.business.service.BloodStorageOrderServer;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/blood/math")
public class BloodStorageOrderController {
    private final BloodStorageOrderServer server;
    @GetMapping("/uniqueNumber")
    @ApiOperation(value = "Finds blood info by providing patient unique number",
            notes = "Returns the entire list of blood info",
            response = Object.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request has succeeded", response = Object.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "The server has not found anything matching the Request-URI"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<List<Object>> findAllBloodInfoByUniqueNumber(
            @ApiParam(value = "name of the blood group", required = true) @RequestParam String patientUniqueNumber) {
        ResponseEntity<List<Object>> bloodInfoList = server.orderBlood(patientUniqueNumber);
        return bloodInfoList;
    }
}
