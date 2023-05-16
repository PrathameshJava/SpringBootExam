package com.java.main.service;

import java.util.List;

import com.java.main.exception.ResourceNotFoundException;
import com.java.main.model.Policy;

public interface PolicyService {

	public List<Policy> showPolicy();

	public Policy getpolicy(Integer id) throws ResourceNotFoundException;

	public Policy addPolicy(Policy policy);

	public Policy searchPolicyByname(String policyName);

}
