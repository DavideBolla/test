package com.omicron.fabrik.demo.account.utilities;

import java.util.List;

import com.omicron.fabrik.demo.account.domain.client.response.Error;
public class Utilities {

	public static final String KO = "KO";
	
	/**
	 * Crea una lista personalizzata di errori da ritornare nella response finale in caso di eccezione non legata a client/server
	 * @param messageList: lista di messaggi
	 * @param errors: oggetto lista
	 * @param customStatus: status code da inserire per ogni errore (di solito 500 dato che si tratta di un problema interno all'applicazione)
	 * @return
	 */
	public static List<Error> createCustomErrorList(String[] messageList, List<Error> errors, String customStatus) {
		for(int i = 0 ; i < messageList.length; i++) {
			 Error customError = new Error();
			 customError.setCode(customStatus);
			 customError.setDescription(messageList[i]);
			 errors.add(customError);
		 }
		return errors;
	}
}
