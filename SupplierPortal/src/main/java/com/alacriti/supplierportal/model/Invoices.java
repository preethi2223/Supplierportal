package com.alacriti.supplierportal.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.opencsv.bean.CsvBindByName;



public class Invoices {
	
	
	private int iid;
	
	
	@CsvBindByName(column="Items")
	private String groceries;
	
	
	@CsvBindByName(column="Quantity")
	private int quantity;
	
	
	@CsvBindByName(column="UnitPrice")
	private int unitPrice;
	
	
	@CsvBindByName(column="TotalPrice")
	private int totalPrice;
	
	
	@CsvBindByName(column="Pending")
	private String status = "pending";
	
	private String cemail;
	private String semail;
	
	private LocalDate date = LocalDate.now();
	
	private BigDecimal totalSum;
	
	public Invoices() {
		
		
	}


	public Invoices(int iid, String groceries, int quantity, int unitPrice, int totalPrice, String status,
			String cemail,String semail, LocalDate date) {
		super();
		this.iid = iid;
		this.groceries = groceries;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.status = status;
		this.cemail = cemail;
		this.semail = semail;
		this.date = date;
	}


	public int getIid() {
		return iid;
	}


	public void setIid(int iid) {
		this.iid = iid;
	}


	public String getGroceries() {
		return groceries;
	}


	public void setGroceries(String groceries) {
		this.groceries = groceries;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getCemail() {
		return cemail;
	}


	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	

	public String getSemail() {
		return semail;
	}


	public void setSemail(String semail) {
		this.semail = semail;
	}


	public BigDecimal getTotalSum() {
		return totalSum;
	}


	public void setTotalSum(BigDecimal totalSum) {
		this.totalSum = totalSum;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}

	

}
