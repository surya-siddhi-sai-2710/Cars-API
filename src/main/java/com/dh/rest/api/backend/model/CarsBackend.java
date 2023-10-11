package com.dh.rest.api.backend.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class CarsBackend {
	
	@JsonProperty("modelno")
	private int modelno;
	
	@JsonProperty("cname")
	private String cname;
	
	@JsonProperty("price")
	private int price;
	
	public CarsBackend() {
		//default constructor
	}
	
	//getters and setters
	public int getModelno() {
		return modelno;
	}

	public void setModelno(int modelno) {
		this.modelno = modelno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	// constructors with parameters
	public CarsBackend(int modelno, String cname, int price) {
		super();
		this.modelno = modelno;
		this.cname = cname;
		this.price = price;
	}

	@Override
	public String toString() {
		return "CarsBackend [modelno=" + modelno + ", cname=" + cname + ", price=" + price + "]";
	}
}