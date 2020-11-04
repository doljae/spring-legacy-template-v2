package com.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerTest {
	// TODO Auto-generated constructor stub
	@GetMapping(value = "/hello")
	public String hello() {
		return "this is my first RestController & REST API test!(get)";
	}
	@PostMapping(value = "/hello")
	public String hello2() {
		return "this is my first RestController & REST API test!(post)";
	}
	@GetMapping(value = "/hello2")
	public String hello3() {
		return "this is my first RestController & REST API test!(get22)";
	}
	
}
