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
public class PaymentRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(PaymentRepository.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public int checkIid(String Iid) {
		logger.info("Class:PaymentRepository & Method:checkIid");
		int count = jdbcTemplate.queryForObject("select count(*) from AL383_invoices where iid=?",
				new Object[] {Iid},Integer.class);
		int count1 = jdbcTemplate.queryForObject("select count(*) from AL383_invoices where iid=? and status=?",
				new Object[] {Iid,"paid"},Integer.class);
		
		if(count==0) {
			return 0;
		}
		else if(count1>=1) {
			return 1;
		}
		else {
			return -1;
		}
	}


	public List<Invoices> checkPayList(String invoiceId) {
		logger.info("Class:PaymentRepository & Method:checkPayList");
		String sql = "select * from AL383_invoices where iid=?";
		List<Invoices> invoices = new ArrayList<>();
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql,invoiceId);
		for(Map<String,Object>row:rows) {
			Invoices insert = new Invoices();
			insert.setIid((Integer) row.get("iid"));
			insert.setGroceries((String) row.get("groceries"));
			insert.setQuantity((Integer) row.get("quantity"));
			insert.setUnitPrice((Integer) row.get("unitPrice"));
			insert.setTotalPrice((Integer) row.get("totalPrice"));
			insert.setStatus((String) row.get("status"));
			
			invoices.add(insert);
	}
		return invoices;
	}



	public int makePayment(String invoiceId) {
		logger.info("Class:PaymentRepository & Method:makePayment");
		String sql = "update AL383_invoices set status='paid',date=curdate() where iid=?";
		return jdbcTemplate.update(sql,new Object[] {invoiceId});
	}
	
}
