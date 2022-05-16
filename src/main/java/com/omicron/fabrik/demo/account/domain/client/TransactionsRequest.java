package com.omicron.fabrik.demo.account.domain.client;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionsRequest {
	private Long accountId; 
	private Date fromAccountingDate;
	private Date toAccountingDate;
	
	public TransactionsRequest() {
		super();
	}
	
	public TransactionsRequest(Long accountId, Date fromAccountingDate, Date toAccountingDate) {
		super();
		this.accountId = accountId;
		this.fromAccountingDate = fromAccountingDate;
		this.toAccountingDate = toAccountingDate;
	}

}
