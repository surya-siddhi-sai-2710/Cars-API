package com.dh.rest.api.bean;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.dh.rest.api.backend.model.CarsBackend;
import com.dh.rest.api.backend.model.GetModelNo;
import com.dh.rest.api.model.CarsResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Service("getCarByModelNoBackend")
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class CarsService {
		
		// mapping response
		public void getResponseForCars(Exchange exchange) throws Exception{
		
			Message oMessage = exchange.getIn();
			CarsBackend oCarsBackend = oMessage.getBody(CarsBackend.class);
			System.out.println(oMessage.getBody());
			CarsResponse oCarsResponse = new CarsResponse();
			oCarsResponse.setMODELNO(oCarsBackend.getModelno());
			oCarsResponse.setCNAME(oCarsBackend.getCname());
			oCarsResponse.setPRICE(oCarsBackend.getPrice());
			
			System.out.println(oCarsResponse.toString());
			oMessage.setBody("");
			oMessage.setBody(oCarsResponse);

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
