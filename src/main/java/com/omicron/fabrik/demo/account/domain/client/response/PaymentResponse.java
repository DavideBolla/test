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
public class PaymentResponse extends ApiGenericResponse {

	private static final long serialVersionUID = 1L;

	private PaymentPayload payload;
	
	private static PaymentResponse setCustomErrorListObject(String[] messageList){
		 PaymentResponse errorObj = new PaymentResponse();
		 List<Error> errors = new ArrayList<Error>();
		 String customStatus = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value());
		 errors = Utilities.createCustomErrorList(messageList, errors, customStatus);
		 
		 errorObj.setPayload(new PaymentPayload());
		 errorObj.getPayload().setStatus(customStatus);
		 errorObj.setStatus(Utilities.KO);
		 errorObj.setErrors(errors);
		 
		 return errorObj;
   }
	
	public static PaymentResponse handlePaymentError(String message, String statusCode)
			throws JsonProcessingException, JsonMappingException {
		
		ObjectMapper mapper = new ObjectMapper();
		PaymentResponse errorObj = new PaymentResponse();
		if(message != null && !"".equalsIgnoreCase(message) && message.indexOf("status") != -1) {
			errorObj = mapper.readValue(message, PaymentResponse.class);
			errorObj.getPayload().setStatus(statusCode);
//			errorObj.setStatus(statusCode);
		}else {
			errorObj = setCustomErrorListObject(new String[] {message});
		}
		return errorObj;
	}
	
}
