package com.amigoscode.demo.comic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//  This will have all the resources for our API
@RestController
@RequestMapping(path= "/api/v1/comic") //
public class ComicController {
	
	private final ComicService comicService;
	
	//  add constructor parameter
	//  comicService will auto instantiated into this
	@Autowired 
	public ComicController(ComicService comicService) {
		this.comicService = comicService;
	}
	
	//  this creates a RESTful endpoint - get something out of our server
	@GetMapping  
	public List<Comic> getComics() {
		return comicService.getComics();
	}
	
	@PostMapping				// payload from client 
	public void registerNewComic(@RequestBody Comic comic) {
		comicService.addNewComic(comic);
		
	}
}
