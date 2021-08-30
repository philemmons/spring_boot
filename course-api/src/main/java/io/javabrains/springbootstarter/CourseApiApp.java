package io.javabrains.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Annotation
public class CourseApiApp {

	public static void main(String[] args) {
		//spring bootstrapped app in main because it is stand alone.
		//inform spring this class contains the sublet container and start
		
		//static method( class, main args)
		SpringApplication.run(CourseApiApp.class, args);
		
		//execute java main; goto browser localhost:8080
	}

}
