package com.dh.rest.api.backend.bean;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dh.rest.api.model.CarsBackend;
import com.dh.rest.api.model.CarsFrontend;
import com.dh.rest.api.model.CarsModelNo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Service("getCarByModelNoBackend")
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class GetCarByModelNoBackend {
	
	
	public void getResponseForCars(CarsBackend carsBackend){
		
//		carsFrontend.setMODELNO(carsBackend.getModelno());
//		carsFrontend.setCNAME(carsBackend.getCname());
//		carsFrontend.setPRICE(carsBackend.getPrice());
		
		}
	
	public CarsBackend getRequestForCars(Exchange exchange) throws Exception{
		
//		System.out.println(exchange.getIn().getBody());
		Message message = exchange.getIn();
		CarsModelNo carsModelno = message.getBody(CarsModelNo.class);
		System.out.println(message.getBody());
		CarsBackend carsBackend = new CarsBackend();
		carsBackend.setModelno(carsModelno.getModelno());
		return carsBackend;
		
//		carsModelno.setModelno(carsFrontend.getMODELNO());
//		carsBackend.setCname(carsFrontend.getCNAME());
//		carsBackend.setPrice(carsFrontend.getPRICE());
	}
}
