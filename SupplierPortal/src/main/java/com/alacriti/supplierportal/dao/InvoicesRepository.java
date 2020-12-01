package com.alacriti.supplierportal.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alacriti.supplierportal.controller.CustomerController;
import com.alacriti.supplierportal.controller.InvoicesController;
import com.alacriti.supplierportal.model.Invoices;


@Repository
public class InvoicesRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(InvoicesRepository.class);
	
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	InvoicesController invoicesController;
	
	@Autowired
	CustomerController customerController;
	
	
	
	public void saveInvoices(Invoices invoices) {
		logger.info("Class:InvoicesRepository & Method:saveInvoices");
		String sql = "insert into AL383_invoices(iid,groceries,quantity,unitPrice,totalPrice,status,date,cemail,semail)values(?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {invoices.getIid(),invoices.getGroceries(),invoices.getQuantity(),
				invoices.getUnitPrice(),invoices.getTotalPrice(),invoices.getStatus(),invoices.getDate(),invoices.getCemail(),invoices.getSemail()});
	}
	
	public List<Invoices> getInvoices(String semail){
		logger.info("Class:InvoicesRepository & Method:getInvoices");
		String sql = "select distinct g1.iid,g1.status,g2.totalSum from AL383_invoices as g1 inner join(select iid,sum(totalPrice) as totalSum from (select * from AL383_invoices where status='pending' and semail=? && cemail=?)as g3 group by iid)as g2 where g1.iid=g2.iid";
		String cemail = invoicesController.getcEmail();
		List<Invoices> invoices = new ArrayList<>();
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql,semail,cemail);
		for(Map<String,Object>row:rows) {
			Invoices insert = new Invoices();
			insert.setIid((Integer) row.get("iid"));
			insert.setTotalSum((BigDecimal) row.get("totalSum"));
			insert.setStatus((String) row.get("status"));
			invoices.add(insert);
			
		}
		return invoices;
	}
	
	public void getReference() {
		logger.info("Class:InvoicesRepository & Method:getReference");
		String sql = "insert into AL383_reference(cemail,semail)values(?,?)";
		String cemail = invoicesController.getcEmail();
		String semail = customerController.getSemail();
		jdbcTemplate.update(sql,new Object[] {cemail,semail});
	}

	public int maxReference() {
		logger.info("Class:InvoicesRepository & Method:maxReference");
		int max = jdbcTemplate.queryForObject( "select max(iid) from AL383_reference", Integer.class);
		return max;
	}


}
