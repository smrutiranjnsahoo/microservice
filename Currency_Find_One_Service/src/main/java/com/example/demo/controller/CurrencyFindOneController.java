package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.ConversionMultiple;
import com.example.demo.repo.ConversionMultipleRepository;

@RestController
public class CurrencyFindOneController {
	
	@Autowired
	ConversionMultipleRepository repo;
	
	@Autowired
	Environment env;
	
	@GetMapping("/exchange-value/from/{from}/to/{to}")
	private ConversionMultiple getValue(@PathVariable String from ,@PathVariable String to) {
		ConversionMultiple  multiple = repo.findByValueToAndValueFrom(to, from);
		multiple.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		
		return multiple;
	}
	


}
