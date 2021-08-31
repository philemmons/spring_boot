package io.javabrains.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//  gives the class Spring framework context - API - RESTful
//  MARKING the class as a REST controller
//  deals with http responses with http request

@RestController 
public class HelloController {
	
	//  This annotation maps ONLY to the GET method by default. 
	//  To map to other HTTP methods, you'll have to specify it in the annotation.
	//  when there is a http request, execute this class, and return hello
	//  the method is the response
	
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hello World";
	}

}
