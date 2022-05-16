package com.omicron.fabrik.demo.account.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.omicron.fabrik.demo.account.domain.client.PaymentRequest;
import com.omicron.fabrik.demo.account.domain.client.TransactionsRequest;
import com.omicron.fabrik.demo.account.domain.client.response.BalanceResponse;
import com.omicron.fabrik.demo.account.domain.client.response.PaymentResponse;
import com.omicron.fabrik.demo.account.domain.client.response.TransactionsResponse;
import com.omicron.fabrik.demo.account.dto.BalanceDtoOut;
import com.omicron.fabrik.demo.account.dto.PaymentDtoOut;
import com.omicron.fabrik.demo.account.dto.TransactionsDtoOut;
import com.omicron.fabrik.demo.account.service.AccountService;
import com.omicron.fabrik.demo.account.domain.client.response.Error;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/test/api/v4.0")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/balance", method = RequestMethod.GET)
	public ResponseEntity<?> balance(@RequestParam(name = "accountId", required = true) Long accountId) {

		log.info("balance() - IN");
		ResponseEntity<?> responseEntity = null;
		try {
			BalanceResponse balanceData = accountService.retrieveBalance(accountId);
			BalanceDtoOut balanceOut = new BalanceDtoOut();
			balanceOut.setBalance(balanceData.getPayload().getAvailableBalance());
			if("OK".equalsIgnoreCase(balanceData.getStatus())) {
//				responseEntity = new ResponseEntity<>(balanceData, HttpStatus.OK);
				responseEntity = new ResponseEntity<>(balanceOut, HttpStatus.OK);
			}else{
				List<Error> errorList = balanceData.getErrors();
				HttpStatus status = HttpStatus.resolve(Integer.parseInt(balanceData.getPayload().getStatus()));
			
				balanceData.getPayload().setStatus(null);
//				responseEntity = new ResponseEntity<>(balanceData, status);
				responseEntity = new ResponseEntity<>(errorList, status);
			}
		} catch (JsonProcessingException e) {
			log.error("balance() - EXCEPTION - ", e);
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR);
			return responseEntity;
		}
		log.info("balance() - OUT - httpstatus: [{}] - response: [{}]");
		return responseEntity;
	}

	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public ResponseEntity<?> transactions(@RequestParam(name = "accountId", required = true) Long accountId,
			@RequestParam(name = "fromAccountingDate", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromAccountingDate,
			@RequestParam(name = "toAccountingDate", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date toAccountingDate) {

		log.info("transactions() - IN");
		ResponseEntity<?> responseEntity = null;
		try {
			TransactionsRequest req = new TransactionsRequest(accountId, fromAccountingDate, toAccountingDate);
			TransactionsResponse transData = accountService.retrieveTransactions(req);
			TransactionsDtoOut transOut = new TransactionsDtoOut();
			transOut.setTransactions(transData.getPayload().getList());
			if("OK".equalsIgnoreCase(transData.getStatus())) {
//				responseEntity = new ResponseEntity<>(transData, HttpStatus.OK);
				responseEntity = new ResponseEntity<>(transOut, HttpStatus.OK);
			}else{
				List<Error> errorList = transData.getErrors();				
				HttpStatus status = HttpStatus.resolve(Integer.parseInt(transData.getPayload().getStatus()));

				transData.getPayload().setStatus(null);
				
//				responseEntity = new ResponseEntity<>(transData, status);
				responseEntity = new ResponseEntity<>(errorList, status);
			}
		} catch (JsonProcessingException e) {
			log.error("transactions() - EXCEPTION - ", e);
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR);
			return responseEntity;
		}
		log.info("transactions() - OUT - httpstatus: [{}] - response: [{}]");
		return responseEntity;
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public ResponseEntity<?> performPayment(@RequestParam(name = "accountId", required = true) Long accountId, 
			@RequestBody PaymentRequest request) {
		ResponseEntity<?> responseEntity = null;

		try {
//			PaymentRequest req = new PaymentRequest();
			PaymentResponse paymentData = accountService.performPayment(request, accountId);
			PaymentDtoOut paymentOut = new PaymentDtoOut();
			paymentOut.setStatus(paymentData.getStatus());
			if("OK".equalsIgnoreCase(paymentData.getStatus())) {
				responseEntity = new ResponseEntity<>(paymentOut, HttpStatus.OK);
			}else{
				List<Error> errorList = paymentData.getErrors();
				HttpStatus status = HttpStatus.resolve(Integer.parseInt(paymentData.getPayload().getStatus()));
				paymentData.getPayload().setStatus(null);
				
				
				responseEntity = new ResponseEntity<>(errorList, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		} catch (JsonProcessingException e) {
			
			log.error("performPayment() - EXCEPTION - ", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("performPayment() - OUT - httpstatus: [{}] - response: [{}]");
		return responseEntity;
	}

}
