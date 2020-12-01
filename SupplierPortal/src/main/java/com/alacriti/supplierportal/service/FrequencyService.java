package com.alacriti.supplierportal.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alacriti.supplierportal.dao.FrequencyRepository;

@Service
public class FrequencyService {
	
	private static final Logger logger = LoggerFactory.getLogger(FrequencyService.class);
	
	@Autowired
	public FrequencyRepository frequencyRepo;
	
	public ResponseEntity<List<Map<String, Object>>> getFrequency(String semail,String date,String dateType) {
		logger.info("Class:FrequencyService & Method:getFrequency");
		
		try {
			 List<Map<String, Object>> response = frequencyRepo.getFrequency(semail, date, dateType);
			 return new ResponseEntity<List<Map<String, Object>>>(response, HttpStatus.OK);
		}
		catch(Exception e){
			 logger.error("Class:FrequencyService & Method:getFrequency"+e.getMessage());
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		 }

	}
	
}
