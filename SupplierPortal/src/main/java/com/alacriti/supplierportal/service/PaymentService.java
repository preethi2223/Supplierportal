package com.alacriti.supplierportal.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alacriti.supplierportal.dao.PaymentRepository;
import com.alacriti.supplierportal.model.Invoices;

@Service
public class PaymentService {
	
	private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);
	
	@Autowired
	public PaymentRepository paymentRepo;  
	
	public ResponseEntity<Integer> checkIid(String Iid) {  
		logger.info("Class:PaymentService & Method:checkIid");
		try {
				int response = paymentRepo.checkIid(Iid);
				if(response == 0) {
					return new ResponseEntity<Integer>(response, HttpStatus.OK);
				}
				else if(response == 1) {
					return new ResponseEntity<Integer>(response, HttpStatus.ALREADY_REPORTED);
				}
				else {
					return new ResponseEntity<Integer>(response, HttpStatus.OK);
				}
		}
		catch(Exception e){
			 logger.error("Class:PaymentService & Method:checkIid"+e.getMessage());
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	public ResponseEntity<List<Invoices>> checkPayList(String invoiceId) {
		logger.info("Class:PaymentService & Method:checkPayList");
		try {
			List<Invoices> response = paymentRepo.checkPayList(invoiceId);
			return new ResponseEntity<List<Invoices>>(response, HttpStatus.OK);
		}
		catch(Exception e){
			 logger.error("Class:PaymentService & Method:checkPayList"+e.getMessage());
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	
	public ResponseEntity<Integer> makePayment(String invoiceId) {
		logger.info("Class:PaymentService & Method:makePayment");
		try {
			int response = paymentRepo.makePayment(invoiceId); 
			return new ResponseEntity<Integer>(response, HttpStatus.ACCEPTED);
		}
		catch(Exception e){
			 logger.error("Class:PaymentService & Method:makePayment"+e.getMessage());
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
