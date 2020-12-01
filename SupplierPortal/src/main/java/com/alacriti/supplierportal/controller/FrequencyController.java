package com.alacriti.supplierportal.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alacriti.supplierportal.service.FrequencyService;


@RestController
public class FrequencyController {
	private static final Logger logger = LoggerFactory.getLogger(FrequencyController.class);
	@Autowired 
	public FrequencyService frequencyService;
	
	@GetMapping("/frequency")
	@CrossOrigin
	public ResponseEntity<List<Map<String, Object>>> getFrequency(@RequestParam(value="semail") String semail,
			@RequestParam(value="date") String date,@RequestParam(value="dateType") String dateType){
		logger.info("Class:FrequencyController & Method:getFrequency");
		ResponseEntity<List<Map<String, Object>>> list = frequencyService.getFrequency(semail, date, dateType);
		return list;
	}
}
