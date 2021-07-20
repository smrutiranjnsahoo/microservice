package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="config-mgmt-service")
public class MyConfiguration {
	
	private int value1;
	private String value2;
	
	public int getValue1() {
		return value1;
	}
	public void setValue1(int value1) {
		this.value1 = value1;
	}
	public String getValue2() {
		return value2;
	}
	public void setValue2(String value2) {
		this.value2 = value2;
	}
	@Override
	public String toString() {
		return "MyConfiguration [value1=" + value1 + ", value2=" + value2 + "]";
	}
	
	
	

}
