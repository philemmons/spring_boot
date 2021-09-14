package com.amigoscode.demo.comic;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//  localhost:8080/api/v1/comic
	@PostMapping				// payload from client 
	public void registerNewComic(@RequestBody Comic comic) {
		comicService.addNewComic(comic);
	}
	
	//  localhost:8080/api/v1/comic/{comicId}
	
	@DeleteMapping(path="{comicId}")
	public void deleteComic(
		@PathVariable("comicId") Long comicId) {
			comicService.deleteComic(comicId);
	}
	
	//  localhost:8080/api/v1/comic/1?title=IRONMAN
	
	@PutMapping(path="{comicId}")
	public void updateComic(
			@PathVariable("comicId") Long comicId, 
			@RequestParam(required = false) String title,
			@RequestParam(required = false) LocalDate date,
			@RequestParam(required = false) Integer issue,
			@RequestParam(required = false) Boolean significant
			){
		comicService.updateComic(comicId, title, date, issue, significant);
	}
}
