package com.dh.rest.api.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.dh.rest.api.backend.bean.GetCarByModelNoBackend;
import com.dh.rest.api.model.CarsBackend;
import org.apache.camel.component.jackson.JacksonDataFormat;

@Component
public class CarsFromBackendRoute extends RouteBuilder{
	
	@Override
	public void configure() throws Exception{
		
		restConfiguration().bindingMode(RestBindingMode.json);
		
		rest().post("/viewcar").type(GetCarByModelNoBackend.class).consumes("application/json")
//		.to("direct:view-car-in-frontend");
		.to("direct:view-car");
		
		from("direct:view-car")
		.log("log1")
		.to("bean:getCarByModelNoBackend?method=getRequestForCars")
		.log("log2")
		.marshal().json(JsonLibrary.Jackson)
		.log("${body}")
		.to("http://localhost:8080/api/viewcar?bridgeEndpoint=true")
		.log("log4")
		.unmarshal(new JacksonDataFormat(CarsBackend.class)) 
		.log("log5")
		 .to("bean:getCarByModelNoBackend?method=getResponseForCars");
	
		
//		from("direct:view-car-in-frontend")
//		.log("debug log 1")
//		 .marshal().json(JsonLibrary.Jackson)
//		 .to("http://localhost:8080/api/viewcar?bridgeEndpoint=true")
//		 .unmarshal(new JacksonDataFormat(CarsBackend.class)) 
//		 .to("bean:getCarByModelNoBackend?method=getResponseForCars");
	}
}
