package com.alacriti.supplierportal.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alacriti.supplierportal.model.Supplier;


@Repository
public class SupplierRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(SupplierRepository.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int addSupplier(Supplier supplier)  {
		logger.info("Class:SupplierRepository & Method:addSupplier");
		if(supplier==null || this.isExistEmail(supplier.getSemail())==1) {
			 return 1;
		}
		else {
		String sql = "insert into AL383_supplier(sid,semail,supplierName,phone,password)values(?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {supplier.getSid(),supplier.getSemail(),supplier.getSupplierName(),
				supplier.getPhone(),supplier.getPassword()});
		return 0;
		}
				
	}

	private int isExistEmail(String semail) {
		logger.info("Class:SupplierRepository & Method:isExistEmail");
		String sql="select exists(select * from AL383_supplier where semail=?)";
		return jdbcTemplate.queryForObject(sql, new Object[] {semail},Integer.class);
	}
}
