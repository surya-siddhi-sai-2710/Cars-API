package com.dh.rest.api.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class CarsModelNo {
	
	@JsonProperty("modelno")
	private int modelno;
	
	//default constructor
	public CarsModelNo() {
		super();
	}
	
	//Parameterized constructor
	public CarsModelNo(int modelno) {
		super();
		this.modelno = modelno;
	}
	
	//getters and setters
	public int getModelno() {
		return modelno;
	}

	public void setModelno(int modelno) {
		this.modelno = modelno;
	}
	
	//to string
	@Override
	public String toString() {
		return "CarsModelNo [modelno=" + modelno + "]";
	}
}