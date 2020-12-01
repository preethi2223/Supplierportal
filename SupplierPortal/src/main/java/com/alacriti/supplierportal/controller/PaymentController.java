package com.alacriti.supplierportal.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alacriti.supplierportal.model.Invoices;
import com.alacriti.supplierportal.service.PaymentService;


@RestController
public class PaymentController {
	
	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	String invoiceId;
	
	
	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	@Autowired
	public PaymentService paymentService;
	
	
	@CrossOrigin
	@PostMapping("/invoiceid")
	public ResponseEntity<Integer> checkIid(@RequestBody String Iid) {
		logger.info("Class:PaymentController & Method:checkIid");
		setInvoiceId(Iid);
		return paymentService.checkIid(Iid);
	}
	
	@CrossOrigin
	@GetMapping("/payment")
	public ResponseEntity<List<Invoices>> checkPayList() {
		logger.info("Class:PaymentController & Method:checkPayList");
		ResponseEntity<List<Invoices>> invoicesList = paymentService.checkPayList(getInvoiceId());
		return invoicesList;
	}  
	
	@CrossOrigin
	@PostMapping("/makepayment")
	public ResponseEntity<Integer> makePayment(@RequestBody String invoiceId) {
		logger.info("Class:PaymentController & Method:makePayment");
		return paymentService.makePayment(invoiceId);
	}   
	
}
