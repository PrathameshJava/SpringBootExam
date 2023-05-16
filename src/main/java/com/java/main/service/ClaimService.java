package com.java.main.service;

import java.util.List;

import com.java.main.exception.ResourceNotFoundException;
import com.java.main.model.Claim;

public interface ClaimService {
	public List<Claim> getAllClaims();

	public Claim getAllclaimsByid(Integer id) throws ResourceNotFoundException;

	public Claim cerateClaims(Claim claim);
	
	public Claim searchCliams(String claims);
}
