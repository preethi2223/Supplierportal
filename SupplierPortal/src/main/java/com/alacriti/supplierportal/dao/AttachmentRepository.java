package com.alacriti.supplierportal.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alacriti.supplierportal.model.Invoices;



@Repository
public class AttachmentRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(AttachmentRepository.class);

	
	@Autowired 
	JdbcTemplate jdbcTemplate;

	public List<Invoices> listInvoices(String semail,String cemail,String iid){
		logger.info("Class:AttachmentRepository & Method:listInvoices");
		String sql = "select * from AL383_invoices where semail=? and cemail=? and iid=?";
		List<Invoices> invoices = new ArrayList<>();
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql,semail,cemail,iid);
		for(Map<String,Object>row:rows) {
			Invoices insert = new Invoices();
			insert.setGroceries((String) row.get("groceries"));
			insert.setQuantity((Integer) row.get("quantity"));
			insert.setUnitPrice((Integer) row.get("unitPrice"));
			insert.setTotalPrice((Integer) row.get("totalPrice"));
			insert.setStatus((String) row.get("status"));
			invoices.add(insert);
			
	
		}
		return invoices;
	} 
}
