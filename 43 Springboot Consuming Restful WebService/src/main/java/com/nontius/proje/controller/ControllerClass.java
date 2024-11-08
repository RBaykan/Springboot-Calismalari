package com.nontius.proje.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/test")
@CrossOrigin("*")
public class ControllerClass {

	
	//---- Record and Greeting ------//
	// Temsili sınıftır
	public record Greeting(Long id, String content) {
		
		
	}
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	// ----------------------------------------------//
	
	
	// ------- Request Param -----------------------//
	
	@GetMapping("param")
	public String testRequestParam(
			@RequestParam(value = "name", defaultValue = "Anonymous") String name) {
		
		return "Hello " + name;
	}
	
	@GetMapping("testParam")
	public String testParamRequired(
			@RequestParam String name) {
		
		return "Hello " + name;
	}
	
	@GetMapping("testParam2")
	public String testParamRequired2(
			@RequestParam(defaultValue = "World") String name) {
		
		return "Hello " + name;
	}

	
	@GetMapping("testParam3")
	public String multiValueRequestParam(
			@RequestParam(defaultValue = "World") String firstname,
			@RequestParam("lastname") String lastname
			) {
		
		return "Hello " + firstname + " " + lastname;
	}


	
	
	
	

}


