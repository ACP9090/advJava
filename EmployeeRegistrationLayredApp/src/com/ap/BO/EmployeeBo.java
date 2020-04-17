package com.ap.BO;

import java.sql.Date;

public class EmployeeBo {
	private String eName=null;
	private String eAddress=null;
	private Date doj=null;
	private float bSal=0.0f;
	private float gSal=0.0f;
	private float nSal=0.0f;
	
	
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteAddress() {
		return eAddress;
	}
	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
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
	public float getgSal() {
		return gSal;
	}
	public void setgSal(float gSal) {
		this.gSal = gSal;
	}
	public float getnSal() {
		return nSal;
	}
	public void setnSal(float nSal) {
		this.nSal = nSal;
	}
	
	

}
