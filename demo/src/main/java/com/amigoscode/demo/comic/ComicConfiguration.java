package com.amigoscode.demo.comic;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // adding a BEAN
public class ComicConfiguration {
	
	//  Interface used to indicate that a bean should run when it is contained within a SpringApplication
	@Bean
	CommandLineRunner commandLineRunner(
			ComicRepository repository ) { // allows access to the repo by injection
		return args -> {
			Comic ironman = new Comic(
					"Ironman",
					LocalDate.of(1968, Month.MARCH, 5),
					1,
					true
					);
			Comic thor = new Comic(
					"THOR",
					LocalDate.of(1966,Month.MARCH, 5),
					126,
					true
					);
			
			//  examine the console to view the SQl invoked by hibernate when executed		
			repository.saveAll(
					List.of(ironman,thor)
					);
		};
	}
}
