package com.nontius.proje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nontius.proje.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

}