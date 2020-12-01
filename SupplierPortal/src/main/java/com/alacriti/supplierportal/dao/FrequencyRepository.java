package com.alacriti.supplierportal.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class FrequencyRepository {

	private static final Logger logger = LoggerFactory.getLogger(FrequencyRepository.class);
	
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> getFrequency(String semail, String date,String dateType) {
		logger.info("Class:FrequencyRepository & Method:getFrequency");
		String sql = "select distinct g1.iid,g1.date,g1.cemail,g2.totalSum from AL383_invoices as g1 inner join(select iid,sum(totalPrice) as totalSum from (select * from AL383_invoices where semail=? and "+dateType+"(date)=? and status='paid')as g3 group by iid)as g2 where g1.iid=g2.iid";
		return jdbcTemplate.queryForList(sql, new Object[] {semail,date});
		
	}
}
