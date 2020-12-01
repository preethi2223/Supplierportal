package com.alacriti.supplierportal.model;


public class Customer {
	private int id;
	private String customerName;
	private String cemail;
	private String semail;
	
	
	public Customer() {
	
	}
	
	public Customer(int id, String customerName, String cemail, String semail) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.cemail = cemail;
		this.semail = semail;
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	

	
	
	
	
}
