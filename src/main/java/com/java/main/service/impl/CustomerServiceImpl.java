package com.java.main.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.java.main.exception.ResourceNotFoundException;
import com.java.main.model.Customer;
import com.java.main.repository.CustomerRepo;
import com.java.main.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public List<Customer> showCustomer() {
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomerById(Integer id) throws ResourceNotFoundException {
		return customerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("no Id found for this variable"));

	}

	public Customer saveCustomer( Customer customer) throws IOException {
		//String name = file.getOriginalFilename();

//		String FilePath = path + File.separator + name;
//String path, MultipartFile file,
//		File file1 = new File(path);
//		if (!file1.exists()) {
//			file1.mkdir();
//		}
//		Files.copy(file.getInputStream(), Paths.get(FilePath));
//		Customer customer2 = new Customer();
//
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		if (fileName.contains("..")) {
//			System.out.println("not a a valid file");
//		}
//		customer2.setImage(fileName);

		return customerRepo.save(customer);
	}
}
