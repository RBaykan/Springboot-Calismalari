package com.nontius.proje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nontius.proje.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	
}