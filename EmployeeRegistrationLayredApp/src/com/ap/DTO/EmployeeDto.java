package com.ap.DTO;

import java.sql.Date;

public class EmployeeDto {
	private String eName=null;
	private String EAddress=null;
	private Date doj=null;
	private float bSal=0.0f;
	
	
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getEAddress() {
		return EAddress;
	}
	public void setEAddress(String eAddress) {
		EAddress = eAddress;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public float getbSal() {
		return bSal;
	}
	public void setbSal(float bSal) {
		this.bSal = bSal;
	}
	
	
}
