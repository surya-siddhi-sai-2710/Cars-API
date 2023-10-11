package com.dh.rest.api.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.dh.rest.api.backend.model.CarsBackend;
import com.dh.rest.api.backend.model.GetModelNo;
import com.dh.rest.api.bean.CarsService;
import com.dh.rest.api.model.CarsResponse;

import org.apache.camel.component.jackson.JacksonDataFormat;

@Component
public class CarsRoute extends RouteBuilder{
	
	@Autowired
	private Environment ev;
	
	@Override
	public void configure() throws Exception{
		
		restConfiguration().bindingMode(RestBindingMode.json);
		
		rest().post("/viewcar").type(GetModelNo.class).consumes("application/json")
		.to("direct:invoke-request");
		
		from("direct:invoke-request")
		.log("log1")
		.to("bean:getCarByModelNoBackend?method=getRequestForCars")			// sending request
		.log("log2")
		.marshal().json(JsonLibrary.Jackson)
		.log("${body}")
		.to(ev.getProperty("ENV_URL"))		//calling DB endpoint
		.log("log4")
		.unmarshal(new JacksonDataFormat(CarsBackend.class)) 
		.log("log5")
		.log("${body}")
		 .to("bean:getCarByModelNoBackend?method=getResponseForCars");
	
	}
}
