package com.alacriti.supplierportal.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.alacriti.supplierportal.dao.AttachmentRepository;
import com.alacriti.supplierportal.model.Invoices;

@Service
public class AttachmentService {
	private static final Logger logger = LoggerFactory.getLogger(AttachmentService.class);

	@Autowired
	AttachmentRepository attachmentRepo;
	
	
	
	public List<Invoices> listInvoices(String semail, String cemail, String iid) {
		
		logger.info("Class:AttachmentService & Method:listInvoices");
		
		return attachmentRepo.listInvoices(semail, cemail, iid);
	}
}
