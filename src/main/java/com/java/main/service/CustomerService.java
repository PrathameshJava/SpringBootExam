package com.java.main.service;

import java.io.IOError;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.java.main.exception.ResourceNotFoundException;
import com.java.main.model.Customer;

public interface CustomerService {

    public List<Customer> showCustomer();
    public Customer getCustomerById(Integer integer) throws ResourceNotFoundException;
   // public Customer
	public Customer saveCustomer( Customer customer) throws IOException;

}
