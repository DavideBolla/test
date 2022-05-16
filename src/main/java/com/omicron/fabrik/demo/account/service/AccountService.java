package com.omicron.fabrik.demo.account.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.omicron.fabrik.demo.account.domain.client.PaymentRequest;
import com.omicron.fabrik.demo.account.domain.client.TransactionsRequest;
import com.omicron.fabrik.demo.account.domain.client.response.BalanceResponse;
import com.omicron.fabrik.demo.account.domain.client.response.PaymentResponse;
import com.omicron.fabrik.demo.account.domain.client.response.TransactionsResponse;

public interface AccountService {
	
	public BalanceResponse retrieveBalance(Long accountId) throws JsonMappingException, JsonProcessingException;
	
	public TransactionsResponse retrieveTransactions(TransactionsRequest request) throws JsonMappingException, JsonProcessingException;
	
	public PaymentResponse performPayment(PaymentRequest request, Long accountId) throws JsonMappingException, JsonProcessingException;

}
