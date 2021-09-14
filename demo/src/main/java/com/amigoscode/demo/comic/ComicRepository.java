package com.amigoscode.demo.comic;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicRepository
	//  https://stackoverflow.com/questions/14014086/what-is-difference-between-crudrepository-and-jparepository-interfaces-in-spring
	//  JPA repo  extends PagingAndSortingRepository which in turn extends CrudRepository. 
	extends JpaRepository<Comic, Long>{ // <T, ID>
	
	//@Query("SELECT s FROM Comic c WHERE c.title =?1")
	Optional<Comic> findComicByTitle(String title);
}
