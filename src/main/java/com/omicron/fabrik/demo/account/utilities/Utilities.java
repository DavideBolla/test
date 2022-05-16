package com.omicron.fabrik.demo.account.utilities;

import java.util.List;

import com.omicron.fabrik.demo.account.domain.client.response.Error;
public class Utilities {

	public static final String KO = "KO";
	
	public static final String BALANCE_KO_DESC = "Invalid account identifier";
	public static final String BALANCE_KO_CODE = "REQ004";
	
	public static final String TRANSACTION_KO_DESC = "Invalid date format";
	public static final String TRANSACTION_KO_CODE = "REQ017";
	
	public static final String PAYMENT_KO_CODE = "API000";
	public static final String PAYMENT_KO_DESC = "Errore tecnico  La condizione BP049 non e' prevista per il conto id ";
	
	public static final String PAYMENT_BR_KO_CODE = "API000";
	public static final String PAYMENT_BR_KO_DESC = "L'importo dell'operazione deve essere maggiore di 0.01 EUR e minore di 999999999999.00 EUR.";
	
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
