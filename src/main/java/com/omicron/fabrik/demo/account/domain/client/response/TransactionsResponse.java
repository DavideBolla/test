package com.omicron.fabrik.demo.account.domain.client.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.omicron.fabrik.demo.account.utilities.Utilities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionsResponse extends ApiGenericResponse {

	private static final long serialVersionUID = 1L;
	
	private TransactionsPayload payload;
	
	private static TransactionsResponse setCustomErrorListObject(String[] messageList){
		 TransactionsResponse errorObj = new TransactionsResponse();
		 List<Error> errors = new ArrayList<Error>();
		 String customStatus = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value());

		 errors = Utilities.createCustomErrorList(messageList, errors, customStatus);
		 
		 errorObj.setPayload(new TransactionsPayload());
		 errorObj.getPayload().setStatus(customStatus);
		 errorObj.setStatus(Utilities.KO);
		 errorObj.setErrors(errors);
		 
		 return errorObj;
  }
	
	public static TransactionsResponse handleTransactionsError(String message, String statusCode)
			throws JsonProcessingException, JsonMappingException {
		
		ObjectMapper mapper = new ObjectMapper();
		TransactionsResponse errorObj = new TransactionsResponse();
		if(message != null && !"".equalsIgnoreCase(message) && message.indexOf("status") != -1) {
			errorObj = mapper.readValue(message, TransactionsResponse.class);
			errorObj.getPayload().setStatus(statusCode);
//			errorObj.setStatus(statusCode);
		}else {
			errorObj = setCustomErrorListObject(new String[] {message});
		}
		return errorObj;
	}
}
