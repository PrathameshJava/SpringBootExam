package com.java.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.main.exception.ResourceNotFoundException;
import com.java.main.model.Claim;
import com.java.main.repository.ClaimRepo;
import com.java.main.service.ClaimService;

@Service
public class ClaimsServiceImpl implements ClaimService {

	@Autowired
	private ClaimRepo claimRepo;

	@Override
	public List<Claim> getAllClaims() {
		return claimRepo.findAll();
	}

	@Override
	public Claim getAllclaimsByid(Integer id) throws ResourceNotFoundException {
		return claimRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No id found for this id"));
	}

	@Override
	public Claim cerateClaims(Claim claim) {
		return claimRepo.save(claim);
	}

	@Override
	public Claim searchCliams(String claims) {
		// TODO Auto-generated method stub
		return claimRepo.findByclaimNumber(claims);
	}
}
