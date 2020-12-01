package com.alacriti.supplierportal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alacriti.supplierportal.model.Supplier;
import com.alacriti.supplierportal.service.LoginService;


@RestController
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<Supplier> checkSupplier(@RequestBody Supplier supplier) {
		logger.info("Class:LoginController & Method:checkSupplier");
		return loginService.checkSupplier(supplier);
	}
}
