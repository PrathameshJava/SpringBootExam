package com.java.main.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.java.main.model.Customer;
import com.java.main.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Value("${project.image}")
	String path;

	@PostMapping(value = "/customer")
	public Customer saveProduct(@RequestBody Customer customer) throws IOException {

		return customerService.saveCustomer(customer);
	}
	@GetMapping("/customer")
	public List<Customer> getAll()
	{
		return customerService.showCustomer();
	}
}
