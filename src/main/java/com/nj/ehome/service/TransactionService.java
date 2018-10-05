package com.nj.ehome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nj.ehome.entity.Transaction;
import com.nj.ehome.repository.TransactionRepository;

@Service
public class TransactionService {
	
	private final TransactionRepository txnRepository;

	@Autowired
	public TransactionService(TransactionRepository txnRepository) {
		this.txnRepository = txnRepository;
	}
	
	public void createTransaction(Transaction transaction)
	{
		txnRepository.save(transaction);
	}
	
	public List<Transaction> getTransactions(int year, int month)
	{
		return txnRepository.findAll();
	}

}
