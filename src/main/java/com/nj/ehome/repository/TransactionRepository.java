package com.nj.ehome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nj.ehome.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
}
