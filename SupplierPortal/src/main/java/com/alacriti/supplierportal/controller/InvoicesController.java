package com.alacriti.supplierportal.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alacriti.supplierportal.model.Invoices;
import com.alacriti.supplierportal.model.Response;
import com.alacriti.supplierportal.service.InvoicesService;


@RestController
public class InvoicesController {
	
	private static final Logger logger = LoggerFactory.getLogger(InvoicesController.class);
	
	public String cEmail;
	public String iId;
	
	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	

	public String getiId() {
		return iId;
	}
	
	

	public void setiId(String iId) {
		this.iId = iId;
	}

	@Autowired
	private InvoicesService invoicesService;
	
	@Autowired
	private CustomerController customerController;
	
	@CrossOrigin
	@PostMapping("/uploadinvoices")
	public ResponseEntity<Object> saveInvoices(@RequestParam("file") MultipartFile file,@RequestParam("cemail") String cemail,@RequestParam("semail") String semail) throws IOException {
		logger.info("Class:InvoicesController & Method:saveInvoices");
		File convertFile = new File("src/main/resources/"+file.getOriginalFilename());
		convertFile.createNewFile();
		try(FileOutputStream fout = new FileOutputStream(convertFile))
		{
		fout.write(file.getBytes());
		}
		catch(Exception exe) {
			exe.printStackTrace();
		}
		invoicesService.saveInvoices(file,cemail,semail);
		return new ResponseEntity<Object>(new Response("File uploaded successfully"),HttpStatus.OK);

	}
	
	@CrossOrigin
	@GetMapping("/invoices")
	public ResponseEntity<List<Invoices>> getInvoices() {
		logger.info("Class:InvoicesController & Method:getInvoices");
		String semail = customerController.getSemail();
		ResponseEntity<List<Invoices>> invoiceslist = invoicesService.getCustomers(semail);
		return invoiceslist;
	}   
	
	
	@CrossOrigin
	@PostMapping("/invoice")
	public void postInvoice(@RequestParam("cemail") String cemail) {
		logger.info("Class:InvoicesController & Method:postInvoice");
		setcEmail(cemail);
		
	}
	
	@CrossOrigin
	@PostMapping("/iid")
	public void postId(@RequestParam("iid") String iid) {
		logger.info("Class:InvoicesController & Method:postId");
		setiId(iid);
	}
	
}
