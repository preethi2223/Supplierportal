package com.alacriti.supplierportal.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alacriti.supplierportal.dao.CustomerRepository;
import com.alacriti.supplierportal.model.Customer;

@Service
public class CustomerService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
	public CustomerRepository customerRepository;
	
	public ResponseEntity<Integer> addCustomer(Customer customer,String semail) {
		logger.info("Class:CustomerService & Method:addCustomer");
		
		try {
			int response = customerRepository.addCustomer(customer,semail);
			if(response == 1) {
				 return new ResponseEntity<Integer>(response, HttpStatus.ALREADY_REPORTED);
			}
			else {
				 return new ResponseEntity<Integer>(response, HttpStatus.CREATED);
			 }
		}
		catch(Exception e){
			logger.error("Class:CustomerService & Method:addCustomer"+e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

	public ResponseEntity<List<Customer>> getCustomers(String semail) {
		logger.info("Class:CustomerService & Method:getCustomers");
		
		try {
			List<Customer> response =customerRepository.getCustomers(semail);
			 return new ResponseEntity<List<Customer>>(response, HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Class:CustomerService & Method:addCustomer"+e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	

	
	
}
