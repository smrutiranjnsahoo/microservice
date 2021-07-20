package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.feignclient.ConversionFeignClient;
import com.example.demo.pojo.ConversionValue;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class ConversionController {
	
	@Autowired
	ConversionFeignClient feign;
	
	@GetMapping("/conversion-value-rest/from/{from}/to/{to}/quantity/{quantity}")
	//@CircuitBreaker(name="currency-find-one" , fallbackMethod = "fallbackvalues")
	@Retry(name = "get", fallbackMethod = "fallbackvalues")
	public ConversionValue getValue_rest(@PathVariable String to, @PathVariable String from,
			@PathVariable String quantity) {
		
		System.out.println("Called");
		ConversionValue object  = null;
		Map<String, String> uriVariable = new HashMap<>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ConversionValue> entity = restTemplate.getForEntity(
				"http://localhost:8085/exchange-value/from/{from}/to/{to}", ConversionValue.class,uriVariable);
		
		object= entity.getBody();
		
		object.setQuantity(BigDecimal.valueOf(Double.parseDouble(quantity)));
		object.setTotalCalculatedAmmount(object.getQuantity().multiply(object.getConversionMultiple()));

		return object;
		
	}
	
	@GetMapping("/conversion-value-feign/from/{from}/to/{to}/quantity/{quantity}")
	//@CircuitBreaker(name="currency-find-one" , fallbackMethod = "fallbackvalues")
	public ConversionValue getValue_feign(@PathVariable String to, @PathVariable String from,
			@PathVariable String quantity) {
		
		ConversionValue object  = null;
		object = feign.getConversionValue(from, to);
		
		
		
		object.setQuantity(BigDecimal.valueOf(Double.parseDouble(quantity)));
		object.setTotalCalculatedAmmount(object.getQuantity().multiply(object.getConversionMultiple()));

		return object;
		
	}
	
	private ConversionValue fallbackvalues(String valueTo,String valueFrom,String quantity,Throwable throwable) {
		return new ConversionValue(1,valueTo,valueFrom, new BigDecimal(123));
	}
	
	


}
