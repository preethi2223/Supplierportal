package com.alacriti.supplierportal.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alacriti.supplierportal.model.Supplier;


@Repository
public class LoginRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginRepository.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	

	public Supplier checkSupplier(Supplier supplier) {
		
		logger.info("Class:LoginRepository & Method:checkSupplier");
		
		int sid = jdbcTemplate.queryForObject("select sid from AL383_supplier where semail=? and password=?"
				,new Object[] {supplier.getSemail(),supplier.getPassword()},Integer.class);
		
		String supplierName = (String) jdbcTemplate.queryForObject("select supplierName from AL383_supplier where semail=? and password=?"
			,new Object[] {supplier.getSemail(),supplier.getPassword()},String.class);
		
		String phone = (String) jdbcTemplate.queryForObject("select phone from AL383_supplier where semail=? and password=?"
				,new Object[] {supplier.getSemail(),supplier.getPassword()},String.class);
		
		int count = jdbcTemplate.queryForObject("select count(*) from AL383_supplier where semail=? and password=?",
				new Object[] {supplier.getSemail(),supplier.getPassword()},Integer.class);
		
		
		
		if(count>0) {
			supplier.setSid(sid);
			supplier.setSupplierName(supplierName);
			supplier.setPhone(phone);
			return supplier;
			
		}
		
		else {
			return null;
		}
	}
	

}
