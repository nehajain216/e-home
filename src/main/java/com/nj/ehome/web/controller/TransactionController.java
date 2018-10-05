package com.nj.ehome.web.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nj.ehome.entity.Transaction;
import com.nj.ehome.service.TransactionService;

@Controller
public class TransactionController {
	
	Logger log= LoggerFactory.getLogger(TransactionController.class);
	private final TransactionService transactionService;

	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@GetMapping("/")
	public String home(Model model,@RequestParam(value="year", required=false)Integer year, 
			@RequestParam(value="month", required=false) Integer month)
	{
		LocalDate now = LocalDate.now();
		if(year==null)
			year = now.getYear();
		if(month == null)
			month = now.getMonthValue();
		
		log.info("year:{},month:{}",year,month);
		
		model.addAttribute("transaction", new Transaction());
		model.addAttribute("transactions",transactionService.getTransactions(year, month));
		return "home";
	}
	
	@PostMapping("/transactions")
	public String saveTransaction(Model model, Transaction transaction)
	{
		transactionService.createTransaction(transaction);
		return "redirect:/";
	}

}
