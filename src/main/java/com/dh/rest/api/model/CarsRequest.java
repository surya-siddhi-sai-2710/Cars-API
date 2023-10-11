package com.dh.rest.api.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class CarsRequest {
	
	@JsonProperty("modelno")
	private int modelno;
	
	@JsonProperty("cname")
	private String cname;
	
	@JsonProperty("price")
	private int price;
	
	//default constructor
	public CarsRequest() {
		super();
	}
	
	//constructor with parameters
	public CarsRequest(int mODELNO, String cNAME, int pRICE) {
		super();
		modelno = mODELNO;
		cname = cNAME;
		price = pRICE;
	}
	
	//getters and setters
	public int getModelno() {
		return modelno;
	}
	public void setModelno(int mODELNO) {
		modelno = mODELNO;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cNAME) {
		cname = cNAME;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int pRICE) {
		price = pRICE;
	}
	
	@Override
	public String toString() {
		return "CarsRequest [MODELNO=" + modelno + ", CNAME=" + cname + ", PRICE=" + price + "]";
	}
}
