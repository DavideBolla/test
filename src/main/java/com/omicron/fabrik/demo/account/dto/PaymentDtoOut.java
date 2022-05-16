package com.omicron.fabrik.demo.account.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class PaymentDtoOut implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("status")
	private String status;
	
}
