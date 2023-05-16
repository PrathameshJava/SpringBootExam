package com.java.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.main.model.Claim;

@Repository
public interface ClaimRepo extends JpaRepository<Claim,Integer> {
	
	public Claim findByclaimNumber(String claimNumber);

}
