package com.omicron.fabrik.demo.account.domain.client.response;

import java.io.Serializable;

public class Amount implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer debtorAmount;
	private String debtorCurrency;
	private Integer creditorAmount;
	private String creditorCurrency;
	private String creditorCurrencyDate;
	private Integer exchangeRate;
	
	public Integer getDebtorAmount() {
		return debtorAmount;
	}
	public void setDebtorAmount(Integer debtorAmount) {
		this.debtorAmount = debtorAmount;
	}
	public String getDebtorCurrency() {
		return debtorCurrency;
	}
	public void setDebtorCurrency(String debtorCurrency) {
		this.debtorCurrency = debtorCurrency;
	}
	public Integer getCreditorAmount() {
		return creditorAmount;
	}
	public void setCreditorAmount(Integer creditorAmount) {
		this.creditorAmount = creditorAmount;
	}
	public String getCreditorCurrency() {
		return creditorCurrency;
	}
	public void setCreditorCurrency(String creditorCurrency) {
		this.creditorCurrency = creditorCurrency;
	}
	public String getCreditorCurrencyDate() {
		return creditorCurrencyDate;
	}
	public void setCreditorCurrencyDate(String creditorCurrencyDate) {
		this.creditorCurrencyDate = creditorCurrencyDate;
	}
	public Integer getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(Integer exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
}
