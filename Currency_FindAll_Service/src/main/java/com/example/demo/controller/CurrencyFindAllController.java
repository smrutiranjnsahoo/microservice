package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.ConversionMultiple;
import com.example.demo.repo.ConversionMultipleRepository;

@RestController
public class CurrencyFindAllController {
	
	@Autowired
	ConversionMultipleRepository repo;
	
	@GetMapping("/currency-all")
	public ResponseEntity<List<ConversionMultiple>> getAllCurrency() {
 
		List<ConversionMultiple> currencies = repo.findAll();
		if (currencies.size() > 0) {
			return new ResponseEntity<List<ConversionMultiple>>(currencies, HttpStatus.OK);
		}
		return new ResponseEntity<List<ConversionMultiple>>(HttpStatus.NO_CONTENT);
	}
	
	
	
	

}
