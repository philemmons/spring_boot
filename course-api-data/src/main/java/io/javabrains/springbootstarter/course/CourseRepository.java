package io.javabrains.springbootstarter.course;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{
	
	//  no matter what the entity is, there are some standard operators - CRUD
	//  Spring framework has these built-in features.
	//  Also, Spring JPA has a built-in class
	//  what we need is an interface.... which uses the implementation of the object
	//  extending  CrudRepository
	//  it need a couple generic types< T, id >
	
}