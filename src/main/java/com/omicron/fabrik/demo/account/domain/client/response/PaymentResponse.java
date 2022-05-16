package com.omicron.fabrik.demo.account.domain.client.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.omicron.fabrik.demo.account.utilities.Utilities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResponse extends ApiGenericResponse {

	private static final long serialVersionUID = 1L;

	private PaymentPayload payload;
	
	private static PaymentResponse setCustomErrorListObject(String[] messageList, String statusCode){
		 PaymentResponse errorObj = new PaymentResponse();
		 List<Error> errors = new ArrayList<Error>();
		 errors = Utilities.createCustomErrorList(messageList, errors, statusCode);
		 
		 errorObj.setPayload(new PaymentPayload());
		 errorObj.getPayload().setStatus(statusCode);
		 errorObj.setStatus(Utilities.KO);
		 errorObj.setErrors(errors);
		 
		 return errorObj;
   }
	
	public static PaymentResponse handlePaymentError(String message, String statusCode)
			throws JsonProcessingException, JsonMappingException {
		
		return setCustomErrorListObject(new String[] {message}, statusCode);
	}
	
}
