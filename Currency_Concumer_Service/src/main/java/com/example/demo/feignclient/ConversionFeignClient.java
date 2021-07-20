package com.example.demo.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.pojo.ConversionValue;
import com.netflix.appinfo.RefreshableAmazonInfoProvider.FallbackAddressProvider;

@FeignClient(value = "currency-find-one",fallback=Fallback.class /* ,url="localhost:8085" */)
public interface ConversionFeignClient {
	
	@GetMapping("exchange-value/from/{from}/to/{to}")
	public ConversionValue getConversionValue(@PathVariable("from") String from, @PathVariable("to") String to);

	
}
