package com.dh.rest.api.model;

import org.springframework.stereotype.Component;

@Component
public class CarsFrontend {
	
	private int MODELNO;
	private String CNAME;
	private int PRICE;
	
	//default constructor
	public CarsFrontend() {
		super();
	}
	
	//constructor with parameters
	public CarsFrontend(int mODELNO, String cNAME, int pRICE) {
		super();
		MODELNO = mODELNO;
		CNAME = cNAME;
		PRICE = pRICE;
	}
	
	//getters and setters
	public int getMODELNO() {
		return MODELNO;
	}
	public void setMODELNO(int mODELNO) {
		MODELNO = mODELNO;
	}
	public String getCNAME() {
		return CNAME;
	}
	public void setCNAME(String cNAME) {
		CNAME = cNAME;
	}
	public int getPRICE() {
		return PRICE;
	}
	public void setPRICE(int pRICE) {
		PRICE = pRICE;
	}
	
	@Override
	public String toString() {
		return "CarsFrontend [MODELNO=" + MODELNO + ", CNAME=" + CNAME + ", PRICE=" + PRICE + "]";
	}
}
