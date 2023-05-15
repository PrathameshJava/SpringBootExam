package com.java.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.main.exception.ResourceNotFoundException;
import com.java.main.model.Claim;
import com.java.main.service.ClaimService;

@RestController
public class ClaimController {

    @Autowired
    private ClaimService claimService;


    @GetMapping(value = "/api/claims")
    public ResponseEntity<List<Claim>> getAllUsers() {
        List<Claim> list = claimService.getAllClaims();
        try {
            if (list.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/api/claims")
    public ResponseEntity<Claim> savePolicy(@RequestBody Claim claim) {
        try {
            Claim claim1 = claimService.cerateClaims(claim);
            return new ResponseEntity<>(claim1, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/api/claims/{id}")
    public ResponseEntity<Claim> getPolicyById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Claim claim = claimService.getAllclaimsByid(id);
        if (claim == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(claim, HttpStatus.OK);
    }

}
