package com.nj.ehome.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nj.ehome.entity.Transaction;
import com.nj.ehome.service.TransactionService;

@RestController
public class TransactionRestController {
	
	TransactionService transactionService;
	
	@Autowired
	public TransactionRestController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@GetMapping("/transactions/all")
	public List<Transaction> getAllTransactions()
	{
		return transactionService.getTransactions(2018, 12);
	}

}
