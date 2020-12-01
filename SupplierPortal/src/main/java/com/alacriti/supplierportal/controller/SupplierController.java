package com.alacriti.supplierportal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alacriti.supplierportal.model.Supplier;
import com.alacriti.supplierportal.service.SupplierService;


@RestController
public class SupplierController {
	
	private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);
	
	@Autowired
	public SupplierService supplierService;
	
	@PostMapping("/registersupplier")
	public ResponseEntity<Integer> addSupplier(@RequestBody Supplier supplier) {
		
		logger.info("Class:SupplierController & Method:addSupplier");
		
		 return supplierService.addSupplier(supplier);
	}
	
}
