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
import com.java.main.model.Policy;
import com.java.main.service.PolicyService;

@RestController
public class PolicyController {

	@Autowired
	private PolicyService policyService;

	@GetMapping(value = "/api/policies")
	public ResponseEntity<List<Policy>> getAllUsers() {
		List<Policy> list = policyService.showPolicy();
		try {
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/api/policies")
	public ResponseEntity<Policy> savePolicy(@RequestBody Policy policy) {
		try {
			Policy policy1 = policyService.addPolicy(policy);
			return new ResponseEntity<>(policy, HttpStatus.CREATED);
		} catch (Exception exception) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/api/policies/{id}")
	public ResponseEntity<Policy> getPolicyById(@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		Policy policy = policyService.getpolicy(id);
		if (policy == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(policy, HttpStatus.OK);
	}

//	@GetMapping(value = "/api/{policyName}")
//	public ResponseEntity<Policy> getpolicyByname(@PathVariable(value = "policyName") String policyname)
//			throws ResourceNotFoundException {
//		Policy policy = policyService.searchPolicyByname(policyname);
//		if (policy == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(policy, HttpStatus.OK);
//	}
}
