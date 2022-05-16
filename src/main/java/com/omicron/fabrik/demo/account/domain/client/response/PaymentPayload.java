package com.omicron.fabrik.demo.account.domain.client.response;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omicron.fabrik.demo.account.domain.client.Creditor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Generated("jsonschema2pojo")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentPayload implements Serializable{
//	public class PaymentPayload extends PaymentDtoOut implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public PaymentPayload () {}

	@JsonProperty("moneyTransferId")
	private String moneyTransferId;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("direction")
	private String direction;
	
	@JsonProperty("creditor")
	private Creditor creditor;
	
	@JsonProperty("debtor")
	private Debtor debtor;
	
	@JsonProperty("cro")
	private String cro;
	
	@JsonProperty("uri")
	private String uri;
	
	@JsonProperty("trn")
	private String trn;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("createdDatetime")
	private String createdDatetime;
	
	@JsonProperty("accountedDatetime")
	private String accountedDatetime;
	
	@JsonProperty("debtorValueDate")
	private String debtorValueDate;
	
	@JsonProperty("creditorValueDate")
	private String creditorValueDate;
	
	@JsonProperty("amount")
	private Amount amount;
	
	@JsonProperty("isUrgent")
	private Boolean isUrgent;
	
	@JsonProperty("isInstant")
	private Boolean isInstant;
	
	@JsonProperty("feeType")
	private String feeType;
	
	@JsonProperty("feeAccountId")
	private String feeAccountId;
	
	@JsonProperty("fees")
	private List<Fee> fees = null;
	
	@JsonProperty("hasTaxRelief")
	private Boolean hasTaxRelief;
}
