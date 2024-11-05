package com.nontius.proje;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nontius.proje.controller.EmployeeController;
import com.nontius.proje.entity.Employee;
import com.nontius.proje.repository.EmployeeRepository;
import com.nontius.proje.service.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component

public class MyCommandLinerTest implements CommandLineRunner {
	

	public EmployeeRepository repository;
	
	public MyCommandLinerTest(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	
	

	@Override
	public void run(String... args) throws Exception {

		
		for(Employee employee : repository.findAll()) {
			
			System.out.println(employee.getFirstname());
		}
		
		
	}

}
