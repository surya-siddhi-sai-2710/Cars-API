package com.dh.rest.api.bean;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dh.rest.api.backend.model.CarsBackend;
import com.dh.rest.api.model.CarsResponse;
import com.dh.rest.api.model.GetModelNo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Service("getCarByModelNoBackend")
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class CarsService {
		
		// mapping response
		public void getResponseForCars(CarsBackend carsBackend){
		
			CarsResponse carsFrontend = new CarsResponse();
			carsFrontend.setMODELNO(carsBackend.getModelno());
			carsFrontend.setCNAME(carsBackend.getCname());
			carsFrontend.setPRICE(carsBackend.getPrice());
			
			System.out.println(carsFrontend.toString());
		}
		
		// mapping request
		public CarsBackend getRequestForCars(Exchange exchange) throws Exception{
		
			Message oMessage = exchange.getIn();
			GetModelNo oCarsModelno = oMessage.getBody(GetModelNo.class);
			System.out.println(oMessage.getBody());
			CarsBackend oCarsBackend = new CarsBackend();
			oCarsBackend.setModelno(oCarsModelno.getModelno());
			System.out.println(oCarsModelno.getModelno());
			
			return oCarsBackend;
	}
}
