package com.amigoscode.demo.comic;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

//  this is a Spring BEAN and informs Spring the source 
@Service
public class ComicService {
	
	public List<Comic> getComics() {
		return List.of(new Comic(
							1L,
							"Ironman",
							LocalDate.of(1966, Month.AUGUST, 26),
							1,
							true
						)
					);
	}
}
