package com.alacriti.supplierportal.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alacriti.supplierportal.dao.InvoicesRepository;
import com.alacriti.supplierportal.model.Invoices;

@Service
public class InvoicesService {

	private static final Logger logger = LoggerFactory.getLogger(InvoicesService.class);
	
	@Autowired
	private InvoicesRepository invoicesRepo;
	
	String line ="";
	
	public void saveInvoices(MultipartFile file,String cemail,String semail) {
		
		logger.info("Class:InvoicesService & Method:saveInvoices");
		
		invoicesRepo.getReference();
		int max = invoicesRepo.maxReference();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/"+file.getOriginalFilename()));
			while((line=br.readLine())!=null) {
				String [] data=line.split(",");
				Invoices invoices = new Invoices(); 
				invoices.setIid(max);
				invoices.setGroceries(data[0]);
				invoices.setQuantity(Integer.parseInt(data[1]));
				invoices.setUnitPrice(Integer.parseInt(data[2]));
				invoices.setTotalPrice(Integer.parseInt(data[3]));
				invoices.getStatus();
				invoices.getDate();
				invoices.setCemail(cemail);
				invoices.setSemail(semail);
				invoicesRepo.saveInvoices(invoices);
				File file1 = new File("src/main/resources/"+file.getOriginalFilename());
				file1.delete();
			}
				
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Class:InvoicesService & Method:saveInvoices"+e.getMessage());
		}
	}

	
	
	public ResponseEntity<List<Invoices>> getCustomers(String semail) {
		logger.info("Class:InvoicesService & Method:getCustomers");
		
		List<Invoices> response = invoicesRepo.getInvoices(semail);
		try {
			return new ResponseEntity<List<Invoices>>(response, HttpStatus.OK);
		}
		catch(Exception e){
			 logger.error("Class:InvoicesService & Method:getCustomers"+e.getMessage());
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}


	


	 
}
