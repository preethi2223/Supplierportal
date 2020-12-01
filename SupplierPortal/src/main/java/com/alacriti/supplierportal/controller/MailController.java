package com.alacriti.supplierportal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alacriti.supplierportal.service.MailService;


@RestController
public class MailController {

	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	
	@Autowired 
	private MailService mailService;
	
	@GetMapping("/mail")
	@CrossOrigin
	public int sendMail() throws Exception {
		logger.info("Class:MailController & Method:sendMail");
		mailService.sendMail();
		return 1;
	}
}
