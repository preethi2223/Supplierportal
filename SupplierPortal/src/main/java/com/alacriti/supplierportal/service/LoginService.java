package com.alacriti.supplierportal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alacriti.supplierportal.dao.LoginRepository;
import com.alacriti.supplierportal.model.Supplier;

@Service
public class LoginService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	@Autowired
	LoginRepository loginRepository;
	
	public ResponseEntity<Supplier> checkSupplier(Supplier supplier) {
		logger.info("class:LoginService & method:checkSupplier");
		Supplier response = loginRepository.checkSupplier(supplier);
		try {
			if(response!=null) {
				return new ResponseEntity<Supplier>(response, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Supplier>(response, HttpStatus.OK);
			}
		}
		
		 catch(Exception e){
			 logger.error("class:SupplierService & method:addSupplier"+e.getMessage());
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		 }
	}
}
