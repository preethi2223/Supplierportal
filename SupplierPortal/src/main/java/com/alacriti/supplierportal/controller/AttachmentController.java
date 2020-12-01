package com.alacriti.supplierportal.controller;


import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alacriti.supplierportal.model.Invoices;
import com.alacriti.supplierportal.service.AttachmentService;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;


@RestController
public class AttachmentController {
	
	private static final Logger logger = LoggerFactory.getLogger(AttachmentController.class);
	
	@Autowired
	private AttachmentService attachmentService;
	
	@Autowired   
	private CustomerController customerController;
	
	@Autowired
	private InvoicesController invoicesController;
	
	public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }
	
	@CrossOrigin
	@GetMapping("/exportinvoices")
    public void exportCSV(HttpServletResponse response) throws Exception {
		logger.info("Class:AttachmentController & Method:exportCSV");
		
		String semail=customerController.getSemail();
		String cemail=invoicesController.getcEmail();
		String iid=invoicesController.getiId();
        //set file name and content type
        String filename = "invoices.csv";
        
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");

        //create a csv writer
        StatefulBeanToCsv<Invoices> writer = new StatefulBeanToCsvBuilder<Invoices>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

        //write all users to csv file
        writer.write(attachmentService.listInvoices(semail,cemail,iid));
                
    }
	
}
