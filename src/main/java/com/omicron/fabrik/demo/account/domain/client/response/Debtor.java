package com.omicron.fabrik.demo.account.domain.client.response;

import java.io.Serializable;

import com.omicron.fabrik.demo.account.domain.client.Account;

public class Debtor implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private Account account;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
