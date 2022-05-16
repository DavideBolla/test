package com.omicron.fabrik.demo.account.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.omicron.fabrik.demo.account.domain.client.PaymentRequest;
import com.omicron.fabrik.demo.account.domain.client.TransactionsRequest;
import com.omicron.fabrik.demo.account.domain.client.response.BalanceResponse;
import com.omicron.fabrik.demo.account.domain.client.response.Error;
import com.omicron.fabrik.demo.account.domain.client.response.PaymentResponse;
import com.omicron.fabrik.demo.account.domain.client.response.TransactionsResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

	private static final String AUTH_SCHEMA_HEADER = "Auth-Schema";

	private static final String API_KEY_HEADER = "Api-Key";

	private static final String API_KEY_X_TIMEZONE = "X-Time-Zone";
	
	private static final String API_KEY_X_CONTENT_TYPE = "Content-Type";
	
	@Value("${server.api.base.path}")
	private String baseUrl;

	@Value("${server.api.retrieve.details.path}")
	private String detailsEndpoint;

	@Value("${server.api.retrieve.balance.path}")
	private String balanceEndpoint;

	@Value("${server.api.retrieve.transactions.path}")
	private String transactionsEndpoint;

	@Value("${server.api.payment.path}")
	private String paymentEndpoint;

	@Value("${server.api.auth.schema}")
	private String authSchema;

	@Value("${server.api.key}")
	private String apiKey;

	@Value("${server.api.timezone}")
	private String timezone;

	@Autowired
	private RestTemplate restTemplate;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public BalanceResponse retrieveBalance(Long accountId) throws JsonMappingException, JsonProcessingException{
		HttpEntity<String> entity = buildAuthHeader();
		ResponseEntity<BalanceResponse> exchange = null;
		try {
			exchange = restTemplate.exchange(
					baseUrl + String.format(balanceEndpoint, accountId), HttpMethod.GET, entity, BalanceResponse.class);
		
		}catch(HttpClientErrorException e) {
			 return BalanceResponse.handleBalanceError(e.getResponseBodyAsString(), String.valueOf(e.getRawStatusCode()));
		}catch(HttpServerErrorException e) {
			 return BalanceResponse.handleBalanceError(e.getResponseBodyAsString(), String.valueOf(e.getRawStatusCode()));
		}catch(Exception e) {
			 return BalanceResponse.handleBalanceError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		}
		return exchange.getBody();
	}

	
	@Override
	public TransactionsResponse retrieveTransactions(TransactionsRequest request) throws JsonMappingException, JsonProcessingException {
		HttpEntity<String> entity = buildAuthHeader();
		String endpoint = String.format(transactionsEndpoint, request.getAccountId());
		Date fromDate = request.getFromAccountingDate();
		Date toDate = request.getToAccountingDate();
		String from = fromDate == null ? null : sdf.format(fromDate);
		String to = toDate == null ? null : sdf.format(toDate);

		String queryString = "?fromAccountingDate={fromAccountingDate}&toAccountingDate={toAccountingDate}";
		ResponseEntity<TransactionsResponse> exchange = null;
		try {
			exchange = restTemplate.exchange(baseUrl + endpoint + queryString,
					HttpMethod.GET, entity, TransactionsResponse.class, from, to);
		
		}catch(HttpClientErrorException e) {
			 return TransactionsResponse.handleTransactionsError(e.getResponseBodyAsString(), String.valueOf(e.getRawStatusCode()));
		}catch(HttpServerErrorException e) {
			 return TransactionsResponse.handleTransactionsError(e.getResponseBodyAsString(), String.valueOf(e.getRawStatusCode()));
		}catch(Exception e) {
			 return TransactionsResponse.handleTransactionsError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		}
		return exchange.getBody();
	}

	@Override
	public PaymentResponse performPayment(PaymentRequest request, Long accountId) throws JsonMappingException, JsonProcessingException {

		HttpHeaders headers = buildPaymentHeader();
		HttpEntity<PaymentRequest> entity = new HttpEntity<PaymentRequest>(request, headers);
		String endpoint = String.format(paymentEndpoint, accountId);

		ResponseEntity<PaymentResponse> exchange = null;
		try {
			
			exchange = restTemplate.exchange(baseUrl + endpoint, HttpMethod.POST, entity, PaymentResponse.class);
		
		}catch(HttpClientErrorException e) {
			log.error(e.getMessage());
			return PaymentResponse.handlePaymentError(e.getResponseBodyAsString(), String.valueOf(e.getRawStatusCode()));
		}catch(HttpServerErrorException e) {
			log.error(e.getMessage());
			return PaymentResponse.handlePaymentError(e.getResponseBodyAsString(), String.valueOf(e.getRawStatusCode()));
		}catch(Exception e) {
			log.error(e.getMessage());
			return PaymentResponse.handlePaymentError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		}
		return exchange.getBody();
	}

	private HttpEntity<String> buildAuthHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.set(AUTH_SCHEMA_HEADER, authSchema);
		headers.set(API_KEY_HEADER, apiKey);
		return new HttpEntity<String>(headers);
	}

	private HttpHeaders buildPaymentHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.set(AUTH_SCHEMA_HEADER, authSchema);
		headers.set(API_KEY_HEADER, apiKey);
		headers.set(API_KEY_X_TIMEZONE, timezone);
		headers.set(API_KEY_X_CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE); 
		return headers;
	}
	
}
