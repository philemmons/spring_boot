package com.amigoscode.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // makes a REST class for the endpoint below
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	@GetMapping  //  this creates a RESTful endpoint - get something out of our server
	public List<String> hello() {
		return List.of("Hello", "World");
	}

}
