package com.java.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.main.exception.ResourceNotFoundException;
import com.java.main.model.Policy;
import com.java.main.repository.PolicyRepo;
import com.java.main.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService {
	@Autowired
	private PolicyRepo policyRepo;

	@Override
	public List<Policy> showPolicy() {
		return policyRepo.findAll();
	}

	@Override
	public Policy getpolicy(Integer id) throws ResourceNotFoundException {
		return policyRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id not found for this parameter"));
	}

	@Override
	public Policy addPolicy(Policy policy) {
		return policyRepo.save(policy);
	}

	@Override
	public Policy searchPolicyByname(String policyName) {
		return policyRepo.findBypolicyNumber(policyName);
	}


}
