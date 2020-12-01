package com.alacriti.supplierportal.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alacriti.supplierportal.model.Customer;



@Repository
public class CustomerRepository {

	private static final Logger logger = LoggerFactory.getLogger(CustomerRepository.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addCustomer(Customer customer,String semail) {
		logger.info("Class:CustomerRepository & Method:addCustomer");
		if(customer==null || this.isExistCustomer(customer.getCemail(),semail)==1) {
			return 1;
		}
		else {
		String sql = "insert into AL383_customer(id,customerName,cemail,semail)values(?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {customer.getId(),customer.getCustomerName(),customer.getCemail(),semail});
		return 0;
		}
		
	}
	
	private int isExistCustomer(String cemail,String loginEmailId) {
		logger.info("Class:CustomerRepository & Method:isExistCustomer");
		String sql="select exists(select * from AL383_customer where cemail=? and semail=?)";
		return jdbcTemplate.queryForObject(sql, new Object[] {cemail,loginEmailId},Integer.class);
	}
	
	
	
	
	public List<Customer> getCustomers(String semail){
		logger.info("Class:CustomerRepository & Method:getCustomers");
		String sql = "select * from AL383_customer where semail = ?";
		List<Customer> customers = new ArrayList<>();
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql,semail);
		for(Map<String,Object>row:rows) {
			Customer insert = new Customer();
			insert.setId((int)row.get("id"));
			insert.setCemail((String) row.get("cemail"));
			insert.setCustomerName((String) row.get("customerName"));
			insert.setSemail((String) row.get("semail"));
			customers.add(insert);
			
		}
		return customers;
	}

}
