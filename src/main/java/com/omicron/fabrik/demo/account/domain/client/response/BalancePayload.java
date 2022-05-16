package com.omicron.fabrik.demo.account.domain.client.response;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Generated("jsonschema2pojo")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BalancePayload {
	
	@JsonProperty("date")
	private String date;
	
	@JsonProperty("balance")
	private Double balance;
	
	@JsonProperty("availableBalance")
	private Double availableBalance;
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("status")
	private String status;
}
