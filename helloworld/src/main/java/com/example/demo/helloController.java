package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

	@GetMapping("/hello")
	public String helloworld() {
		return "Welcome to HELLO WORLD in the port 2023";
	}
}
