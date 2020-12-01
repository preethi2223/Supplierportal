package com.alacriti.supplierportal.service;

import java.io.File;
import java.util.Date;


import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.alacriti.supplierportal.controller.InvoicesController;


@Service
public class MailService {
	
	private static final Logger logger = LoggerFactory.getLogger(SupplierService.class);
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private InvoicesController invoicesController;
	
	
	
	
	public void sendMail() throws Exception{
		
		logger.info("Class:MailService & Method:sendMail");
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
			mimeMessageHelper.setFrom("preethidevireddy21@gmail.com");
			mimeMessageHelper.setTo(invoicesController.getcEmail());
			mimeMessageHelper.setSubject("Pending Invoices and Payment Remainder");
			mimeMessageHelper.setText("Your Invoice Id:"+invoicesController.getiId()+". Please find the attachment below. "+"Visit Here to Pay : http://localhost:4200/invoiceid", true);
			mimeMessageHelper.setSentDate(new Date());
			FileSystemResource file = new FileSystemResource("/home/preethid/Downloads/invoices.csv");
			mimeMessageHelper.addAttachment(file.getFilename(), file);
			javaMailSender.send(mimeMessage);
			File file1 = new File("/home/preethid/Downloads/invoices.csv");
			file1.delete(); 
		}
		catch(Exception e){
			 logger.error("Class:MailService & Method:sendMail"+e.getMessage());
			 return;
		 }
	}

}
