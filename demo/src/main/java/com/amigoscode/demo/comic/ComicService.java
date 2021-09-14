package com.amigoscode.demo.comic;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

	public void deleteComic(Long comicId) {
		boolean exists = comicRepository.existsById(comicId);
		if(!exists) {
			throw new IllegalStateException(
					"Comic with id "+ comicId + " does not exist.");
		}
		comicRepository.deleteById(comicId);
	}
	
	// avoids queries, allow the entity goes into a managed state
	@Transactional
	public void updateComic(Long comicId, 
							String title, 
							LocalDate date, 
							Integer issue, 
							Boolean significant) {
		Comic comic = comicRepository.findById(comicId)
				.orElseThrow( ()-> new IllegalStateException(
						"Comic with id " + comicId + " does not exist."
						));
		if(title != null &&
				title.length() > 0 &&
				!title.equals(comic.getTitle())
			){
				/*//  use this logic when a unique attribute is used 
				 * Optional<Comic> comicOptional = comicRepository .findComicByTitle(title); if(
				 * comicOptional.isPresent() ) { throw new IllegalStateException("Title exist");
				 * }
				 */
				comic.setTitle(title);
		}
		
		if(date != null &&
				date.equals(comic.getPublishDate() )
			){
				comic.setPublishDate(date);
		}
		
		if(issue != null &&
				issue > -1 &&
				comic.getIssue() != issue
			){ 
				comic.setIssue(issue);
		}
		
		if(significant != null &&
				!significant.equals( comic.getSignificant() )
			){ 
				comic.setSignificant(significant);
		}
	}
}
