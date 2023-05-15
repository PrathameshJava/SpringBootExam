package com.java.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.main.model.Policy;

@Repository
public interface PolicyRepo extends JpaRepository<Policy, Integer> {

	//public Policy findByPolicyName(String policyName);
}
