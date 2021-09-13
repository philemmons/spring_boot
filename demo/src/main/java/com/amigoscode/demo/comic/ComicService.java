package com.amigoscode.demo.comic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//  this is a Spring BEAN and informs Spring the source 
@Service
public class ComicService {
	//  dependency injection from the interface
	private final ComicRepository comicRepository;
	
	@Autowired //  constructor
	public ComicService(ComicRepository comicRepository) {
		this.comicRepository = comicRepository;
	}

	public List<Comic> getComics() {
		return comicRepository.findAll();
	}

	public void addNewComic(Comic comic) {
		Optional<Comic> comicOptional = comicRepository
				.findComicByTitle( comic.getTitle() );
		if(comicOptional.isPresent()) {
			throw new IllegalStateException("Title exist");
		}
		//System.out.println(comic);
		comicRepository.save(comic);
	}
}
