package com.example.demo.feignclient;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.example.demo.pojo.ConversionValue;

@Component
public class Fallback implements ConversionFeignClient {

	@Override
	public ConversionValue getConversionValue(String from, String to) {
		// TODO Auto-generated method stub
		return new ConversionValue(1, to, from, new BigDecimal(40));
	}

}
