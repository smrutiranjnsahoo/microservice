package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.ConversionMultiple;
import com.example.demo.repo.ConversionMultipleRepository;

@RestController
public class CurrencyAddController {
	
	@Autowired
	ConversionMultipleRepository repo;
	
	@PostMapping("/currencies")
	private ConversionMultiple addToData(@RequestBody ConversionMultiple conversionMultiple) {
		return repo.save(conversionMultiple);
	}
	


}
