package com.example.demo.pojo;

import java.math.BigDecimal;


public class ConversionValue {
	

	private int id;
	private String valueTo;
	private String valueFrom;
  	private BigDecimal conversionMultiple;
	private int port;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmmount;
	
	public ConversionValue(int id, String valueTo, String valueFrom, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.valueTo = valueTo;
		this.valueFrom = valueFrom;
		this.conversionMultiple = conversionMultiple;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValueTo() {
		return valueTo;
	}
	public void setValueTo(String valueTo) {
		this.valueTo = valueTo;
	}
	public String getValueFrom() {
		return valueFrom;
	}
	public void setValueFrom(String valueFrom) {
		this.valueFrom = valueFrom;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalCalculatedAmmount() {
		return totalCalculatedAmmount;
	}
	public void setTotalCalculatedAmmount(BigDecimal totalCalculatedAmmount) {
		this.totalCalculatedAmmount = totalCalculatedAmmount;
	}
	@Override
	public String toString() {
		return "ConversionMultiple [id=" + id + ", valueTo=" + valueTo + ", valueFrom=" + valueFrom
				+ ", conversionMultiple=" + conversionMultiple + ", port=" + port + ", quantity=" + quantity
				+ ", totalCalculatedAmmount=" + totalCalculatedAmmount + "]";
	}
	public ConversionValue() {
	}
	
	

	
	
	
	


}
