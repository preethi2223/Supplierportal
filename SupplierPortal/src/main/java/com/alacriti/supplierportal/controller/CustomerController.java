package com.alacriti.supplierportal.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alacriti.supplierportal.model.Customer;
import com.alacriti.supplierportal.service.CustomerService;


@RestController
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired 
	public CustomerService customerService;
	
	
	public String semail;
	
	public String getSemail() {
		return semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}
	
	
	

	@PostMapping("/addcustomer")
	public ResponseEntity<Integer> addCustomer(@RequestBody Customer customer,@RequestParam("semail") String semail) {
		logger.info("Class:CustomerController & Method:addCustomer");
		return customerService.addCustomer(customer,semail); 
	}
	
	
	@CrossOrigin
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers(@RequestParam("semail") String semail) {
		logger.info("Class:CustomerController & Method:getCustomers");
		setSemail(semail);
		ResponseEntity<List<Customer>> customerslist = customerService.getCustomers(semail);
		return customerslist;
	}

}
