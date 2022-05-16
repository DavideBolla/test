package com.omicron.fabrik.demo.account.domain.client.response;

import java.io.Serializable;

public class Fee implements Serializable{

	private static final long serialVersionUID = 1L;
	private String feeCode;
	private String description;
	private Double amount;
	private String currency;
	
	public String getFeeCode() {
		return feeCode;
	}
	public void setFeeCode(String feeCode) {
		this.feeCode = feeCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
