package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.MyConfiguration;
import com.example.demo.pojo.MyPojo;

@RestController
public class ConfigController {
	
	@Autowired
	MyConfiguration config ;
	
	@GetMapping("/values")
	public MyPojo getValues() {
		return new MyPojo(config.getValue2() , config.getValue1());
	}
	

}
