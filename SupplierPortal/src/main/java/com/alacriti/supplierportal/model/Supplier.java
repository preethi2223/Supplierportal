package com.alacriti.supplierportal.model;


public class Supplier {
	private int sid;
	private String semail;
	private String supplierName;
	private String phone;
	private String password;
	
	public Supplier() {
		

	}
	
	public Supplier(int sid,String semail, String supplierName, String phone, String password) {
		super();
		this.sid = sid;
		this.semail = semail;
		this.supplierName = supplierName;
		this.phone = phone;
		this.password = password;
	}
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
	
	
	public String getSemail() {
		return semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
