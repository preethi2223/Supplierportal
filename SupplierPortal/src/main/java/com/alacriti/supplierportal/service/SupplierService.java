package com.alacriti.supplierportal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alacriti.supplierportal.dao.SupplierRepository;
import com.alacriti.supplierportal.model.Supplier;

@Service
public class SupplierService {
	
	private static final Logger logger = LoggerFactory.getLogger(SupplierService.class);
	
	@Autowired
	public SupplierRepository supplierRepository;

	public ResponseEntity<Integer>  addSupplier(Supplier supplier) {
		
		logger.info("Class:SupplierService & Method:addSupplier");
		 
		 try {
			int response = supplierRepository.addSupplier(supplier);
			 if(response == 1) {
			 return new ResponseEntity<Integer>(response, HttpStatus.ALREADY_REPORTED);
			 }
			 else {
				 return new ResponseEntity<Integer>(response, HttpStatus.CREATED);
			 }
		 }
		 catch(Exception e){
			 logger.error("Class:SupplierService & Method:addSupplier"+e.getMessage());
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		 }
	}
	
	
}

