package com.omicron.fabrik.demo.account;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.omicron.fabrik.demo.account.domain.client.Account;
import com.omicron.fabrik.demo.account.domain.client.Creditor;
import com.omicron.fabrik.demo.account.domain.client.PaymentRequest;
import com.omicron.fabrik.demo.account.domain.client.response.Error;
import com.omicron.fabrik.demo.account.dto.BalanceDtoOut;
import com.omicron.fabrik.demo.account.dto.PaymentDtoOut;
import com.omicron.fabrik.demo.account.dto.TransactionsDtoOut;
import com.omicron.fabrik.demo.account.utilities.Utilities;

@SpringBootTest
@WebAppConfiguration
class AccountApplicationTests {
	
	private final String baseRestUrl = "/test/api/v4.0";
	private final String balanceUrl = "/balance";
	private final String transactionsUrl = "/transactions";
	private final String paymentUrl = "/payment";
	
    protected MockMvc mvc;
    
    @Autowired
    WebApplicationContext webApplicationContext;
    	
    //SYSTEM TESTS
	@Test
	public void balance() throws Exception {
		setUp();
		Long accountId = 14537780L;
		String accountIdReqParam = "accountId="+accountId;
		String queryString = baseRestUrl + balanceUrl + "?" +accountIdReqParam;
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(queryString)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		
		assertTrue(status == 200);
		
		String content = mvcResult.getResponse().getContentAsString();
		BalanceDtoOut response = mapFromJson(content, BalanceDtoOut.class);

		assertTrue(response.getBalance() != null);
	}
	
	@Test
	public void balanceKo() throws Exception {
		setUp();
		
		//Imposto un id non valido
		Long accountId = 14537781L;
		String accountIdReqParam = "accountId="+accountId;
		String queryString = baseRestUrl + balanceUrl + "?" +accountIdReqParam;
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(queryString)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		
		assertTrue(status == 403);
		
		String content = mvcResult.getResponse().getContentAsString();
		List<Error> errorList = mapFromJson(content, new TypeReference<List<Error>>(){});
		
		//Per un id non valido, mi aspetto il seguente errore nella lista della response
		Error expectedError = new Error(Utilities.BALANCE_KO_CODE, Utilities.BALANCE_KO_DESC, null);
		
		assertTrue(errorList.contains(expectedError));
	}
	
	@Test
	public void transactions() throws Exception {
		setUp();
		Long accountId = 14537780L;
		String fromAccountingDate = "2019-01-01";
		String toAccountingDate = "2019-12-01";
		String accountIdReqParam = "accountId="+accountId;
		String fromAccountingDateReqParam = "fromAccountingDate="+fromAccountingDate;
		String toAccountingDateReqParam = "toAccountingDate="+toAccountingDate;
		String queryString = baseRestUrl + transactionsUrl + "?" +accountIdReqParam + "&" +fromAccountingDateReqParam + "&" + toAccountingDateReqParam;
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(queryString)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		
		assertTrue(status == 200);
		
		String content = mvcResult.getResponse().getContentAsString();
		TransactionsDtoOut response = mapFromJson(content, TransactionsDtoOut.class);
				
		assertTrue(response.getTransactions() != null);
	}
	
	@Test
	public void transactionsKo() throws Exception {
		setUp();
		Long accountId = 14537780L;
		String fromAccountingDate = "2019-12-02";
		String toAccountingDate = "2019-12-01";
		String accountIdReqParam = "accountId="+accountId;
		String fromAccountingDateReqParam = "fromAccountingDate="+fromAccountingDate;
		String toAccountingDateReqParam = "toAccountingDate="+toAccountingDate;
		String queryString = baseRestUrl + transactionsUrl + "?" +accountIdReqParam + "&" +fromAccountingDateReqParam + "&" + toAccountingDateReqParam;
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(queryString)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		
		assertTrue(status == 400);
		
		String content = mvcResult.getResponse().getContentAsString();
		List<Error> errorList = mapFromJson(content, new TypeReference<List<Error>>(){});
		
		//Per data minima maggiore di data massima mi aspetto il seguente errore nella lista della response
		Error expectedError = new Error(Utilities.TRANSACTION_KO_CODE, Utilities.TRANSACTION_KO_DESC, null);
				
		assertTrue(errorList.contains(expectedError));
	}
	
	//Test per previsione del caso in cui il bonifico risponda con un OK invece di sempre KO
	@Test 
	public void payment() throws Exception {
		setUp();
		Long accountId = 14537780L;
		String accountIdReqParam = "accountId="+accountId;
		String queryString = baseRestUrl + paymentUrl + "?" +accountIdReqParam;
		
		PaymentRequest request = setUpMockPaymentObj(0.01);

		String inputJson = mapToJson(request);
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(queryString)
				.content(inputJson)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
	
		assertTrue(status == 200);
		
		String content = mvcResult.getResponse().getContentAsString();
		PaymentDtoOut response = mapFromJson(content, PaymentDtoOut.class);
		
		assertTrue(response.getStatus() != null && "OK".equalsIgnoreCase(response.getStatus()));

	}

	@Test
	public void paymentKo() throws Exception {
		setUp();
		Long accountId = 14537780L;
		String accountIdReqParam = "accountId="+accountId;
		String queryString = baseRestUrl + paymentUrl + "?" +accountIdReqParam;
		
		PaymentRequest request = setUpMockPaymentObj(0.00);

		String inputJson = mapToJson(request);
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(queryString)
				.content(inputJson)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
	
		assertTrue(status == 400);
		
		String content = mvcResult.getResponse().getContentAsString();
		List<Error> errorList = mapFromJson(content, new TypeReference<List<Error>>(){});
		
		Error expectedError = new Error(Utilities.PAYMENT_BR_KO_CODE, Utilities.PAYMENT_BR_KO_DESC, null);
		
		assertTrue(errorList.contains(expectedError));

	}
	
     private void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
     }
     	
     private String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
     }
     private <T> T mapFromJson(String json, Class<T> clazz)
        throws JsonParseException, JsonMappingException, IOException {
        
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
     }
     
     private <T> T mapFromJson(String json, TypeReference<T> typeRef)
    		 throws JsonParseException, JsonMappingException, IOException {
    	 
    	 ObjectMapper objectMapper = new ObjectMapper();
    	 return objectMapper.readValue(json, typeRef);
     }
     
     private PaymentRequest setUpMockPaymentObj(Double amount) {
 		PaymentRequest request = new PaymentRequest();
		
 		request.setCreditor(new Creditor());
 		request.getCreditor().setName("Save the Children Italia ONLUS");
 		request.getCreditor().setAccount(new Account());
 		request.getCreditor().getAccount().setAccountCode("IT71P0501803200000011184009");
 		
 		request.setExecutionDate("2022-05-12");
 		request.setDescription("Donazione");
 		request.setAmount(amount);//In base al valore posso ottenere una response diversa (400 per valore = 0.00)
 		request.setCurrency("EUR");
 		request.setIsInstant(false);
 		request.setIsUrgent(false);
 		return request;
     }
}
