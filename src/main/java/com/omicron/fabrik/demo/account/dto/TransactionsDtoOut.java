package com.omicron.fabrik.demo.account.dto;

import java.util.List;

import com.omicron.fabrik.demo.account.domain.client.response.Transaction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionsDtoOut {

	private List<Transaction> transactions;

}
